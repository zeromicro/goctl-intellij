package cn.xiaoheiban.psi.nodes;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.antlr.jetbrains.adapter.lexer.RuleIElementType;
import org.apache.commons.collections.map.HashedMap;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//    case 1: type User int
//    case 2: type User struct {
//        ...
//    }
public class StructNameNode extends IPsiNode {

    private boolean isTypeLit;

    public StructNameNode(@NotNull ASTNode node) {
        super(node);
        if (node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_typeAlias)) || node.getElementType().equals(ApiParserDefinition.rule(ApiParser.RULE_typeGroupAlias))) {
            this.setIsTypeList(true);
        }
    }


    @NotNull
    public Map<String, Set<FieldNode>> getFields() {
        Map<String, Set<FieldNode>> filedSet = new HashedMap();
        List<ASTNode> fieldChildren = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_typeFiled));
        for (ASTNode node : fieldChildren) {
            ASTNode childByType = node.findChildByType(ApiParserDefinition.rule(ApiParser.RULE_fieldName));
            if (childByType == null) {
                continue;
            }
            ASTNode parentStruct = getParentStruct(childByType.getPsi());
            // 防止将child struct中的field错误归类
            if (parentStruct != null && !parentStruct.equals(this.getNode())) {
                continue;
            }
            String text = childByType.getText();
            Set<FieldNode> nodeSet = filedSet.get(text);
            if (nodeSet == null) {
                nodeSet = new HashSet<>();
            }
            FieldNode fieldNode = new FieldNode(node);
            nodeSet.add(fieldNode);
            filedSet.put(text, nodeSet);
        }
        return filedSet;
    }

    private ASTNode getParentStruct(@NotNull PsiElement element) {
        while (true) {
            PsiElement parent = element.getParent();
            if (parent == null) {
                return null;
            }
            ASTNode node = parent.getNode();
            if (node == null) {
                return null;
            }
            IElementType elementType = node.getElementType();
            if (elementType instanceof RuleIElementType) {
                RuleIElementType type = (RuleIElementType) elementType;
                if (type.getRuleIndex() == ApiParser.RULE_structType) {
                    return parent.getNode();
                }
            }
            element = parent;
        }
    }

    public boolean isTypeLit() {
        return isTypeLit;
    }

    public void setIsTypeList(boolean typeLit) {
        this.isTypeLit = typeLit;
    }
}
