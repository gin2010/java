package demo01;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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

public class DemoTestCase01 {

	@Test  
	public void verify_behaviour(){  
	    //ģ�ⴴ��һ��List����  
	    List mock = mock(List.class);  
	    //ʹ��mock�Ķ���  
	    mock.add(1);  
	    mock.clear();  
	    //��֤add(1)��clear()��Ϊ�Ƿ���  
	    verify(mock).add(1);  
	    verify(mock).clear();  
	}  
	
	 @Test  
	    public void simpleTest(){  
	          
	        //����mock���󣬲����������࣬Ҳ�����ǽӿ�  
	        List<String> list = mock(List.class);  
	          
	        //���÷�����Ԥ�ڷ���ֵ  
	        when(list.get(0)).thenReturn("helloworld");  
	      
	        String result = list.get(0);  
	          
	        //��֤��������(�Ƿ������get(0))  
	        verify(list).get(0);  
	          
	        //junit����  
	        assertEquals("helloworld", result);  
	    }  
	 
	 @Test  
	    public void simpleStubTest(){  
		//You can mock concrete classes, not only interfaces
		 LinkedList mockedList = mock(LinkedList.class);

		 //stubbing
		 when(mockedList.get(0)).thenReturn("first");
		 when(mockedList.get(1)).thenThrow(new RuntimeException());

		 //following prints "first"
		 System.out.println(mockedList.get(0));

		 //following throws runtime exception
		// System.out.println(mockedList.get(1));

		 //following prints "null" because get(999) was not stubbed
		 //System.out.println(mockedList.get(999));

		 //Although it is possible to verify a stubbed invocation, usually it's just redundant
		 //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
		 //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
		 verify(mockedList).get(0);
		 
		//stubbing using built-in anyInt() argument matcher
		 when(mockedList.get(anyInt())).thenReturn("element");

		 //stubbing using hamcrest (let's say isValid() returns your own hamcrest matcher):
		// when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		 //following prints "element"
		 System.out.println(mockedList.get(999));

		 //you can also verify using an argument matcher
		 verify(mockedList).get(anyInt());
		 
	 }
}
