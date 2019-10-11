package demo08;

import demo08.EngineerAware.Engineer;
import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;



public class SpyOnInterfaceExample {
	@Test
	public void spyOnInterface() {
		EngineerAware engineerAware = spy(new Dev());
		assertEquals(Engineer.DEV, engineerAware.getDesignation());
		when(engineerAware.getDesignation()).thenReturn(Engineer.QA);
		assertEquals(Engineer.QA, engineerAware.getDesignation());
	}	
	private class Dev implements EngineerAware {
		@Override
		public Engineer getDesignation() {
			return Engineer.DEV;
		}
		
	}
}
