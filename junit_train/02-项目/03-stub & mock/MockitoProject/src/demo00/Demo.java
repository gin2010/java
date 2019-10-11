package demo00;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

public class Demo {
	@Test
	public void test1()  {
	        //  create mock
	        MyClass test = Mockito.mock(MyClass.class);

	        // define return value for method getUniqueId()
	        when(test.getUniqueId()).thenReturn(43);

	        // use mock in test....
	        assertEquals(test.getUniqueId(), 43);
	}


	// Demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue()  {
	        Iterator i= mock(Iterator.class);
	        
	        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
	        
	        String result=i.next()+" "+i.next();
	        //assert
	        assertEquals("Mockito rocks", result);
	}

	// this test demonstrates how to return values based on the input
	@Test
	public void testReturnValueDependentOnMethodParameter()  {
	        Comparable c= mock(Comparable.class);
	        when(c.compareTo("Mockito")).thenReturn(1);
	        when(c.compareTo("Eclipse")).thenReturn(2);
	        //assert
	        assertEquals(1,c.compareTo("Mockito"));
	}
	

	// this test demonstrates how to return values independent of the input value

	
	@Test
	public void testReturnValueInDependentOnMethodParameter()  {
	        Comparable c= mock(Comparable.class);
	        when(c.compareTo(anyInt())).thenReturn(-1);
	        //assert
	        assertEquals(-1 ,c.compareTo(9));
	}
	//验证执行顺序
	@Test  
	public void verification_in_order(){  
	    List list = mock(List.class);  
	    List list2 = mock(List.class);  
	    list.add(1);  
	    list2.add("hello");  
	    list.add(2);  
	    list2.add("world");  
	    
	    //将需要排序的mock对象放入InOrder  
	    InOrder inOrder = inOrder(list,list2);  
	    
	    //下面的代码不能颠倒顺序，验证执行顺序  
	    inOrder.verify(list).add(1);  
	    inOrder.verify(list2).add("hello");  
	    inOrder.verify(list).add(2);  
	    inOrder.verify(list2).add("world");  
	}  
	@Mock  
    private List mockList;  
	public Demo(){  
        MockitoAnnotations.initMocks(this);  
    }  
  
    @Test  
    public void shorthand(){  
        mockList.add(1);  
        verify(mockList).add(1);  
    }  
    
    /*
	@Test  
	public void answer_with_callback(){  
	    //使用Answer来生成我们我们期望的返回  
	    when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {  
	        @Override  
	        public Object answer(InvocationOnMock invocation) throws Throwable {  
	            Object[] args = invocation.getArguments();  
	            return "hello world:"+args[0];  
	        }  
	    });  
	    assertEquals("hello world:0",mockList.get(0));  
	    assertEquals("hello world:999",mockList.get(999));  
	}  
	*/
	/*
	// return a value based on the type of the provide parameter

	@Test
	public void testReturnValueInDependentOnMethodParameter()  {
	        Comparable c= mock(Comparable.class);
	        when(c.compareTo(isA(Todo.class))).thenReturn(0);
	        //assert
	        Todo todo = new Todo(5);
	        assertEquals(todo ,c.compareTo(new Todo(1)));
	}
	 */
}
