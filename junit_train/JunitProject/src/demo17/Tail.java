
package demo17;

import java.util.Calendar;

public class Tail implements Comparable {
	public static final int URGENT = 0;
	public static final int IMPORTANT = 1;
	public static final int REQUESTING = 2;
	public static final int DISMISSED = 3;
	
	int id;
	int priorityClass;
	Calendar lastContactTime;

	public Tail(int id, int priorityClass, Calendar lastContactTime) {
		this.id = id;
		this.priorityClass = priorityClass;
		this.lastContactTime = lastContactTime;
	}

	public int compareTo(Object arg0) {
		Tail other = (Tail) arg0;
		if (id == other.id) return 0;
		if (priorityClass < other.priorityClass) return -1;
		if (priorityClass > other.priorityClass) return 1;
		if (lastContactTime.before(other.lastContactTime)) return -1;
		if (lastContactTime.after(other.lastContactTime)) return 1;
		if (id < other.id) return -1;
		return 1;
	}
}
