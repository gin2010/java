package demo06;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JunitTest11 {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
	    List<Object> list = new ArrayList<Object>();

	    thrown.expect(IndexOutOfBoundsException.class);
	    thrown.expectMessage("Index: 0, Size: 0");
	    list.get(0); // execution will never get past this line
	}
}