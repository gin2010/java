
package demo02.introduction;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FailingTests.class,
	PassingTests.class,
	ErrorTest.class,
	UsingCustomAssert.class,
	TestSetupAndTearDown.class
})
public class AllTests {

	// The above annotations suffice for declaring the suite.
	
	// We define the JUnit 3-style suite() method here for the sake of our RunSuiteMultipleTimes example,
	// which uses the JUnit 3 extension RepeatedTest.
	public static Test suite() {
		return new JUnit4TestAdapter(AllTests.class);
	}
}
