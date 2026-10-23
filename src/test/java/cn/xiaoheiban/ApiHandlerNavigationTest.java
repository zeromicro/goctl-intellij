package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiAtHandlerClause;
import cn.xiaoheiban.psi.ApiBodyExpr;
import cn.xiaoheiban.psi.ApiTypeLiteralExpr;
import com.goide.psi.GoFunctionDeclaration;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class ApiHandlerNavigationTest extends BasePlatformTestCase {
    public void testHandlerWithoutSuffix() {
        PsiFile target = function("internal/handler/list_items_handler.go", "ListItemsHandler");
        assertTarget(target, navigate("service.api", "", "ListItems"));
    }

    public void testHandlerWithSuffixAndDifferentFileNamingStyle() {
        PsiFile target = function("internal/handler/listItemsHandler.go", "ListItemsHandler");
        assertTarget(target, navigate("service.api", "", "ListItemsHandler"));
    }

    public void testNestedGroupDisambiguatesIdenticalFunctionNames() {
        PsiFile target = function("internal/handler/public/items/list.go", "ListItemsHandler");
        function("internal/handler/admin/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("docs/routes.api", "public/items", "ListItemsHandler"));
    }

    public void testNearestServiceDisambiguatesIdenticalGroups() {
        PsiFile target = function("first/internal/handler/items/list.go", "ListItemsHandler");
        function("second/internal/handler/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("first/docs/routes.api", "items", "ListItems"));
    }

    public void testDefaultGroupDoesNotSelectNestedGroup() {
        PsiFile target = function("internal/handler/list.go", "ListItemsHandler");
        function("internal/handler/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("service.api", "", "ListItems"));
    }

    public void testMissingHandlerDoesNotNavigateToAnotherGroup() {
        function("internal/handler/admin/list.go", "ListItemsHandler");
        PsiElement[] targets = navigate("docs/routes.api", "public", "ListItems");
        assertTrue(targets == null || targets.length == 0);
    }

    public void testLowercaseUngroupedHandler() {
        PsiFile target = function("internal/handler/list.go", "listItemsHandler");
        assertTarget(target, navigate("service.api", "", "listItems"));
    }

    public void testGroupedHandlerUsesExportedFunctionName() {
        PsiFile target = function("internal/handler/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("service.api", "items", "listItems"));
    }

    public void testQuotedGroupWithBoundarySlashes() {
        PsiFile target = function("internal/handler/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("service.api", "\"/items/\"", "ListItems"));
    }

    public void testRouteGroupOverridesServiceGroup() {
        PsiFile target = function("internal/handler/admin/items/list.go", "ListItemsHandler");
        function("internal/handler/public/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("service.api", "public/items", "ListItems",
                "@doc (group: \"admin/items\")\n"));
    }

    public void testCustomOutputDirectoryStaysInsideGoModule() {
        myFixture.addFileToProject("first/go.mod", "module example.org/first\n\ngo 1.21\n");
        PsiFile target = function("first/generated/internal/handler/items/list.go", "ListItemsHandler");
        function("second/generated/internal/handler/items/list.go", "ListItemsHandler");
        assertTarget(target, navigate("first/spec/routes.api", "items", "ListItems"));
    }

    public void testMissingModuleHandlerDoesNotSelectAnotherModule() {
        myFixture.addFileToProject("first/go.mod", "module example.org/first\n\ngo 1.21\n");
        function("second/internal/handler/items/list.go", "ListItemsHandler");
        PsiElement[] targets = navigate("first/spec/routes.api", "items", "ListItems");
        assertTrue(targets == null || targets.length == 0);
    }

    public void testAmbiguousCustomOutputsReturnAllTargets() {
        PsiFile first = function("first/generated/internal/handler/items/list.go", "ListItemsHandler");
        PsiFile second = function("second/generated/internal/handler/items/list.go", "ListItemsHandler");
        PsiElement[] targets = navigate("spec/routes.api", "items", "ListItems");
        assertNotNull(targets);
        assertEquals(2, targets.length);
        assertEquals(first, targets[0].getContainingFile());
        assertEquals(second, targets[1].getContainingFile());
    }

    public void testTestFunctionsAreNotNavigationTargets() {
        PsiFile target = function("internal/handler/list.go", "ListItemsHandler");
        myFixture.addFileToProject("internal/handler/list_test.go",
                "package handler_test\nfunc ListItemsHandler() {}\n");
        assertTarget(target, navigate("service.api", "", "ListItems"));
    }

    public void testExistingTypeNavigationStillWorks() {
        PsiFile api = myFixture.addFileToProject("service.api", """
                type Request { Page int64 }
                service example-api {
                    @handler ListItems
                    get /items (Request)
                }
                """);
        myFixture.configureFromExistingVirtualFile(api.getVirtualFile());
        ApiBodyExpr body = PsiTreeUtil.findChildOfType(api, ApiBodyExpr.class);
        assertNotNull(body);
        PsiElement[] targets = new ApiGotoDeclarationHandler().getGotoDeclarationTargets(
                body.getIdent(), body.getTextOffset(), myFixture.getEditor());
        assertNotNull(targets);
        assertEquals(1, targets.length);
        assertInstanceOf(targets[0], ApiTypeLiteralExpr.class);
    }

    private PsiFile function(String path, String name) {
        return myFixture.addFileToProject(path, "package handler\nfunc " + name + "() {}\n");
    }

    private PsiElement[] navigate(String path, String group, String handler) {
        return navigate(path, group, handler, "");
    }

    private PsiElement[] navigate(String path, String group, String handler, String doc) {
        String server = group.isEmpty() ? "" : "@server (group: " + group + ")\n";
        PsiFile api = myFixture.addFileToProject(path,
                server + "service example-api {\n" + doc + "@handler " + handler + "\nget /items\n}\n");
        myFixture.configureFromExistingVirtualFile(api.getVirtualFile());
        ApiAtHandlerClause clause = PsiTreeUtil.findChildOfType(api, ApiAtHandlerClause.class);
        assertNotNull(clause);
        PsiElement ident = clause.getIdent();
        return new ApiGotoDeclarationHandler().getGotoDeclarationTargets(
                ident, ident.getTextOffset(), myFixture.getEditor());
    }

    private void assertTarget(PsiFile file, PsiElement[] targets) {
        assertNotNull(targets);
        assertEquals(1, targets.length);
        assertInstanceOf(targets[0], GoFunctionDeclaration.class);
        assertEquals(file, targets[0].getContainingFile());
    }
}
