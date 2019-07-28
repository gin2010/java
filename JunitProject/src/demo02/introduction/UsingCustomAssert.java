
package demo02.introduction;

import org.junit.Test;

import demo02.extensions.ExtendedTestCase;

public class UsingCustomAssert extends ExtendedTestCase {

	@Test
	public void strings() {
		String expected =
			"Yankee doodle went to town, riding on a pony.\n" +
			"He stuck a feather in his cap and called it macaroni.";
		String actual =
			"Yankee doodle went to town, riding on a pony\n" +
			"He stuck a feather in his cap and called it macaroni.";

		assertStringEquals("string matching", expected, actual);
	}

}  
