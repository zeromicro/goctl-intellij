package cn.xiaoheiban.template;


import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

public class ApiLiveTemplatesProvider implements DefaultLiveTemplatesProvider {

    @Override
    public String[] getDefaultLiveTemplateFiles() {
       return new String[]{"/liveTemplates/api", "/liveTemplates/apiTags"};
    }

    @Nullable
    @Override
    public  String[] getHiddenLiveTemplateFiles() {
        return new String[]{"/liveTemplates/apiHidden"};
    }
}
