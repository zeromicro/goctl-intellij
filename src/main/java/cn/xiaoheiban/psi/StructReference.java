package cn.xiaoheiban.psi;

import cn.xiaoheiban.psi.nodes.ApiRootNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class StructReference extends IReference {
    public StructReference(@NotNull IdentifierPSINode element) {
        super(element);
    }

    @Override
    public boolean isFieldTypeSubTree(PsiElement element) {
        return element instanceof ApiRootNode;
    }

}
