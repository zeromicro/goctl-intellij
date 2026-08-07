package cn.xiaoheiban;

import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingContext;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public class ApiFormattingModelBuilder implements FormattingModelBuilder {

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext ctx) {
        PsiElement element = ctx.getPsiElement();
        CodeStyleSettings settings = ctx.getCodeStyleSettings();
        ASTNode root = element.getContainingFile().getNode();
        Block block = new ApiBlock(root, null, Indent.getNoneIndent(), null, settings, null, null);
        return FormattingModelProvider.createFormattingModelForPsiFile(
                element.getContainingFile(), block, settings);
    }
}
