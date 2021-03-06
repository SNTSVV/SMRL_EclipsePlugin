/**
 * generated by Xtext 2.16.0
 */
package lu.svv.lang.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import lu.svv.lang.sMRL.Entity;
import lu.svv.lang.sMRL.Feature;
import lu.svv.lang.sMRL.Operation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class SMRLJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  private TypeReferences typeReferences;
  
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
  protected void _infer(final Entity element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<Feature> _features = element.getFeatures();
      for (final Feature feature : _features) {
        {
          EList<JvmMember> _members = it.getMembers();
          final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
          };
          JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(feature, _function_1);
          this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
          boolean _matched = false;
          if (feature instanceof Operation) {
            _matched=true;
            EList<JvmMember> _members_1 = it.getMembers();
            final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
              this._jvmTypesBuilder.setBody(it_1, ((Operation)feature).getBody());
            };
            JvmOperation _method = this._jvmTypesBuilder.toMethod(feature, "mr", this._typeReferenceBuilder.typeRef(void.class), _function_2);
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method);
          }
        }
      }
    };
    acceptor.<JvmGenericType>accept(this._jvmTypesBuilder.toClass(element, this._iQualifiedNameProvider.getFullyQualifiedName(element)), _function);
  }
  
  protected void _infer(final XFeatureCall element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    boolean _equals = element.getConcreteSyntaxFeatureName().equals("implies");
    if (_equals) {
    } else {
      super.infer(element, acceptor, isPreIndexingPhase);
    }
  }
  
  public void infer(final EObject element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (element instanceof XFeatureCall) {
      _infer((XFeatureCall)element, acceptor, isPreIndexingPhase);
      return;
    } else if (element instanceof Entity) {
      _infer((Entity)element, acceptor, isPreIndexingPhase);
      return;
    } else if (element != null) {
      _infer(element, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, acceptor, isPreIndexingPhase).toString());
    }
  }
}
