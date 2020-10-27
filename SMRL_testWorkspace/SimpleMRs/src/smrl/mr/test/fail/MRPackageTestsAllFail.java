package smrl.mr.test.fail;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import smrl.mr.test.BasicOperationsProvider;
import smrl.mr.test.MRBasicPackageTest;



/**
 * This test class executes all the MR in the same package (i.e., lu.svv.mr.test.pass)
 * 
 * @author fabrizio.pastore
 *
 */
public class MRPackageTestsAllFail extends MRBasicPackageTest {

	
	private static smrl.mr.test.BasicOperationsProvider provider;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		provider = new BasicOperationsProvider();
	}

	@Before
	public void setUp() throws Exception {
		setProvider(provider);
	}
	
	
	@Test
	public void test() {
		super.test();
	}


}
