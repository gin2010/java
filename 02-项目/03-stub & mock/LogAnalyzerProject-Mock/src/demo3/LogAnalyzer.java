package demo3;

public class LogAnalyzer {
	private IWebService service;
   
    public LogAnalyzer(IWebService service)
    {
        this.service = service;
    }
	
    public void analyze(String fileName){
		if( fileName.length()<8)
        {
            service.logError("Filename too short:" + fileName);            
        }
	}	
}
