package cn.xiaoheiban.action;

import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.PsiDirectory;
import com.intellij.util.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProtoCreateFileAction extends CreateFileFromTemplateAction implements DumbAware {
    public static final String FILE_TEMPLATE = "Proto File";
    public static final String APPLICATION_TEMPLATE = "Proto Template";
    private static final String NEW_PROTO_FILE = "New Proto File";

    private static final String DEFAULT_API_TEMPLATE_PROPERTY = "DefaultProtoTemplateProperty";


    public ProtoCreateFileAction() {
        super(NEW_PROTO_FILE, "", AllIcons.FileTypes.Text);
    }

    @Override
    protected void buildDialog(@NotNull Project project, @NotNull PsiDirectory directory, CreateFileFromTemplateDialog.@NotNull Builder builder) {
        builder.setTitle(FILE_TEMPLATE)
                .addKind("Empty file", AllIcons.FileTypes.Text, FILE_TEMPLATE)
                .addKind("Proto Template", AllIcons.FileTypes.Text, APPLICATION_TEMPLATE);
    }

    @Override
    protected @NlsContexts.Command String getActionName(PsiDirectory directory, @NotNull String newName, String templateName) {
        return NEW_PROTO_FILE;
    }

    @Override
    protected @Nullable String getDefaultTemplateProperty() {
        return DEFAULT_API_TEMPLATE_PROPERTY;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProtoCreateFileAction;
    }
}
