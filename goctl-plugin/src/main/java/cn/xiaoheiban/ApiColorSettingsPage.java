package cn.xiaoheiban;

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
            new AttributesDescriptor("Keyword", ApiSyntaxHighlighter.KEY),
            new AttributesDescriptor("Identifier", ApiSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("String", ApiSyntaxHighlighter.STRING),
            new AttributesDescriptor("Comment", ApiSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Separator", ApiSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Braces", ApiSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Parentheses", ApiSyntaxHighlighter.PARENTHESES),
            new AttributesDescriptor("Type//Type declaration name", ApiSyntaxHighlighter.TYPE_DECL),
            new AttributesDescriptor("Type//Struct type reference", ApiSyntaxHighlighter.CLASS_TYPE),
            new AttributesDescriptor("Type//Primitive type (string, int, bool...)", ApiSyntaxHighlighter.PRIMITIVE_TYPE),
    };
    private static final String template = """
            syntax = "v1"
            
            import "commong.api"
            
            info(
                title: "type title here"
                desc: "type desc here"
                author: "type author here"
                email: "type email here"
                version: "type version here"
            )
            type alias int
            
            type (
                User {
                    Name string `json:"name"`
                }
            
                Person {
                    Name string `json:"name"`
                }
            )
            
            type Student {
                Name string `json:"name"`
            }
            
            type Teacher {
                Name string `json:"name"`
                User
            }
            
            type LoginReq {
                Username string `json:"username"`
                password string `json:"password"`
            }
            
            type LoginReply {
                Token string `json:"token"`
                Expire int64 `json:"expire"`
                RefreshToken string `json:"refreshToken"`
            }
            
            type UserInfoReply {
                Name string `json:"name"`
                Age int `json:"age"`
                Gender string `json:"gender"`
                Birthday string `json:"birthday"`
            }
            
            type UserPasswordEditReq {
                OldPassword string `json:"oldPassword"`
                NewPassword string `json:"newPassword"`
            }
            
            @server(
                jwt: Auth
                middleware: MetricMiddleware,LogMiddleware
                group: user
            )
            service user-api {
                @handler healthCheck
                post /user/health/check
            
                @handler login
                post /user/login (LoginReq) returns (LoginReply)
            
                @handler userInfo
                get /user/info returns (UserInfoReply)
            
                @handler passwordEdit
                post /user/password/edit (UserPasswordEditReq)
            }""";

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
