/*
 * generated by Xtext 2.16.0
 */
package lu.svv.lang.jvmmodel

import com.google.inject.Inject
import lu.svv.lang.sMRL.SMRL
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import lu.svv.lang.sMRL.Entity
import org.eclipse.xtext.naming.IQualifiedNameProvider
import lu.svv.lang.sMRL.Operation
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.common.types.util.TypeReferences

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class SMRLJvmModelInferrer extends AbstractModelInferrer {

	/**
	 * convenience API to build and initialize JVM types and their members.
	 */
	@Inject extension JvmTypesBuilder
	
	@Inject extension IQualifiedNameProvider
	
	@Inject TypeReferences typeReferences

	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the lambda you pass as the last argument.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
	def dispatch void infer(Entity element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		// Here you explain how your model is mapped to Java elements, by writing the actual translation code.
		
		
		
		// An implementation for the initial hello world example could look like this:
 		acceptor.accept(element.toClass(element.fullyQualifiedName)) [
 			      for (feature : element.features) {
 			      	members += feature.toConstructor []
        switch feature {
          
		  
          Operation : {
            members += feature.toMethod("mr", typeRef(void) ) [
              body = feature.body
            ]
          }
        }
        
        }
		]
		
		
	}
	
	
	def dispatch void infer(XFeatureCall element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		
		if ( element.concreteSyntaxFeatureName.equals("implies") ){
			
		} else {
			super.infer(element,acceptor,isPreIndexingPhase);
		}
		
	}


	
	
}