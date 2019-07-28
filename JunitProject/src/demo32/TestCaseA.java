package demo32;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A dummy test-case to demonstrate how to use a test-suite.
 * 
 * @version $Id: TestCaseA.java 552 2010-03-06 11:48:47Z paranoid12 $
 */
public class TestCaseA {
	@Test
	public void testA1() {
		assertEquals("Dummy test-case", 1+1, 2);
	}  
}