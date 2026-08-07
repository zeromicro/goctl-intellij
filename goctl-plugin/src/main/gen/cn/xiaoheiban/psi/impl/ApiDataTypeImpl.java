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

public class ApiDataTypeImpl extends ApiCompositeElement implements ApiDataType {

  public ApiDataTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ApiVisitor visitor) {
    visitor.visitDataType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ApiVisitor) accept((ApiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ApiAnyType getAnyType() {
    return findChildByClass(ApiAnyType.class);
  }

  @Override
  @Nullable
  public ApiArrayDataType getArrayDataType() {
    return findChildByClass(ApiArrayDataType.class);
  }

  @Override
  @Nullable
  public ApiBaseDataType getBaseDataType() {
    return findChildByClass(ApiBaseDataType.class);
  }

  @Override
  @Nullable
  public ApiMapDataType getMapDataType() {
    return findChildByClass(ApiMapDataType.class);
  }

  @Override
  @Nullable
  public ApiPointerDataType getPointerDataType() {
    return findChildByClass(ApiPointerDataType.class);
  }

  @Override
  @Nullable
  public ApiSliceDataType getSliceDataType() {
    return findChildByClass(ApiSliceDataType.class);
  }

  @Override
  @Nullable
  public ApiStructDataType getStructDataType() {
    return findChildByClass(ApiStructDataType.class);
  }

}
