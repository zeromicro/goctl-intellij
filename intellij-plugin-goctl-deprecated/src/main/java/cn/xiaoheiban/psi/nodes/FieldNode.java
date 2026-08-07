package cn.xiaoheiban.psi.nodes;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class FieldNode extends IPsiNode {

    public FieldNode(@NotNull ASTNode node) {
        super(node);
    }

    public String getFiledName() {
        PsiElement firstChild = this.getFirstChild();
        if (firstChild instanceof AnonymousField) {
            AnonymousField child = (AnonymousField) firstChild;
            return child.getName();
        } else if (firstChild instanceof NormalField) {
            NormalField child = (NormalField) firstChild;
            return child.getFieldName();
        } else if (firstChild instanceof StructNode) {
            StructNode child = (StructNode) firstChild;
            return child.getStructName();
        } else {
            return "";
        }
    }

    public PsiElement getFiledNameNode() {
        PsiElement firstChild = this.getFirstChild();
        if (firstChild instanceof AnonymousField) {
            AnonymousField child = (AnonymousField) firstChild;
            return child.getNameNode();
        } else if (firstChild instanceof NormalField) {
            NormalField child = (NormalField) firstChild;
            return child.getFieldNode();
        } else if (firstChild instanceof StructNode) {
            StructNode child = (StructNode) firstChild;
            return child.getStructNameNode();
        } else {
            return null;
        }
    }


    public TagNode getFieldTag() {
        ASTNode node = ApiFile.findChild(this, ApiParserDefinition.rule(ApiParser.RULE_tag));
        if (node == null) {
            return null;
        }
        return new TagNode(node);
    }
}
