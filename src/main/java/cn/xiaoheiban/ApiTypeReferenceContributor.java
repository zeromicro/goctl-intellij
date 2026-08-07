package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiBaseDataType;
import cn.xiaoheiban.psi.ApiBodyExpr;
import cn.xiaoheiban.psi.ApiElemExpr;
import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * Registers ApiTypeReference on IDENT leaf tokens that name user-defined types.
 *
 * Three patterns are covered:
 *   1. IDENT inside ApiBaseDataType — named field type, map/slice/array/pointer element
 *   2. IDENT inside ApiBodyExpr    — route request / response body type
 *   3. IDENT inside ApiElemExpr with no ApiDataType child — anonymous embedded field (Base / *Base)
 */
public class ApiTypeReferenceContributor extends PsiReferenceContributor {

    private static final PsiReferenceProvider NAMED_TYPE_PROVIDER = new PsiReferenceProvider() {
        @Override
        public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                               @NotNull ProcessingContext context) {
            String name = element.getText().trim();
            if (name.isEmpty() || ApiPsiUtil.isPrimitive(name)) return PsiReference.EMPTY_ARRAY;
            return new PsiReference[]{new ApiTypeReference(element)};
        }
    };

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {

        // Pattern 1: named field type / map / slice / array / pointer
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(ApiTypes.IDENT)
                        .withParent(ApiBaseDataType.class),
                NAMED_TYPE_PROVIDER);

        // Pattern 2: route request / response body
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(ApiTypes.IDENT)
                        .withParent(ApiBodyExpr.class),
                NAMED_TYPE_PROVIDER);

        // Pattern 3: anonymous embedded field (Base / *Base)
        // IDENT is a direct child of ApiElemExpr with no ApiDataType sibling.
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(ApiTypes.IDENT)
                        .withParent(ApiElemExpr.class),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(
                            @NotNull PsiElement element,
                            @NotNull ProcessingContext context) {
                        // Distinguish anonymous type from named field's field-name IDENTs.
                        // Named fields have an ApiDataType child; anonymous fields do not.
                        ApiElemExpr elemExpr = (ApiElemExpr) element.getParent();
                        if (elemExpr.getDataType() != null) return PsiReference.EMPTY_ARRAY;
                        String name = element.getText().trim();
                        if (name.isEmpty() || ApiPsiUtil.isPrimitive(name)) return PsiReference.EMPTY_ARRAY;
                        return new PsiReference[]{new ApiTypeReference(element)};
                    }
                });
    }
}
