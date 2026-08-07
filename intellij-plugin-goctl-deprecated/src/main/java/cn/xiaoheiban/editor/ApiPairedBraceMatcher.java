package cn.xiaoheiban.editor;

import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ApiPairedBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = {
            new BracePair(ApiParserDefinition.LPAREN, ApiParserDefinition.RPAREN, false),
            new BracePair(ApiParserDefinition.LBRACE, ApiParserDefinition.RBRACE, true),
            new BracePair(ApiParserDefinition.LBRACK, ApiParserDefinition.RBRACK, false),
    };

    @Override
    public @NotNull BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
