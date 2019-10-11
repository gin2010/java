package demo01;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.MockWebConnection;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class InLineHtmlFixtureTest extends ManagedWebClient {

    @Test
    public void testInLineHtmlFixture() throws Exception {
        final String expectedTitle = "Hello 1!";
        String html = "<html><head><title>" + expectedTitle + "</title></head></html>";
        MockWebConnection conn = new MockWebConnection();
        conn.setDefaultResponse(html);
        this.webClient.setWebConnection(conn);
        HtmlPage page = this.webClient.getPage("http://page");
        System.out.println(page.getTitleText());
        Assert.assertEquals(expectedTitle, page.getTitleText());
    }

    @Test
    public void testInLineHtmlFixtures() throws Exception {
        final URL page1Url = new URL("http://Page1/");
        final URL page2Url = new URL("http://Page2/");
        final URL page3Url = new URL("http://Page3/");

        MockWebConnection conn = new MockWebConnection();
        conn.setResponse(page1Url, "<html><head><title>Hello 1!</title></head></html>");
        conn.setResponse(page2Url, "<html><head><title>Hello 2!</title></head></html>");
        conn.setResponse(page3Url, "<html><head><title>Hello 3!</title></head></html>");
        this.webClient.setWebConnection(conn);

        HtmlPage page1 = this.webClient.getPage(page1Url);
        Assert.assertEquals("Hello 1!", page1.getTitleText());

        HtmlPage page2 = this.webClient.getPage(page2Url);
        Assert.assertEquals("Hello 2!", page2.getTitleText());

        HtmlPage page3 = this.webClient.getPage(page3Url);
        Assert.assertEquals("Hello 3!", page3.getTitleText());
    }

}

