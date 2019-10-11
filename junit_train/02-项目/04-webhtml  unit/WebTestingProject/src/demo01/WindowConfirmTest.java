package demo01;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.CollectingAlertHandler;
import com.gargoylesoftware.htmlunit.ConfirmHandler;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.MockWebConnection;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class WindowConfirmTest extends ManagedWebClient {

    @Test
    public void testWindowConfirm() throws FailingHttpStatusCodeException, IOException {
        String html = "<html><head><title>Hello</title></head><body onload='confirm(\"Confirm Message\")'></body></html>";
        URL testUrl = new URL("http://Page1/");
        WebClient webClient = new WebClient();
        MockWebConnection mockConnection = new MockWebConnection();
        final List<String> confirmMessages = new ArrayList<String>();
        // set up
        webClient.setConfirmHandler(new ConfirmHandler() {
            public boolean handleConfirm(Page page, String message) {
                confirmMessages.add(message);
                return true;
            }
        });
        mockConnection.setResponse(testUrl, html);
        webClient.setWebConnection(mockConnection);
        // go
        HtmlPage firstPage = webClient.getPage(testUrl);
        Assert.assertEquals("Hello", firstPage.getTitleText());
        Assert.assertArrayEquals(new String[] { "Confirm Message" }, confirmMessages.toArray());
    }

    @Test
    public void testWindowConfirmAndAlert() throws FailingHttpStatusCodeException, IOException {
        String html = "<html><head><title>Hello</title><script>function go(){alert(confirm('Confirm Message'))}</script>\n"
                + "</head><body onload='go()'></body></html>";
        URL testUrl = new URL("http://Page1/");
        WebClient webClient = new WebClient();
        MockWebConnection mockConnection = new MockWebConnection();
        final List<String> confirmMessages = new ArrayList<String>();
        // set up
        webClient.setAlertHandler(new CollectingAlertHandler());
        webClient.setConfirmHandler(new ConfirmHandler() {
            public boolean handleConfirm(Page page, String message) {
                confirmMessages.add(message);
                return true;
            }
        });
        mockConnection.setResponse(testUrl, html);
        webClient.setWebConnection(mockConnection);
        // go
        HtmlPage firstPage = webClient.getPage(testUrl);
        Assert.assertEquals("Hello", firstPage.getTitleText());
        Assert.assertArrayEquals(new String[] { "Confirm Message" }, confirmMessages.toArray());
        Assert.assertArrayEquals(new String[] { "true" }, ((CollectingAlertHandler) webClient.getAlertHandler()).getCollectedAlerts()
                .toArray());
    }

}

