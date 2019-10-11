
package demo03;

import org.junit.Test;

public class ErrorTest {

	@Test
	public void error() {
		String stringToDecode = "a string";
		Integer.parseInt(stringToDecode);
	}

}
