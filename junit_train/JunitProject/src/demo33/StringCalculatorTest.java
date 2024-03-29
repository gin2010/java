package demo33;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public final void testAdd_如果串是NUll_return_zero() {				
		assertEquals(0,StringCalculator.add(null));
	}
	 
	@Test
	public final void testAdd_如果串是空串_return_zero() {
		assertEquals(0,StringCalculator.add(""));
		assertEquals(0,StringCalculator.add("    "));		
	}
	 
	@Test
	public final void testAdd_单一数字_return_number() {
		assertEquals(1,StringCalculator.add("1"));
		assertEquals(2,StringCalculator.add("2"));
		assertEquals(13,StringCalculator.add("13"));		
	}
	 
	@Test
	public final void testAdd_多个数字_return_number() {
		assertEquals(6,StringCalculator.add("1,2,3"));
		assertEquals(60,StringCalculator.add("10,20,30"));			
	}
	@Test
	public final void testAdd_多个数字含有大于1000_return_number() {
		assertEquals(1005,StringCalculator.add("1000,2,3"));
		assertEquals(5,StringCalculator.add("1001,2,3"));			
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testAdd_多个数字含有负数_抛出异常() {
		StringCalculator.add("-1,2,3");				
	}
	

	 
	@Test
	public final void testAdd_多个数字含有负数_抛出异常_检查异常消息() {
		try{
			StringCalculator.add("-1,2,3");
			fail("竟然没有抛出异常");
		}catch(IllegalArgumentException ex){
			String msg="参数不能为负数!  负数是-1";
			assertEquals(msg,ex.getMessage());
		}						
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testAdd_含有非法数字_抛出异常() {
		StringCalculator.add("a");				
	}
	@Test 
	public final void testAdd_含有非法数字_抛出异常_检查异常消息() {
		try{
			StringCalculator.add("1,2,3,abc");
			fail("竟然没有抛出异常");
		}catch(IllegalArgumentException ex){
			String msg="参数不能含有非法数字!  非法数字是"+"abc";
			assertEquals(msg,ex.getMessage());
		}						
	}
}