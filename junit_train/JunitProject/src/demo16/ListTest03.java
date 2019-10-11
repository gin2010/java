package demo16;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTest03 {
	private List list; 
	@Before
	public void setUp() throws Exception {
		list=new List();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_listEmpty() {
		assertTrue("list is empty", list.isEmpty());
	}


	
	@Test
	public void test_listAdd() {
		list.add("AAAA");
		assertEquals("List get element is ","AAAA",list.get(0));
	}
	
	@Test
	public void test_listAddNotEmpty() {
		list.add("abcd");
		assertFalse("list is empty", list.isEmpty());
	}

	@Test
	public void test_listGet() {
		
		for(int i=0;i<20;i++){
			list.add("AAAA"+i);
			assertEquals("List get element is ","AAAA"+i,list.get(i));	
	   }
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void test_listOutOfBoundError() {
		for(int i=0;i<20;i++){
			list.add("AAAA"+i);
			assertEquals("List get element is ","AAAA"+i,list.get(i+1));	
		}
	}
}
