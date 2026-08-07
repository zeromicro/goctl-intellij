package cn.xiaoheiban.template;

import cn.xiaoheiban.ApiLanguage;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class ApiEverywhereContextType extends ApiLiveTemplateContextType {

    protected ApiEverywhereContextType() {
        super("API");
    }

    @Override
    protected boolean isInContext(@NotNull PsiElement element) {
        return !(element instanceof PsiComment);
    }
}
