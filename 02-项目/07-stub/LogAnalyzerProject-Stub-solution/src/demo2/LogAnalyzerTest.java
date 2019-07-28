package demo2;
 
import static org.junit.Assert.*;

import org.junit.Test;

public class LogAnalyzerTest {

	class TestableLogAnalyzer extends LogAnalyzer {
		private boolean isSupported;

		public TestableLogAnalyzer(boolean supported) {
			isSupported = supported;
		}

		@Override
		protected boolean isSupportedExtension(String fileName) {
			return isSupported;
		}
	}

	@Test
	public void testIsValidLogFileName() {
		TestableLogAnalyzer log = new TestableLogAnalyzer(true);

		boolean result = log.isValidLogFileName("shortfile.slf");
		assertTrue(result);
	}

	@Test
	public void testIsInvalidLogFileName() {
		TestableLogAnalyzer log = new TestableLogAnalyzer(false);

		boolean result = log.isValidLogFileName("shortfile.slf");
		assertFalse(result);
	}

}
