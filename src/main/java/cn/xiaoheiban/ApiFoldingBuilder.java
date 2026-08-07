// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package cn.xiaoheiban;

import cn.xiaoheiban.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class ApiFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root,
                                                           @NotNull Document document,
                                                           boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        root.accept(new PsiRecursiveElementWalkingVisitor() {
            @Override
            public void visitElement(@NotNull PsiElement element) {
                super.visitElement(element);
                switch (element) {
                    // type ( Foo { ... }  Bar { ... } ) — fold the entire (...) block
                    case ApiTypeGroupBody group ->
                            addFolding(group, group.getTextRange(), "(...)", document, descriptors);

                    // type Foo { ... } — fold only the struct body { ... }
                    case ApiTypeLiteralExpr expr -> {
                        ApiDataType dt = expr.getDataType();
                        if (dt != null && dt.getStructDataType() != null) {
                            ApiStructDataType struct = dt.getStructDataType();
                            addFolding(struct, struct.getTextRange(), "{ ... }", document, descriptors);
                        }
                    }

                    // @server ( key: value ... ) — fold the (...) block
                    case ApiAtServerBlock atServer -> {
                        PsiElement lp = findToken(atServer, ApiTypes.LPAREN);
                        if (lp != null) {
                            TextRange range = new TextRange(
                                    lp.getTextRange().getStartOffset(),
                                    atServer.getTextRange().getEndOffset());
                            addFolding(atServer, range, "(...)", document, descriptors);
                        }
                    }

                    // info ( key: value ... ) — fold the (...) block
                    case ApiInfoStatement info -> {
                        PsiElement lp = findToken(info, ApiTypes.LPAREN);
                        if (lp != null) {
                            TextRange range = new TextRange(
                                    lp.getTextRange().getStartOffset(),
                                    info.getTextRange().getEndOffset());
                            addFolding(info, range, "(...)", document, descriptors);
                        }
                    }

                    // service name { ... } — fold from '{' to the closing '}'
                    case ApiServiceSpec spec -> {
                        PsiElement lbrace = findToken(spec, ApiTypes.LBRACE);
                        if (lbrace != null) {
                            TextRange range = new TextRange(
                                    lbrace.getTextRange().getStartOffset(),
                                    spec.getTextRange().getEndOffset());
                            addFolding(spec, range, "{ ... }", document, descriptors);
                        }
                    }

                    default -> {}
                }
            }
        });

        return descriptors.toArray(FoldingDescriptor.EMPTY_ARRAY);
    }

    /**
     * Add a folding descriptor only when the region spans more than one line.
     * Single-line constructs are never folded (they would just be confusing).
     */
    private void addFolding(PsiElement element,
                            TextRange range,
                            String placeholder,
                            Document document,
                            List<FoldingDescriptor> out) {
        if (range.isEmpty()) return;
        int startLine = document.getLineNumber(range.getStartOffset());
        int endLine   = document.getLineNumber(
                Math.min(range.getEndOffset(), document.getTextLength() - 1));
        if (endLine > startLine) {
            out.add(new FoldingDescriptor(element.getNode(), range, null,
                    placeholder, false, Set.of()));
        }
    }

    /** Find the first direct child of {@code parent} whose token type matches {@code type}. */
    private @Nullable PsiElement findToken(PsiElement parent,
                                           com.intellij.psi.tree.IElementType type) {
        PsiElement child = parent.getFirstChild();
        while (child != null) {
            if (child.getNode().getElementType() == type) return child;
            child = child.getNextSibling();
        }
        return null;
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        // Placeholder is set per-descriptor; this fallback is rarely used.
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}

