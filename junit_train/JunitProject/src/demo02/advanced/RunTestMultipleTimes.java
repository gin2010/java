
package demo02.advanced;

import junit.extensions.RepeatedTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// RepeatedTest is present in JUnit4 for backward compatibility, and uses JUnit 3-style definitions.
public class RunTestMultipleTimes extends TestCase {

	private static Test additionTest() {
		Test testCase = new TestCase("addition test") {
			protected void runTest() throws Exception { 
				assertEquals(4, 2 + 2);
			}
		};
		return testCase;
	}

	public static TestSuite suite() throws Exception {
		TestSuite suite = new TestSuite();
		Test singleTestRunThreeTimes =
			new RepeatedTest(additionTest(), 3); 
		suite.addTest(singleTestRunThreeTimes);
		return suite;
	}
}
