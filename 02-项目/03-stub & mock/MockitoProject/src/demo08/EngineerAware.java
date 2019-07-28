package demo08;

public interface EngineerAware {
	Engineer getDesignation();
	
	enum Engineer {
		DEV,QA
	}
}
