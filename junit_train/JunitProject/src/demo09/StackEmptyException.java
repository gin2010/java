package demo09;

public class StackEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackEmptyException(String aString) {
	    super(aString);
	  }
	
	public StackEmptyException() {
	    super("Stack 为空，没有任何元素！！！");
	  }
}
