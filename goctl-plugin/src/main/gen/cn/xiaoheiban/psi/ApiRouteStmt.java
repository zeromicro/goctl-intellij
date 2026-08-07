// This is a generated file. Not intended for manual editing.
package cn.xiaoheiban.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ApiRouteStmt extends PsiElement {

  @NotNull
  List<ApiBodyClause> getBodyClauseList();

  @NotNull
  ApiHttpMethod getHttpMethod();

  @NotNull
  ApiPathExpr getPathExpr();

}
