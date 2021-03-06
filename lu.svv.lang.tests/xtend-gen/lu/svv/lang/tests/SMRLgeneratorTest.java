/**
 * generated by Xtext 2.16.0
 */
package lu.svv.lang.tests;

import com.google.inject.Inject;
import com.google.inject.Injector;

import lu.svv.lang.SMRLJvmModelGenerator;
import lu.svv.lang.SMRLStandaloneSetup;
import lu.svv.lang.generator.SMRLGenerator;
import lu.svv.lang.sMRL.SMRL;
import lu.svv.lang.tests.SMRLInjectorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(SMRLInjectorProvider.class)
@SuppressWarnings("all")
public class SMRLgeneratorTest {
  @Inject
  private ParseHelper<SMRL> parseHelper;
  
  @Inject
  private SMRLJvmModelGenerator jvmgenerator;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static lu.svv.mr.language.Operations.*\n" + 
      		"			import lu.svv.mr.language.Action;\n" + 
      		"			\n" + 
      		"			package lu.svv.mr.owasp {\n" + 
      		"			  MR OTG_AUTHZ_002 {\n" + 
      		"			   {\n" + 
      		"			     for ( Action action : Input(1).actions() ){\n" + 
      		"				   IMPLIES(\n" + 
      		"				     cannotReachThroughGUI ( User(2), action.url ) &&\n" + 
      		"				     equal( Input(2), changeCredentials(Input(1), User(2)) )\n" + 
      		"					 ,\n" + 
      		"					 NOT( Output(Input(1)).equals(Output(Input(2)))));\n" + 
      		"			     }\n" + 
      		"			   } \n" + 
      		"			}}");
      _builder.newLine();
      final SMRL result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", ");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
      
      SMRLGenerator generator = new SMRLGenerator();
      InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      generator.doGenerate( result.eResource(), fsa, null );
      
      System.out.println(result.getElements());
      

//      jvmgenerator.doGenerate(result.eResource(), fsa);
      
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void main(String[] args) {
      Injector injector = new SMRLStandaloneSetup().createInjectorAndDoEMFRegistration();
      //SMRLgeneratorTest application = injector.getInstance(SMRLgeneratorTest.class);
      
      SMRLJvmModelGenerator generator = injector.getInstance(SMRLJvmModelGenerator.class);
      
//      StringConcatenation _builder = new StringConcatenation();
//      _builder.append("import static lu.svv.mr.language.Operations.*\n" + 
//      		"			import lu.svv.mr.language.Action;\n" + 
//      		"			\n" + 
//      		"			package lu.svv.mr.owasp {\n" + 
//      		"			  MR OTG_AUTHZ_002 {\n" + 
//      		"			   {\n" + 
//      		"			     for ( Action action : Input(1).actions() ){\n" + 
//      		"				   IMPLIES(\n" + 
//      		"				     cannotReachThroughGUI ( User(2), action.url ) &&\n" + 
//      		"				     equal( Input(2), changeCredentials(Input(1), User(2)) )\n" + 
//      		"					 ,\n" + 
//      		"					 NOT( Output(Input(1)).equals(Output(Input(2)))));\n" + 
//      		"			     }\n" + 
//      		"			   } \n" + 
//      		"			}}");
//      _builder.newLine();
//      
//      injector.get
//      
//      final SMRL result = parseHelper.parse(_builder);
//      Assertions.assertNotNull(result);
//      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
//      boolean _isEmpty = errors.isEmpty();
//      StringConcatenation _builder_1 = new StringConcatenation();
//      _builder_1.append("Unexpected errors: ");
//      String _join = IterableExtensions.join(errors, ", ");
//      _builder_1.append(_join);
//      Assertions.assertTrue(_isEmpty, _builder_1.toString());
//      
////      SMRLGenerator generator = new SMRLGenerator();
//      InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
//      generator.doGenerate( result.eResource(), fsa );
      
  }
}
