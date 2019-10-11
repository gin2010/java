package demo03;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.matchers.JUnitMatchers.hasItem;

/**
 * A sample hamcrest test.
 * 
 * @version $Id: HamcrestTest.java 553 2010-03-06 12:29:58Z paranoid12 $
 */
public class HamcrestTest {

	private List<String> values;

	@Before
	public void setUpList() {
		values = new ArrayList<String>();
		values.add("one");
		values.add("two");
		values.add("three");
	}

	@Test
	public void testWithoutHamcrest() {
		assertTrue(values.contains("one") || values.contains("two")
				|| values.contains("three"));
	}

	@Test
	public void testWithHamcrest() {
		assertThat(values, hasItem(anyOf(equalTo("one"), equalTo("two"),
			equalTo("three"))));
	}
}
