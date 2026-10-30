package cn.xiaoheiban;

import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingContext;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.Wrap;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nullable;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ApiFormattingModelBuilder implements FormattingModelBuilder {

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext ctx) {
        PsiElement element = ctx.getPsiElement();
        CodeStyleSettings settings = ctx.getCodeStyleSettings();
        ASTNode root = element.getContainingFile().getNode();
        if (PsiTreeUtil.hasErrorElements(element.getContainingFile())) {
            Block untouched = new UntouchedBlock(root);
            return FormattingModelProvider.createFormattingModelForPsiFile(
                    element.getContainingFile(), untouched, settings);
        }
        Block block = new ApiBlock(root, null, Indent.getNoneIndent(), null, settings, null, null);
        return FormattingModelProvider.createFormattingModelForPsiFile(
                element.getContainingFile(), block, settings);
    }

    // Files the parser cannot fully understand are left as-is instead of being reformatted incorrectly.
    private static class UntouchedBlock implements Block {
        private final ASTNode node;

        UntouchedBlock(ASTNode node) {
            this.node = node;
        }

        @Override
        public @NotNull TextRange getTextRange() {
            return node.getTextRange();
        }

        @Override
        public @NotNull List<Block> getSubBlocks() {
            return Collections.emptyList();
        }

        @Override
        public @Nullable Wrap getWrap() {
            return null;
        }

        @Override
        public @Nullable Indent getIndent() {
            return Indent.getNoneIndent();
        }

        @Override
        public @Nullable Alignment getAlignment() {
            return null;
        }

        @Override
        public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
            return null;
        }

        @Override
        public @NotNull com.intellij.formatting.ChildAttributes getChildAttributes(int newChildIndex) {
            return new com.intellij.formatting.ChildAttributes(Indent.getNoneIndent(), null);
        }

        @Override
        public boolean isIncomplete() {
            return false;
        }

        @Override
        public boolean isLeaf() {
            return true;
        }
    }
}
