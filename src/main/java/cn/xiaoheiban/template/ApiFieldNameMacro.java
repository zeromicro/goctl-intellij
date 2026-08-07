package cn.xiaoheiban.template;

import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.template.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/** Returns the field name at the cursor position, used inside tag templates. */
public class ApiFieldNameMacro extends Macro {

    @Override public String getName() { return "apiFieldName"; }
    @Override public String getPresentableName() { return "apiFieldName()"; }

    @Override
    public @Nullable Result calculateResult(@NotNull Expression[] params, ExpressionContext context) {
        String name = fieldNames(context).stream().findFirst().orElse(null);
        return StringUtil.isNotEmpty(name) ? new TextResult(name) : null;
    }

    @Override
    public @Nullable LookupElement[] calculateLookupItems(@NotNull Expression[] params, ExpressionContext context) {
        return fieldNames(context).stream()
                .map(LookupElementBuilder::create)
                .toArray(LookupElement[]::new);
    }

    @Override
    public boolean isAcceptableInContext(TemplateContextType context) {
        return context instanceof ApiLiveTemplateContextType.Tag
                || context instanceof ApiLiveTemplateContextType.TagLiteral;
    }

    private static Set<String> fieldNames(ExpressionContext context) {
        PsiElement psi = context != null ? context.getPsiElementAtStartOffset() : null;
        if (psi == null) return Collections.emptySet();

        ASTNode node = psi.getNode();
        while (node != null) {
            if (node.getElementType() == ApiTypes.ELEM_EXPR) {
                // First IDENT child is the field name
                for (ASTNode child = node.getFirstChildNode(); child != null; child = child.getTreeNext()) {
                    if (child.getElementType() == ApiTypes.IDENT) {
                        Set<String> result = new LinkedHashSet<>();
                        result.add(child.getText());
                        return result;
                    }
                }
                return Collections.emptySet();
            }
            node = node.getTreeParent();
        }
        return Collections.emptySet();
    }
}
