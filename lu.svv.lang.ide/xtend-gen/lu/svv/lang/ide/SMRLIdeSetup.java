/**
 * generated by Xtext 2.16.0
 */
package lu.svv.lang.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lu.svv.lang.SMRLRuntimeModule;
import lu.svv.lang.SMRLStandaloneSetup;
import lu.svv.lang.ide.SMRLIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class SMRLIdeSetup extends SMRLStandaloneSetup {
  @Override
  public Injector createInjector() {
    SMRLRuntimeModule _sMRLRuntimeModule = new SMRLRuntimeModule();
    SMRLIdeModule _sMRLIdeModule = new SMRLIdeModule();
    return Guice.createInjector(Modules2.mixin(_sMRLRuntimeModule, _sMRLIdeModule));
  }
}
