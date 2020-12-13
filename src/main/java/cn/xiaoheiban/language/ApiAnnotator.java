package cn.xiaoheiban.language;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.highlighting.ApiSyntaxHighlighter;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.nodes.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiAnnotator implements Annotator {

    private AnnotationHolder mHolder;
    private Map<IElementType, List<ASTNode>> allNode;

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof IPsiNode)) {
            return;
        }
        mHolder = holder;
        if (element instanceof ApiRootNode) {
            ApiRootNode root = (ApiRootNode) element;
            allNode = root.getAllNode();
            Map<IElementType, Set<ASTNode>> duplicateNode = ApiRootNode.getAllDuplicateNode(allNode);
            duplicateNode.forEach((et, nodes) -> {
                if (nodes.size() > 1) {
                    if (et.equals(ApiParserDefinition.rule(ApiParser.RULE_structNameId))) {
                        for (ASTNode node : nodes) {
                            mHolder.createErrorAnnotation(node, "duplicate struct " + node.getText());
                        }
                    } else if (et.equals(ApiParserDefinition.rule(ApiParser.RULE_handlerValue))) {
                        for (ASTNode node : nodes) {
                            mHolder.createErrorAnnotation(node, "duplicate handler " + node.getText());
                        }
                    } else {// route
                        for (ASTNode node : nodes) {
                            mHolder.createErrorAnnotation(node, "duplicate route " + node.getText());
                        }
                    }
                }
            });

        } else if (element instanceof StructNode) {
            StructNode node = (StructNode) element;
            Map<String, Set<PsiElement>> duplicateField = node.getDuplicateField();
            duplicateField.forEach((s, psiElements) -> {
                if (psiElements == null || s == null) return;
                psiElements.forEach(el -> {
                    if (el == null) return;
                    mHolder.createErrorAnnotation(el, "filed [" + s + "] redeclare in this struct");
                });
            });
        } else if (element instanceof ServiceNameNode) {
            mHolder.createInfoAnnotation(element, element.getText()).setTextAttributes(ApiSyntaxHighlighter.IDENTIFIER);
        } else if (element instanceof ReferenceIdNode) {//RULE_referenceId
            if (allNode == null) {
                ApiRootNode root = ApiFile.getRoot(element);
                if (root == null) {
                    return;
                }
                allNode = root.getAllNode();
            }
            String name = ((ReferenceIdNode) element).getName();
            if (ApiRootNode.resolve(allNode, ApiParserDefinition.rule(ApiParser.RULE_structNameId), name)) {
                holder.createInfoAnnotation(element, element.getText()).setTextAttributes(ApiSyntaxHighlighter.IDENTIFIER);
                return;
            }
            holder.createErrorAnnotation(element, "can not resolve " + name);
        }
    }

}
