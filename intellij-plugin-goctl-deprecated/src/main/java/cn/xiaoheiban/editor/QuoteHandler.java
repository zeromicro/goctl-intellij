package cn.xiaoheiban.editor;

import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class QuoteHandler implements MultiCharQuoteHandler {
    private static Map<String, String> quete = new HashMap();

    static {
        quete.put("\"", "\"");
        quete.put("`", "`");
        quete.put("'", "'");
    }

    @Override
    public @Nullable CharSequence getClosingQuote(@NotNull HighlighterIterator highlighterIterator, int offset) {
        Document document = highlighterIterator.getDocument();
        CharSequence closingQuote = null;

        if (document != null) {
            String openingQuote;
            if (offset >= 3) {
                openingQuote = document.getText(new TextRange(offset - 3, offset));
                closingQuote = quete.get(openingQuote);
            }
            if (closingQuote == null && offset >= 1) {
                openingQuote = document.getText(new TextRange(offset - 1, offset));
                closingQuote = quete.get(openingQuote);
            }
        }
        return closingQuote;
    }

    @Override
    public boolean isClosingQuote(HighlighterIterator highlighterIterator, int offset) {
        Document document = highlighterIterator.getDocument();
        if (document != null) {
            if (offset > 3) {
                String text = document.getText(new TextRange(offset - 3, offset));
                if (quete.containsValue(text)) {
                    return true;
                }
            }
            if (offset > 1) {
                String text = document.getText(new TextRange(offset - 1, offset));
                return quete.containsValue(text);
            }

        }
        return false;
    }

    @Override
    public boolean isOpeningQuote(HighlighterIterator highlighterIterator, int offset) {
        Document document = highlighterIterator.getDocument();
        if (document != null) {
            if (offset > 3) {
                String text = document.getText(new TextRange(offset - 3, offset));
                if (quete.containsValue(text)) {
                    return true;
                }
            }
            if (offset > 1) {
                String text = document.getText(new TextRange(offset - 1, offset));
                return quete.containsValue(text);
            }

        }
        return false;
    }

    @Override
    public boolean hasNonClosedLiteral(Editor editor, HighlighterIterator iterator, int offset) {
        return true;
    }

    @Override
    public boolean isInsideLiteral(HighlighterIterator iterator) {
        return false;
    }
}
