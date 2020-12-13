package cn.xiaoheiban.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.IncorrectOperationException;
import org.antlr.jetbrains.adapter.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class IReference extends PsiReferenceBase<IdentifierPSINode> {
    public IReference(@NotNull IdentifierPSINode element) {
        super(element, new TextRange(0, element.getText().length()));
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        return myElement.setName(newElementName);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ScopeNode scope = (ScopeNode) myElement.getContext();
        if (scope == null) return null;

        return scope.resolve(myElement);
    }

    @Override
    public boolean isReferenceTo(PsiElement def) {
        String refName = myElement.getName();
        if (def instanceof IdentifierPSINode && isFieldTypeSubTree(def.getParent())) {
            def = def.getParent();
        }
        if (isFieldTypeSubTree(def)) {
            PsiElement id = ((PsiNameIdentifierOwner) def).getNameIdentifier();
            String defName = id != null ? id.getText() : null;
            return refName != null && defName != null && refName.equals(defName);
        }
        return false;
    }

    public abstract boolean isFieldTypeSubTree(PsiElement def);
}
