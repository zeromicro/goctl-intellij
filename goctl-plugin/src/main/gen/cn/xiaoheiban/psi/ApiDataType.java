// This is a generated file. Not intended for manual editing.
package cn.xiaoheiban.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ApiDataType extends PsiElement {

  @Nullable
  ApiAnyType getAnyType();

  @Nullable
  ApiArrayDataType getArrayDataType();

  @Nullable
  ApiBaseDataType getBaseDataType();

  @Nullable
  ApiMapDataType getMapDataType();

  @Nullable
  ApiPointerDataType getPointerDataType();

  @Nullable
  ApiSliceDataType getSliceDataType();

  @Nullable
  ApiStructDataType getStructDataType();

}
