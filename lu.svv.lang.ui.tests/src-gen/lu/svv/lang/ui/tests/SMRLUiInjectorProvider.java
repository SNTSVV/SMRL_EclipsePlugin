/*
 * generated by Xtext 2.16.0
 */
package lu.svv.lang.ui.tests;

import com.google.inject.Injector;
import lu.svv.lang.ui.internal.LangActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class SMRLUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return LangActivator.getInstance().getInjector("lu.svv.lang.SMRL");
	}

}