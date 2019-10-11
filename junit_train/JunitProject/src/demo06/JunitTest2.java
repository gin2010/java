package demo06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.*;

/**
 * JUnit Expected Exception Test
 *
 */
public class JunitTest2 {
 
	@Test(expected = ArithmeticException.class)  
	public void divisionWithException() {  
	    int i = 1/0;
	}  
   
	@Test
	public void divisionWithExceptionMsg() {
		try {
	         assertEquals( 1, 1/0,0 );
			fail();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			assertEquals("/ by zero", e.getMessage());
		}
	}
	
	
}
