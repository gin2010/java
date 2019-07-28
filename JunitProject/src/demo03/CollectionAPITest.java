package demo03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollectionAPITest {
	
	@Test
    public void testEmptyCollection() {
        List collection = new ArrayList();
        assertTrue(collection.isEmpty());
    }
	
	/*
      int size()���ش� collection �е�Ԫ������
      ����� collection ������Ԫ�ش��� Integer.MAX_VALUE���򷵻� Integer.MAX_VALUE�� 
      ���أ�   �� collection �е�Ԫ����
	 */
	@Test
    public void testCollectionSize() { 
		List collection = new ArrayList();
		collection.add('a');
		assertEquals(0,collection.size(),1);
    }	
	
	/*
	 * ����˳��add��˳��
	 */
	@Test
    public void testCollectionOrdering() {
    		List collection = new ArrayList();
    		collection.add(111);
    		collection.add(123);
    		collection.add(133);
    		assertSame(123,collection.get(1));
	}
	@Test
    public void testCollectionSame() {
		List collection = new ArrayList();
		collection.add(11);
		collection.add(12);
		collection.add(13);
		assertTrue(collection.contains(11));
    }	
	
	@Test
    public void testCollectionContains() {
    
    }
	@Test
    public void testCollectionNew() {
    
		
    }
}
