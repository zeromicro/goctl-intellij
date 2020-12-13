package cn.xiaoheiban.highlighting;

import cn.xiaoheiban.antlr4.ApiLexer;
import cn.xiaoheiban.language.ApiLanguage;
import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.antlr.jetbrains.adapter.lexer.AntlrLexerAdapter;
import org.antlr.jetbrains.adapter.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ApiSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("API_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("API_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("API_IDENTIFIER", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("API_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("API_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("API_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] ATTR_SEPARATOR = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] ATTR_KEYWORD = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] ATTR_IDENTIFIER = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] ATTR_STRING = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] ATTR_COMMENT = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] ATTR_BAD_CHARACTER = new TextAttributesKey[]{BAD_CHARACTER};


    @Override
    public @NotNull Lexer getHighlightingLexer() {
        ApiLexer lexer = new ApiLexer(null);
        return new AntlrLexerAdapter(ApiLanguage.INSTANCE, lexer, ApiParserDefinition.ELEMENT_FACTORY);
    }


    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        TextAttributesKey[] attrs;
        if (tokenType instanceof TokenIElementType) {
            TokenIElementType myType = (TokenIElementType) tokenType;
            int ttype = myType.getAntlrTokenType();
            switch (ttype) {
                case ApiLexer.INFO:
                case ApiLexer.MAP:
                case ApiLexer.STRUCT:
                case ApiLexer.TYPE:
                case ApiLexer.ATSERVER:
                case ApiLexer.ATHANDLER:
                case ApiLexer.ATDOC:
                case ApiLexer.SERVICE:
                case ApiLexer.RETURNS:
                case ApiLexer.HTTPMETHOD:
                case ApiLexer.INTERFACE:
                case ApiLexer.IMPORT:
                    attrs = ATTR_KEYWORD;
                    break;
                case ApiLexer.GOTYPE:
                    attrs = ATTR_IDENTIFIER;
                    break;
                case ApiLexer.RAW_STRING:
                case ApiLexer.VALUE:
                    attrs = ATTR_STRING;
                    break;
                case ApiLexer.COMMENT:
                    attrs = ATTR_COMMENT;
                    break;
                case ApiLexer.COLON:
                    attrs = ATTR_SEPARATOR;
                    break;
                case ApiLexer.ERRCHAR:
                    attrs = ATTR_BAD_CHARACTER;
                    break;
                default:
                    attrs = EMPTY_KEYS;
            }
        } else {
            if (tokenType.equals(TokenType.BAD_CHARACTER) || tokenType.equals(TokenType.ERROR_ELEMENT)) {
                attrs = ATTR_BAD_CHARACTER;
            } else {
                attrs = ATTR_BAD_CHARACTER;
            }
        }

        return attrs;
    }

}
