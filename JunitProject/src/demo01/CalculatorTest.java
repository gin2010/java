package demo01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {		
		//setup
        Calculator calculator = new Calculator();
        //Exercise
        double result = calculator.add( 50,150 );
        //Inspec     
         assertEquals("Failure Messages ", 200, result,0 );
        //Tear down
        // do nothing                       
	}
	
	
	
}
