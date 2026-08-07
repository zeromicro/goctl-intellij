package cn.xiaoheiban;

import com.intellij.lang.CodeDocumentationAwareCommenter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import cn.xiaoheiban.psi.ApiTypes;
import org.jetbrains.annotations.Nullable;

public class ApiCommenter implements CodeDocumentationAwareCommenter {

    @Override public @Nullable String getLineCommentPrefix() { return "//"; }
    @Override public @Nullable String getBlockCommentPrefix() { return "/*"; }
    @Override public @Nullable String getBlockCommentSuffix() { return "*/"; }
    @Override public @Nullable String getCommentedBlockCommentPrefix() { return null; }
    @Override public @Nullable String getCommentedBlockCommentSuffix() { return null; }

    @Override public @Nullable IElementType getLineCommentTokenType() { return ApiTypes.LINE_COMMENT; }
    @Override public @Nullable IElementType getBlockCommentTokenType() { return ApiTypes.BLOCK_COMMENT; }
    @Override public @Nullable IElementType getDocumentationCommentTokenType() { return null; }
    @Override public @Nullable String getDocumentationCommentPrefix() { return null; }
    @Override public @Nullable String getDocumentationCommentLinePrefix() { return null; }
    @Override public @Nullable String getDocumentationCommentSuffix() { return null; }
    @Override public boolean isDocumentationComment(PsiComment element) { return false; }
}
