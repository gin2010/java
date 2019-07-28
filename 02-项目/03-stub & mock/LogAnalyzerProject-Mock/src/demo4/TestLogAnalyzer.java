package demo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLogAnalyzer {

	@Test
	public void analyze_WebServiceThrows_SendsEmail() {
		StubWebService stubService = new StubWebService();
        stubService.toThrow= true;
        
        MockEmailService mockEmail = new MockEmailService();
        
        LogAnalyzer log = new LogAnalyzer(stubService,mockEmail);
     
        String tooShortFileName="abc.ext";
        log.analyze(tooShortFileName);

        assertEquals("a",mockEmail.to);
        assertEquals("fake exception",mockEmail.body);
        assertEquals("subject",mockEmail.subject);        
	}

}
