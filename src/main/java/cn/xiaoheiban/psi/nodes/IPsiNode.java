package cn.xiaoheiban.psi.nodes;

import com.intellij.lang.ASTNode;
import org.antlr.jetbrains.adapter.psi.AntlrPsiNode;
import org.jetbrains.annotations.NotNull;

public class IPsiNode extends AntlrPsiNode {
    public IPsiNode(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    public String getPath() {
        String path = null;
        if (this.getContainingFile() != null && this.getContainingFile().getVirtualFile() != null) {
            path = this.getContainingFile().getVirtualFile().getParent().getPath();
        }
        if (path == null) {
            path = "";
        }
        return path;
    }

    @NotNull
    public String getFileName() {
        String path = null;
        if (this.getContainingFile() != null && this.getContainingFile().getVirtualFile() != null) {
            path = this.getContainingFile().getVirtualFile().getPath();
        }
        if (path == null) {
            path = "";
        }
        return path;
    }

    @Override
    public String getName() {
        return this.getText();
    }

    @NotNull
    public String getKey() {
        if (this.getName() == null) {
            return getFileName();
        }
        return getFileName() + ":" + this.getName();
    }

}
