
package demo02.advanced;

import junit.extensions.RepeatedTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import demo02.introduction.AllTests;

public class RunSuiteMultipleTimes extends TestCase {
	private static final int TIMES_TO_RUN = 2;
	
	public RunSuiteMultipleTimes(String name) {
		super(name);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new RepeatedTest(AllTests.suite(), TIMES_TO_RUN));
		return suite;
	}
}
