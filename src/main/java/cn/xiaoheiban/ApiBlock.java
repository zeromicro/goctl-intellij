package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ApiBlock extends AbstractBlock {

    private final Indent myIndent;
    private final CodeStyleSettings settings;
    private final Alignment typeAlignment;
    private final Alignment tagAlignment;
    private final boolean embeddedTypePairSeparatedByLineBreak;

    protected ApiBlock(
            @NotNull ASTNode node,
            @Nullable Alignment alignment,
            @Nullable Indent indent,
            @Nullable Wrap wrap,
            @NotNull CodeStyleSettings settings,
            @Nullable Alignment typeAlignment,
            @Nullable Alignment tagAlignment
    ) {
        super(node, wrap, alignment);
        this.myIndent = indent == null ? Indent.getNoneIndent() : indent;
        this.settings = settings;
        this.typeAlignment = typeAlignment;
        this.tagAlignment = tagAlignment;
        this.embeddedTypePairSeparatedByLineBreak = node.getElementType() == ApiTypes.ELEM_EXPR
                && isEmbeddedTypePairSeparatedByLineBreak();
    }

    @Override
    protected @NotNull List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        IElementType parentType = myNode.getElementType();
        Alignment groupTypeAlignment = null;
        Alignment groupTagAlignment = null;
        boolean isEmbeddedTypePair = parentType == ApiTypes.ELEM_EXPR
                && embeddedTypePairSeparatedByLineBreak;

        for (ASTNode child = myNode.getFirstChildNode(); child != null; child = child.getTreeNext()) {
            if (child.getElementType() == TokenType.WHITE_SPACE) {
                continue;
            }

            IElementType childType = child.getElementType();
            Alignment childAlignment = null;
            Alignment childTypeAlignment = null;
            Alignment childTagAlignment = null;

            if (parentType == ApiTypes.STRUCT_DATA_TYPE && childType == ApiTypes.ELEM_EXPR) {
                // Only consecutive plain fields are aligned; embedded and inline-struct fields start a new group.
                if (isPlainField(child)) {
                    if (groupTypeAlignment == null) {
                        groupTypeAlignment = Alignment.createAlignment(true);
                        groupTagAlignment = Alignment.createAlignment(true);
                    }
                    childTypeAlignment = groupTypeAlignment;
                    childTagAlignment = groupTagAlignment;
                } else {
                    groupTypeAlignment = null;
                    groupTagAlignment = null;
                }
            }

            if (parentType == ApiTypes.ELEM_EXPR) {
                if (childType == ApiTypes.DATA_TYPE && !isEmbeddedTypePair) {
                    childAlignment = typeAlignment;
                } else if (childType == ApiTypes.TAG) {
                    childAlignment = tagAlignment;
                }
            }

            blocks.add(new ApiBlock(
                    child,
                    childAlignment,
                    childIndent(parentType, childType),
                    null,
                    settings,
                    childTypeAlignment,
                    childTagAlignment
            ));
        }

        return blocks;
    }

    private static boolean isPlainField(@NotNull ASTNode elem) {
        ASTNode type = elem.findChildByType(ApiTypes.DATA_TYPE);
        return type != null && !containsStruct(type);
    }

    private static boolean containsStruct(@NotNull ASTNode node) {
        if (node.getElementType() == ApiTypes.STRUCT_DATA_TYPE) {
            return true;
        }
        for (ASTNode child = node.getFirstChildNode(); child != null; child = child.getTreeNext()) {
            if (containsStruct(child)) {
                return true;
            }
        }
        return false;
    }

    private static @NotNull Indent childIndent(@Nullable IElementType parentType, @Nullable IElementType childType) {
        if (parentType == ApiTypes.IMPORT_GROUP && childType == ApiTypes.IMPORT_VALUE) {
            return Indent.getNormalIndent();
        }
        if (parentType == ApiTypes.TYPE_GROUP_BODY && childType == ApiTypes.TYPE_LITERAL_EXPR) {
            return Indent.getNormalIndent();
        }
        if (parentType == ApiTypes.STRUCT_DATA_TYPE && childType == ApiTypes.ELEM_EXPR) {
            return Indent.getNormalIndent();
        }
        if (parentType == ApiTypes.SERVICE_SPEC && childType == ApiTypes.SERVICE_BODY) {
            return Indent.getNormalIndent();
        }
        if (parentType == ApiTypes.AT_SERVER_BLOCK && childType == ApiTypes.AT_SERVER_KV_PAIR) {
            return Indent.getNormalIndent();
        }
        if (parentType == ApiTypes.INFO_STATEMENT && childType == ApiTypes.KV_PAIR) {
            return Indent.getNormalIndent();
        }
        if (parentType == ApiTypes.AT_DOC_CLAUSE && childType == ApiTypes.KV_PAIR) {
            return Indent.getNormalIndent();
        }
        if (isComment(childType) && (
                parentType == ApiTypes.IMPORT_GROUP
                        || parentType == ApiTypes.TYPE_GROUP_BODY
                        || parentType == ApiTypes.STRUCT_DATA_TYPE
                        || parentType == ApiTypes.SERVICE_SPEC
                        || parentType == ApiTypes.AT_SERVER_BLOCK
                        || parentType == ApiTypes.INFO_STATEMENT
                        || parentType == ApiTypes.AT_DOC_CLAUSE)) {
            return Indent.getNormalIndent();
        }
        return Indent.getNoneIndent();
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        if (child1 == null) {
            return null;
        }

        IElementType parentType = myNode.getElementType();
        IElementType leftType = typeOf(child1);
        IElementType rightType = typeOf(child2);

        if (isRootBlock()) {
            if (isComment(rightType) && !isComment(leftType) && isOnSameLine(child1, child2)) {
                return space(1);
            }
            return isComment(leftType) || isComment(rightType) ? newline(1, true) : blankLines(1);
        }

        if (parentType == ApiTypes.SYNTAX_LIT) {
            return space(1);
        }

        if (parentType == ApiTypes.IMPORT_LIT) {
            return space(1);
        }

        if (parentType == ApiTypes.IMPORT_GROUP) {
            if (leftType == ApiTypes.IMPORT && rightType == ApiTypes.LPAREN) {
                return space(1);
            }
            if (leftType == ApiTypes.LPAREN && rightType == ApiTypes.RPAREN) {
                return noSpace();
            }
            if (leftType == ApiTypes.LPAREN || rightType == ApiTypes.RPAREN) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.INFO_STATEMENT) {
            if (leftType == ApiTypes.INFO && rightType == ApiTypes.LPAREN) {
                return space(1);
            }
            if (leftType == ApiTypes.LPAREN && rightType == ApiTypes.RPAREN) {
                return noSpace();
            }
            if (leftType == ApiTypes.LPAREN || rightType == ApiTypes.RPAREN) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.KV_PAIR || parentType == ApiTypes.AT_SERVER_KV_PAIR) {
            if (rightType == ApiTypes.COLON) {
                return noSpace();
            }
            if (leftType == ApiTypes.COLON) {
                return space(1);
            }
        }

        if (parentType == ApiTypes.TYPE_STATEMENT) {
            return space(1);
        }

        if (parentType == ApiTypes.TYPE_GROUP_BODY) {
            if (isComment(rightType) && !isComment(leftType) && isOnSameLine(child1, child2)) {
                return space(1);
            }
            if (leftType == ApiTypes.LPAREN && rightType == ApiTypes.RPAREN) {
                return noSpace();
            }
            if (leftType == ApiTypes.LPAREN || rightType == ApiTypes.RPAREN) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.TYPE_LITERAL_EXPR) {
            if (leftType == ApiTypes.IDENT && rightType == ApiTypes.ASSIGN) {
                return space(1);
            }
            if (leftType == ApiTypes.ASSIGN) {
                return space(1);
            }
            return space(1);
        }

        if (parentType == ApiTypes.STRUCT_DATA_TYPE) {
            if (leftType == ApiTypes.LBRACE && rightType == ApiTypes.RBRACE) {
                return noSpace();
            }
            if (isComment(rightType) && isOnSameLine(child1, child2)) {
                return space(1);
            }
            if (isComment(leftType) || isComment(rightType)) {
                return newline(1, true);
            }
            if (leftType == ApiTypes.LBRACE || rightType == ApiTypes.RBRACE) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.ELEM_EXPR) {
            if (embeddedTypePairSeparatedByLineBreak) {
                return newline(1, false);
            }
            if (rightType == ApiTypes.COMMA) {
                return noSpace();
            }
            if (leftType == ApiTypes.COMMA) {
                return space(1);
            }
            if (leftType == ApiTypes.STAR) {
                return noSpace();
            }
            return space(1);
        }

        if (parentType == ApiTypes.MAP_DATA_TYPE
                || parentType == ApiTypes.ARRAY_DATA_TYPE
                || parentType == ApiTypes.SLICE_DATA_TYPE
                || parentType == ApiTypes.POINTER_DATA_TYPE) {
            return noSpace();
        }

        if (parentType == ApiTypes.SERVICE_STATEMENT) {
            return newline(1, false);
        }

        if (parentType == ApiTypes.AT_SERVER_BLOCK) {
            if (leftType == ApiTypes.ATSERVER && rightType == ApiTypes.LPAREN) {
                return space(1);
            }
            if (leftType == ApiTypes.LPAREN && rightType == ApiTypes.RPAREN) {
                return noSpace();
            }
            if (leftType == ApiTypes.LPAREN || rightType == ApiTypes.RPAREN) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.SERVICE_SPEC) {
            if (leftType == ApiTypes.SERVICE) {
                return space(1);
            }
            if (rightType == ApiTypes.LBRACE) {
                return space(1);
            }
            if (leftType == ApiTypes.LBRACE && rightType == ApiTypes.RBRACE) {
                return noSpace();
            }
            if (leftType == ApiTypes.SERVICE_BODY && rightType == ApiTypes.SERVICE_BODY) {
                return blankLines(1);
            }
            if (isComment(leftType) || isComment(rightType)) {
                return newline(1, false);
            }
            if (leftType == ApiTypes.LBRACE || rightType == ApiTypes.RBRACE) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.SERVICE_BODY) {
            return newline(1, false);
        }

        if (parentType == ApiTypes.AT_DOC_CLAUSE) {
            if (leftType == ApiTypes.ATDOC) {
                return space(1);
            }
            if (leftType == ApiTypes.LPAREN && rightType == ApiTypes.RPAREN) {
                return noSpace();
            }
            if (leftType == ApiTypes.LPAREN || rightType == ApiTypes.RPAREN) {
                return newline(1, false);
            }
            return newline(1, false);
        }

        if (parentType == ApiTypes.AT_HANDLER_CLAUSE) {
            return space(1);
        }

        if (parentType == ApiTypes.ROUTE_STMT) {
            if (rightType == ApiTypes.SEMICOLON || leftType == ApiTypes.SEMICOLON) {
                return noSpace();
            }
            return space(1);
        }

        if (parentType == ApiTypes.BODY_CLAUSE || parentType == ApiTypes.BODY_EXPR) {
            return noSpace();
        }

        if (parentType == ApiTypes.IMPORT_VALUE) {
            return space(1);
        }

        if (parentType == ApiTypes.SERVICE_NAME || parentType == ApiTypes.PATH_EXPR) {
            return noSpace();
        }

        if (parentType == ApiTypes.AT_SERVER_VALUE) {
            return noSpace();
        }

        return Spacing.createSafeSpacing(false, 0);
    }

    private boolean isEmbeddedTypePairSeparatedByLineBreak() {
        ASTNode first = firstNonWhitespaceChild(myNode);
        ASTNode second = first == null ? null : firstNonWhitespaceSibling(first.getTreeNext());
        if (first == null || second == null
                || first.getElementType() != ApiTypes.IDENT
                || second.getElementType() != ApiTypes.DATA_TYPE
                || !containsLineBreakBetween(first, second)) {
            return false;
        }

        String[] parts = myNode.getText().trim().split("\\s+");
        if (parts.length != 2 || !isIdentifier(parts[0]) || !isIdentifier(parts[1])) {
            return false;
        }

        ASTNode baseType = second.getFirstChildNode();
        return baseType != null
                && baseType.getElementType() == ApiTypes.BASE_DATA_TYPE
                && baseType.getFirstChildNode() != null
                && baseType.getFirstChildNode().getElementType() == ApiTypes.IDENT
                && baseType.getFirstChildNode().getTreeNext() == null;
    }

    private static boolean containsLineBreakBetween(@NotNull ASTNode first, @NotNull ASTNode second) {
        for (ASTNode node = first.getTreeNext(); node != null && node != second; node = node.getTreeNext()) {
            if (node.getText().contains("\n") || node.getText().contains("\r")) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOnSameLine(@NotNull Block left, @NotNull Block right) {
        if (!(left instanceof ApiBlock leftBlock) || !(right instanceof ApiBlock rightBlock)) {
            return false;
        }
        return !containsLineBreakBetween(leftBlock.myNode, rightBlock.myNode);
    }

    private static boolean isIdentifier(@NotNull String text) {
        return text.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private static @Nullable ASTNode firstNonWhitespaceChild(@NotNull ASTNode node) {
        return firstNonWhitespaceSibling(node.getFirstChildNode());
    }

    private static @Nullable ASTNode firstNonWhitespaceSibling(@Nullable ASTNode node) {
        for (ASTNode current = node; current != null; current = current.getTreeNext()) {
            if (current.getElementType() != TokenType.WHITE_SPACE) {
                return current;
            }
        }
        return null;
    }

    @Override
    public @NotNull Indent getIndent() {
        return myIndent;
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
        IElementType parentType = myNode.getElementType();
        if (parentType == ApiTypes.IMPORT_GROUP
                || parentType == ApiTypes.TYPE_GROUP_BODY
                || parentType == ApiTypes.STRUCT_DATA_TYPE
                || parentType == ApiTypes.SERVICE_SPEC
                || parentType == ApiTypes.AT_SERVER_BLOCK
                || parentType == ApiTypes.INFO_STATEMENT
                || parentType == ApiTypes.AT_DOC_CLAUSE) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        }
        return new ChildAttributes(Indent.getNoneIndent(), null);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    private boolean isRootBlock() {
        return myNode.getPsi() instanceof ApiFile || myNode.getElementType() instanceof IFileElementType;
    }

    private static @Nullable IElementType typeOf(@Nullable Block block) {
        if (block instanceof ApiBlock) {
            return ((ApiBlock) block).myNode.getElementType();
        }
        return null;
    }

    private static boolean isComment(@Nullable IElementType type) {
        return type == ApiTypes.LINE_COMMENT || type == ApiTypes.BLOCK_COMMENT;
    }

    private static Spacing space(int count) {
        return Spacing.createSpacing(count, count, 0, false, 0);
    }

    private static Spacing noSpace() {
        return Spacing.createSpacing(0, 0, 0, false, 0);
    }

    private static Spacing newline(int lines, boolean keep) {
        return Spacing.createSpacing(0, 0, lines, keep, keep ? 1 : 0);
    }

    private static Spacing blankLines(int count) {
        return Spacing.createSpacing(0, 0, count + 1, false, count);
    }
}
