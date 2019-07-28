package demo4;

public class StubWebService implements IWebService {

	public boolean toThrow=true;	
	@Override
	public void logError(String message) {
		if(toThrow){
			throw new RuntimeException("Log Error");
		}
	}

}
