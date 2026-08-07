package cn.xiaoheiban.psi;

import cn.xiaoheiban.ApiLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ApiElementType extends IElementType {

    public ApiElementType(@NotNull @NonNls String debugName) {
        super(debugName, ApiLanguage.INSTANCE);
    }

}