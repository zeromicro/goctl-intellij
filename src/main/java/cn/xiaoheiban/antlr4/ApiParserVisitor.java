package cn.xiaoheiban.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ApiParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ApiParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ApiParser#api}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApi(ApiParser.ApiContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#syntaxLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxLit(ApiParser.SyntaxLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#apiBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApiBody(ApiParser.ApiBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(ApiParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#importSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpec(ApiParser.ImportSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#importLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportLit(ApiParser.ImportLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#importGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportGroup(ApiParser.ImportGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#infoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfoStatement(ApiParser.InfoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatement(ApiParser.TypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeGroupSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeGroupSpec(ApiParser.TypeGroupSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeGroupBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeGroupBody(ApiParser.TypeGroupBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeGroupAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeGroupAlias(ApiParser.TypeGroupAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeSingleSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSingleSpec(ApiParser.TypeSingleSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStruct(ApiParser.TypeStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAlias(ApiParser.TypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#typeFiled}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFiled(ApiParser.TypeFiledContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#normalField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalField(ApiParser.NormalFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldType(ApiParser.FieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#anonymousField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousField(ApiParser.AnonymousFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#normalFieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFieldType(ApiParser.NormalFieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#starFieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStarFieldType(ApiParser.StarFieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#mapFieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapFieldType(ApiParser.MapFieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#arrayOrSliceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOrSliceType(ApiParser.ArrayOrSliceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#structType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(ApiParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#structNameId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructNameId(ApiParser.StructNameIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(ApiParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#referenceId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceId(ApiParser.ReferenceIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#pkg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPkg(ApiParser.PkgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(ApiParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceStatement(ApiParser.ServiceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceServerSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceServerSpec(ApiParser.ServiceServerSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceSpec(ApiParser.ServiceSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceName(ApiParser.ServiceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceBody(ApiParser.ServiceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceDoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceDoc(ApiParser.ServiceDocContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceDocNew}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceDocNew(ApiParser.ServiceDocNewContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceHandler(ApiParser.ServiceHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceHandlerNew}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceHandlerNew(ApiParser.ServiceHandlerNewContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#serviceRoute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceRoute(ApiParser.ServiceRouteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#httpRoute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHttpRoute(ApiParser.HttpRouteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#identPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentPair(ApiParser.IdentPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#handlerPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerPair(ApiParser.HandlerPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#identValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentValue(ApiParser.IdentValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#handlerValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerValue(ApiParser.HandlerValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#importValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportValue(ApiParser.ImportValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#docValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocValue(ApiParser.DocValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(ApiParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link ApiParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(ApiParser.KeyContext ctx);
}