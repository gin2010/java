package demo32;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A demonstration of a test-suite.
 * 
 * @version $Id: TestSuiteB.java 552 2010-03-06 11:48:47Z paranoid12 $
 */
@RunWith(value = Suite.class)
@SuiteClasses(value = { TestCaseB.class })
public class TestSuiteB {}
