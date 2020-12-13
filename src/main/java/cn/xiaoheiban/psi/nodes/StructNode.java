package cn.xiaoheiban.psi.nodes;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StructNode extends IPsiNode {
    public StructNode(@NotNull ASTNode node) {
        super(node);
    }

    public String getStructName() {
        return getStructNameNode().getText();
    }

    public PsiElement getStructNameNode() {
        return this.getFirstChild();
    }

    public Map<String, Set<PsiElement>> getDuplicateField() {
        Map<String, Set<PsiElement>> tmp = new HashMap<>();
        Map<String, Set<PsiElement>> ret = new HashMap<>();
        @NotNull FieldNode[] children = this.findChildrenByClass(FieldNode.class);
        for (FieldNode node : children) {
            String key = node.getFiledName();
            Set<PsiElement> set = tmp.get(key);
            if (set == null) {
                set = new HashSet<>();
            }
            if (node.getFiledNameNode() != null) {
                set.add(node.getFiledNameNode());
            }
            tmp.put(key, set);
        }
        tmp.forEach((s, psiElements) -> {
            if (psiElements.size() > 1) {
                ret.put(s, psiElements);
            }
        });
        return ret;
    }
}
