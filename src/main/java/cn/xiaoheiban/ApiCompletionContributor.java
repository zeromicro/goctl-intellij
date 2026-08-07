package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ApiCompletionContributor extends CompletionContributor {

    public ApiCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ApiTypes.IDENT),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create(""));
                    }
                }
        );
    }
}

