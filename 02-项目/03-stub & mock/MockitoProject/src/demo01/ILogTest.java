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
		  //模拟创建一个List对象  
		ILog mock = mock(ILog.class);  
	    //使用mock的对象  
	   //mock.publish("message");
	    
	  //stubbing
	  when(mock.publish("message")).thenReturn("message");
	 
	    //following prints "first"
	    System.out.println(mock.publish("message"));
	    System.out.println(mock.converte("message"));
	    //验证add(1)和clear()行为是否发生  
	    verify(mock).publish("message");
	    verify(mock).converte("message");  
	     
	}

}
