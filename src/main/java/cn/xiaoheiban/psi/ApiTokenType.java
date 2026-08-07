package cn.xiaoheiban.psi;

import cn.xiaoheiban.ApiLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ApiTokenType extends IElementType {

    public ApiTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ApiLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ApiTokenType." + super.toString();
    }

}
