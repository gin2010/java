package demo06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest1 {

	
	@Test
	public void testFail() {
		fail("Not yet implemented");
		System.out.println(" testFail  ");
		System.out.println(" testFail  ");
	}

	@Test
	public void stringEquality() {
		String expected = "Something";
		String actual   = "Something Else";
		assertEquals(expected, actual);
		assertEquals(10, 10);
		System.out.println(expected + actual);
		System.out.println(expected + actual);
	}

	@Test
	public void intEquality() {
		int expected = 10;
		int actual   = 10;
		assertEquals(expected, actual);
		System.out.println("intEquality  "+expected + actual);
		System.out.println("intEquality  "+expected + actual);
	}

	@Test
	public void error() {
		String stringToDecode = "a string";
		Integer.parseInt(stringToDecode);
	}
	
	@Test
	public void failedMessage() {
	 int[][] data = new int[][] {
		       new int[] { 2, 2, 0 },
		         new int[] { 4, 2, 2 },
		     new int[] { 8, 2, 4 },
		     new int[] { 0, 2, -2 }
		     };
		      for (int index = 0; index < data.length; index++) {
		      int[] dataSet = data[index];
		        assertEquals("Failed on dataset " + index, dataSet[0], dataSet[1]+dataSet[2]);
		     }
	}
	
}
