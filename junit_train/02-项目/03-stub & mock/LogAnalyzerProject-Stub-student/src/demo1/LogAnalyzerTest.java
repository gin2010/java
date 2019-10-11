package demo1;

import static org.junit.Assert.*;

import org.junit.Test;

import demo1.LogAnalyzer;

public class LogAnalyzerTest {

	@Test
	public void testIsValidLogFileName() {
		LogAnalyzer log = new LogAnalyzer();

		boolean result = log.isValidLogFileName("shortfile.slf");
		assertTrue(result);
	}

}
