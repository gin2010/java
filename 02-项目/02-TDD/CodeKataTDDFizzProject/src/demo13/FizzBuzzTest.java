package demo13;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {
	private final String Buzz = "buzz";
	private final String Fizz = "fizz";
	private final String FizzBuzz = "fizzbuzz";

	private static FizzBuzz _fizzBuzz;

	@BeforeClass 
	public static void Setup() {
		_fizzBuzz = new FizzBuzz();
	}
		
	@Test
	public void Returns_fizz_for_multiples_of_3() {
		assertEquals(Fizz, _fizzBuzz.StringFor(3));
		assertEquals(Fizz, _fizzBuzz.StringFor(6));
	}
	/*
	@Test
	public void Returns_buzz_for_multiple_of_5() {
		assertEquals(Buzz, _fizzBuzz.StringFor(5));
		assertEquals(Buzz, _fizzBuzz.StringFor(10));
	}
	
	@Test
	public void Returns_fizzbuzz_for_multiples_of_3_and_5() {
		assertEquals(FizzBuzz, _fizzBuzz.StringFor(15));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void Throws_exception_for_value_less_than_one() {
		_fizzBuzz.StringFor(0);
	}
	
	@Test
	public void Throws_exception_for_value_more_than_rule() {
		try {
			_fizzBuzz.StringFor(101);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Number must be less than 101", e.getMessage());
		}
	}	
	*/
}
