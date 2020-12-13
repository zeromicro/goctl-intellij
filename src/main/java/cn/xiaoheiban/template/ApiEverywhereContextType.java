package cn.xiaoheiban.template;

import cn.xiaoheiban.antlr4.ApiLexer;
import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.codeInsight.template.EverywhereContextType;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;

public class ApiEverywhereContextType extends ApiLiveTemplateContextType {
    protected ApiEverywhereContextType() {
        super("API", "Api", EverywhereContextType.class);
    }

    @Override
    protected boolean isInContext(@NotNull PsiElement element) {
        return !(element instanceof PsiComment ||
                element instanceof LeafPsiElement && ((LeafPsiElement) element).getElementType() == ApiParserDefinition.token(ApiLexer.VALUE));
    }
}
