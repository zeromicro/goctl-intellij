// This is a generated file. Not intended for manual editing.
package cn.xiaoheiban.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ApiServiceBody extends PsiElement {

  @Nullable
  ApiAtDocClause getAtDocClause();

  @NotNull
  ApiAtHandlerClause getAtHandlerClause();

  @NotNull
  ApiRouteStmt getRouteStmt();

}
