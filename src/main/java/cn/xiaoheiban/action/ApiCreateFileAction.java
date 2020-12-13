package cn.xiaoheiban.action;

import cn.xiaoheiban.icon.ApiIcon;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ApiCreateFileAction extends CreateFileFromTemplateAction implements DumbAware {
    public static final String FILE_TEMPLATE = "Api File";
    public static final String APPLICATION_TEMPLATE = "Api Template";
    private static final String NEW_API_FILE = "New Api File";

    private static final String DEFAULT_API_TEMPLATE_PROPERTY = "DefaultApiTemplateProperty";


    public ApiCreateFileAction() {
        super(NEW_API_FILE, "", ApiIcon.FILE);
    }

    @Override
    protected void buildDialog(@NotNull Project project, @NotNull PsiDirectory directory, CreateFileFromTemplateDialog.@NotNull Builder builder) {
        builder.setTitle(FILE_TEMPLATE)
                .addKind("Empty file", ApiIcon.FILE, FILE_TEMPLATE)
                .addKind("Api Template", ApiIcon.FILE, APPLICATION_TEMPLATE);
    }

    @Override
    protected @NlsContexts.Command String getActionName(PsiDirectory directory, @NotNull String newName, String templateName) {
        return NEW_API_FILE;
    }

    @Override
    protected @Nullable String getDefaultTemplateProperty() {
        return DEFAULT_API_TEMPLATE_PROPERTY;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ApiCreateFileAction;
    }
}
