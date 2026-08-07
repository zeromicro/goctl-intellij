package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiFile;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Reference attached to an IDENT leaf token that names a user-defined type.
 * resolve() returns the ApiTypeLiteralExpr declaring that type.
 * Used by PsiReferenceContributor; enables Cmd+Click via the standard PsiReference mechanism.
 */
public class ApiTypeReference extends PsiReferenceBase<PsiElement> {

    public ApiTypeReference(@NotNull PsiElement identLeaf) {
        super(identLeaf, TextRange.from(0, identLeaf.getTextLength()));
    }

    @Override
    public @Nullable PsiElement resolve() {
        String typeName = myElement.getText().trim();
        if (ApiPsiUtil.isPrimitive(typeName)) return null;
        PsiFile file = myElement.getContainingFile();
        if (!(file instanceof ApiFile apiFile)) return null;
        return ApiPsiUtil.findTypeDeclaration(apiFile, typeName);
    }

    @Override
    public Object @NotNull [] getVariants() {
        return EMPTY_ARRAY;
    }
}
