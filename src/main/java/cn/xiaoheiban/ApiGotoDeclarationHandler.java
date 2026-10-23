package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiBaseDataType;
import cn.xiaoheiban.psi.ApiAtHandlerClause;
import cn.xiaoheiban.psi.ApiBodyExpr;
import cn.xiaoheiban.psi.ApiElemExpr;
import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandlerBase;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

/**
 * Handles Cmd+Click (Go To Declaration) for handler functions and user-defined types.
 *
 * Triggered when clicking an IDENT leaf token that is a direct child of:
 *   ApiAtHandlerClause — a generated Go handler function
 *   ApiBaseDataType — struct field types, map/slice/array/pointer element types
 *   ApiBodyExpr     — route request / response body types
 *
 * Navigates to the ApiTypeLiteralExpr that declares the type, searching
 * the current file and all transitively imported files.
 */
public class ApiGotoDeclarationHandler extends GotoDeclarationHandlerBase {

    @Override
    public PsiElement @Nullable [] getGotoDeclarationTargets(
            @Nullable PsiElement sourceElement, int offset, Editor editor) {
        if (sourceElement != null && sourceElement.getNode().getElementType() == ApiTypes.IDENT
                && sourceElement.getParent() instanceof ApiAtHandlerClause clause) {
            return ApiHandlerResolver.findTargets(clause);
        }
        return super.getGotoDeclarationTargets(sourceElement, offset, editor);
    }

    @Override
    public @Nullable PsiElement getGotoDeclarationTarget(
            @Nullable PsiElement sourceElement,
            Editor editor) {

        if (sourceElement == null) return null;

        // Only handle IDENT leaf tokens
        if (sourceElement.getNode().getElementType() != ApiTypes.IDENT) return null;

        PsiElement parent = sourceElement.getParent();

        String typeName = null;

        if (parent instanceof ApiBaseDataType) {
            // Named field type / map / slice / array / pointer element type
            typeName = sourceElement.getText().trim();
        } else if (parent instanceof ApiBodyExpr) {
            // Route request / response body type
            typeName = sourceElement.getText().trim();
        } else if (parent instanceof ApiElemExpr elemExpr) {
            // Anonymous embedded field: Base or *Base
            // Only navigate when elemExpr has NO ApiDataType child.
            // If it has one, the leading IDENTs are field names, not type references.
            if (elemExpr.getDataType() == null) {
                typeName = sourceElement.getText().trim();
            }
        }

        if (typeName == null || typeName.isEmpty() || ApiPsiUtil.isPrimitive(typeName)) return null;

        PsiFile file = sourceElement.getContainingFile();
        if (!(file instanceof ApiFile apiFile)) return null;

        // findTypeDeclaration searches current file + all transitively imported files
        return ApiPsiUtil.findTypeDeclaration(apiFile, typeName);
    }
}
