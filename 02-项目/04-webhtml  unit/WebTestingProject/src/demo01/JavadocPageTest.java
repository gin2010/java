package demo01;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;


public class JavadocPageTest extends ManagedWebClient {

    @Test
    public void testClassNav() throws IOException {

        HtmlPage mainPage = (HtmlPage) this.webClient.getPage("file:src/webapp/index.html");
        HtmlPage packagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();
        HtmlPage bVerPage = packagePage.getAnchorByHref("com/gargoylesoftware/htmlunit/BrowserVersion.html").click();
        HtmlParagraph p = (HtmlParagraph) bVerPage.getElementsByTagName("p").item(0);
        Assert.assertTrue("Unexpected text", p.asText().startsWith(
                "Objects of this class represent one specific version of a given browser."));
    }
}
