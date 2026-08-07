package cn.xiaoheiban.template;

import cn.xiaoheiban.ApiLanguage;
import cn.xiaoheiban.ApiSyntaxHighlighter;
import cn.xiaoheiban.psi.*;
import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ApiLiveTemplateContextType extends TemplateContextType {

    protected ApiLiveTemplateContextType(@NotNull String id) {
        super(id);
    }

    /**
     * Exact port of GoLiveTemplateContextType.isInContext(TemplateActionContext):
     * - check language
     * - findElementAt (fallback to file root)
     * - unless acceptLeaf(), promote to first composite ancestor
     * - call abstract isInContext(PsiElement)
     */
    @Override
    public boolean isInContext(@NotNull TemplateActionContext ctx) {
        var file = ctx.getFile();
        int offset = ctx.getStartOffset();
        if (!PsiUtilCore.getLanguageAtOffset(file, offset).isKindOf(ApiLanguage.INSTANCE)) return false;

        PsiElement element = ObjectUtils.notNull(file.findElementAt(offset), file);
        if (!acceptLeaf()) {
            element = getFirstCompositeElement(element);
        }
        return element != null && isInContext(element);
    }

    /**
     * Return true if the raw leaf token is enough to determine context (for tag detection).
     */
    protected boolean acceptLeaf() {
        return false;
    }

    @Override
    public SyntaxHighlighter createHighlighter() {
        return new ApiSyntaxHighlighter();
    }

    /**
     * Walks up until a non-whitespace composite element is found.
     */
    @Nullable
    private static PsiElement getFirstCompositeElement(@Nullable PsiElement at) {
        PsiElement result = at;
        while (result != null
                && (result instanceof PsiWhiteSpace
                || result.getNode() == null
                || result.getNode().getFirstChildNode() == null)) {
            result = result.getParent();
        }
        return result;
    }

    protected abstract boolean isInContext(@NotNull PsiElement element);

    // ─── Nested context types ──────────────────────────────────────────────────

    /**
     * Top-level API file context (not inside service block).
     */
    public static class ApiFile extends ApiLiveTemplateContextType {
        protected ApiFile() {
            super("API_FILE");
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            if (PsiTreeUtil.getParentOfType(element, false,
                    ApiServiceSpec.class, ApiServiceStatement.class, ApiStructDataType.class) != null) return false;
            return PsiTreeUtil.getParentOfType(element, false, cn.xiaoheiban.psi.ApiFile.class) != null;
        }
    }

    /**
     * Inside a service statement or service body.
     */
    public static class ApiService extends ApiLiveTemplateContextType {
        protected ApiService() {
            super("API_SERVICE");
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            return PsiTreeUtil.getParentOfType(element, false,
                    ApiServiceSpec.class, ApiServiceStatement.class, ApiServiceBody.class) != null;
        }
    }

    /**
     * Position after a struct field's data type, where a tag backtick would be typed.
     */
    public static class Tag extends ApiLiveTemplateContextType {
        protected Tag() {
            super("API_TAG");
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            ApiElemExpr elemExpr = PsiTreeUtil.getParentOfType(element, false, ApiElemExpr.class);
            if (elemExpr == null) return false;
            // must not already be inside a TAG
            if (PsiTreeUtil.getParentOfType(element, false, ApiElemExpr.class) != null) {
                var node = element.getNode();
                if (node != null && node.getElementType() == ApiTypes.TAG) return false;
                // check if any ancestor up to elemExpr is a TAG
                for (PsiElement p = element; p != null && p != elemExpr; p = p.getParent()) {
                    var n = p.getNode();
                    if (n != null && n.getElementType() == ApiTypes.TAG) return false;
                }
            }
            // ELEM_EXPR must have a DATA_TYPE child (named field, not anonymous embed)
            for (PsiElement child = elemExpr.getFirstChild(); child != null; child = child.getNextSibling()) {
                var cn = child.getNode();
                if (cn != null && cn.getElementType() == ApiTypes.DATA_TYPE) return true;
            }
            return false;
        }
    }

    /**
     * Inside an existing backtick tag literal.
     */
    public static class TagLiteral extends ApiLiveTemplateContextType {
        protected TagLiteral() {
            super("API_TAG_LITERAL");
        }

        @Override
        protected boolean acceptLeaf() {
            return true;
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            var node = element.getNode();
            if (node == null) return false;
            IElementType et = node.getElementType();
            if (et == ApiTypes.RAW_STRING) {
                PsiElement parent = element.getParent();
                return parent != null && parent.getNode() != null
                        && parent.getNode().getElementType() == ApiTypes.TAG;
            }
            return et == ApiTypes.TAG;
        }
    }
}
