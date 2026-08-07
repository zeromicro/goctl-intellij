package cn.xiaoheiban;

import cn.xiaoheiban.psi.*;
import cn.xiaoheiban.psi.ApiTypes;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApiAnnotator implements Annotator {
    public static final String API_PREFIX_STR = "service";
    public static final String API_SEPARATOR_STR = "";
    private static final String NOTIFICATION_GROUP = "Goctl.ApiImport";

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiFile file = element.getContainingFile();
        if (!(file instanceof ApiFile apiFile)) return;

        switch (element) {
            // Per-file trigger: ApiSyntaxLit appears exactly once per file.
            case ApiSyntaxLit s -> checkImportCycles(apiFile);

            // Type declaration: highlight the name as a type decl, then run duplicate / field checks.
            case ApiTypeLiteralExpr expr -> {
                highlightTypeDecl(expr.getIdent(), holder);
                Set<ApiFile> allFiles = collectAllApiFiles(apiFile);
                checkDuplicateStruct(expr, holder, allFiles);
                checkDuplicateFields(expr, holder, allFiles);
            }

            // Named-field / map / slice / array / pointer type reference.
            case ApiBaseDataType baseType -> {
                String name = baseType.getText().trim();
                if (ApiPsiUtil.isPrimitive(name)) {
                    highlightPrimitive(baseType, holder);
                } else {
                    highlightClass(baseType, holder);
                    checkUnresolvedType(baseType, name, holder, apiFile);
                }
            }

            // Route request / response body type.
            case ApiBodyExpr bodyExpr -> {
                PsiElement ident = bodyExpr.getIdent();
                String name = ident.getText().trim();
                if (ApiPsiUtil.isPrimitive(name)) {
                    highlightPrimitive(ident, holder);
                } else {
                    highlightClass(ident, holder);
                    checkUnresolvedType(ident, name, holder, apiFile);
                }
            }

            // Anonymous embedded field: Base or *Base (no ApiDataType child).
            case ApiElemExpr elemExpr -> {
                if (elemExpr.getDataType() == null) {
                    // Find the IDENT — skip the leading '*' if present
                    PsiElement child = elemExpr.getFirstChild();
                    while (child != null) {
                        if (child.getNode().getElementType() == ApiTypes.IDENT) {
                            String name = child.getText().trim();
                            if (!name.isEmpty() && !ApiPsiUtil.isPrimitive(name)) {
                                highlightClass(child, holder);
                                checkUnresolvedType(child, name, holder, apiFile);
                            }
                            break;
                        }
                        child = child.getNextSibling();
                    }
                }
            }

            case ApiServiceName name   -> checkServiceName(name, holder, apiFile);
            case ApiAtHandlerClause clause -> checkDuplicateHandler(clause, holder, apiFile);
            case ApiRouteStmt route        -> checkDuplicateRoute(route, holder, apiFile);
            default -> {}
        }
    }

    // =========================================================================
    // Duplicate struct: across current file + all transitively imported files
    // =========================================================================

    private void checkDuplicateStruct(ApiTypeLiteralExpr element,
                                      AnnotationHolder holder,
                                      Set<ApiFile> allFiles) {
        String name = element.getIdent().getText();

        long count = allFiles.stream()
                .flatMap(f -> PsiTreeUtil.collectElementsOfType(f, ApiTypeLiteralExpr.class).stream())
                .filter(e -> name.equals(e.getIdent().getText()))
                .count();

        if (count > 1) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                            "Duplicate type declaration: '" + name + "'")
                    .range(element.getIdent())
                    .create();
        }
    }

    // =========================================================================
    // Duplicate fields within a struct — recursive into nested anonymous structs
    // =========================================================================

    // =========================================================================
    // Service name consistency: all service blocks across all files must share
    // exactly one name. Multiple distinct names are an error.
    // =========================================================================

    private void checkServiceName(ApiServiceName element,
                                  AnnotationHolder holder,
                                  ApiFile file) {
        String thisName = element.getText().trim();
        Set<ApiFile> allFiles = collectAllApiFiles(file);

        // Collect every distinct service name across all reachable files
        Set<String> allNames = allFiles.stream()
                .flatMap(f -> PsiTreeUtil.collectElementsOfType(f, ApiServiceName.class).stream())
                .map(n -> n.getText().trim())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // If more than one distinct name exists and this element uses a different name,
        // report it. We highlight only the elements that are NOT the "first" (canonical) name.
        if (allNames.size() > 1) {
            String canonical = allNames.iterator().next(); // first seen = canonical
            if (!thisName.equals(canonical)) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                "Service name '" + thisName + "' conflicts with '" + canonical +
                                "'. All service blocks must share the same name.")
                        .range(element)
                        .create();
            }
        }
    }

    /** json:"fieldName,omitempty" → captures the part before the first comma */
    private static final Pattern JSON_TAG_PATTERN =
            Pattern.compile("\\bjson:\"([^\"]+)\"");

    // =========================================================================
    // Unresolved type reference: red error when a named type can't be found
    // =========================================================================

    private void checkUnresolvedType(PsiElement element,
                                     String typeName,
                                     AnnotationHolder holder,
                                     ApiFile apiFile) {
        if (typeName.isEmpty()) return;
        if (ApiPsiUtil.isPrimitive(typeName)) return;
        if (ApiPsiUtil.findTypeDeclaration(apiFile, typeName) == null) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                            "Unresolved type: '" + typeName + "'")
                    .range(element)
                    .create();
        }
    }

    // =========================================================================
    // Semantic highlighting helpers
    // =========================================================================

    /** Type declaration name: type Foo { } — uses Go's TYPE_SPECIFICATION color. */
    private static void highlightTypeDecl(@NotNull PsiElement element,
                                          @NotNull AnnotationHolder holder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(ApiSyntaxHighlighter.TYPE_DECL)
                .create();
    }

    /** Type reference in field / body / anonymous embed — uses Go's TYPE_SPEC_REFERENCE color. */
    private static void highlightClass(@NotNull PsiElement element,
                                       @NotNull AnnotationHolder holder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(ApiSyntaxHighlighter.CLASS_TYPE)
                .create();
    }

    /** Primitive type (string, int, bool…) — uses Go's BUILTIN_TYPE_REFERENCE color. */
    private static void highlightPrimitive(@NotNull PsiElement element,
                                           @NotNull AnnotationHolder holder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.getTextRange())
                .textAttributes(ApiSyntaxHighlighter.PRIMITIVE_TYPE)
                .create();
    }

    private void checkDuplicateFields(ApiTypeLiteralExpr structExpr,
                                      AnnotationHolder holder,
                                      Set<ApiFile> allFiles) {
        ApiDataType dataType = structExpr.getDataType();
        if (dataType == null) return;
        // resolving tracks type names currently on the resolution stack — prevents infinite loops
        // for mutually-referencing aliases (not valid in .api, but guard anyway)
        Set<String> resolving = new HashSet<>();
        resolving.add(structExpr.getIdent().getText());
        recurseIntoDataType(dataType, holder, allFiles, resolving);
    }

    /**
     * Check one struct body for duplicate field names and json tags,
     * then recurse into any nested anonymous struct types found in field types.
     */
    private void checkStructBody(ApiStructDataType structBody,
                                 AnnotationHolder holder,
                                 Set<ApiFile> allFiles,
                                 Set<String> resolving) {
        List<ApiElemExpr> fields = structBody.getElemExprList();

        Map<String, PsiElement> seenNames    = new LinkedHashMap<>();
        Map<String, PsiElement> seenJsonTags = new LinkedHashMap<>();

        for (ApiElemExpr field : fields) {
            List<PsiElement> nameTokens = fieldNameTokens(field);
            ApiTag tag     = field.getTag();
            String jsonTag = tag != null ? extractJsonTag(tag.getRawString().getText()) : null;

            for (PsiElement nameToken : nameTokens) {
                String fieldName = nameToken.getText();

                if (seenNames.containsKey(fieldName)) {
                    holder.newAnnotation(HighlightSeverity.ERROR,
                                    "Duplicate field name: '" + fieldName + "'")
                            .range(nameToken)
                            .create();
                } else {
                    seenNames.put(fieldName, nameToken);
                }

                if (jsonTag != null && !jsonTag.equals("-")) {
                    if (seenJsonTags.containsKey(jsonTag)) {
                        holder.newAnnotation(HighlightSeverity.ERROR,
                                        "Duplicate json tag: '" + jsonTag + "'")
                                .range(tag.getRawString())
                                .create();
                    } else {
                        seenJsonTags.put(jsonTag, tag.getRawString());
                    }
                }
            }

            // Recurse into any nested struct embedded in this field's type
            ApiDataType fieldType = field.getDataType();
            if (fieldType != null) {
                recurseIntoDataType(fieldType, holder, allFiles, resolving);
            }
        }
    }

    /**
     * Walk a dataType tree, calling checkStructBody for any inline or referenced struct found.
     *
     * Handles:
     *   struct      → inline anonymous struct body
     *   map[K]V     → recurse into K and V
     *   [N]T / []T  → recurse into element type T
     *   *T          → recurse into pointed-to type T
     *   baseDataType (IDENT) → look up the named type across all files and recurse into its body
     *   anyType / primitive  → leaf node, stop
     *
     * resolving: names currently on the resolution stack, guards against type alias cycles.
     */
    private void recurseIntoDataType(ApiDataType dt,
                                     AnnotationHolder holder,
                                     Set<ApiFile> allFiles,
                                     Set<String> resolving) {
        if (dt == null) return;

        if (dt.getStructDataType() != null) {
            checkStructBody(dt.getStructDataType(), holder, allFiles, resolving);

        } else if (dt.getMapDataType() != null) {
            for (ApiDataType inner : dt.getMapDataType().getDataTypeList()) {
                recurseIntoDataType(inner, holder, allFiles, resolving);
            }

        } else if (dt.getArrayDataType() != null) {
            recurseIntoDataType(dt.getArrayDataType().getDataType(), holder, allFiles, resolving);

        } else if (dt.getSliceDataType() != null) {
            recurseIntoDataType(dt.getSliceDataType().getDataType(), holder, allFiles, resolving);

        } else if (dt.getPointerDataType() != null) {
            recurseIntoDataType(dt.getPointerDataType().getDataType(), holder, allFiles, resolving);

        } else if (dt.getBaseDataType() != null) {
            // Named type reference — look up its definition and recurse into its body.
            // baseDataType ::= IDENT ('.' IDENT)?  — use full text as the lookup key.
            String typeName = dt.getBaseDataType().getText().trim();
            if (!resolving.add(typeName)) return; // already resolving this type — stop
            try {
                for (ApiFile f : allFiles) {
                    for (ApiTypeLiteralExpr decl :
                            PsiTreeUtil.collectElementsOfType(f, ApiTypeLiteralExpr.class)) {
                        if (typeName.equals(decl.getIdent().getText())) {
                            // Found the declaration — recurse into its dataType
                            recurseIntoDataType(decl.getDataType(), holder, allFiles, resolving);
                            break; // each name is unique (duplicate check handles violations)
                        }
                    }
                }
            } finally {
                resolving.remove(typeName); // restore stack on exit so siblings can still resolve this type
            }
        }
        // anyType / primitive baseDataType with no declaration → leaf, nothing to recurse into
    }

    /**
     * Collect all leading IDENT tokens in an elemExpr node that are field names.
     * BNF: namedField ::= IDENT (',' IDENT)* dataType tag?
     * The IDENTs before the dataType child are field name tokens.
     * For anonField (*Base) there is one IDENT = the embedded type name; treat it as the field name.
     */
    private List<PsiElement> fieldNameTokens(ApiElemExpr field) {
        List<PsiElement> result = new ArrayList<>();
        PsiElement dataType = field.getDataType();
        PsiElement child = field.getFirstChild();
        while (child != null && child != dataType) {
            if (child.getNode().getElementType() == ApiTypes.IDENT) {
                result.add(child);
            }
            child = child.getNextSibling();
        }
        return result;
    }

    /**
     * Extract the json key from a raw struct-tag string.
     * Tag text includes surrounding backticks, e.g.: `json:"name,omitempty" form:"name"`
     * Returns the part before the first comma in the json value, or null if no json tag.
     */
    @Nullable
    private String extractJsonTag(String rawTagText) {
        if (rawTagText == null) return null;
        Matcher m = JSON_TAG_PATTERN.matcher(rawTagText);
        if (!m.find()) return null;
        String value = m.group(1);
        int comma = value.indexOf(',');
        return comma >= 0 ? value.substring(0, comma) : value;
    }

    // =========================================================================
    // Duplicate handler: key = group + ":" + handlerName, across all files
    // group comes from the @server block of the enclosing service statement
    // =========================================================================

    private void checkDuplicateHandler(ApiAtHandlerClause element,
                                       AnnotationHolder holder,
                                       ApiFile file) {
        String handlerKey = handlerKey(element);
        if (handlerKey == null) return;

        Set<ApiFile> allFiles = collectAllApiFiles(file);

        long count = allFiles.stream()
                .flatMap(f -> PsiTreeUtil.collectElementsOfType(f, ApiServiceStatement.class).stream())
                .flatMap(svc -> {
                    String group = extractGroup(svc);
                    return svc.getServiceSpec().getServiceBodyList().stream()
                            .map(body -> buildHandlerKey(group, body.getAtHandlerClause()));
                })
                .filter(handlerKey::equals)
                .count();

        if (count > 1) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                            "Duplicate handler: '" + handlerKey + "'")
                    .range(element.getIdent())
                    .create();
        }
    }

    // =========================================================================
    // Duplicate route: key = method + ":" + prefix + path, across all files
    // =========================================================================

    private void checkDuplicateRoute(ApiRouteStmt element,
                                     AnnotationHolder holder,
                                     ApiFile file) {
        String thisKey = routeKey(element);
        if (thisKey == null) return;

        Set<ApiFile> allFiles = collectAllApiFiles(file);

        long count = allFiles.stream()
                .flatMap(f -> PsiTreeUtil.collectElementsOfType(f, ApiServiceStatement.class).stream())
                .flatMap(svc -> {
                    String prefix = extractPrefix(svc);
                    return svc.getServiceSpec().getServiceBodyList().stream()
                            .map(body -> buildRouteKey(prefix, body.getRouteStmt()));
                })
                .filter(thisKey::equals)
                .count();

        if (count > 1) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                            "Duplicate route: '" + thisKey + "'")
                    .range(element)
                    .create();
        }
    }

    // =========================================================================
    // Import cycle check — triggered once per file via ApiSyntaxLit
    // =========================================================================

    private void checkImportCycles(ApiFile file) {
        // collectAllApiFiles performs DFS cycle detection as a side effect.
        // Any detected cycle is reported via the notification bar inside dfsCollect.
        collectAllApiFiles(file);
    }

    // =========================================================================
    // Import graph traversal using DFS + currentPath stack
    //
    // visited     = fully processed files (grey → black in DFS coloring)
    // currentPath = files currently on the DFS call stack (white → grey)
    //
    // Cycle detected when a file we're about to visit is already in currentPath.
    // =========================================================================

    private Set<ApiFile> collectAllApiFiles(ApiFile startFile) {
        Set<ApiFile> visited = new LinkedHashSet<>();
        // LinkedHashSet preserves insertion order, needed for readable cycle messages
        LinkedHashSet<ApiFile> currentPath = new LinkedHashSet<>();
        // Track reported cycles to avoid duplicate notifications within one pass
        Set<String> reportedCycles = new HashSet<>();

        dfsCollect(startFile, visited, currentPath, reportedCycles);
        return visited;
    }

    private void dfsCollect(ApiFile file,
                             Set<ApiFile> visited,
                             LinkedHashSet<ApiFile> currentPath,
                             Set<String> reportedCycles) {
        // Cycle detected: file is already on the current DFS stack
        if (currentPath.contains(file)) {
            notifyCycle(file, currentPath, reportedCycles);
            return;
        }

        // Already fully processed in a previous branch — skip
        if (visited.contains(file)) return;

        currentPath.add(file);
        visited.add(file);

        Collection<ApiImportStatement> imports =
                PsiTreeUtil.collectElementsOfType(file, ApiImportStatement.class);

        for (ApiImportStatement stmt : imports) {
            for (String importPath : extractImportPaths(stmt)) {
                ApiFile resolved = resolveImport(file, importPath);
                if (resolved != null) {
                    dfsCollect(resolved, visited, currentPath, reportedCycles);
                }
            }
        }

        // Back-track: remove from current path after all children processed
        currentPath.remove(file);
    }

    // =========================================================================
    // Cycle notification
    // =========================================================================

    private void notifyCycle(ApiFile cycleEntry,
                              LinkedHashSet<ApiFile> currentPath,
                              Set<String> reportedCycles) {
        // Build the cycle portion: find where cycleEntry first appears in path
        List<ApiFile> pathList = new ArrayList<>(currentPath);
        int startIdx = 0;
        for (int i = 0; i < pathList.size(); i++) {
            if (pathList.get(i).equals(cycleEntry)) {
                startIdx = i;
                break;
            }
        }

        List<String> cycleNames = pathList.subList(startIdx, pathList.size())
                .stream()
                .map(f -> f.getName())
                .collect(Collectors.toList());
        cycleNames.add(cycleEntry.getName()); // close the loop

        String cycleKey = String.join(" → ", cycleNames);

        // Avoid duplicate notifications for the same cycle
        if (!reportedCycles.add(cycleKey)) return;

        String message = "Circular import detected: " + cycleKey;

        NotificationGroupManager.getInstance()
                .getNotificationGroup(NOTIFICATION_GROUP)
                .createNotification(
                        "Goctl: Circular Import",
                        message,
                        NotificationType.ERROR)
                .notify(cycleEntry.getProject());
    }

    // =========================================================================
    // Import path extraction & resolution
    // =========================================================================

    private List<String> extractImportPaths(ApiImportStatement stmt) {
        List<String> paths = new ArrayList<>();
        if (stmt.getImportLit() != null) {
            String p = unquote(stmt.getImportLit().getImportValue().getString().getText());
            if (p != null) paths.add(p);
        }
        if (stmt.getImportGroup() != null) {
            for (ApiImportValue val : stmt.getImportGroup().getImportValueList()) {
                String p = unquote(val.getString().getText());
                if (p != null) paths.add(p);
            }
        }
        return paths;
    }

    /**
     * Resolve an import path (Unix-style, absolute or relative) to an ApiFile.
     *
     * Absolute path: starts with '/' → resolve directly from filesystem root.
     * Relative path: resolve relative to the directory of the importing file.
     */
    @Nullable
    private ApiFile resolveImport(ApiFile fromFile, String importPath) {
        if (importPath == null || importPath.isEmpty()) return null;

        VirtualFile targetVFile;

        if (importPath.startsWith("/")) {
            // Absolute Unix path
            targetVFile = LocalFileSystem.getInstance().findFileByPath(importPath);
        } else {
            // Relative path — resolved against the importing file's directory
            VirtualFile fromVFile = fromFile.getVirtualFile();
            if (fromVFile == null) return null;
            VirtualFile dir = fromVFile.getParent();
            if (dir == null) return null;
            targetVFile = dir.findFileByRelativePath(importPath);
        }

        if (targetVFile == null || !targetVFile.isValid()) return null;

        PsiFile psiFile = PsiManager.getInstance(fromFile.getProject()).findFile(targetVFile);
        return psiFile instanceof ApiFile ? (ApiFile) psiFile : null;
    }

    /** Strip surrounding double-quotes or backticks from a STRING token. */
    @Nullable
    private String unquote(String text) {
        if (text == null || text.length() < 2) return null;
        char f = text.charAt(0), l = text.charAt(text.length() - 1);
        if ((f == '"' && l == '"') || (f == '`' && l == '`')) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }

    // =========================================================================
    // Route key helpers
    // =========================================================================

    @Nullable
    private String routeKey(ApiRouteStmt route) {
        ApiServiceStatement svc = PsiTreeUtil.getParentOfType(route, ApiServiceStatement.class);
        if (svc == null) return null;
        return buildRouteKey(extractPrefix(svc), route);
    }

    private String buildRouteKey(String prefix, ApiRouteStmt route) {
        String method = route.getHttpMethod().getText().trim().toLowerCase();
        String path = route.getPathExpr().getText().trim();
        return method + ":" + prefix + path;
    }

    private String extractPrefix(ApiServiceStatement svc) {
        return extractAtServerValue(svc, "prefix");
    }

    // =========================================================================
    // Handler key helpers
    // =========================================================================

    @Nullable
    private String handlerKey(ApiAtHandlerClause clause) {
        ApiServiceStatement svc = PsiTreeUtil.getParentOfType(clause, ApiServiceStatement.class);
        if (svc == null) return null;
        return buildHandlerKey(extractGroup(svc), clause);
    }

    /** group:handlerName — if no group, key is just handlerName */
    private String buildHandlerKey(String group, ApiAtHandlerClause clause) {
        if (clause == null) return null;
        String name = clause.getIdent().getText().trim();
        return group.isEmpty() ? name : group + ":" + name;
    }

    private String extractGroup(ApiServiceStatement svc) {
        return extractAtServerValue(svc, "group");
    }

    // =========================================================================
    // @server KV extraction
    // =========================================================================

    /** Extract the value of a given key from the @server block, or "" if absent. */
    private String extractAtServerValue(ApiServiceStatement svc, String key) {
        ApiAtServerBlock block = svc.getAtServerBlock();
        if (block == null) return "";
        for (ApiAtServerKvPair pair : block.getAtServerKvPairList()) {
            if (key.equals(pair.getIdent().getText())) {
                return pair.getAtServerValue().getText().trim();
            }
        }
        return "";
    }
}
