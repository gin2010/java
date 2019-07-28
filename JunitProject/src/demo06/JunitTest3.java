package demo06;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * JUnit Ignore Test
 * 
 *
 */
public class JunitTest3 {
 
	@Ignore("Test is ignored as a demonstration")  
	@Test
	public void divisionWithException() {  
	  System.out.println("Method is not ready yet");
	}  
 
	  
	@Test
	public void runTestMethod() {  
	  System.out.println("run the Method ");
	}  
	
	
	@Test
	public void runTestMethod2() {  
	  fail("runTestMethod2 ");
	}
	
	@Test
	public void runTestMethod3() {
		String expected = "Something";
		String actual   = "Something Else";
		assertEquals(expected, actual);
	}
}