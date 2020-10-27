package smrl.mr.test;



import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import smrl.mr.language.MRBaseTest;
import smrl.mr.test.fail.AND_fail;
import smrl.mr.test.fail.AND_fail2;
import smrl.mr.test.fail.FALSE_fail;
import smrl.mr.test.fail.IMPLIES_fail;
import smrl.mr.test.fail.NOT_fail;
import smrl.mr.test.fail.OR_fail;
import smrl.mr.test.fail.ResetWithinLoop_MultipleInputs_TRUE_fail;
import smrl.mr.test.fail.TRUE_fail;
import smrl.mr.test.pass.AND;
import smrl.mr.test.pass.FALSE;
import smrl.mr.test.pass.HTTPMethod;
import smrl.mr.test.pass.IMPLIES;
import smrl.mr.test.pass.IMPLIES_pass2;
import smrl.mr.test.pass.NOT;
import smrl.mr.test.pass.OR;
import smrl.mr.test.pass.OR_pass2;
import smrl.mr.test.pass.RandomDouble;
import smrl.mr.test.pass.RandomInteger;
import smrl.mr.test.pass.RandomString;
import smrl.mr.test.pass.ResetWithinLoop_MultipleInputs_TRUE_pass;
import smrl.mr.test.pass.ResetWithinLoop_TRUE_pass;
import smrl.mr.test.pass.ResetWithinLoop_TwoExpressions_TRUE_pass;
import smrl.mr.test.pass.TRUE;


public class MRTests extends MRBaseTest {

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
	public void test1() {
		super.test(provider,FALSE.class);
	}
	
	@Test
	public void test2() {
		super.test(provider,TRUE.class);
	}
	
	@Test
	public void test3() {
		super.test(provider,NOT.class);
	}
	
	@Test
	public void test4() {
		super.test(provider,IMPLIES.class);
	}
	
	@Test
	public void test5() {
		super.test(provider,AND.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test6() {
		super.test(provider,AND_fail.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test7() {
		super.test(provider,AND_fail2.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test8() {
		super.test(provider,FALSE_fail.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test9() {
		super.test(provider,IMPLIES_fail.class);
	}
	
	
	public void test10() {
		super.test(provider,IMPLIES_pass2.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test11() {
		super.test(provider,NOT_fail.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test12() {
		super.test(provider,TRUE_fail.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test13() {
		super.test(provider,OR_fail.class);
	}
	
	@Test
	public void test14() {
		super.test(provider,OR_pass2.class);
	}
	
	@Test
	public void test15() {
		super.test(provider,OR.class);
	}
	
	@Test
	public void test16() {
		super.test(provider,ResetWithinLoop_TRUE_pass.class);
	}
	
	@Test
	public void test17() {
		super.test(provider,ResetWithinLoop_TwoExpressions_TRUE_pass.class);
	}
	
	@Test
	public void test18() {
		super.test(provider,ResetWithinLoop_MultipleInputs_TRUE_pass.class);
	}
	
	@Test(expected=AssertionError.class)
	public void test19() {
		super.test(provider,ResetWithinLoop_MultipleInputs_TRUE_fail.class);
	}

	@Test
	public void testRandomString() {
		super.test(provider,RandomString.class);
	}
	
	@Test
	public void testRandomDouble() {
		super.test(provider,RandomDouble.class);
	}
	
	@Test
	public void testRandomInteger() {
		super.test(provider,RandomInteger.class);
	}
	
	@Test
	public void testRandomHttpMethod() {
		super.test(provider,HTTPMethod.class);
	}
	
}
