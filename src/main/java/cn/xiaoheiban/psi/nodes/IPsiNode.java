package cn.xiaoheiban.psi.nodes;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.util.text.Strings;
import com.intellij.psi.tree.IElementType;
import org.antlr.jetbrains.adapter.psi.AntlrPsiNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
        String option = getOption();
        if (this.getName() == null) {
            return getFileName();
        }
        return getFileName() + ":" + option + this.getName();
    }

    private boolean isHttpRoute(IElementType type) {
        if (type == null) {
            return false;
        }

        IElementType rule = ApiParserDefinition.rule(ApiParser.RULE_httpRoute);
        return type.equals(rule);
    }

    private String getOption() {
        IElementType type = this.getNode().getElementType();
        if (!isHttpRoute(type)) {
            return "";
        }
        ASTNode node = this.getNode();
        while (true) {
            if (node == null) {
                break;
            }
            IElementType t = node.getElementType();
            if (t == null) {
                break;
            }
            if (t.equals(ApiParserDefinition.rule(ApiParser.RULE_apiBody))) {
                break;
            }
            if (t.equals(ApiParserDefinition.rule(ApiParser.RULE_serviceStatement))) {
                return getPrefix(node);
            }
            node = node.getTreeParent();
        }
        return "";
    }

    private String getPrefix(ASTNode node) {
        ASTNode child = ApiFile.findChild(node.getPsi(), ApiParserDefinition.rule(ApiParser.RULE_identPair));
        if (child == null) {
            return "";
        }

        List<ASTNode> kvNodes = ApiFile.findChildren(child.getPsi(), ApiParserDefinition.rule(ApiParser.RULE_key));
        for (ASTNode kvNode : kvNodes) {
            String kv = kvNode.getText();
            if (kv.startsWith("prefix")) {
                ASTNode valueNode = kvNode.getTreeParent().getLastChildNode();
                if (valueNode == null) {
                    return "";
                }
                return valueNode.getText();
            }
        }
        return "";
    }
}
