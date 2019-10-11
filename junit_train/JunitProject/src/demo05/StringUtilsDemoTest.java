package demo05;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsDemoTest {
	/*
	@Test(expected = IllegalArgumentException.class)  
	public void FirstParamenterisNULL_ThrowException() {  
		StringUtilsDemo.contains(null, "abc");
	}  
   
	@Test
	public void FirstParamenterisNULL_ThrowException_MSGisOK() {
		try {
			StringUtilsDemo.contains(null, "abc");
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertEquals("第一个参数不能是NULL", e.getMessage());
		}
	}
	*/
	
	@Test(expected = IllegalArgumentException.class)
	public void FirstParamenterisNULL_ThrowException() {  
		StringUtilsDemo.contains();
	}  

   
	@Test
	public void FirstParamenterisNULL_ThrowException2() {
		try {
			StringUtilsDemo.contains();
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertEquals("first para is NULL", e.getMessage());
		}
	}
	@Test
	public void containsTest(){
		assertTrue(StringUtilsDemo.contains("ABCD", "ab"));
		assertTrue(StringUtilsDemo.contains("ABCD", "Ab"));
		assertTrue(StringUtilsDemo.contains("ABCD", "AB"));
		assertFalse(StringUtilsDemo.contains("ABCD", "DE"));
		assertFalse(StringUtilsDemo.contains("ABCD", "EF"));
	}

}
