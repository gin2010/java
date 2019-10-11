
package demo17;

public class TailAlreadyInQueueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TailAlreadyInQueueException(int id) {
		super("Tail with id " + id + " is already in the queue.");
	}
}
