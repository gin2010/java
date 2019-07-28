
package demo02.introduction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSetupAndTearDown {
	private List<String> list;

	@Before
	public void createList() {
		list = new ArrayList<String>();
	}

	@After
	public void clearList() {
		list.clear();
	}

	@Test
	public void emptyCollection() {
		assertTrue(list.isEmpty());
	}

	@Test
	public void twoItemCollection() {
		list.add("cat");
		list.add("mouse");
		assertEquals(2, list.size());
	}
}
