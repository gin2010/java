package demo07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
public class LogAnalyzerTestCase {
	  @Test
	    public void testisValidLogFileName() {
			LogAnalyzer logAnalyzer = new LogAnalyzer();
			
			assertTrue(logAnalyzer.isValidLogFileName(""));
	        System.out.println("@Test - testEmpty");
	        assertTrue(logAnalyzer.isValidLogFileName());
	        assertTrue(logAnalyzer.isValidLogFileName("test.log"));
	        
	        assertTrue(logAnalyzer.isValidLogFileName("test.Log"));
	        
	        
	    }

}
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogAnalyzerTest {
    LogAnalyzer logAnalyzer=null;
	
	@Before
	public void setup(){
		logAnalyzer=new LogAnalyzer();
	}
	@After 
	public void tearDown(){
		logAnalyzer=null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Throws_exception_for_null() {
		assertTrue(logAnalyzer.isValidLogFileName(null));
	}
	 

	@Test 
	public void isValidFilename_validFileLowerCased_returnTrue(){
		assertTrue(logAnalyzer.isValidLogFileName("systemfilename.log"));
	}	
	
	@Test 
	public void isValidFilename_shortFilename7_returnFalse(){
		assertFalse(logAnalyzer.isValidLogFileName("111.log"));
	}	
	
	@Test 
	public void isValidFilename_shortFilename10_returnFalse(){
		assertTrue(logAnalyzer.isValidLogFileName("abcdef.log"));
	}	
	
	@Test 
	public void isValidFilename_longFilename24_returnTrue(){
		assertTrue(logAnalyzer.isValidLogFileName("long1long2long3long4.log"));
	}	
	
	@Test 
	public void isValidFilename_invalidFilename25_returnFalse(){
		assertFalse(logAnalyzer.isValidLogFileName("long1long2long3long4l.log"));
	}
	
	@Test 
	public void isValidFilename_FilenameNotEndwithLog6_returnFalse(){
		assertFalse(logAnalyzer.isValidLogFileName("111.lo"));
	}
	
	@Test (expected =IllegalArgumentException.class)
	public void isValidFilename_FilenameIsBlank_returnFalse(){
		assertFalse(logAnalyzer.isValidLogFileName(" "));
	}
	
	@Test 
	public void isValidFilename_upperFilename_returnTrue(){
		assertTrue(logAnalyzer.isValidLogFileName("abcdefg.LOG"));
	}
	
	@Test 
	public void isValidFilename_upperAndLowerFilename_returnTrue(){
		assertTrue(logAnalyzer.isValidLogFileName("abcdefg.LOG"));
	}
}
