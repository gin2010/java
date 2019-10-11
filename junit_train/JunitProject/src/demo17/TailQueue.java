
package demo17;

import java.util.TreeSet;

public class TailQueue {

	private int state;
	
	static final int STATE_IMPORTANT_FIRST = 0;
	static final int STATE_REQUESTING = 1;
	static final int STATE_IMPORTANT_SECOND = 2;
	private TreeSet[] queues;

	public TailQueue() {
		state = STATE_IMPORTANT_FIRST;
		queues = new TreeSet[4];
		queues[Tail.URGENT] = new TreeSet();
		queues[Tail.IMPORTANT] = new TreeSet();
		queues[Tail.REQUESTING] = new TreeSet();
		queues[Tail.DISMISSED] = new TreeSet();
	}

	public Tail get() {
		if (queues[Tail.URGENT].isEmpty())
			return getNextInRotation();
		return dequeue(Tail.URGENT);
	}

	public Tail getNextInRotation() {
		switch(state) {
			case STATE_IMPORTANT_FIRST:
				return get(Tail.IMPORTANT, Tail.REQUESTING, STATE_REQUESTING);
			case STATE_REQUESTING:
				return get(Tail.REQUESTING, Tail.IMPORTANT, STATE_IMPORTANT_SECOND);
			case STATE_IMPORTANT_SECOND:
			default:
				return get(Tail.IMPORTANT, Tail.REQUESTING, STATE_IMPORTANT_FIRST);
		}
	}

	private Tail get(int firstChoice, int secondChoice, int nextState) {
		if (!queues[firstChoice].isEmpty()) {
			state = nextState;
			return dequeue(firstChoice);
		}
		if (!queues[secondChoice].isEmpty())
			return dequeue(secondChoice);
		
		if (!queues[Tail.DISMISSED].isEmpty())
			return dequeue(Tail.DISMISSED);
		
		return null;
	}

	private Tail dequeue(int queueNumber) {
		Tail result = (Tail)queues[queueNumber].first();
		queues[queueNumber].remove(result);
		return result;
	}

	public void add(Tail tail) {
		if (isQueued(tail))
			throw new TailAlreadyInQueueException(tail.id);
		queues[tail.priorityClass].add(tail);
	}

	public boolean isQueued(Tail tail) {
		for (int queueNumber = 0; queueNumber < queues.length; queueNumber++)
			if (queues[queueNumber].contains(tail))
				return true;

		return false;
	}
}
