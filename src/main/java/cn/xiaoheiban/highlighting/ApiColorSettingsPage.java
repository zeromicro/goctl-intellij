package cn.xiaoheiban.highlighting;

import cn.xiaoheiban.icon.ApiIcon;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ApiColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Separator", ApiSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Keyword", ApiSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Identifier", ApiSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("String", ApiSyntaxHighlighter.STRING),
            new AttributesDescriptor("Comment", ApiSyntaxHighlighter.COMMENT)
    };
    private static final String template = "syntax = \"v1\"\n" +
            "\n" +
            "import \"commong.api\"\n" +
            "\n" +
            "info(\n" +
            "    title: \"type title here\"\n" +
            "    desc: \"type desc here\"\n" +
            "    author: \"type author here\"\n" +
            "    email: \"type email here\"\n" +
            "    version: \"type version here\"\n" +
            ")\n" +
            "type alias int\n" +
            "\n" +
            "type (\n" +
            "    User {\n" +
            "        Name string `json:\"name\"`\n" +
            "    }\n" +
            "\n" +
            "    Person {\n" +
            "        Name string `json:\"name\"`\n" +
            "    }\n" +
            ")\n" +
            "\n" +
            "type Student {\n" +
            "    Name string `json:\"name\"`\n" +
            "}\n" +
            "\n" +
            "type Teacher {\n" +
            "    Name string `json:\"name\"`\n" +
            "    User\n" +
            "}\n" +
            "\n" +
            "type LoginReq {\n" +
            "    Username string `json:\"username\"`\n" +
            "    password string `json:\"password\"`\n" +
            "}\n" +
            "\n" +
            "type LoginReply {\n" +
            "    Token string `json:\"token\"`\n" +
            "    Expire int64 `json:\"expire\"`\n" +
            "    RefreshToken string `json:\"refreshToken\"`\n" +
            "}\n" +
            "\n" +
            "type UserInfoReply {\n" +
            "    Name string `json:\"name\"`\n" +
            "    Age int `json:\"age\"`\n" +
            "    Gender string `json:\"gender\"`\n" +
            "    Birthday string `json:\"birthday\"`\n" +
            "}\n" +
            "\n" +
            "type UserPasswordEditReq {\n" +
            "    OldPassword string `json:\"oldPassword\"`\n" +
            "    NewPassword string `json:\"newPassword\"`\n" +
            "}\n" +
            "\n" +
            "@server(\n" +
            "    jwt: Auth\n" +
            "    middleware: MetricMiddleware,LogMiddleware\n" +
            "    group: user\n" +
            ")\n" +
            "service user-api {\n" +
            "    @handler healthCheck\n" +
            "    post /user/health/check\n" +
            "\n" +
            "    @handler login\n" +
            "    post /user/login (LoginReq) returns (LoginReply)\n" +
            "\n" +
            "    @handler userInfo\n" +
            "    get /user/info returns (UserInfoReply)\n" +
            "\n" +
            "    @handler passwordEdit\n" +
            "    post /user/password/edit (UserPasswordEditReq)\n" +
            "}";

    @Override
    public @Nullable Icon getIcon() {
        return ApiIcon.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new ApiSyntaxHighlighter();
    }

    @Override
    public @NotNull String getDemoText() {
        return template;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public @NotNull AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public @NotNull ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Api";
    }
}
