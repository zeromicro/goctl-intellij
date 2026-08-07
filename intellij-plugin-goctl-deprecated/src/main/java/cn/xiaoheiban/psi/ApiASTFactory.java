package cn.xiaoheiban.psi;

import cn.xiaoheiban.antlr4.ApiLexer;
import com.intellij.lang.DefaultASTFactoryImpl;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import org.antlr.jetbrains.adapter.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

public class ApiASTFactory extends DefaultASTFactoryImpl {
    @NotNull
    @Override
    public CompositeElement createComposite(@NotNull IElementType type) {
        return super.createComposite(type);
    }

    @NotNull
    @Override
    public LeafElement createLeaf(@NotNull IElementType type, @NotNull CharSequence text) {
        // 控制跳转的字段类型
        if (type instanceof TokenIElementType) {
            TokenIElementType elementType = (TokenIElementType) type;
            int antlrTokenType = elementType.getAntlrTokenType();
            if (antlrTokenType == ApiLexer.IDENT) {
                return new IdentifierPSINode(type, text);
            }
        }
        return super.createLeaf(type, text);
    }
}
