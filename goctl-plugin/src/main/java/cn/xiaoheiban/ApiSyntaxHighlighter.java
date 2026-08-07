package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ApiSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("API_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("API_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("API_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("API_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("API_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("API_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BRACKETS =
            createTextAttributesKey("API_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey PARENTHESES =
            createTextAttributesKey("API_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("API_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    /** Go primitive types: string, int, bool … — same color as Go's built-in type references. */
    public static final TextAttributesKey PRIMITIVE_TYPE =
            createTextAttributesKey("API_PRIMITIVE_TYPE",
                    com.goide.highlighting.GoSyntaxHighlightingColors.BUILTIN_TYPE_REFERENCE);

    /**
     * Struct type declaration name (type Foo {}) — same color as Go's type specification.
     * Follows GoLand's own color for type declarations.
     */
    public static final TextAttributesKey TYPE_DECL =
            createTextAttributesKey("API_TYPE_DECL",
                    com.goide.highlighting.GoSyntaxHighlightingColors.TYPE_SPECIFICATION);

    /**
     * Struct type reference in field / body / anonymous embed — same color as Go's exported struct reference.
     */
    public static final TextAttributesKey CLASS_TYPE =
            createTextAttributesKey("API_CLASS_TYPE",
                    com.goide.highlighting.GoSyntaxHighlightingColors.TYPE_SPEC_REFERENCE);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[]{BRACKETS};
    private static final TextAttributesKey[] PARENTHESES_KEYS = new TextAttributesKey[]{PARENTHESES};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ApiLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ApiTypes.COLON) || tokenType.equals(ApiTypes.COMMA) || tokenType.equals(ApiTypes.ASSIGN)) {
            return SEPARATOR_KEYS;
        }
        if (tokenType.equals(ApiTypes.SYNTAX) ||
                tokenType.equals(ApiTypes.INFO) ||
                tokenType.equals(ApiTypes.MAP) ||
                tokenType.equals(ApiTypes.STRUCT) ||
                tokenType.equals(ApiTypes.TYPE) ||
                tokenType.equals(ApiTypes.ATSERVER) ||
                tokenType.equals(ApiTypes.ATHANDLER) ||
                tokenType.equals(ApiTypes.ATDOC) ||
                tokenType.equals(ApiTypes.SERVICE) ||
                tokenType.equals(ApiTypes.RETURNS) ||
                tokenType.equals(ApiTypes.GET) ||
                tokenType.equals(ApiTypes.HEAD) ||
                tokenType.equals(ApiTypes.POST) ||
                tokenType.equals(ApiTypes.PUT) ||
                tokenType.equals(ApiTypes.PATCH) ||
                tokenType.equals(ApiTypes.DELETE) ||
                tokenType.equals(ApiTypes.CONNECT) ||
                tokenType.equals(ApiTypes.OPTIONS) ||
                tokenType.equals(ApiTypes.TRACE) ||
                tokenType.equals(ApiTypes.INTERFACE) ||
                tokenType.equals(ApiTypes.BASE_DATA_TYPE) ||
                tokenType.equals(ApiTypes.ANY) ||
                tokenType.equals(ApiTypes.IMPORT)
        ) {
            return KEY_KEYS;
        }
        if (tokenType.equals(ApiTypes.RAW_STRING) || tokenType.equals(ApiTypes.STRING)) {
            return VALUE_KEYS;
        }
        if (tokenType.equals(ApiTypes.LINE_COMMENT) || tokenType.equals(ApiTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(ApiTypes.LBRACE) || tokenType.equals(ApiTypes.RBRACE)) {
            return BRACKETS_KEYS;
        }
        if (tokenType.equals(ApiTypes.LPAREN) || tokenType.equals(ApiTypes.RPAREN)) {
            return PARENTHESES_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}