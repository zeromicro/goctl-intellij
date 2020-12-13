package cn.xiaoheiban.formatter;

import cn.xiaoheiban.antlr4.ApiLexer;
import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.language.ApiLanguage;
import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.formatting.*;
import com.intellij.formatting.alignment.AlignmentStrategy;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiFormatter implements FormattingModelBuilder {
    private static final IElementType COLON = ApiParserDefinition.token(ApiLexer.COLON);
    private static final IElementType COMMENT = ApiParserDefinition.token(ApiLexer.COMMENT);
    private static final IElementType VALUE = ApiParserDefinition.token(ApiLexer.VALUE);
    private static final IElementType HANDLER_VALUE = ApiParserDefinition.rule(ApiParser.RULE_handlerValue);
    private static final IElementType IMPORT_VALUE = ApiParserDefinition.rule(ApiParser.RULE_importValue);
    private static final IElementType TYPE = ApiParserDefinition.token(ApiLexer.TYPE);
    private static final IElementType STRUCT_NAME = ApiParserDefinition.rule(ApiParser.RULE_structNameId);
    private static final IElementType STRUCT = ApiParserDefinition.token(ApiLexer.STRUCT);
    private static final IElementType LBRACE = ApiParserDefinition.token(ApiLexer.LBRACE);
    private static final IElementType LBRACK = ApiParserDefinition.token(ApiLexer.LBRACK);
    private static final IElementType RBRACK = ApiParserDefinition.token(ApiLexer.RBRACK);
    private static final IElementType STAR = ApiParserDefinition.token(ApiLexer.STAR);
    private static final IElementType FIELD_NAME = ApiParserDefinition.rule(ApiParser.RULE_fieldName);
    private static final IElementType FIELD_TYPE = ApiParserDefinition.rule(ApiParser.RULE_fieldType);
    private static final IElementType FIELD_TAG = ApiParserDefinition.rule(ApiParser.RULE_tag);
    private static final IElementType DOC = ApiParserDefinition.token(ApiLexer.ATDOC);
    private static final IElementType SERVER = ApiParserDefinition.token(ApiLexer.ATSERVER);
    private static final IElementType HANDLER = ApiParserDefinition.token(ApiLexer.ATHANDLER);
    private static final IElementType INFO = ApiParserDefinition.token(ApiLexer.INFO);
    private static final IElementType SERVICE_DOC = ApiParserDefinition.rule(ApiParser.RULE_serviceDoc);
    private static final IElementType SERVICE_HANDLER = ApiParserDefinition.rule(ApiParser.RULE_serviceHandler);
    private static final IElementType INFO_STATEMENT = ApiParserDefinition.rule(ApiParser.RULE_infoStatement);
    private static final IElementType LPAREN = ApiParserDefinition.token(ApiParser.LPAREN);
    private static final IElementType RPAREN = ApiParserDefinition.token(ApiParser.RPAREN);
    private static final IElementType SERVICE = ApiParserDefinition.token(ApiParser.SERVICE);
    private static final IElementType HTTP_METHOD = ApiParserDefinition.token(ApiParser.HTTPMETHOD);
    private static final IElementType ROUTE = ApiParserDefinition.rule(ApiParser.RULE_httpRoute);
    private static final IElementType RETURNS = ApiParserDefinition.token(ApiParser.RETURNS);
    private static final IElementType REFERENCE_ID = ApiParserDefinition.rule(ApiParser.RULE_referenceId);
    private static final IElementType PAIR = ApiParserDefinition.rule(ApiParser.RULE_pair);
    private static final IElementType HANDLER_PAIR = ApiParserDefinition.rule(ApiParser.RULE_handlerPair);
    private static final IElementType HANDLER_NEW = ApiParserDefinition.rule(ApiParser.RULE_serviceHandlerNew);
    private static final IElementType IMPORT = ApiParserDefinition.rule(ApiParser.RULE_importSpec);
    private static final IElementType IDENT_PAIR = ApiParserDefinition.rule(ApiParser.RULE_identPair);
    private static final IElementType IDENT_PAIR_VALUE = ApiParserDefinition.rule(ApiParser.RULE_identValue);
    private static final Key<Alignment> TYPE_ALIGNMENT_INSIDE_STRUCT = Key.create("TYPE_ALIGNMENT_INSIDE_STRUCT");
    private static final IElementType INTERFACE = ApiParserDefinition.token(ApiLexer.INTERFACE);
    private static final IElementType RBRACE = ApiParserDefinition.token(ApiLexer.RBRACE);
    private static final IElementType STRUCT_TYPE = ApiParserDefinition.rule(ApiParser.RULE_structType);
    private static final IElementType KEY = ApiParserDefinition.rule(ApiParser.RULE_key);
    private static final IElementType FIELD = ApiParserDefinition.rule(ApiParser.RULE_typeFiled);
    private static final IElementType GROUP_BODY = ApiParserDefinition.rule(ApiParser.RULE_typeGroupBody);
    private static final IElementType SERVICE_BODY = ApiParserDefinition.rule(ApiParser.RULE_serviceBody);
    private static final IElementType LINE_COMMENT = ApiParserDefinition.token(ApiLexer.COMMENT);
    private static final IElementType ATSERVER = ApiParserDefinition.token(ApiLexer.ATSERVER);

    @NotNull
    private static SpacingBuilder createSpacingBuilder(@NotNull CodeStyleSettings settings) {
        SpacingBuilder builder = new SpacingBuilder(settings, ApiLanguage.INSTANCE);
        builder.before(VALUE).spaceIf(true);
        builder.before(HANDLER_VALUE).spaceIf(true);
        builder.after(TYPE).spaceIf(true);
        builder.after(STRUCT_NAME).spaceIf(true);
        builder.after(STRUCT).spaceIf(true);
        builder.before(LBRACE).spaceIf(true);
        builder.after(FIELD_NAME).spaceIf(true);
        builder.after(SERVICE).spaceIf(true);
        builder.after(HTTP_METHOD).spaceIf(true);
        builder.after(ROUTE).spaceIf(true);
        builder.around(RETURNS).spaceIf(true);
        builder.between(FIELD_TYPE, FIELD_TAG).spaceIf(true);
        builder.between(LPAREN, RPAREN).none();
        builder.around(REFERENCE_ID).none();
        builder.between(INFO, LPAREN).none();
        builder.between(DOC, LPAREN).none();
        builder.between(SERVER, LPAREN).none();
        return builder;
    }

    @Override
    public @NotNull FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        Block block = new ApiFormatterBlock(element.getNode(), null, Indent.getNoneIndent(), null, createSpacingBuilder(settings));
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(), block, settings);
    }

    private static class ApiFormatterBlock extends UserDataHolderBase implements ASTBlock {
        @NotNull
        private final ASTNode myNode;
        @Nullable
        private final Alignment myAlignment;
        @Nullable
        private final Wrap myWrap;
        @Nullable
        private final Indent myIndent;
        @NotNull
        private final SpacingBuilder mySpacingBuilder;
        @Nullable
        private List<Block> mySubBlocks;

        private static final TokenSet BLOCK_TOKEN_SET = TokenSet.create(
                ApiParserDefinition.rule(ApiParser.RULE_infoStatement),
                ApiParserDefinition.rule(ApiParser.RULE_typeStruct),
                ApiParserDefinition.rule(ApiParser.RULE_serviceSpec));

        private ApiFormatterBlock(@NotNull ASTNode node,
                                  @Nullable Alignment alignment,
                                  @Nullable Indent indent,
                                  @Nullable Wrap wrap,
                                  @NotNull SpacingBuilder spacingBuilder) {
            myNode = node;
            myAlignment = alignment;
            myWrap = wrap;
            mySpacingBuilder = spacingBuilder;
            myIndent = indent;
        }

        @Override
        public @Nullable ASTNode getNode() {
            return myNode;
        }

        @Override
        public @NotNull TextRange getTextRange() {
            return myNode.getTextRange();
        }

        @Override
        public @NotNull List<Block> getSubBlocks() {
            if (mySubBlocks == null) {
                mySubBlocks = buildSubBlocks();
            }
            return new ArrayList<>(mySubBlocks);
        }

        @NotNull
        private List<Block> buildSubBlocks() {
            AlignmentStrategy.AlignmentPerTypeStrategy strategy = null;
            boolean isStruct = (getNode() != null ? getNode().getElementType() : null) == STRUCT_TYPE;
            Alignment forType = null;
            if (isStruct) {
                strategy = AlignmentStrategy.createAlignmentPerTypeStrategy(ContainerUtil.list(FIELD, LINE_COMMENT, STRUCT_TYPE), STRUCT_TYPE, true);
                forType = Alignment.createAlignment(true);
            }

            List<Block> blocks = ContainerUtil.newArrayList();
            for (ASTNode child = myNode.getFirstChildNode(); child != null; child = child.getTreeNext()) {
                IElementType childType = child.getElementType();
                if (child.getTextRange().getLength() == 0) continue;
                if (childType == TokenType.WHITE_SPACE) continue;
                Alignment alignment = strategy != null ? strategy.getAlignment(childType) : null;
                ApiFormatterBlock e = buildSubBlock(child, alignment);
                if (isStruct) {
                    e.putUserDataIfAbsent(TYPE_ALIGNMENT_INSIDE_STRUCT, forType);
                }
                blocks.add(e);
            }
            return Collections.unmodifiableList(blocks);
        }

        @NotNull
        private ApiFormatterBlock buildSubBlock(@NotNull ASTNode child, @Nullable Alignment alignment) {
            if (child.getTreeParent().getElementType() == FIELD) {
                alignment = getUserData(TYPE_ALIGNMENT_INSIDE_STRUCT);
            }
            Indent indent = calcIndent(child);
            return new ApiFormatterBlock(child, alignment, indent, null, mySpacingBuilder);
        }

        @NotNull
        private Indent calcIndent(@NotNull ASTNode child) {
            Indent indent = Indent.getNoneIndent();
            IElementType elementType = child.getElementType();
            if (elementType.equals(FIELD)
                    || elementType.equals(KEY)
                    || elementType.equals(HTTP_METHOD)
                    || elementType.equals(COMMENT)
                    || elementType.equals(GROUP_BODY)
                    || elementType.equals(SERVICE_DOC)
                    || elementType.equals(SERVICE_HANDLER)
                    || elementType.equals(HANDLER)
            ) {
                indent = Indent.getNormalIndent();
            }
            return indent;
        }

        @Override
        public @Nullable Wrap getWrap() {
            return myWrap;
        }

        @Override
        public @Nullable Indent getIndent() {
            return myIndent;
        }

        @Override
        public @Nullable Alignment getAlignment() {
            return myAlignment;
        }

        @Override
        public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
            if (child1 instanceof ApiFormatterBlock && child2 instanceof ApiFormatterBlock) {
                ASTNode n1 = ((ApiFormatterBlock) child1).getNode();
                ASTNode n2 = ((ApiFormatterBlock) child2).getNode();
                PsiElement psi1 = n1 != null ? n1.getPsi() : null;
                if (psi1 == null) {
                    return this.mySpacingBuilder.getSpacing(this, child1, child2);
                }
                if (n2 == null) {
                    return this.mySpacingBuilder.getSpacing(this, child1, child2);
                }
                PsiElement parent = psi1.getParent();
                IElementType parentElementType = parent.getNode().getElementType();
                boolean oneLineType = !parent.textContains('\n');
//                if (parent.getNode() != null && parent.getNode().getElementType().equals(STRUCT_TYPE)) {
//                    if ((n1.getElementType().equals(STRUCT) || n1.getElementType().equals(INTERFACE)) && n2.getElementType().equals(LBRACE)) {
//                        return none();
//                    }
//                    if (n1.getElementType() == LBRACE && n2.getElementType() == RBRACE) {
//                        return none();
//                    }
//                    if (n1.getElementType() == LBRACE) {
//                        return oneLineType ? none() : lineBreak(false);
//                    }
//                    if (n2.getElementType() == RBRACE) {
//                        return oneLineType ? none() : lineBreak(false);
//                    }
//                }
                if (n1.getElementType().equals(LBRACE) && n2.getElementType().equals(RBRACE)) {
                    if (parent.getText().contains("interface")) {
                        return none();
                    }
                    return lineBreak();
                }

                if (parentElementType.equals(INFO_STATEMENT)) {
                    if (n1.getElementType().equals(INFO) && n2.getElementType().equals(LPAREN)) {
                        return none();
                    }
                }
                if ((n1.getElementType().equals(PAIR) || n1.getElementType().equals(HANDLER_PAIR) || n1.getElementType().equals(IDENT_PAIR))
                        && n2.getElementType().equals(RPAREN)
                        || n1.getElementType().equals(LPAREN) && (n2.getElementType().equals(PAIR) || n2.getElementType().equals(HANDLER_PAIR) || n2.getElementType().equals(IDENT_PAIR))) {
                    return oneLineType ? none() : lineBreak(false);
                }
                if (n2.getElementType() == LBRACE) {
                    return oneLineType ? none() : one();
                }
                if (n2.getElementType() == RBRACE) {
                    return oneLineType ? none() : lineBreak(false);
                }
                if (n1.getElementType() == LBRACE && n2.getElementType() == SERVICE_BODY) {
                    return oneLineType ? none() : lineBreak(false);
                }

                if (n1.getElementType() == TYPE && n2.getElementType() == LPAREN) {
                    return oneLineType ? none() : one();
                }
                if (n1.getElementType() == LPAREN && n2.getElementType() == GROUP_BODY
                        || n1.getElementType() == GROUP_BODY && n2.getElementType() == RPAREN) {
                    return oneLineType ? none() : lineBreak(false);
                }
                if (n1.getElementType() == LBRACK
                        || n2.getElementType() == RBRACK
                        || n1.getElementType() == STAR
                        || n2.getElementType() == STAR) {
                    return none();
                }
                if ((n1.getElementType() == ATSERVER || n1.getElementType() == DOC) && n2.getElementType() == LPAREN) {
                    return none();
                }

                if (parent.getNode() != null && parentElementType.equals(PAIR)) {
                    if (n1.getElementType().equals(COLON) && n2.getElementType().equals(VALUE)) {
                        String value = n2.getText();
                        if (value.startsWith(" ")) {
                            return none();
                        }
                        return one();
                    }
                }

                if (parent.getNode() != null && parentElementType.equals(HANDLER_PAIR)) {
                    if (n1.getElementType().equals(COLON) && n2.getElementType().equals(HANDLER_VALUE)) {
                        String value = n2.getText();
                        if (value.startsWith(" ")) {
                            return none();
                        }
                        return one();
                    }
                }


                if (parent.getNode() != null && parentElementType.equals(HANDLER_NEW)) {
                    if (n2.getElementType().equals(HANDLER_VALUE)) {
                        String value = n2.getText();
                        if (value.startsWith(" ")) {
                            return none();
                        }
                        return one();
                    }
                }

                if (parent.getNode() != null && parentElementType.equals(IMPORT)) {
                    if (n2.getElementType().equals(IMPORT_VALUE)) {
                        String value = n2.getText();
                        if (value.startsWith(" ")) {
                            return none();
                        }
                        return one();
                    }
                }

                if (parent.getNode() != null && parentElementType.equals(IDENT_PAIR)) {
                    if (n1.getElementType().equals(COLON) && n2.getElementType().equals(IDENT_PAIR_VALUE)) {
                        String value = n2.getText();
                        if (value.startsWith(" ")) {
                            return none();
                        }
                        return one();
                    }
                }


            }
            return this.mySpacingBuilder.getSpacing(this, child1, child2);
        }

        @Override
        public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
            Indent childIndent = Indent.getNoneIndent();
            IElementType elementType = myNode.getElementType();
            if (BLOCK_TOKEN_SET.contains(elementType)) {
                childIndent = Indent.getNoneIndent();
            }
            return new ChildAttributes(childIndent, null);
        }

        @Override
        public boolean isIncomplete() {
            return false;
        }

        @Override
        public boolean isLeaf() {
            return myNode.getFirstChildNode() == null;
        }

        private static Spacing none() {
            return Spacing.createSpacing(0, 0, 0, false, 0);
        }

        private static Spacing one() {
            return Spacing.createSpacing(1, 1, 0, false, 0);
        }

        private static Spacing lineBreak() {
            return lineBreak(true);
        }

        private static Spacing lineBreak(boolean keepLineBreaks) {
            return Spacing.createSpacing(0, 0, 1, keepLineBreaks, keepLineBreaks ? 1 : 0);
        }

    }


}
