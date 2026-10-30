package cn.xiaoheiban;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.util.Computable;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class ApiFormattingTest extends BasePlatformTestCase {

    public void testKeepsLineSeparatedAnonymousEmbeddedTypesOnSeparateLines() {
        myFixture.configureByText(ApiFileType.INSTANCE, """
                type BaseAdminApi {
                    ApiBaseHeader
                    BaseOperateUser
                }
                """);
        reformatFile();

        assertEquals("""
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

    public void testDoesNotSplitNamedFieldsWithTrailingComments() {
        myFixture.configureByText(ApiFileType.INSTANCE, """
                type Example {
                    Name string `json:"name"` // name
                    Age int `json:"age"` // age
                }
                """);

        reformatFile();

        assertEquals("""
                type Example {
                    Name string `json:"name"` // name
                    Age  int    `json:"age"` // age
                }
                """, myFixture.getFile().getText());
    }

    public void testFormatsTypeAndFieldCommentsLikeGoctl() {
        myFixture.configureByText(ApiFileType.INSTANCE, """
                /*aa*/type /*bb*/T /*cc*/{// type
                Name string `json:"name"`// name
                }
                """);

        reformatFile();

        assertEquals("""
                /*aa*/
                type /*bb*/ T /*cc*/ { // type
                    Name string `json:"name"` // name
                }
                """, myFixture.getFile().getText());
    }

    public void testFormatsNestedStructsLikeGoctl() {
        String source = """
                /*aa*/
                type /*bb*/ T /*cc*/ { // T.bg
                    // Name head1
                    /*Name head2*/
                    Name string `json:"name"` // name
                    Age  int    `json:"age"` // age
                    Extra
                    Address string
                    Hobby []{
                        Name string // hobby.name
                        Rate string
                    } `json:"hobby"` // hobby
                    Child { // child.bg
                        Name     string `json:"name"` // child.name
                        Gender   int    `json:"gender"` // child.gender
                        Birthday string `json:"birthday"` // child.birthday
                        Desc     string // son.desc
                        Son { // son.bg
                            Name     string `json:"name"` // son.name
                            Gender   int    `json:"gender"` // son.gender
                            Birthday string `json:"birthday"` // son.birthday
                            Desc     string // son.desc
                            Hobby []{
                                Name        string // hobby.name
                                Description string
                                // Map
                                Map map[string]{
                                    Name string `json:"name"`
                                    Age  string `json:"age"`
                                } `json:"map"`
                            } `json:"hobby"` // hobby
                        } // son.end
                    } // child.end
                } // T.end
                """;
        myFixture.configureByText(ApiFileType.INSTANCE, source);

        reformatFile();

        assertEquals(source, myFixture.getFile().getText());
    }

    private void reformatFile() {
        WriteCommandAction.runWriteCommandAction(getProject(),
                (Computable<Void>) () -> {
                    CodeStyleManager.getInstance(getProject()).reformat(myFixture.getFile());
                    return null;
                });
    }
}
