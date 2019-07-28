package demo06;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
/**
 * JUnit Suite Test
 *The ¡°Suite Test¡± means bundle a few unit test cases and run it together.
 * In Junit, * both @RunWith and @Suite annotation 
 * are used to run the suite test.
 */
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
        JunitTest10.class,
        JunitTest2.class, 
        JunitTest3.class,
        JunitTest4.class
})
public class JunitTest5 {
}
