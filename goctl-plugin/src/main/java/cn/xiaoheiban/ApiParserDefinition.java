package cn.xiaoheiban;

import cn.xiaoheiban.parser.ApiParser;
import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.ApiTokenSets;
import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class ApiParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(ApiLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ApiLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return ApiTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new ApiParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new ApiFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return ApiTypes.Factory.createElement(node);
    }
}