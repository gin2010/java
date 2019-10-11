package demo08;

import demo08.EngineerAware.Engineer;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;

public class StubOnFinalMethod {
	private Employee emp;
	private static final String FIRST_NAME = "Joe";
	private static final String LAST_NAME = "M";
	private static final int AGE = 35;
	QA qa = new QA();
	
	@Before
	public void buildSpy() {
		emp = spy(new Employee(FIRST_NAME, LAST_NAME, AGE));
	}
	
	@Test(expected=RuntimeException.class)
	public void stubNonFinalMoveTo() {
		doThrow(new RuntimeException("Can't move to a different department")).when(emp).moveTo(qa);
		emp.moveTo(qa);
	}
	
	@Test(expected=RuntimeException.class)
	public void stubFinalMoveTo() {
		doThrow(new RuntimeException("Can't move to a different department")).when(emp).finalMoveTo(qa);
		emp.finalMoveTo(qa);
	}
	
	private class QA implements EngineerAware {
		@Override
		public Engineer getDesignation() {
			return Engineer.QA;
		}		
	}
}
