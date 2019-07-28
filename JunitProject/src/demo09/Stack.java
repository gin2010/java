package demo09;

public interface Stack {
	 /** 
	    * Return and remove the most recent item from 
	    * the top of the  stack.  
	    * Throws StackEmptyException
	    * if the stack is empty
	    */
	  public String pop() throws StackEmptyException; 
	  
	  /**
	   * Add an item to the top of the stack.
	   */
	  public void push(String item);
	  
	  /** 
	    * Return but do not remove the most recent 
	    * item from the top of the stack.  
	    * Throws StackEmptyException 
	    * if the stack is empty
	    */
	  public String top() throws StackEmptyException;
	  
	  /**
	    * Returns true if the stack is empty.
	    */
	  public boolean isEmpty();

}
