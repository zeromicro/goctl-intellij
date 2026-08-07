package cn.xiaoheiban.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class ApiCompositeElement extends ASTWrapperPsiElement {
    public ApiCompositeElement(@NotNull ASTNode node) {
        super(node);
    }
}
