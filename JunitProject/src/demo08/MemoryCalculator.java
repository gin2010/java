package demo08;

public class MemoryCalculator {
	 private int sum=0;

     public void add(int number)
     {
         sum+=number;
     }
         
     public int sum()
     {
         int temp = sum;
         sum = 0;
         return temp;
     }  
    
     public void subtraction(int number){
    	 sum-=number;
 	}	
     
     
 	public void multiply2(){
 		sum=sum*2;
 	}
     
}
