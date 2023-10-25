package cn.xiaoheiban.psi.nodes;

import cn.xiaoheiban.antlr4.ApiParser;
import cn.xiaoheiban.language.ApiFileType;
import cn.xiaoheiban.parser.ApiParserDefinition;
import cn.xiaoheiban.psi.ApiFile;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ArrayListSet;
import org.antlr.jetbrains.adapter.SymtabUtils;
import org.antlr.jetbrains.adapter.psi.ScopeNode;
import org.apache.commons.collections.map.HashedMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;

public class ApiRootNode extends IPsiNode implements ScopeNode {

    public ApiRootNode(@NotNull ASTNode node) {
        super(node);
    }

    public Map<IElementType, List<ASTNode>> getAllNode() {
        Set<IElementType> elementTypeSet = new HashSet<>();
        elementTypeSet.add(ApiParserDefinition.rule(ApiParser.RULE_handlerValue));
        elementTypeSet.add(ApiParserDefinition.rule(ApiParser.RULE_structNameId));
        elementTypeSet.add(ApiParserDefinition.rule(ApiParser.RULE_httpRoute));
        Map<IElementType, List<ASTNode>> children = ApiFile.findChildren(this, elementTypeSet);
        Set<PsiElement> importedPsiElements = getImportedPsiElements(this);
        for (PsiElement psi : importedPsiElements) {
            Map<IElementType, List<ASTNode>> list = ApiFile.findChildren(psi, elementTypeSet);
            list.forEach((iElementType, astNodes) -> {
                List<ASTNode> gotList = children.get(iElementType);
                gotList.addAll(astNodes);
                children.put(iElementType, gotList);
            });
        }
        return children;
    }

    public static boolean resolve(Map<IElementType, List<ASTNode>> children, IElementType elementType, String name) {
        if (children == null || elementType == null || name == null) {
            return true;
        }
        Set<String> nameSet = new HashSet<>();
        children.forEach((et, astNodes) -> {
            if (!et.equals(elementType)) {
                return;
            }
            for (ASTNode node : astNodes) {
                nameSet.add(node.getText());
            }
        });
        return nameSet.contains(name);
    }

    public static Map<IElementType, Set<ASTNode>> getAllDuplicateNode(Map<IElementType, List<ASTNode>> children) {
        Map<String, Set<ASTNode>> tmp = new HashedMap();
        children.forEach((elementType, astNodes) -> {
            for (ASTNode node : astNodes) {
                IPsiNode psiNode = new IPsiNode(node);
                String key = elementType.hashCode() + psiNode.getKey();
                Set<ASTNode> set = tmp.get(key);
                if (set == null) {
                    set = new HashSet<>();
                }
                if (set.contains(node)) {
                    continue;
                }
                set.add(node);
                tmp.put(key, set);
            }
        });
        Map<IElementType, Set<ASTNode>> ret = new HashedMap();
        tmp.forEach((key, set) -> {
            if (set.size() > 1) {
                Object[] objects = set.toArray();
                Object obj = objects[0];
                ASTNode node = (ASTNode) obj;
                ret.put(node.getElementType(), set);
            }
        });
        return ret;
    }

    public static Set<PsiElement> getPsiElementsByDir(PsiDirectory directory, Set<String> expectedPath) {
        Set<PsiElement> importedPsiElements = new ArrayListSet<>();
        if (null == directory) {
            return importedPsiElements;
        }
        Project project = directory.getProject();
        VirtualFile virtualFile = directory.getVirtualFile();
        try {
            String baseDir = directory.getVirtualFile().getPath();
            Set<VirtualFile> relativeFiles = new ArrayListSet<>();
            Set<PsiFile> psiFiles = new ArrayListSet<>();
            for (String importPath : expectedPath) {
                VirtualFile fileByRelativePath = virtualFile.findFileByRelativePath(importPath);
                if (fileByRelativePath == null) {
                    continue;
                }
                relativeFiles.add(fileByRelativePath);
            }
            for (VirtualFile file : relativeFiles) {
                for (String path : expectedPath) {
                    File f = new File(baseDir, path);
                    String absolutePath = f.getCanonicalPath();
                    if (Objects.equals(file.getCanonicalPath(), absolutePath)) {
                        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
                        if (psiFile == null) {
                            continue;
                        }
                        psiFiles.add(psiFile);
                    }
                }
            }

            for (PsiFile file : psiFiles) {
                if (!(file.getFileType() instanceof ApiFileType)) {
                    continue;
                }
                PsiElement[] children = file.getChildren();
                for (PsiElement psi : children) {
                    if (!(psi instanceof ApiRootNode)) {
                        continue;
                    }
                    ApiRootNode apiRootNode = (ApiRootNode) (psi);
                    String filePath = apiRootNode.getContainingFile().getVirtualFile().getPath();
                    for (String path : expectedPath) {
                        File f = new File(baseDir, path);
                        String absolutePath = f.getCanonicalPath();
                        if (filePath.equals(absolutePath)) {
                            importedPsiElements.add(psi);
                        }
                    }
                }
            }
            PsiDirectory[] subdirectories = directory.getSubdirectories();
            for (PsiDirectory d : subdirectories) {
                importedPsiElements.addAll(getPsiElementsByDir(d, expectedPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return importedPsiElements;
    }

    public static Set<PsiElement> getImportedPsiElements(PsiElement element) {
        Set<PsiElement> importedPsiElements = new ArrayListSet<>();
        Set<String> expectedPath = getImports(element);
        PsiDirectory directory = element.getContainingFile().getContainingDirectory();
        importedPsiElements.addAll(getPsiElementsByDir(directory, expectedPath));
        return importedPsiElements;
    }

    public static Set<String> getImports(PsiElement element) {
        List<ASTNode> nodes = ApiFile.findChildren(element, ApiParserDefinition.rule(ApiParser.RULE_importValue));
        Set<String> set = new ArrayListSet<>();
        for (ASTNode node : nodes) {
            String text = node.getLastChildNode().getText();
            set.add(text.replaceAll("\"", ""));
        }
        return set;
    }

    public Map<String, Set<StructNameNode>> getAllStructMap() {
        Map<String, Set<StructNameNode>> ret = new HashedMap();
        Set<ASTNode> nodeSet = new HashSet<>();
        List<ASTNode> structs = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_structType));
        List<ASTNode> alias = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_typeAlias));
        List<ASTNode> groupAlias = ApiFile.findChildren(this, ApiParserDefinition.rule(ApiParser.RULE_typeGroupAlias));
        Set<ASTNode> children = new HashSet<>();
        children.addAll(structs);
        children.addAll(alias);
        children.addAll(groupAlias);
        for (ASTNode node : children) {
            ASTNode childByType = node.findChildByType(ApiParserDefinition.rule(ApiParser.RULE_structNameId));
            if (childByType == null) {
                continue;
            }
            if (nodeSet.contains(childByType)) {
                continue;
            }
            nodeSet.add(childByType);
            StructNameNode nameNode = new StructNameNode(childByType);
            String text = nameNode.getText();
            Set<StructNameNode> duplicateNodeSet = ret.get(text);
            if (duplicateNodeSet == null) {
                duplicateNodeSet = new HashSet<>();
            }
            duplicateNodeSet.add(nameNode);
            ret.put(text, duplicateNodeSet);
        }
        return ret;
    }


    @Override
    public @Nullable PsiElement resolve(PsiNamedElement element) {
        PsiElement resolve = resolve(this, element, "");
        if (resolve != null) {
            return resolve;
        }
        Project project = element.getProject();
        Set<String> pathSet = getImports(this);
        PsiDirectory directory = element.getContainingFile().getContainingDirectory();
        if (null == directory) {
            return null;
        }
        return resolve(directory, element, pathSet);
    }

    public static Set<ApiRootNode> getApiRootNode(PsiElement element) {
        ApiRootNode root = ApiFile.getRoot(element);
        if (root == null) {
            return new ArrayListSet<>();
        }
        Project project = element.getProject();
        Set<String> pathSet = getImports(root);
        VirtualFile[] virtualFiles = ProjectRootManager.getInstance(project).getContentRoots();
        Set<ApiRootNode> set = new ArrayListSet<>();
        for (VirtualFile virtualFile : virtualFiles) {
            PsiDirectory directory = PsiManager.getInstance(project).findDirectory(virtualFile);
            if (null == directory) {
                continue;
            }
            List<ApiRootNode> apiRootNode = getApiRootNode(directory, pathSet);
            for (ApiRootNode node : apiRootNode) {
                set.add(node);
            }
        }
        return set;
    }

    private static List<ApiRootNode> getApiRootNode(PsiDirectory directory, Set<String> pathSet) {
        List<ApiRootNode> list = new ArrayList<>();
        PsiFile[] files = directory.getFiles();
        for (PsiFile file : files) {
            if (!(file.getFileType() instanceof ApiFileType)) {
                continue;
            }
            PsiElement[] children = file.getChildren();
            for (PsiElement psi : children) {
                if (!(psi instanceof ApiRootNode)) {
                    continue;
                }
                ApiRootNode apiRootNode = (ApiRootNode) (psi);
                String filePath = apiRootNode.getContainingFile().getVirtualFile().getPath();
                boolean contains = false;
                for (String path : pathSet) {
                    if (filePath.endsWith(path)) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    continue;
                }
                list.add(apiRootNode);
            }
        }
        PsiDirectory[] subdirectories = directory.getSubdirectories();
        if (subdirectories.length == 0) {
            return list;
        }

        for (PsiDirectory d : subdirectories) {
            List<ApiRootNode> apiRootNode = getApiRootNode(d, pathSet);
            list.addAll(apiRootNode);
        }
        return list;
    }

    private PsiElement resolve(PsiDirectory directory, PsiNamedElement element, Set<String> expectedPath) {
        try {
            if (directory == null) {
                return null;
            }
            Project project = directory.getProject();
            VirtualFile virtualFile = directory.getVirtualFile();
            String baseDir = directory.getVirtualFile().getPath();
            Set<VirtualFile> relativeFiles = new ArrayListSet<>();
            Set<PsiFile> psiFiles = new ArrayListSet<>();
            for (String importPath : expectedPath) {
                VirtualFile fileByRelativePath = virtualFile.findFileByRelativePath(importPath);
                if (fileByRelativePath == null) {
                    continue;
                }
                relativeFiles.add(fileByRelativePath);
            }
            for (VirtualFile file : relativeFiles) {
                for (String path : expectedPath) {
                    File f = new File(baseDir, path);
                    String absolutePath = f.getCanonicalPath();
                    if (Objects.equals(file.getCanonicalPath(), absolutePath)) {
                        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
                        if (psiFile == null) {
                            continue;
                        }
                        psiFiles.add(psiFile);
                    }
                }
            }
            for (PsiFile file : psiFiles) {
                if (!(file.getFileType() instanceof ApiFileType)) {
                    continue;
                }
                PsiElement[] children = file.getChildren();
                for (PsiElement psi : children) {
                    if (!(psi instanceof ApiRootNode)) {
                        continue;
                    }
                    ApiRootNode apiRootNode = (ApiRootNode) (psi);
                    String filePath = apiRootNode.getContainingFile().getVirtualFile().getPath();
                    boolean contains = false;
                    for (String path : expectedPath) {
                        File f = new File(baseDir, path);
                        String absolutePath = f.getCanonicalPath();
                        if (filePath.equals(absolutePath)) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        continue;
                    }
                    PsiElement resolve = resolve(apiRootNode, element, "");
                    if (resolve != null) {
                        return resolve;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public @Nullable PsiElement resolve(ScopeNode scope, PsiNamedElement element, String basePath) {
        PsiElement psiElement = SymtabUtils.resolve(scope, ApiParserDefinition.ELEMENT_FACTORY, element, basePath + "/api/apiBody/typeStatement/typeSingleSpec/typeAlias/structNameId/IDENT");
        if (psiElement != null) {
            return psiElement;
        }
        psiElement = SymtabUtils.resolve(scope, ApiParserDefinition.ELEMENT_FACTORY, element, basePath + "/api/apiBody/typeStatement/typeSingleSpec/typeStruct/structType/structNameId/IDENT");
        if (psiElement != null) {
            return psiElement;
        }
        psiElement = SymtabUtils.resolve(scope, ApiParserDefinition.ELEMENT_FACTORY, element, basePath + "/api/apiBody/typeStatement/typeGroupSpec/typeGroupBody/typeGroupAlias/structNameId/IDENT");
        if (psiElement != null) {
            return psiElement;
        }

        psiElement = SymtabUtils.resolve(scope, ApiParserDefinition.ELEMENT_FACTORY, element, basePath + "/api/apiBody/typeStatement/typeGroupSpec/typeGroupBody/structType/structNameId/IDENT");
        return psiElement;
    }
}
