
package demo17;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class TailQueueTest {
	private TailQueue queue = new TailQueue();
	private Calendar now = Calendar.getInstance();

	@Test
	public void startsEmpty() {
		assertNull(queue.get());
	}

	
	@Test(expected = TailAlreadyInQueueException.class)
	public void addThrowsOnExistingTail() {
		Tail tail = new Tail(1, Tail.URGENT, null);
		queue.add(tail);

		Tail secondTailWithSameId = new Tail(1, Tail.IMPORTANT, Calendar.getInstance());
		queue.add(secondTailWithSameId);
	}

	
}
