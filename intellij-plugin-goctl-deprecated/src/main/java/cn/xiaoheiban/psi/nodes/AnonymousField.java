package cn.xiaoheiban.psi.nodes;

import cn.xiaoheiban.antlr4.ApiLexer;
import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class AnonymousField extends IPsiNode {
    public AnonymousField(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        PsiElement child = this.findChildByType(ApiParserDefinition.rule(ApiParser.RULE_referenceId));
        return child == null ? "" : child.getText();
    }

    public PsiElement getNameNode() {
        return findChildByClass(ReferenceIdNode.class);
    }
}
