package cn.xiaoheiban;

import cn.xiaoheiban.psi.ApiFile;
import cn.xiaoheiban.psi.ApiImportGroup;
import cn.xiaoheiban.psi.ApiImportStatement;
import cn.xiaoheiban.psi.ApiImportValue;
import cn.xiaoheiban.psi.ApiTypeLiteralExpr;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/** Shared PSI utilities used by annotators and reference providers. */
public final class ApiPsiUtil {

    private ApiPsiUtil() {}

    // -------------------------------------------------------------------------
    // Primitive Go types — these are never user-defined and need no resolution
    // -------------------------------------------------------------------------

    private static final Set<String> GO_PRIMITIVES = Set.of(
            "string", "bool", "byte", "rune", "error",
            "int", "int8", "int16", "int32", "int64",
            "uint", "uint8", "uint16", "uint32", "uint64",
            "float32", "float64", "complex64", "complex128",
            "uintptr",
            "any"       // Go 1.18 alias for interface{}; interface{} is tokenized as ANY, not IDENT
    );

    public static boolean isPrimitive(@NotNull String typeName) {
        return GO_PRIMITIVES.contains(typeName);
    }

    // -------------------------------------------------------------------------
    // Find a type declaration by name across all reachable files
    // -------------------------------------------------------------------------

    @Nullable
    public static ApiTypeLiteralExpr findTypeDeclaration(@NotNull ApiFile fromFile,
                                                          @NotNull String typeName) {
        for (ApiFile f : collectAllApiFiles(fromFile)) {
            for (ApiTypeLiteralExpr decl :
                    PsiTreeUtil.collectElementsOfType(f, ApiTypeLiteralExpr.class)) {
                if (typeName.equals(decl.getIdent().getText())) {
                    return decl;
                }
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // DFS import graph traversal
    // -------------------------------------------------------------------------

    @NotNull
    public static Set<ApiFile> collectAllApiFiles(@NotNull ApiFile startFile) {
        Set<ApiFile> visited = new LinkedHashSet<>();
        dfsCollect(startFile, visited, new LinkedHashSet<>());
        return visited;
    }

    private static void dfsCollect(@NotNull ApiFile file,
                                    @NotNull Set<ApiFile> visited,
                                    @NotNull Set<ApiFile> currentPath) {
        if (currentPath.contains(file)) return; // cycle — stop
        if (visited.contains(file)) return;

        currentPath.add(file);
        visited.add(file);

        Collection<ApiImportStatement> imports =
                PsiTreeUtil.collectElementsOfType(file, ApiImportStatement.class);

        for (ApiImportStatement stmt : imports) {
            for (String path : extractImportPaths(stmt)) {
                ApiFile resolved = resolveImport(file, path);
                if (resolved != null) {
                    dfsCollect(resolved, visited, currentPath);
                }
            }
        }

        currentPath.remove(file);
    }

    @NotNull
    private static java.util.List<String> extractImportPaths(@NotNull ApiImportStatement stmt) {
        java.util.List<String> paths = new java.util.ArrayList<>();
        if (stmt.getImportLit() != null && stmt.getImportLit().getImportValue() != null) {
            String p = unquote(stmt.getImportLit().getImportValue().getString().getText());
            if (p != null) paths.add(p);
        }
        ApiImportGroup group = stmt.getImportGroup();
        if (group != null) {
            for (ApiImportValue val : group.getImportValueList()) {
                String p = unquote(val.getString().getText());
                if (p != null) paths.add(p);
            }
        }
        return paths;
    }

    @Nullable
    private static ApiFile resolveImport(@NotNull ApiFile fromFile, @NotNull String importPath) {
        if (importPath.isEmpty()) return null;
        VirtualFile target;
        if (importPath.startsWith("/")) {
            target = LocalFileSystem.getInstance().findFileByPath(importPath);
        } else {
            VirtualFile vf = fromFile.getVirtualFile();
            if (vf == null) return null;
            VirtualFile dir = vf.getParent();
            if (dir == null) return null;
            target = dir.findFileByRelativePath(importPath);
        }
        if (target == null || !target.isValid()) return null;
        PsiFile psi = PsiManager.getInstance(fromFile.getProject()).findFile(target);
        return psi instanceof ApiFile ? (ApiFile) psi : null;
    }

    @Nullable
    private static String unquote(@Nullable String text) {
        if (text == null || text.length() < 2) return null;
        char f = text.charAt(0), l = text.charAt(text.length() - 1);
        if ((f == '"' && l == '"') || (f == '`' && l == '`')) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }
}
