package smrl.mr.test;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import smrl.mr.crawljax.WebOperationsProvider;




/**
 * This test class executes all the MR in the same package (i.e., lu.svv.mr.test.pass)
 * 
 * @author fabrizio.pastore
 *
 */
public class MRTest extends MRBasicTest {
	private static WebOperationsProvider provider;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String inputFile = "./testData/input.txt";
		String accFile = "./testData/accountData.txt";
		String outputLogFile = "./testData/log.txt";
		provider = new WebOperationsProvider( inputFile, accFile, outputLogFile );
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
