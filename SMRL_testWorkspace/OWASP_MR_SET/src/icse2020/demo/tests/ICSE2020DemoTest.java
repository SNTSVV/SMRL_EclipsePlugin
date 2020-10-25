package icse2020.demo.tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import smrl.mr.crawljax.WebOperationsProvider;
import smrl.mr.language.MRBaseTest;
import smrl.mr.owasp.OTG_AUTHZ_002;

public class ICSE2020DemoTest extends MRBaseTest {
	
	private static WebOperationsProvider provider;
	
	private static String system = "jenkins";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("*** Starting time: " + getCurrentTime() +" ***");
		
		//by default, the SUT is the Jenkins
		String configFile = "./testData/JenkinsICSE/jenkinsSysConfigDEMO.json";
		
		provider = new WebOperationsProvider(configFile);
	}

	@Before
	public void setUp() throws Exception {
		setProvider(provider);
	}
	
	@AfterClass
    public static void printEndingTime() {
		System.out.println("*** Ending time: " + getCurrentTime() + " ***");
    }   
	
	
	@Test
	/**
	  *This test case should detect CVE-2018-1999004". A malicious user can start an agent.
	  */
	public void test_OTG_AUTHZ_002() {
		super.test(provider,OTG_AUTHZ_002.class);
	}
	
	
	
	public static String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now).toString();  
	}

}
