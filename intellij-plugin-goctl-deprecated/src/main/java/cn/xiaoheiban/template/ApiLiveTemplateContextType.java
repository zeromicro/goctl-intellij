
package cn.xiaoheiban.template;

import cn.xiaoheiban.antlr4.ApiLexer;
import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.highlighting.ApiSyntaxHighlighter;
import cn.xiaoheiban.language.ApiLanguage;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract public class ApiLiveTemplateContextType extends TemplateContextType {
    protected ApiLiveTemplateContextType(@NotNull @NonNls String id,
                                         @NotNull String presentableName,
                                         @Nullable Class<? extends TemplateContextType> baseContextType) {
        super(id, presentableName, baseContextType);
    }

    @Override
    public boolean isInContext(@NotNull PsiFile file, int offset) {
        if (PsiUtilCore.getLanguageAtOffset(file, offset).isKindOf(ApiLanguage.INSTANCE)) {
            PsiElement psiElement = ObjectUtils.notNull(file.findElementAt(offset), file);
            if (!acceptLeaf()) {
                psiElement = getFirstCompositeElement(psiElement);
            }
            return psiElement != null && isInContext(psiElement);
        }

        return false;
    }

    protected boolean acceptLeaf() {
        return false;
    }

    @Nullable
    public static PsiElement prevVisibleLeafOrNewLine(PsiElement element) {
        PsiElement prevLeaf = element;
        while ((prevLeaf = PsiTreeUtil.prevLeaf(prevLeaf)) != null) {
            if (prevLeaf instanceof PsiComment || prevLeaf instanceof PsiErrorElement) {
                continue;
            }
            if (prevLeaf instanceof PsiWhiteSpace) {
                if (prevLeaf.textContains('\n')) {
                    return prevLeaf;
                }
                continue;
            }
            break;
        }
        return prevLeaf;
    }

    @Nullable
    private static PsiElement getFirstCompositeElement(@Nullable PsiElement at) {
        if (at instanceof PsiComment || at instanceof LeafPsiElement && ((LeafPsiElement) at).getElementType() == ApiParserDefinition.token(ApiLexer.VALUE))
            return at;
        PsiElement result = at;
        while (result != null && (result instanceof PsiWhiteSpace || result.getNode().getChildren(null).length == 0)) {
            result = result.getParent();
        }
        return result;
    }

    protected abstract boolean isInContext(@NotNull PsiElement element);

    @Override
    public SyntaxHighlighter createHighlighter() {
        return new ApiSyntaxHighlighter();
    }


    // struct域
    public static class Struct extends ApiLiveTemplateContextType {
        protected Struct() {
            super("API_STRUCT", "Struct", ApiEverywhereContextType.class);
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            ASTNode node = element.getNode();
            if (node == null) {
                return false;
            }
            ASTNode treeParent = node.getTreeParent();
            if (treeParent == null) {
                return false;
            }

            return treeParent.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_normalFieldType));
        }
    }

    // api file域
    public static class ApiFile extends ApiLiveTemplateContextType {
        protected ApiFile() {
            super("API_FILE", "ApiFile", ApiEverywhereContextType.class);
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            ASTNode node = element.getNode();
            if (node == null) {
                return false;
            }
            ASTNode treeParent = node.getTreeParent();
            if (treeParent == null) {
                return false;
            }

            return treeParent.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_apiBody)) || treeParent.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_api));
        }
    }

    // service域
    public static class ApiService extends ApiLiveTemplateContextType {
        protected ApiService() {
            super("API_SERVICE", "ApiService", ApiEverywhereContextType.class);
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            ASTNode node = element.getNode();
            while (true) {
                if (node == null) {
                    return false;
                }
                if (node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_serviceStatement))) {
                    return true;
                }
                if (node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_serviceSpec))) {
                    return true;
                }
                if (node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_serviceBody))) {
                    return true;
                }
                node = node.getTreeParent();
            }
        }
    }


    public static class Tag extends ApiLiveTemplateContextType {
        protected Tag() {
            super("API_TAG", "Tag", ApiEverywhereContextType.class);
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            if (element.getNode().getElementType() == ApiParserDefinition.IDENTIFIER) {
                if (isInsideFieldTypeDeclaration(element)) {
                    return true;
                }
                if (isInsideFieldTypeDeclaration(prevVisibleLeafOrNewLine(element))) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isInsideFieldTypeDeclaration(@Nullable PsiElement element) {
            if (element != null) {
                PsiElement parent = element.getParent();
                ASTNode node = parent.getNode();
                if (node == null) {
                    return false;
                }
                ASTNode normalTypeNode = node.getTreeParent();
                if (normalTypeNode == null) {
                    return false;
                }
                ASTNode filedNode = normalTypeNode.getTreeParent();
                if (filedNode == null) {
                    return false;
                }
                IElementType elementType = filedNode.getElementType();
                return elementType.equals(ApiParserDefinition.rule(ApiParser.RULE_typeFiled));
            }
            return false;
        }

        @Override
        protected boolean acceptLeaf() {
            return true;
        }
    }

    public static class TagLiteral extends ApiLiveTemplateContextType {
        protected TagLiteral() {
            super("API_TAG_LITERAL", "Tag literal", ApiEverywhereContextType.class);
        }

        @Override
        protected boolean isInContext(@NotNull PsiElement element) {
            ASTNode node = element.getNode();
            if (node == null) {
                return false;
            }
            return node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_tag));
        }
    }

}
