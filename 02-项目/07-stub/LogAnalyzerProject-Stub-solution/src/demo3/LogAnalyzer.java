package demo3;

public class LogAnalyzer {
	private boolean wasLastFileNameValid;
	private String defaultFilename="defaultFilename.slf";
	
	
	private IExtensionManager manager;
	
	public LogAnalyzer() {	
		this.manager = new FileExtensionManager();
	}
	public LogAnalyzer(IExtensionManager manager) {
		this.manager = manager;
	}
  

	public boolean  isValidLogFileName(String fileName)
    {
		if(fileName==null || fileName.isEmpty()){
			fileName=this.defaultFilename;
		}
		
		if(fileName.length()>16 || fileName.length()<6){
			 wasLastFileNameValid=false;
	         return false;
		}
		
        if (!fileName.toLowerCase().endsWith(".slf"))  {
            wasLastFileNameValid=false;
            return false;
        }
        //文件系统检测是否支持
        if(!manager.IsSupportedExtension(fileName)){
        	 wasLastFileNameValid=false;
             return false;
        }        
        wasLastFileNameValid = true;
        return true;
    }
}
