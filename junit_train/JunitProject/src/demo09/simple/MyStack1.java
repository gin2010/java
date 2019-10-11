package demo09.simple;

import java.util.ArrayList;
import java.util.List;

import demo09.Stack;
import demo09.StackEmptyException;

public class MyStack1 implements Stack {
	private  List<String>  stack;

	public MyStack1() {
		stack = new ArrayList<String>();
	}

	@Override
	public String pop() throws StackEmptyException {
		if(stack.size()==0)
			throw new StackEmptyException();
		int index=stack.size();
		String value=stack.get(index-1);
		stack.remove(index-1);		
		return value ;
	}

	@Override
	public void push(String item) {
		stack.add(item);		
	}

	@Override
	public String top() throws StackEmptyException {
		if(stack.size()==0)
			throw new StackEmptyException();
		int index=stack.size();
		String value=stack.get(index-1);				
		return value ;
	}

	@Override
	public boolean isEmpty() {
		if (stack.size()==0)
			return true;
		else
			return false;
	}

}
