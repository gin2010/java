package demo1;

import java.util.Random;

public class FileExtensionManager {
	public boolean IsSupportedExtension(String fileName)
    {        
		try {
			//read some file here and determine if it is valid.
	        //实现对I/O检查是否支持
			
			Thread.sleep(1000*3);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		//随机结果， 因为依赖外部资源，导致可能随时出现问题
		Random Random=new Random();	
		if(Random.nextBoolean())
			return true;
		else
			return false;
    }
}
