package cn.xiaoheiban.completion;

import cn.xiaoheiban.parser.ApiParserDefinition;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.openapi.project.DumbAware;
import com.intellij.patterns.ElementPattern;
import com.intellij.psi.PsiElement;

import static com.intellij.patterns.PlatformPatterns.psiElement;


public class KeywordCompletionContributor extends CompletionContributor implements DumbAware {
    private static final String[] keywords = new String[]{"import", "map", "type", "bool", "uint8", "uint16", "uint32", "uint64", "int8", "int16", "int32", "int64", "float32", "float64", "complex64", "complex128", "string", "int", "uint", "uintptr", "byte", "rune",
            "get", "head", "post", "put", "patch", "delete", "connect", "options", "trace", "title", "desc", "author", "email", "version", "summary", "title", "desc", "author", "email", "version", "summary",
            "group", "jwt", "doc", "server", "service", "info", "handler", "middleware"};

    public KeywordCompletionContributor() {
        for (String keyword : keywords) {
            extend(CompletionType.BASIC, typeDeclaration(), new ApiKeywordCompletionProvider(Priority.KEYWORD_PRIORITY, AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE, keyword));
        }
    }

    private static ElementPattern<? extends PsiElement> typeDeclaration() {
        return psiElement(ApiParserDefinition.IDENTIFIER);
    }

}
