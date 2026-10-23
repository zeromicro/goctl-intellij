package cn.xiaoheiban;

import cn.xiaoheiban.psi.*;
import com.goide.psi.GoFunctionDeclaration;
import com.goide.stubs.index.GoFunctionIndex;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.Comparator;

/** Resolves generated handler functions independently of goctl's file naming style. */
final class ApiHandlerResolver {
    private ApiHandlerResolver() {}

    static PsiElement[] findTargets(ApiAtHandlerClause clause) {
        if (DumbService.isDumb(clause.getProject())) return PsiElement.EMPTY_ARRAY;
        String group = group(clause);
        String name = handlerName(clause.getIdent().getText(), !group.isEmpty());
        VirtualFile source = clause.getContainingFile().getVirtualFile();
        if (source == null) return PsiElement.EMPTY_ARRAY;

        VirtualFile handlerRoot = null;
        VirtualFile moduleRoot = null;
        ProjectFileIndex index = ProjectFileIndex.getInstance(clause.getProject());
        // Prefer the closest generated service. Stop at go.mod to avoid selecting
        // another service's handlers higher up in a multi-module project.
        for (VirtualFile dir = source.getParent(); dir != null && index.isInContent(dir); dir = dir.getParent()) {
            VirtualFile handlers = dir.findFileByRelativePath("internal/handler");
            if (handlers != null && handlers.isDirectory()) {
                handlerRoot = handlers;
                break;
            }
            if (dir.findChild("go.mod") != null) {
                moduleRoot = dir;
                break;
            }
        }

        VirtualFile expectedDirectory = handlerRoot == null ? null
                : group.isEmpty() ? handlerRoot : handlerRoot.findFileByRelativePath(group);
        if (handlerRoot != null && expectedDirectory == null) return PsiElement.EMPTY_ARRAY;

        VirtualFile serviceRoot = handlerRoot;
        VirtualFile module = moduleRoot;
        String directorySuffix = "/internal/handler" + (group.isEmpty() ? "" : "/" + group);
        return GoFunctionIndex.find(name, clause.getProject(), GlobalSearchScope.projectScope(clause.getProject()), null)
                .stream()
                .filter(function -> {
                    VirtualFile file = function.getContainingFile().getVirtualFile();
                    if (file == null || file.getName().endsWith("_test.go")) return false;
                    if (serviceRoot != null) return expectedDirectory.equals(file.getParent());
                    // Custom output directories may not be ancestors of the API.
                    // Keep candidates in its Go module and let the IDE present
                    // a chooser if more than one generated service matches.
                    return (module == null || VfsUtilCore.isAncestor(module, file, true))
                            && file.getParent().getPath().endsWith(directorySuffix);
                })
                .sorted(Comparator.comparing(function -> function.getContainingFile().getVirtualFile().getPath()))
                .toArray(GoFunctionDeclaration[]::new);
    }

    private static String handlerName(String name, boolean grouped) {
        // Match goctl's suffix normalization and grouped-handler export rule.
        if (name.endsWith("handler")) name = name.substring(0, name.length() - 7);
        if (name.endsWith("Handler")) name = name.substring(0, name.length() - 7);
        name += "Handler";
        return grouped ? Character.toUpperCase(name.charAt(0)) + name.substring(1) : name;
    }

    private static String group(ApiAtHandlerClause clause) {
        ApiServiceBody body = PsiTreeUtil.getParentOfType(clause, ApiServiceBody.class);
        if (body != null && body.getAtDocClause() != null) {
            for (ApiKvPair pair : body.getAtDocClause().getKvPairList()) {
                if ("group".equals(pair.getFirstChild().getText())) {
                    String value = normalizeGroup(pair.getLastChild().getText());
                    if (!value.isEmpty()) return value;
                }
            }
        }
        ApiServiceStatement service = PsiTreeUtil.getParentOfType(clause, ApiServiceStatement.class);
        if (service != null && service.getAtServerBlock() != null) {
            for (ApiAtServerKvPair pair : service.getAtServerBlock().getAtServerKvPairList()) {
                if ("group".equals(pair.getIdent().getText())) return normalizeGroup(pair.getAtServerValue().getText());
            }
        }
        return "";
    }

    private static String normalizeGroup(String value) {
        value = value.trim();
        if (value.length() >= 2 && ((value.startsWith("\"") && value.endsWith("\""))
                || (value.startsWith("`") && value.endsWith("`")))) {
            value = value.substring(1, value.length() - 1);
        }
        return value.replaceAll("^/+|/+$", "");
    }
}
