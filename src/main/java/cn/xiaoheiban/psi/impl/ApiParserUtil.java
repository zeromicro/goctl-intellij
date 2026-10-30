package cn.xiaoheiban.psi.impl;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

public class ApiParserUtil extends GeneratedParserUtilBase {

    // True when no line break separates the current token from the previous non-comment token.
    public static boolean sameLine(PsiBuilder b, int level) {
        for (int i = -1; ; i--) {
            IElementType type = b.rawLookup(i);
            if (type == null) {
                return true;
            }
            if (type == TokenType.WHITE_SPACE) {
                CharSequence text = b.getOriginalText().subSequence(b.rawTokenTypeStart(i), b.rawTokenTypeStart(i + 1));
                if (containsLineBreak(text)) {
                    return false;
                }
                continue;
            }
            if (type == cn.xiaoheiban.psi.ApiTypes.LINE_COMMENT || type == cn.xiaoheiban.psi.ApiTypes.BLOCK_COMMENT) {
                continue;
            }
            return true;
        }
    }

    private static boolean containsLineBreak(CharSequence text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n' || text.charAt(i) == '\r') {
                return true;
            }
        }
        return false;
    }
}
