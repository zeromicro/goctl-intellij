// This is a generated file. Not intended for manual editing.
package cn.xiaoheiban.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cn.xiaoheiban.psi.ApiTypes.*;
import cn.xiaoheiban.psi.ApiCompositeElement;
import cn.xiaoheiban.psi.*;

public class ApiServiceBodyImpl extends ApiCompositeElement implements ApiServiceBody {

  public ApiServiceBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ApiVisitor visitor) {
    visitor.visitServiceBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ApiVisitor) accept((ApiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ApiAtDocClause getAtDocClause() {
    return findChildByClass(ApiAtDocClause.class);
  }

  @Override
  @NotNull
  public ApiAtHandlerClause getAtHandlerClause() {
    return findNotNullChildByClass(ApiAtHandlerClause.class);
  }

  @Override
  @NotNull
  public ApiRouteStmt getRouteStmt() {
    return findNotNullChildByClass(ApiRouteStmt.class);
  }

}
