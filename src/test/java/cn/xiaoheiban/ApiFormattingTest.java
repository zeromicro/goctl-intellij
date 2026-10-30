package cn.xiaoheiban;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.util.Computable;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class ApiFormattingTest extends BasePlatformTestCase {

    public void testKeepsDeclaredAnonymousEmbeddedTypesOnSeparateLines() {
        myFixture.configureByText(ApiFileType.INSTANCE, """
                type ApiBaseHeader {
                    AccessToken string
                }

                type BaseOperateUser {
                    OpUser string
                }

                type BaseAdminApi {
                    ApiBaseHeader
                    BaseOperateUser
                }
                """);
        reformatFile();

        assertEquals("""
                type ApiBaseHeader {
                    AccessToken string
                }

                type BaseOperateUser {
                    OpUser string
                }

                type BaseAdminApi {
                    ApiBaseHeader
                    BaseOperateUser
                }
                """, myFixture.getFile().getText());
    }

    public void testKeepsSingleLineNamedFieldWhenItsNamesAreDeclaredTypes() {
        myFixture.configureByText(ApiFileType.INSTANCE, """
                type ApiBaseHeader {}

                type BaseOperateUser {}

                type BaseAdminApi {
                    ApiBaseHeader BaseOperateUser
                }
                """);

        reformatFile();

        assertEquals("""
                type ApiBaseHeader {}

                type BaseOperateUser {}

                type BaseAdminApi {
                    ApiBaseHeader BaseOperateUser
                }
                """, myFixture.getFile().getText());
    }

    private void reformatFile() {
        WriteCommandAction.runWriteCommandAction(getProject(),
                (Computable<Void>) () -> {
                    CodeStyleManager.getInstance(getProject()).reformat(myFixture.getFile());
                    return null;
                });
    }
}
