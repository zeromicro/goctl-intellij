package cn.xiaoheiban.psi;

import com.intellij.psi.tree.TokenSet;

public interface ApiTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(ApiTypes.IDENT);

    TokenSet COMMENTS = TokenSet.create(ApiTypes.LINE_COMMENT, ApiTypes.BLOCK_COMMENT);
}
