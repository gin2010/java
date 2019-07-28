package demo16;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ListTest01 {
	@Test
	public void testList() {
		/*
		 *  Create an empty List
   			Verify get() and isEmpty()
   			add() an object to the list
   			Verify get() and isEmpty()
   			add() some more, verify again
   			add() until the list grows
   			Use get() to verify that each element is still in place
   			Verify that isEmpty() still returns false
		 */
		List list=new List();		
		assertTrue("list is empty", list.isEmpty());
		
		list.add("AAAA");
		assertFalse("list is empty", list.isEmpty());
		assertEquals("List get element is ","AAAA",list.get(0));
		 
		for(int i=0;i<20;i++){
			list.add("AAAA"+i);
			assertEquals("List get element is ","AAAA"+i,list.get(i+1));	
		}		
		assertEquals("List size is ",21,list.getSize());
		assertFalse("list is empty", list.isEmpty());		
	}
}
