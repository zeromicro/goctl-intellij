package cn.xiaoheiban.psi.nodes;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.IElementType;
import org.antlr.jetbrains.adapter.SymtabUtils;
import org.antlr.jetbrains.adapter.psi.ScopeNode;
import org.apache.commons.collections.map.HashedMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ApiRootNode extends IPsiNode implements ScopeNode {

    public ApiRootNode(@NotNull ASTNode node) {
        super(node);
    }

    public Map<IElementType, List<ASTNode>> getAllNode() {
        Set<IElementType> elementTypeSet = new HashSet<>();
        elementTypeSet.add(ApiParserDefinition.rule(ApiParser.RULE_handlerValue));
        elementTypeSet.add(ApiParserDefinition.rule(ApiParser.RULE_structNameId));
        elementTypeSet.add(ApiParserDefinition.rule(ApiParser.RULE_httpRoute));
        return ApiFile.findChildren(this, elementTypeSet);
    }

    public static boolean resolve(Map<IElementType, List<ASTNode>> children, IElementType elementType, String name) {
        if (children == null || elementType == null || name == null) {
            return true;
        }
        Set<String> nameSet = new HashSet<>();
        children.forEach((et, astNodes) -> {
            if (!et.equals(elementType)) {
                return;
            }
            for (ASTNode node : astNodes) {
                nameSet.add(node.getText());
            }
        });
        return nameSet.contains(name);
    }

    public static Map<IElementType, Set<ASTNode>> getAllDuplicateNode(Map<IElementType, List<ASTNode>> children) {
        Map<String, Set<ASTNode>> tmp = new HashedMap();
        children.forEach((elementType, astNodes) -> {
            for (ASTNode node : astNodes) {
                IPsiNode psiNode = new IPsiNode(node);
                String key = elementType.hashCode() + psiNode.getKey();
                Set<ASTNode> set = tmp.get(key);
                if (set == null) {
                    set = new HashSet<>();
                }
                if (set.contains(node)) {
                    continue;
                }
                set.add(node);
                tmp.put(key, set);
            }
        });
        Map<IElementType, Set<ASTNode>> ret = new HashedMap();
        tmp.forEach((key, set) -> {
            if (set.size() > 1) {
                Object[] objects = set.toArray();
                Object obj = objects[0];
                ASTNode node = (ASTNode) obj;
                ret.put(node.getElementType(), set);
            }
        });
        return ret;
    }

    public Map<String, Set<StructNameNode>> getAllStructMap() {
        Map<String, Set<StructNameNode>> ret = new HashedMap();
        Set<ASTNode> nodeSet = new HashSet<>();
        List<ASTNode> structs = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_structType));
        List<ASTNode> alias = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_typeAlias));
        List<ASTNode> groupAlias = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_typeGroupAlias));
        Set<ASTNode> children = new HashSet<>();
        children.addAll(structs);
        children.addAll(alias);
        children.addAll(groupAlias);
        for (ASTNode node : children) {
            ASTNode childByType = node.findChildByType(ApiParserDefinition.rule(ApiParser.RULE_structNameId));
            if (childByType == null) {
                continue;
            }
            if (nodeSet.contains(childByType)) {
                continue;
            }
            nodeSet.add(childByType);
            StructNameNode nameNode = new StructNameNode(childByType);
            String text = nameNode.getText();
            Set<StructNameNode> duplicateNodeSet = ret.get(text);
            if (duplicateNodeSet == null) {
                duplicateNodeSet = new HashSet<>();
            }
            duplicateNodeSet.add(nameNode);
            ret.put(text, duplicateNodeSet);
        }
        return ret;
    }


    @Override
    public @Nullable PsiElement resolve(PsiNamedElement element) {
        PsiElement psiElement = SymtabUtils.resolve(this, ApiParserDefinition.ELEMENT_FACTORY, element, "/api/apiBody/typeStatement/typeSingleSpec/typeAlias/structNameId/IDENT");
        if (psiElement != null) {
            return psiElement;
        }
        psiElement = SymtabUtils.resolve(this, ApiParserDefinition.ELEMENT_FACTORY, element, "/api/apiBody/typeStatement/typeSingleSpec/typeStruct/structType/structNameId/IDENT");
        if (psiElement != null) {
            return psiElement;
        }
        psiElement = SymtabUtils.resolve(this, ApiParserDefinition.ELEMENT_FACTORY, element, "/api/apiBody/typeStatement/typeGroupSpec/typeGroupBody/typeGroupAlias/structNameId/IDENT");
        if (psiElement != null) {
            return psiElement;
        }

        psiElement = SymtabUtils.resolve(this, ApiParserDefinition.ELEMENT_FACTORY, element, "/api/apiBody/typeStatement/typeGroupSpec/typeGroupBody/structType/structNameId/IDENT");
        return psiElement;
    }
}
