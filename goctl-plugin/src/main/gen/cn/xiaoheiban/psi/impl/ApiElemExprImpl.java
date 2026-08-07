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

public class ApiElemExprImpl extends ApiCompositeElement implements ApiElemExpr {

  public ApiElemExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ApiVisitor visitor) {
    visitor.visitElemExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ApiVisitor) accept((ApiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ApiDataType getDataType() {
    return findChildByClass(ApiDataType.class);
  }

  @Override
  @Nullable
  public ApiTag getTag() {
    return findChildByClass(ApiTag.class);
  }

}
