package cn.xiaoheiban.parser;

import cn.xiaoheiban.antlr4.ApiLexer;
import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.language.ApiLanguage;
import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.nodes.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.antlr.jetbrains.adapter.lexer.AntlrLexerAdapter;
import org.antlr.jetbrains.adapter.lexer.PsiElementTypeFactory;
import org.antlr.jetbrains.adapter.lexer.RuleIElementType;
import org.antlr.jetbrains.adapter.lexer.TokenIElementType;
import org.antlr.jetbrains.adapter.parser.AntlrParserAdapter;
import org.antlr.jetbrains.adapter.psi.AntlrPsiNode;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

import static cn.xiaoheiban.antlr4.ApiLexer.*;

public class ApiParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(ApiLanguage.INSTANCE);
    public static final PsiElementTypeFactory ELEMENT_FACTORY = PsiElementTypeFactory
            .builder()
            .language(ApiLanguage.INSTANCE)
            .parser(new ApiParser(null))
            .build();

    private static final List<TokenIElementType> tokenIElementTypes = ELEMENT_FACTORY.getTokenIElementTypes();
    private static final List<TokenIElementType> TOKEN_TYPES = ELEMENT_FACTORY.getTokenIElementTypes();
    private static final List<RuleIElementType> RULE_TYPES = ELEMENT_FACTORY.getRuleIElementTypes();
    private final Map<Integer, Function<ASTNode, PsiElement>> elementFactories = new HashMap<>();
    public static TokenIElementType LPAREN = tokenIElementTypes.get(ApiLexer.LPAREN);
    public static TokenIElementType RPAREN = tokenIElementTypes.get(ApiLexer.RPAREN);
    public static TokenIElementType LBRACE = tokenIElementTypes.get(ApiLexer.LBRACE);
    public static TokenIElementType RBRACE = tokenIElementTypes.get(ApiLexer.RBRACE);
    public static TokenIElementType LBRACK = tokenIElementTypes.get(ApiLexer.LBRACK);
    public static TokenIElementType RBRACK = tokenIElementTypes.get(ApiLexer.RBRACK);
    public static TokenIElementType IDENTIFIER = tokenIElementTypes.get(IDENT);

    public static final TokenSet COMMENTS = ELEMENT_FACTORY.createTokenSet(ApiLexer.COMMENT);
    public static final TokenSet WHITESPACE = ELEMENT_FACTORY.createTokenSet(ApiLexer.WS);
    public static final TokenSet STRING = ELEMENT_FACTORY.createTokenSet(ApiLexer.VALUE, ApiLexer.RAW_STRING);

    private final Map<String, Method> parserRuleMethods = createParserRuleMethods();

    ApiParserDefinition() {
        register(ApiParser.RULE_api, ApiRootNode::new);
        register(ApiParser.RULE_apiBody, ApiBodyNode::new);
        register(ApiParser.RULE_importValue, ImportValueNode::new);
        register(ApiParser.RULE_structNameId, StructNameNode::new);
        register(ApiParser.RULE_structType, StructNode::new);
        register(ApiParser.RULE_typeFiled, FieldNode::new);
        register(ApiParser.RULE_anonymousField, AnonymousField::new);
        register(ApiParser.RULE_normalField, NormalField::new);
        register(ApiParser.RULE_referenceId, ReferenceIdNode::new);
        register(ApiParser.RULE_serviceSpec, ServiceNode::new);
        register(ApiParser.RULE_serviceRoute, ServiceRouteNode::new);
        register(ApiParser.RULE_httpRoute, HttpRouteNode::new);
        register(ApiParser.RULE_serviceName, ServiceNameNode::new);
        register(ApiParser.RULE_handlerValue, HandlerValueNode::new);
    }

    private void register(int rule, Function<ASTNode, PsiElement> factory) {
        if (elementFactories.containsKey(rule)) {
            throw new IllegalStateException("Duplicate rule");
        }
        elementFactories.put(rule, factory);
    }

    private Map<String, Method> createParserRuleMethods() {
        Map<String, Method> result = new HashMap<>();
        for (String ruleName : ApiParser.ruleNames) {
            try {
                Method method = ApiParser.class.getMethod(ruleName);
                result.put(ruleName, method);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return Collections.unmodifiableMap(result);
    }

    @Override
    public @NotNull Lexer createLexer(Project project) {
        ApiLexer lexer = new ApiLexer(null);
        return new AntlrLexerAdapter(ApiLanguage.INSTANCE, lexer, ELEMENT_FACTORY);
    }

    @Override
    public PsiParser createParser(Project project) {
        final ApiParser apiParser = new ApiParser(null);
        return new AntlrParserAdapter(ApiLanguage.INSTANCE, apiParser, ELEMENT_FACTORY) {

            @Override
            protected ParseTree parse(Parser parser, IElementType root) {
                if (root instanceof IFileElementType) {
                    return ((ApiParser) parser).api();
                }
                if (root instanceof RuleIElementType) {
                    RuleIElementType type = (RuleIElementType) root;
                    String ruleName = ruleNames[type.getRuleIndex()];
                    return parserRule(apiParser, ruleName);
                }
                throw new UnsupportedOperationException(String.valueOf(root.getIndex()));
            }
        };
    }

    @NotNull
    private ParseTree parserRule(ApiParser parser, String ruleName) {
        try {
            Method method = parserRuleMethods.get(ruleName);
            if (method == null) {
                throw new IllegalStateException("Not a parser rule: " + ruleName);
            }
            return (ParseTree) method.invoke(parser);
        } catch (Exception e) {
            throw new IllegalStateException("Exception in parser rule: " + ruleName, e);
        }
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return WHITESPACE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return STRING;
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        IElementType elType = node.getElementType();
        if (elType instanceof TokenIElementType) {
            return new AntlrPsiNode(node);
        }
        if (!(elType instanceof RuleIElementType)) {
            return new AntlrPsiNode(node);
        }
        RuleIElementType ruleElType = (RuleIElementType) elType;
        int ruleIndex = ruleElType.getRuleIndex();
        if (elementFactories.containsKey(ruleIndex)) {
            Function<ASTNode, PsiElement> factory = elementFactories.get(ruleIndex);
            return factory.apply(node);
        }
        return new AntlrPsiNode(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ApiFile(viewProvider);
    }

    public static IElementType rule(int rule) {
        return (IElementType) RULE_TYPES.get(rule);
    }

    public static TokenIElementType token(int token) {
        return TOKEN_TYPES.get(token);
    }
}
