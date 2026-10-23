package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.ApiBodyExpr;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

/** Reproduces shared request/response types in multi-file API definitions. */
public class ApiTypeResolutionTest extends BasePlatformTestCase {
    private static final String ROUTE = """
            service example-api {
                @handler ListItems
                get /items (ListItemsReq) returns (ListItemsResp)
            }
            """;
    private static final String TYPES = """
            type (
                ListItemsReq { Page int64 }
                ListItemsResp { Total int64 }
            )
            """;

    public void testExplicitImportWithoutLocalTypes() {
        myFixture.addFileToProject("docs/types/shared.api", TYPES);
        ApiFile consumer = file("docs/consumer/routes.api", "import \"../types/shared.api\"\n" + ROUTE);
        assertTypesResolve(consumer);
    }

    public void testTypesSharedByEntryPointImports() {
        ApiFile provider = file("docs/provider/routes.api", TYPES + ROUTE);
        ApiFile consumer = file("docs/consumer/routes.api", ROUTE);
        myFixture.addFileToProject("service.api", "import (\"docs/provider/routes.api\" \"docs/consumer/routes.api\")");
        assertTypesResolve(consumer);
        assertTypesResolve(provider);
    }

    public void testTypesOnlyEntryPointImports() {
        myFixture.addFileToProject("docs/types/shared.api", TYPES);
        ApiFile consumer = file("docs/consumer/routes.api", ROUTE);
        myFixture.addFileToProject("service.api", "import (\"docs/types/shared.api\" \"docs/consumer/routes.api\")");
        assertTypesResolve(consumer);
        assertNull(ApiPsiUtil.findTypeDeclaration(consumer, "MissingType"));
    }

    public void testSharedTypesHighlightAndNavigateToTheirDeclaration() {
        ApiFile types = file("types.api", TYPES);
        ApiFile consumer = file("docs/consumer/routes.api", ROUTE);
        myFixture.addFileToProject("service.api", "import (\"types.api\" \"docs/consumer/routes.api\")");
        myFixture.configureFromExistingVirtualFile(consumer.getVirtualFile());
        myFixture.checkHighlighting(false, false, false);

        ApiBodyExpr request = PsiTreeUtil.findChildOfType(consumer, ApiBodyExpr.class);
        assertNotNull(request);
        PsiElement declaration = new ApiGotoDeclarationHandler()
                .getGotoDeclarationTarget(request.getIdent(), myFixture.getEditor());
        assertNotNull(declaration);
        assertEquals(types, declaration.getContainingFile());
    }

    public void testUnrelatedEntryPointDoesNotLeakTypes() {
        ApiFile consumer = file("docs/consumer/routes.api", ROUTE);
        myFixture.addFileToProject("other/types.api", TYPES);
        myFixture.addFileToProject("other.api", "import \"other/types.api\"");
        assertNull(ApiPsiUtil.findTypeDeclaration(consumer, "ListItemsReq"));
    }

    public void testTransitiveImportsAndCyclesTerminate() {
        ApiFile consumer = file("docs/consumer/routes.api", "import \"../types/api.api\"\n" + ROUTE);
        myFixture.addFileToProject("docs/types/api.api", "import \"../../service.api\"\n" + TYPES);
        myFixture.addFileToProject("service.api", "import \"docs/consumer/routes.api\"");
        assertTypesResolve(consumer);
    }

    public void testNewEntryPointIsRecognizedAfterInitialLookup() {
        ApiFile consumer = file("docs/consumer/routes.api", ROUTE);
        assertNull(ApiPsiUtil.findTypeDeclaration(consumer, "ListItemsReq"));
        myFixture.addFileToProject("types.api", TYPES);
        myFixture.addFileToProject("service.api", "import (\"types.api\" \"docs/consumer/routes.api\")");
        assertTypesResolve(consumer);
    }

    private ApiFile file(String path, String text) {
        return assertInstanceOf(myFixture.addFileToProject(path, text), ApiFile.class);
    }

    private void assertTypesResolve(ApiFile file) {
        assertNotNull(ApiPsiUtil.findTypeDeclaration(file, "ListItemsReq"));
        assertNotNull(ApiPsiUtil.findTypeDeclaration(file, "ListItemsResp"));
    }
}
