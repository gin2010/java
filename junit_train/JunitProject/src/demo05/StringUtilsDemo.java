package demo05;

public class StringUtilsDemo {
	//throw new IllegalArgumentException("数据必须是，你输入无效数据"+"");
	
	/*
	       if(str1==null)
    		 throw new IllegalArgumentException("第一个参数不能是NULL");
    	
		 if(str2==null)
    		 throw new IllegalArgumentException("第二个参数不能是NULL");    			 
		 return str1.toLowerCase().contains(str2.toLowerCase());	 
		 
		 
	      if(str1==null)
    		 throw new IllegalArgumentException("第一个参数不能是NULL");
    	
		 if(str2==null)
    		 throw new IllegalArgumentException("第二个参数不能是NULL");
    	
         return str1.toLowerCase().contains(str2.toLowerCase());
    
          return str1.indexOf(str2)+10;
         
          
          	 if(str1==null)
    		 throw new IllegalArgumentException("String 不能是NULL");
    	
    	 if(stat<0 || stat>str1.length())
    		 throw new IllegalArgumentException(" ");
    	
    	 if(end<0 || end>str1.length() || end<stat)
    		 throw new IllegalArgumentException(" ");
    	 
         return   str1.substring(stat, end); 
	 */
	
	
	 public static boolean contains(String str1, String str2) {	
	     if(str1==null)
  		 throw new IllegalArgumentException("first para is NULL");
  	
		 if(str2==null)
  		 throw new IllegalArgumentException("second para is NULL");    			 
 
		 return str1.toUpperCase().contains(str2.toUpperCase());	 
     }
  
     public static int  indexof(String str1, String str2) {
    	  return str1.toLowerCase().indexOf(str2.toLowerCase())+1;
     }
   
     public static String   substring (String str1, int stat, int end) {
      return null;
     } 
}
