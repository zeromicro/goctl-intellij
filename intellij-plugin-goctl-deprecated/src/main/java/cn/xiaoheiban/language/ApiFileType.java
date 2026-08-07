package cn.xiaoheiban.language;

import cn.xiaoheiban.icon.ApiIcon;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ApiFileType extends LanguageFileType {

    public static final String FILE_EXTENSION = "api";

    public static final ApiFileType INSTANCE = new ApiFileType();

    private ApiFileType() {
        super(ApiLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Api File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Api language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return FILE_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ApiIcon.FILE;
    }
}
