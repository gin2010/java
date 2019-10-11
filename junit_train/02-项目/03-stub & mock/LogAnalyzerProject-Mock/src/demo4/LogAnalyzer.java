package demo4;

public class LogAnalyzer {
	private IWebService service;
    private IEmailService email;

	public LogAnalyzer(IWebService service, IEmailService email) {
		this.service = service;
		this.email = email;
	}

	public void analyze(String fileName){
		if( fileName.length()<6)
        {
            try
            {
                service.logError("Filename too short:" + fileName);
            }catch (Exception e){
                email.sendEmail("a","subject",e.getMessage());
            }
        }
	}	
}
