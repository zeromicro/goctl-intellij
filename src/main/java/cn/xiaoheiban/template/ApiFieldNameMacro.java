

package cn.xiaoheiban.template;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.template.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ApiFieldNameMacro extends Macro {
    @Override
    public String getName() {
        return "apiFieldName";
    }

    @Override
    public String getPresentableName() {
        return "apiFieldName()";
    }

    @Nullable
    @Override
    public Result calculateResult(@NotNull Expression[] params, ExpressionContext context) {
        String name = ContainerUtil.getFirstItem(fieldNames(context));
        return StringUtil.isNotEmpty(name) ? new TextResult(name) : null;
    }

    @Nullable
    @Override
    public LookupElement[] calculateLookupItems(@NotNull Expression[] params, ExpressionContext context) {
        return ContainerUtil.map2Array(fieldNames(context), LookupElement.class, LookupElementBuilder::create);
    }

    @Override
    public boolean isAcceptableInContext(TemplateContextType context) {
        return context instanceof ApiLiveTemplateContextType.Tag || context instanceof ApiLiveTemplateContextType.TagLiteral;
    }

    private static Set<String> fieldNames(ExpressionContext context) {
        PsiElement psiElement = context != null ? context.getPsiElementAtStartOffset() : null;
        if (psiElement == null) {
            return Collections.emptySet();
        }
        ASTNode node = psiElement.getNode();
        while (true) {
            if (node == null) {
                return Collections.emptySet();
            }
            if (node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_normalField))) {
                ASTNode fieldNameNode = node.getFirstChildNode();
                if (fieldNameNode == null) {
                    return Collections.emptySet();
                }
                IElementType elementType = fieldNameNode.getElementType();
                if (elementType.equals(ApiParserDefinition.rule(ApiParser.RULE_fieldName))) {
                    Set<String> set = new HashSet<String>();
                    set.add(fieldNameNode.getText());
                    return set;
                }
            } else if (node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_fieldName))) {
                Set<String> set = new HashSet<String>();
                set.add(node.getText());
                return set;
            }
            node = node.getTreeParent();
        }
    }
}
