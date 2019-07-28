package demo3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLogAnalyzer {

	@Test 
	public void isValidFileName_ValidName_RemembersTrue() {
		//setup the stub to use, make sure it returns true
        StubExtensionManager myFakeManager = new StubExtensionManager();
        myFakeManager.shouldExtensionBeValid = true;

        //create analyzer and inject stub
        LogAnalyzer log = new LogAnalyzer(myFakeManager);
        
        //Assert logic assuming extension is supprted
        boolean result = log.isValidLogFileName("shortfile.slf");
        String errorMessage="File name with less than 5 chars should have failed the method, even if the extension is supported";
        assertEquals(errorMessage,true,result);
      
	}

}
