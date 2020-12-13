package cn.xiaoheiban.psi;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.language.ApiLanguage;
import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.antlr.jetbrains.adapter.lexer.RuleIElementType;
import org.antlr.jetbrains.adapter.psi.AntlrPsiLeafNode;
import org.antlr.jetbrains.adapter.psi.Trees;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class IdentifierPSINode extends AntlrPsiLeafNode implements PsiNamedElement {

    public IdentifierPSINode(IElementType type, CharSequence text) {
        super(type, text);
    }

    @Override
    public String getName() {
        return getText();
    }


    @Override
    public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
        if (getParent() == null) return this; // weird but it happened once
        PsiElement newID = Trees.createLeafFromText(getProject(),
                ApiLanguage.INSTANCE,
                getContext(),
                name,
                ApiParserDefinition.IDENTIFIER);
        if (newID != null) {
            return this.replace(newID);
        }
        return this;
    }

    @Override
    public PsiReference getReference() {
        PsiElement parent = getParent();
        IElementType elType = parent.getNode().getElementType();
        if (elType instanceof RuleIElementType) {
            switch (((RuleIElementType) elType).getRuleIndex()) {
                // 允许跳转到struct reference的规则
                case ApiParser.RULE_referenceId:
                    return new StructReference(this);

            }
        }
        return null;
    }
}
