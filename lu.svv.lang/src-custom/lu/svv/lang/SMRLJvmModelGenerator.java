package lu.svv.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.impl.JvmMemberImplCustom;
import org.eclipse.xtext.common.types.impl.JvmOperationImpl;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.impl.XBlockExpressionImpl;
import org.eclipse.xtext.xbase.impl.XFeatureCallImplCustom;
import org.eclipse.xtext.xbase.impl.XIfExpressionImpl;
import org.eclipse.xtext.xbase.impl.XVariableDeclarationImpl;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

import com.google.inject.Inject;


/**
 * 
 * 
 * 
 * The following is needed:
 * public class SMRLRuntimeModule extends AbstractSMRLRuntimeModule {

	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return SMRLJvmModelGenerator.class;
	}

}
 * 
 * @author fabrizio.pastore
 *
 */
public class SMRLJvmModelGenerator extends JvmModelGenerator {


	private String PACKAGE_NAME = "smrl.mr.language";
//	private String PACKAGE_NAME = "ase2019.mr.language";

//	private static final boolean ASE2019 = true;
	
	@Inject JvmTypesBuilder builder;
	@Inject JvmTypeReferenceBuilder rbuilder;

	@Override
	protected ITreeAppendable _generateModifier(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println("!!!"+it.getQualifiedName());
		System.out.println("!!!");
		return super._generateModifier(it, appendable, config);
	}

	@Override
	public void generateExecutableBody(JvmExecutable op, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println(op.getSimpleName());

		super.generateExecutableBody(op, appendable, config);

		System.out.println("!DONE"); //
	}




	@Override
	public ImportManager getImportManager(ITreeAppendable appendable) {
		// TODO Auto-generated method stub
		return super.getImportManager(appendable);
	}

	@Override
	protected ImportingStringConcatenation createImportingStringConcatenation(SharedAppendableState state,
			ITypeReferenceOwner owner) {
		System.out.println("");
		return super.createImportingStringConcatenation(state, owner);
	}

	@Override
	public void generateExtendsClause(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println("EXTENDS");
		super.generateExtendsClause(it, appendable, config);
		appendable.append("extends MR");
		System.out.println("EXTENDS DONE");
	}

	@Override
	protected ITreeAppendable _generateMember(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println("_generateMember"); //OP
		ITreeAppendable member = super._generateMember(it, appendable, config);

		return member;
	}

	@Override
	public ITreeAppendable compile(JvmExecutable executable, XExpression expression, JvmTypeReference returnType,
			ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println(expression);

		if ( expression instanceof XBlockExpression ) {
			processBlockExpression(expression);
		}

		System.out.println(expression.getClass());


		System.out.println("@@@");



		ITreeAppendable tree = super.compile(executable, expression, returnType, appendable, config);
		appendable.newLine();
		appendable.append("return true;");
		return tree;
	}

	/**
	 * internal method used to replace implies(a,b) with if structure
	 * 
	 * @param expression
	 */
	private void processBlockExpression(XExpression expression) {
		System.out.println(expression.getClass().getCanonicalName());
		
		if ( expression instanceof XBasicForLoopExpression ) {
			XBasicForLoopExpression exp = (XBasicForLoopExpression) expression;

			
			XExpression internal = ((XBasicForLoopExpression) exp).getEachExpression();
			
			if ( internal instanceof XFeatureCall ) {
				HashMap<Integer,XExpression> toSet = new HashMap<Integer,XExpression>();
				handleRewritingOfFeatureCall(toSet, 0, exp);
				
				if ( toSet.size() > 0 ) {
					((XBasicForLoopExpression) exp).setEachExpression(toSet.get(0));
				}
			} else {
				processBlockExpression(internal);
			}
		} else if ( expression instanceof XForLoopExpression ) {
			XForLoopExpression exp = (XForLoopExpression) expression;

			
			XExpression internal = ((XForLoopExpression) exp).getEachExpression();
			
			if ( internal instanceof XFeatureCall ) {
				HashMap<Integer,XExpression> toSet = new HashMap<Integer,XExpression>();
				handleRewritingOfFeatureCall(toSet, 0, exp);
				
				if ( toSet.size() > 0 ) {
					((XForLoopExpression) exp).setEachExpression(toSet.get(0));
				}
			} else {
				processBlockExpression(internal);
			}
		} else if ( expression instanceof XBlockExpression ) {

			XBlockExpression b = (XBlockExpression) expression;
			EList<XExpression> expressions = b.getExpressions();

			System.out.println("!!!"+expression);

			HashMap<Integer,XExpression> toSet = new HashMap<Integer,XExpression>();

			ArrayList<XExpression> newExpressions = new ArrayList<>();
			int c=-1;
			for ( XExpression exp : expressions ) {
				c++;
				System.out.println("!!!"+exp);
				if ( exp instanceof XFeatureCall ) {
					handleRewritingOfFeatureCall(toSet, c, exp);
				} else {	
					processBlockExpression(exp);
				}
			}

			for ( Entry<Integer, XExpression> e : toSet.entrySet() ) {
				b.getExpressions().set(e.getKey(), e.getValue());	
			}

		} else {
			System.out.println("!!! Unhandled expression "+expression);
		}
	}

	private void handleRewritingOfFeatureCall(HashMap<Integer, XExpression> toSet, int c, XExpression exp) {
		XFeatureCall f = (XFeatureCall) exp;
		
		//FIXME: we should rewrite only if at the top level
		if ( "IMPLIES".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleImplies(f, c, toSet);
		} else if ( "AND".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleAnd(f, c, toSet);
		} else if ( "OR".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleOr(f, c, toSet);
		} else if ( "XOR".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleXor(f, c, toSet);
		} else if ( "NOT".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleNot(f, c, toSet);
		} else if ( "FALSE".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleNot(f, c, toSet);
		} else if ( "TRUE".equals(f.getConcreteSyntaxFeatureName() ) ){
			handleTrue(f, c, toSet);
		}
	}

	private void handleImplies(XFeatureCall f, int c, HashMap<Integer, XExpression> toSet) {
		EList<XExpression> args = f.getFeatureCallArguments();
		XExpression lhs = args.get(0);
		XExpression rhs = args.get(1);


		//We generate:
		//						if(a) {
		//							if(b) {
		//								PROPERTY HOLDS
		//							}else {
		//								return false;
		//							}
		//						}

		




		//if(b)
		
		
		
		XIfExpressionImpl if_B = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		if_B.setIf(rhs);


		//{ PROPERTY HOLDS }
		XBlockExpressionImpl nrhs = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
		XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
		strLit.setValue("//EXPRESSION_PASS //PROPERTY HOLDS");
		nrhs.getExpressions().add(strLit);
		if_B.setThen(nrhs);


		//{return false}
		XReturnExpression retFalse = XbaseFactory.eINSTANCE.createXReturnExpression();
		XBooleanLiteral falseLit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
		retFalse.setExpression(falseLit);
		if_B.setElse(retFalse);
		
		
		XBlockExpressionImpl if_B_Block = createBlockWithIfCounter(if_B);

		
		
		XIfExpressionImpl if_A = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		//if(a)
		if_A.setIf(lhs);
		if_A.setThen(if_B_Block);
		
		{
			XBlockExpressionImpl nrhsP = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
			XStringLiteral strLitP = XbaseFactory.eINSTANCE.createXStringLiteral();
			strLitP.setValue("//EXPRESSION_PASS //PROPERTY HOLDS");
			nrhsP.getExpressions().add(strLitP);
			if_A.setElse(nrhsP);
		}

		XBlockExpressionImpl if_A_Block = createBlockWithIfCounter(if_A);
		

		toSet.put(c, if_A_Block);
	}

//	private XBlockExpressionImpl createIfCounterBlock() {
//		XBlockExpressionImpl mainBlock = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
//		XStringLiteral conditionsCounterStr = createConditionsCounterString();
//		mainBlock.getExpressions().add(conditionsCounterStr);
//		return mainBlock;
//	}
	
	private XBlockExpressionImpl createBlockWithIfCounter(XIfExpressionImpl if_B) {
		XBlockExpressionImpl mainBlock = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
		XStringLiteral conditionsCounterStr = createConditionsCounterString();
		mainBlock.getExpressions().add(conditionsCounterStr);
		mainBlock.getExpressions().add(if_B);
		return mainBlock;
	}

	private XStringLiteral createConditionsCounterString() {
		XStringLiteral conditionsCounterStr = XbaseFactory.eINSTANCE.createXStringLiteral();
		conditionsCounterStr.setValue("//IF_CONDITION_COUNTER");
		return conditionsCounterStr;
	}
	
	private void handleAnd(XFeatureCall f, int c, HashMap<Integer, XExpression> toSet) {
		EList<XExpression> args = f.getFeatureCallArguments();
		XExpression lhs = args.get(0);
		XExpression rhs = args.get(1);


		//We generate:
				//						if(a) {
				//							if(b) {
				//								PROPERTY HOLDS
				//							}else {
				//								return false;
				//							}
				//						} else {
		//									return false;
		//								}

		
		
		



		//if(b)
		XIfExpressionImpl if_B = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		if_B.setIf(rhs);


		//{ PROPERTY HOLDS }
		XBlockExpressionImpl nrhs = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
		

		
		XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
		strLit.setValue("//EXPRESSION_PASS //PROPERTY HOLDS");
		nrhs.getExpressions().add(strLit);
		if_B.setThen(nrhs);

		{
			//{return false}
			XReturnExpression retFalse = XbaseFactory.eINSTANCE.createXReturnExpression();
			XBooleanLiteral falseLit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
			retFalse.setExpression(falseLit);
			if_B.setElse(retFalse);
		}
		XBlockExpressionImpl if_B_block = createBlockWithIfCounter(if_B);
		
		
		//if(a)
		XIfExpressionImpl if_A = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		if_A.setIf(lhs);
		if_A.setThen(if_B_block);
		
		{
			//{return false}
			XReturnExpression retFalse = XbaseFactory.eINSTANCE.createXReturnExpression();
			XBooleanLiteral falseLit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
			retFalse.setExpression(falseLit);
			if_A.setElse(retFalse);
		}
		
		XBlockExpressionImpl if_A_block = createBlockWithIfCounter(if_A);


		toSet.put(c, if_A_block);
	}
	
	
	private void handleNot(XFeatureCall f, int c, HashMap<Integer, XExpression> toSet) {
		EList<XExpression> args = f.getFeatureCallArguments();
		XExpression lhs = args.get(0);
		


		//We generate:		
		//						if(a) {
		//							return false;
		//						} else {
		//							PROPERTY HOLDS
		//						} 

		
		XIfExpressionImpl if_A = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		//if(a)
		if_A.setIf(lhs);
	
		{
			
			
			XReturnExpression retFalse = XbaseFactory.eINSTANCE.createXReturnExpression();
			XBooleanLiteral falseLit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
			retFalse.setExpression(falseLit);
	
			
			if_A.setThen(retFalse);
		}
		
		//The else branch is needed only to keep track of passing metamorphic expressions
		{
			XBlockExpressionImpl nrhs = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
			XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
			strLit.setValue("//EXPRESSION_PASS //PROPERTY HOLDS");
			nrhs.getExpressions().add(strLit);
			if_A.setElse(nrhs);
		}
		
		
		XBlockExpressionImpl if_A_block = createBlockWithIfCounter(if_A);

		toSet.put(c, if_A_block);
	}
	
	private void handleTrue(XFeatureCall f, int c, HashMap<Integer, XExpression> toSet) {
		EList<XExpression> args = f.getFeatureCallArguments();
		XExpression lhs = args.get(0);
		


		//We generate:		
		//						if(a) {
		//							PROPERTY HOLDS
		//						} else {
		//								return false;
		//							
		//						} 

		
		XIfExpressionImpl if_A = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		//if(a)
		if_A.setIf(lhs);
	
		{
			//{ PROPERTY a HOLDS }
			XBlockExpressionImpl _a_holds_Exp = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
			XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
			strLit.setValue("//EXPRESSION_PASS //PROPERTY a HOLDS");
			_a_holds_Exp.getExpressions().add(strLit);
			
			
			
			if_A.setThen(_a_holds_Exp);
		}
		
		{
			
			
			
			XReturnExpression retFalse = XbaseFactory.eINSTANCE.createXReturnExpression();
			XBooleanLiteral falseLit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
			retFalse.setExpression(falseLit);
//			_a_holds_Exp.getExpressions().add(falseLit);
			
			if_A.setElse(retFalse);
		}
		
		
		XBlockExpressionImpl if_A_block = createBlockWithIfCounter(if_A);


		toSet.put(c, if_A_block);
	}
	
	
	private void handleOr(XFeatureCall f, int c, HashMap<Integer, XExpression> toSet) {
		EList<XExpression> args = f.getFeatureCallArguments();
		XExpression lhs = args.get(0);
		XExpression rhs = args.get(1);

		
		//We generate:		
		//						if(a) {
		//							PROPERTY HOLDS
		//						} else {
		//							if(b) {
		//								PROPERTY HOLDS
		//							}else {
		//								return false;
		//							}
		//						} 

		
		XIfExpressionImpl if_A = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
		//if(a)
		if_A.setIf(lhs);
	
		{
			//{ PROPERTY a HOLDS }
			XBlockExpressionImpl _a_holds_Exp = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
			XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
			strLit.setValue("//EXPRESSION_PASS //PROPERTY a HOLDS");
			_a_holds_Exp.getExpressions().add(strLit);
			if_A.setThen(_a_holds_Exp);
		}
		
		//else !a
		{
			XIfExpressionImpl if_B = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
			
			if_B.setIf(rhs);
			
			XBlockExpressionImpl if_B_block = createBlockWithIfCounter(if_B);
			if_A.setElse(if_B_block);
			
			{	//b holds
				//{ PROPERTY b HOLDS }
				XBlockExpressionImpl _b_holds_Exp = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
				XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
				strLit.setValue("//EXPRESSION_PASS //PROPERTY b HOLDS");
				_b_holds_Exp.getExpressions().add(strLit);
				if_B.setThen(_b_holds_Exp);
			}
			
			
			{
				
			
				
				//{return false}
				XReturnExpression retFalse = XbaseFactory.eINSTANCE.createXReturnExpression();
				XBooleanLiteral falseLit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
				retFalse.setExpression(falseLit);
				
				if_B.setElse(retFalse);
			}
			
			
			
		}
		

		XBlockExpressionImpl if_A_block = createBlockWithIfCounter(if_A);

		toSet.put(c, if_A_block);
	}
	
	
	private void handleXor(XFeatureCall f, int c, HashMap<Integer, XExpression> toSet) {
		EList<XExpression> args = f.getFeatureCallArguments();
		XExpression lhs = args.get(0);
		XExpression rhs = args.get(1);


		//We generate:

		
		//						if(a) {
		//							PROPERTY HOLDS
		//						} else {
		//							if(b) {
		//								PROPERTY HOLDS
		//							}else {
		//								return false;
		//							}
		//						} 

		




		//if(b)
		//_a_holds_Exp.setIf(rhs);

		XBlockExpressionImpl mainBlock = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
		
		JvmOperationImpl jvmOperationImpl = (JvmOperationImpl)((XFeatureCallImplCustom)f).getFeature();
		JvmTypeReference booleanType = jvmOperationImpl.getReturnType();
		
		
		XVariableDeclaration decl = XbaseFactory.eINSTANCE.createXVariableDeclaration();
		XBooleanLiteral lit = XbaseFactory.eINSTANCE.createXBooleanLiteral();
		lit.setIsTrue(false);
//		decl.setRight(lit);
		decl.setName("_xorA");
		decl.setType(booleanType);
		
		XExpression first = f.getFeatureCallArguments().get(0);
		
		mainBlock.getExpressions().add(decl);
		
		
		
		
		XVariableDeclaration declB = XbaseFactory.eINSTANCE.createXVariableDeclaration();
		XBooleanLiteral litB = XbaseFactory.eINSTANCE.createXBooleanLiteral();
		litB.setIsTrue(false);
//		declB.setRight(litB);
		declB.setName("_xorB");
		declB.setType(booleanType);
		
		mainBlock.getExpressions().add(declB);


		
//		XIfExpressionImpl ifExp = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
//		//if(a)
//		ifExp.setIf(lhs);
//		
//		XBlockExpressionImpl _a_holds_Exp = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
//		ifExp.setThen(_a_holds_Exp);
//		
//		XAssignment ass = XbaseFactory.eINSTANCE.createXAssignment();
//		
//		XStringLiteral v = XbaseFactory.eINSTANCE.createXStringLiteral();
//		v.setValue("_xorA");
//
//		ass.setAssignable(v);
//		
//		XBooleanLiteral litT = XbaseFactory.eINSTANCE.createXBooleanLiteral();
//		litT.setIsTrue(true);
//		ass.setValue(litT);
//		_a_holds_Exp.getExpressions().add(ass);
//		
//		mainBlock.getExpressions().add(ifExp);
//	
//		{
//			
//			//{ PROPERTY a HOLDS }
//			XBlockExpressionImpl _a_holds_Exp = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
//			
//			XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
//			strLit.setValue("//PROPERTY a HOLDS");
//			_a_holds_Exp.getExpressions().add(strLit);
//			ifExp.setThen(_a_holds_Exp);
//			
//			
//			
//			
//			
//			
//			
//			_a_holds_Exp.getExpressions().add(ass);
//			
//		}
//		
//		//else !a
//		{
//			XIfExpressionImpl _a_not_holds_Exp = (XIfExpressionImpl) XbaseFactory.eINSTANCE.createXIfExpression();
//			mainBlock.getExpressions().add(_a_not_holds_Exp);
//			
//			_a_not_holds_Exp.setIf(rhs);
//			
//			
//			{	//b holds
//				//{ PROPERTY b HOLDS }
//				XBlockExpressionImpl _b_holds_Exp = (XBlockExpressionImpl) XbaseFactory.eINSTANCE.createXBlockExpression();
//				XStringLiteral strLit = XbaseFactory.eINSTANCE.createXStringLiteral();
//				strLit.setValue("//PROPERTY b HOLDS");
//				_b_holds_Exp.getExpressions().add(strLit);
//				_a_not_holds_Exp.setThen(_b_holds_Exp);
//				
//				XAssignment ass = XbaseFactory.eINSTANCE.createXAssignment();
//				ass.setAssignable(declB);
//				
//				XBooleanLiteral litT = XbaseFactory.eINSTANCE.createXBooleanLiteral();
//				litT.setIsTrue(true);
//				
//				ass.setValue(litT);
//				
//				_b_holds_Exp.getExpressions().add(ass);
//			}
//		}
			

			
			
			
		
		


		toSet.put(c, mainBlock);
	}

	@Override
	protected ITreeAppendable _generateMember(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {

		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		
		type.setPackageName(PACKAGE_NAME);
		type.setSimpleName("MR");

		System.out.println(it);

		return super._generateMember(it, appendable, config);
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		System.out.println(input);
		super.doGenerate(input, fsa);
	}

	@Override
	protected void _internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		System.out.println(type);
		super._internalDoGenerate(type, fsa);
	}

	@Override
	protected ITreeAppendable _generateBody(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		

		type.setPackageName(PACKAGE_NAME);


		type.setSimpleName("MR");
		
		System.out.println(it); //ADD IMPORT HERE
		
		appendable.append("import "+PACKAGE_NAME+".MR;");
		
		appendable.newLine();
		appendable.newLine();

		return super._generateBody(it, appendable, config);
	}



	@Override
	public CharSequence generateType(JvmDeclaredType type, GeneratorConfig config) {

		CharSequence seq = super.generateType(type, config);

		String s = seq.toString();
		s = s.replace("void mr()", "boolean mr()");
		
		s = s.replace("/* \"//EXPRESSION_PASS", "expressionPass(); /*");
		
		s = s.replace("/* \"//IF_CONDITION_COUNTER\" */", 
				"ifThenBlock();");
		
		return s.subSequence(0, s.length());
	}

	@Override
	protected ITreeAppendable _generateModifier(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println("aaa");
		ITreeAppendable m = super._generateModifier(it, appendable, config);
		return m;
	}

	@Override
	protected ITreeAppendable _generateModifier(JvmDeclaredType it, ITreeAppendable appendable,
			GeneratorConfig config) {

		ITreeAppendable mod = super._generateModifier(it, appendable, config);

		return mod;
	}

	@Override
	protected ITreeAppendable _generateMember(JvmMember it, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println("aaa");
		return super._generateMember(it, appendable, config);
	}

	@Override
	public ITreeAppendable generateMember(JvmMember it, ITreeAppendable appendable, GeneratorConfig config) {
		System.out.println("aaa");
		JvmMemberImplCustom c = (JvmMemberImplCustom) it;

		ITreeAppendable m = super.generateMember(it, appendable, config);
		return m;
	}



	@Override
	public ITreeAppendable generateBody(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		
		
		type.setPackageName(PACKAGE_NAME);
		type.setSimpleName("MR");	


		System.out.println(type.getExtendedClass());

		//		JvmType typ = _typeReferences.findDeclaredType(Object.class, it.eResource());
		//		JvmTypeReference typeRef = rbuilder.typeRef(typ);
		//		JvmTypeReference typeRef = rbuilder.typeRef(this.getClass());
		//type.getSuperTypes().add(typeRef);
		return super.generateBody(it, appendable, config);
	}



}
