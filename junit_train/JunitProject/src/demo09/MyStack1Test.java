package demo09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import demo09.simple.MyStack1;

public class MyStack1Test {
	@Test
	public final void testMyStack1() {
		Stack stack=new MyStack1();
		assertTrue(stack.isEmpty());		
	}
    @Test(expected=StackEmptyException.class)
	public final void testMyStack_新对象POP应当抛出异常() throws StackEmptyException {
    	Stack stack=new MyStack1();
		stack.pop();		
	}
    
    @Test(expected=StackEmptyException.class)
	public final void testMyStack_新对象TOP应当抛出异常() throws StackEmptyException {
    	Stack stack=new MyStack1();
		stack.top();		
	}
	@Test
	public final void testPush_正常的加入数据和顺序_返回压入的数据() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.push("a");
		stack.push("bbbbbb");
		stack.push("CCC  cccCCC");
		assertFalse(stack.isEmpty());
		assertEquals("CCC  cccCCC",stack.pop());
		assertEquals("bbbbbb",stack.pop());
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
	@Test
	public final void testPush_加入NULL_返回NULL数据() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.push(null);
		stack.push(null);
		assertFalse(stack.isEmpty());
		assertEquals(null,stack.pop());
		assertEquals(null,stack.pop());
		assertTrue(stack.isEmpty());
	}
	@Test
	public final void testPush_加入空串_返回空() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.push("");
		stack.push("   ");
		stack.push("     ");
		assertFalse(stack.isEmpty());
		assertEquals("     ",stack.pop());
		assertEquals("   ",stack.pop());
		assertEquals("",stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected=StackEmptyException.class)
	public final void testPop_空时抛出异常() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.pop();
	}

	@Test(expected=StackEmptyException.class)
	public final void testPop_空时抛出异常后仍然可以使用() {
		Stack stack=new MyStack1();
		try {
			stack.pop();
			fail("空时应当抛出异常，但是没有抛出");
		} catch (StackEmptyException e) {			
			stack.push("a");
			assertFalse(stack.isEmpty());			
			e.printStackTrace();
		}
	}
	
	@Test(expected=StackEmptyException.class)
	public final void testPop_已经清楚空后抛出异常() throws StackEmptyException {
		MyStack1 stack=new MyStack1();
		stack.push("a");
		stack.push("a");
		stack.push("a");
		stack.pop();
		stack.pop();
		stack.pop();
		//应当抛出异常
		stack.pop();
	}
	
	@Test
	public final void testTop_获取压入的数据但是不删除() throws StackEmptyException {
		MyStack1 stack=new MyStack1();
		stack.push("a");
		stack.push("bbbbbb");
		stack.push("CCC  cccCCC");
		
		assertFalse(stack.isEmpty());
		
		assertEquals("CCC  cccCCC",stack.top());
		
		stack.pop();
		assertEquals("bbbbbb",stack.top());
		
		stack.pop();
		assertEquals("a",stack.top());
		
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
}
