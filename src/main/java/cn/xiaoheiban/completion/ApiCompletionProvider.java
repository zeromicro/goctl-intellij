package cn.xiaoheiban.completion;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.nodes.ApiRootNode;
import cn.xiaoheiban.psi.nodes.StructNameNode;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class ApiCompletionProvider extends ApiProvider {

    public ApiCompletionProvider(int priority, @Nullable AutoCompletionPolicy completionPolicy) {
        super(priority, completionPolicy);
    }

    public ApiCompletionProvider(int priority, @Nullable InsertHandler<LookupElement> insertHandler) {
        super(priority, insertHandler);
    }


    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        PsiElement position = parameters.getPosition();
        ASTNode node = position.getNode();
        if (node == null) {
            return;
        }
        IElementType elementType = node.getElementType();
        boolean canAdd = false;
        if (elementType.equals(ApiParserDefinition.rule(ApiParser.RULE_referenceId))) {
            canAdd = true;
        } else {
            ASTNode treeParent = node.getTreeParent();
            if (treeParent != null) {
                IElementType elementType1 = treeParent.getElementType();
                if (elementType1.equals(ApiParserDefinition.rule(ApiParser.RULE_normalFieldType))
                        || elementType1.equals(ApiParserDefinition.rule(ApiParser.RULE_serviceRoute))
                        || elementType1.equals(ApiParserDefinition.rule(ApiParser.RULE_referenceId))) {
                    canAdd = true;
                }
            }
        }
        if (canAdd) {
            ApiRootNode root = ApiFile.getRoot(parameters.getOriginalFile());
            if (root == null) {
                return;
            }
            Map<String, Set<StructNameNode>> allStructMap = root.getAllStructMap();
            allStructMap.forEach((s, typeNodes) -> {
                result.addElement(createKeywordLookupElement(s));
            });
        }

    }

}
