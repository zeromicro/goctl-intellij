package cn.xiaoheiban.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.PrioritizedLookupElement;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.impl.TemplateSettings;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ApiProvider extends CompletionProvider<CompletionParameters> {
    private final int myPriority;
    @Nullable
    private final InsertHandler<LookupElement> myInsertHandler;
    @Nullable
    private final AutoCompletionPolicy myCompletionPolicy;

    public ApiProvider(int priority, @Nullable AutoCompletionPolicy completionPolicy) {
        this(priority, null, completionPolicy);
    }

    public ApiProvider(int priority, @Nullable InsertHandler<LookupElement> insertHandler) {
        this(priority, insertHandler, null);
    }

    private ApiProvider(int priority,
                        @Nullable InsertHandler<LookupElement> insertHandler,
                        @Nullable AutoCompletionPolicy completionPolicy) {
        myPriority = priority;
        myInsertHandler = insertHandler;
        myCompletionPolicy = completionPolicy;
    }

    @NotNull
    public LookupElement createKeywordLookupElement(@NotNull String keyword) {
        InsertHandler<LookupElement> insertHandler = ObjectUtils.chooseNotNull(myInsertHandler,
                createTemplateBasedInsertHandler("api_" + keyword));
        LookupElement result = createKeywordLookupElement(keyword, myPriority, insertHandler);
        return myCompletionPolicy != null ? myCompletionPolicy.applyPolicy(result) : result;
    }

    public static LookupElement createKeywordLookupElement(@NotNull String keyword,
                                                           int priority,
                                                           @Nullable InsertHandler<LookupElement> insertHandler) {
        LookupElementBuilder builder = LookupElementBuilder.create(keyword).withBoldness(true).withInsertHandler(insertHandler);
        return PrioritizedLookupElement.withPriority(builder, priority);
    }

    @Nullable
    public static InsertHandler<LookupElement> createTemplateBasedInsertHandler(@NotNull String templateId) {
        return (context, item) -> {
            Template template = TemplateSettings.getInstance().getTemplateById(templateId);
            Editor editor = context.getEditor();
            if (template != null) {
                editor.getDocument().deleteString(context.getStartOffset(), context.getTailOffset());
                TemplateManager.getInstance(context.getProject()).startTemplate(editor, template);
            } else {
                int currentOffset = editor.getCaretModel().getOffset();
                CharSequence documentText = editor.getDocument().getImmutableCharSequence();
                if (documentText.length() <= currentOffset || documentText.charAt(currentOffset) != ' ') {
                    EditorModificationUtil.insertStringAtCaret(editor, " ");
                } else {
                    EditorModificationUtil.moveCaretRelatively(editor, 1);
                }
            }
        };
    }
}
