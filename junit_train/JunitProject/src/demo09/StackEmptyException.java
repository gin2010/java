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
	    super("Stack Ϊ�գ�û���κ�Ԫ�أ�����");
	  }
}
