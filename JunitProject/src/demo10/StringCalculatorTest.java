package demo10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import demo10.StringCalculator;

public class StringCalculatorTest {
	
	private StringCalculator stringCalculator;

	@Before
	public void setup(){
		stringCalculator = new StringCalculator();
	}
	
	@Test
	public final void testAdd_isNull_return_zero() {				
		assertEquals(0,stringCalculator.add(null));
	}
	
	@Test
	public final void testAdd_isblank_return_zero() {				
		assertEquals(0,stringCalculator.add("  "));
	}
	
	@Test
	public final void testAdd_isTrue_return_right() {				
		assertEquals(69,stringCalculator.add("12,23,34"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testAdd_isNotNumber_return_false() {				
		assertEquals(0,stringCalculator.add("12,aa,34"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testAdd_isFushu_return_false() {				
		assertEquals(0,stringCalculator.add("12,-12,34"));
	}
	
	@Test
	public final void testAdd_isBigNumber_return_zero() {				
		assertEquals(46,stringCalculator.add("12,2300,34"));
	}
}