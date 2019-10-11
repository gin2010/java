package demo3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLogAnalyzer {

	@Test
	public void analyze_TooShortFileName_CallsWebService() {
		MockWebService mockService = new MockWebService();
        LogAnalyzer log = new LogAnalyzer(mockService);
        
        String tooShortFileName="abc.ext";
        log.analyze(tooShortFileName);

        assertEquals("Filename too short:abc.ext",mockService.lastError);           
	}
}
