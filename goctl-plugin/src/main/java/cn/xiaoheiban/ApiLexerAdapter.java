package cn.xiaoheiban;

import com.intellij.lexer.FlexAdapter;

public class ApiLexerAdapter extends FlexAdapter {

    public ApiLexerAdapter() {
        super(new ApiLexer(null));
    }

}