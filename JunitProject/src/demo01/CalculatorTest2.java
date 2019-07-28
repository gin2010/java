package demo01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest2 {

	@Test
	public void testAdd() {
        Calculator calculator = new Calculator();
        //Exercise
        double result = calculator.add( 50,150 );
        //Inspec     
         assertEquals("Failure Messages ", 200, result,0 );
	}

	@Test
	public void testSub() {
        Calculator calculator = new Calculator();
        //Exercise
        double result = calculator.sub( 133,111 );
        //Inspec     
         assertEquals("Failure Messages ", 22, result,0 );
	}

	@Test
	public void testMultiply() {
        Calculator calculator = new Calculator();
        //Exercise
        double result = calculator.multiply( 150,2 );
        //Inspec     
         assertEquals("Failure Messages ", 300, result,0 );
    }

	@Test
	public void testDiv() {
        Calculator calculator = new Calculator();
        //Exercise
        double result = calculator.div( 150,2 );
        //Inspec     
         assertEquals("Failure Messages ", 75, result,0 );
	}

}
