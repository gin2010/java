package demo4;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestLogAnalyzer {

	@Test
	public void isValidFileName_ValidName_RemembersTrue() {
		 
		//setup the stub to use, make sure it returns true
		//IExtensionManager myFakeManager = new StubExtensionManager();        
		IExtensionManager mock = mock(IExtensionManager.class);  
      		      
        //create analyzer and inject stub
        LogAnalyzer log = new LogAnalyzer(mock);
        
        //stubbing
  	  when(mock.IsSupportedExtension("shortfile.slf")).thenReturn(true);
  	 
        //Assert logic assuming extension is supprted
        boolean result = log.isValidLogFileName("shortfile.slf");
        String errorMessage="File name with less than 5 chars should have failed the method, even if the extension is supported";
        assertEquals(errorMessage,true,result);
      
	}

}
