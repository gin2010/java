package demo01;
import org.junit.After;
import org.junit.Before;

import com.gargoylesoftware.htmlunit.WebClient;

public abstract class ManagedWebClient {
    protected WebClient webClient;

    protected WebClient getWebClient() {
        return this.webClient;
    }

    @Before
    public void setUp() {
        this.setWebClient(new WebClient());
    }

    protected void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @After
    public void tearDown() {
        this.getWebClient().closeAllWindows();
    }
}

