package demo01;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class ILogTest {

	@Test
	public void testPublish() {
		  //ģ�ⴴ��һ��List����  
		ILog mock = mock(ILog.class);  
	    //ʹ��mock�Ķ���  
	   //mock.publish("message");
	    
	  //stubbing
	  when(mock.publish("message")).thenReturn("message");
	 
	    //following prints "first"
	    System.out.println(mock.publish("message"));
	    System.out.println(mock.converte("message"));
	    //��֤add(1)��clear()��Ϊ�Ƿ���  
	    verify(mock).publish("message");
	    verify(mock).converte("message");  
	     
	}

}
