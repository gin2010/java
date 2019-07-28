
package demo02.introduction;

import org.junit.Test;

public class ErrorTest {

	@Test
	public void error() {
		String stringToDecode = "a string";
		Integer.parseInt(stringToDecode);
	}

}
