package demo3;

public class MockWebService implements IWebService {

	public String lastError="";
	
	@Override
	public void logError(String message) {
		lastError=message;
	}

}
