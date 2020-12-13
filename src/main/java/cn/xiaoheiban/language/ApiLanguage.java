package cn.xiaoheiban.language;

import com.intellij.lang.Language;

public class ApiLanguage extends Language {

    public static final ApiLanguage INSTANCE = new ApiLanguage();

    private ApiLanguage() {
        super("api");
    }
}
