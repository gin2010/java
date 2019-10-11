package demo16;

public class List {
	   public Object[] contents;
	   private int capacity;
	   private int size;
	   static final int INITIAL_CAPACITY = 10;
	   private static final int GROW_INCREMENT = 5;   
	       
	   public List() { 
	      size = 0;
	      capacity = INITIAL_CAPACITY;
	      contents = new Object[capacity];
	   }
	   
	   public void add(Object o) {
	      contents[size] = o;
	      size++;
	      if (size == capacity) {
	         capacity += GROW_INCREMENT;
	         Object[] newContents = new Object[capacity];
	         for (int i = 0; i < size; i++)
	            newContents[i] = contents[i];
	         contents = newContents;
	      }
	   }
	    
	   public Object get(int index) {
	      if (index < 0 || index >= size)
	         throw new ArrayIndexOutOfBoundsException(index);
	      return contents[index];
	   } 

	   public boolean isEmpty() {
	      return size == 0;
	   }

	   public int getSize() {
			return size;
		}
}