
package demo02.advanced;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ExternalTest extends TestCase {
	private static String TEST_DATA[] = new String[] {
		"<test>\n" +
		"	<input>\n" +
		"		<param name='command'>add</param>\n" +
		"		<param name='operand1'>10</param>\n" +
		"		<param name='operand2'>20</param>\n" +
		"	</input>\n" +
		"	<output>\n" +
		"		<result>30</result>\n"+
		"	</output>\n" +
		"</test>\n",
		"<test>\n" +
		"	<input>\n" +
		"		<param name='command'>subtract</param>\n" +
		"		<param name='operand1'>30</param>\n" +
		"		<param name='operand2'>20</param>\n" +
		"	</input>\n" +
		"	<output>\n" +
		"		<result>10</result>\n"+
		"	</output>\n" +
		"</test>\n",

	};

	public ExternalTest(String name) {
		super(name);
	}

	protected void performTestIn(String xmlTestFile) {
		String data = readDataFrom(xmlTestFile);
		performTestWith(data);
	}
	
	private void performTestWith(String xmlData) {
		// perform some test here
		
		// fail if test fails
		fail("Test failed\n Test: \n"+xmlData);		
	}

	
	private String readDataFrom(String fileName) {
		if (fileName.equals("testAddition.xml"))
			return TEST_DATA[0];
		else 
			return TEST_DATA[1];
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		String[] fileNames = getAllFileNamesFrom("/data/myXmlTests");
		for (int i=0; i < fileNames.length; i++) {
			final String file = fileNames[i];
			suite.addTest(new ExternalTest(file) {
				protected void runTest() throws Throwable {
					performTestIn(file);
				}
			});
		}
		
		return suite;
	}

	private static String[] getAllFileNamesFrom(String directory) {
		return new String [] {
			"testAddition.xml", "testSubtraction.xml"	
		};
	}
}
