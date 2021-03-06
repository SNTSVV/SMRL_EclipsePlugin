/**
 * generated by Xtext 2.16.0
 */
package lu.svv.lang.tests;

import com.google.inject.Inject;
import lu.svv.lang.sMRL.SMRL;
import lu.svv.lang.tests.SMRLInjectorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(SMRLInjectorProvider.class)
@SuppressWarnings("all")
public class SMRLParsingTest {
  @Inject
  private ParseHelper<SMRL> parseHelper;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static lu.svv.mr.language.Operations.*");
      _builder.newLine();
      _builder.append("import lu.svv.mr.language.Action;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("package lu.svv.mr.owasp {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("MR OTG_AUTHZ_002 {");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("for ( Action action : Input(1).actions() ){");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("IMPLIES(");
      _builder.newLine();
      _builder.append("\t     ");
      _builder.append("cannotReachThroughGUI ( User(2), action.url ) &&");
      _builder.newLine();
      _builder.append("\t     ");
      _builder.append("equal( Input(2), changeCredentials(Input(1), User(2)) )");
      _builder.newLine();
      _builder.append("\t\t ");
      _builder.append(",");
      _builder.newLine();
      _builder.append("\t\t ");
      _builder.append("NOT( Output(Input(1)).equals(Output(Input(2)))));");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("}}");
      _builder.newLine();
      final SMRL result = this.parseHelper.parse(_builder);
      InputOutput.<SMRL>println(result);
      Assertions.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", ");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
