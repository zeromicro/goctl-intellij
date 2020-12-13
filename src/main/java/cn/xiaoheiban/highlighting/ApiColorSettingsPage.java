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
    private static final String template = "info (\n" +
            "    title:\"api highlighter\"\n" +
            "    desc:\"api highlighter description\"\n" +
            "    author:\"xiaoheiban\"\n" +
            "    email:\"\"\n" +
            "    version:\"1.0\"\n" +
            ")\n" +
            "\n" +
            "type Gender int\n" +
            "\n" +
            "type Anonymous struct{}\n" +
            "\n" +
            "type Pointer struct{}\n" +
            "\n" +
            "type Struct struct {\n" +
            "    // 字符串\n" +
            "    String string `json:\"string\"`\n" +
            "    // 性别\n" +
            "    Gender Gender `json:\"gender\"`\n" +
            "    // 匿名类型\n" +
            "    Anonymous\n" +
            "    // 指针类型\n" +
            "    Pointer *Pointer\n" +
            "    // map类型:key必须为go系统类型中的比较类型(number、string、bool)\n" +
            "    M1 map[string]int\n" +
            "    // 数组或切片类型\n" +
            "    Array []string\n" +
            "    // inline\n" +
            "    Inline struct {\n" +
            "        Name string\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "type (\n" +
            "    LoginRequest struct{\n" +
            "        // todo\n" +
            "    }\n" +
            "\n" +
            "    LoginResponse struct{\n" +
            "        // todo\n" +
            "    }\n" +
            "\n" +
            "    UserInfoRequest struct{\n" +
            "        Id string `path:\"id\"`\n" +
            "    }\n" +
            "\n" +
            "    UserInfoResponse struct {\n" +
            "        // todo\n" +
            "    }\n" +
            ")\n" +
            "\n" +
            "@server (\n" +
            "   jwt: Auth\n" +
            "   folder: user\n" +
            ")\n" +
            "service user {\n" +
            "    @doc(\n" +
            "        summary:\"login\"\n" +
            "    )\n" +
            "    @server(\n" +
            "        handler: login\n" +
            "    )\n" +
            "    post /user/login (LoginRequest)returns(LoginResponse);\n" +
            "    \n" +
            "    @server(\n" +
            "        handler: userInfo\n" +
            "    )\n" +
            "    get /user/info/:id () returns (UserInfoResponse);\n" +
            "}\n" +
            "\n";

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
