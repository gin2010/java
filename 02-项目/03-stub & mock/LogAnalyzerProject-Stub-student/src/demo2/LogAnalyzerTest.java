package demo2;

import static org.junit.Assert.*;
import org.junit.Test;

public class LogAnalyzerTest {

	@Test
	public void testIsValidLogFileName() {
		LogAnalyzer log = new LogAnalyzer();

		boolean result = log.isValidLogFileName("shortfile.slf");
		assertTrue(result);
	}

}
