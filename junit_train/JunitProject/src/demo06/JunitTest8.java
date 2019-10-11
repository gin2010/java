package demo06;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
/**
 * JUnit Parameterized Test
 *The ¡°Parameterized Test¡± means vary parameter value for unit test. 
 *In JUnit, both @RunWith and @Parameter annotation are use to provide
 * parameter value for unit test, @Parameters have to return List[], 
 * and the parameter will pass into class constructor as argument.
 */
@RunWith(value = Parameterized.class)
public class JunitTest8 {
 
	 private int number;
 
	 public JunitTest8(int number) {
	    this.number = number;
	 }
 
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { { 1 }, { 2 }, { 3 }, { 4 },{ 5 },{ 6 } };
	   return Arrays.asList(data);
	 }
 
	 @Test
	 public void pushTest() {
	   System.out.println("Parameterized Number is : " + number);
	 }
 
 
}
