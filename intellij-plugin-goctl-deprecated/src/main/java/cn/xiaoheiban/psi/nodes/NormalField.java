package cn.xiaoheiban.psi.nodes;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class NormalField extends IPsiNode {
    public NormalField(@NotNull ASTNode node) {
        super(node);
    }

    public String getFieldName() {
        return getFieldNode().getText();
    }

    public PsiElement getFieldNode() {
        return this.getFirstChild();
    }
}
