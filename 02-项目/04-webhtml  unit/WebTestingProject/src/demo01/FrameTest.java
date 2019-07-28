package demo01;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class FrameTest extends ManagedWebClient {

    @Test
    public void testFramesByIndices() throws IOException {
        this.webClient.setThrowExceptionOnScriptError(false);
        HtmlPage mainPage = (HtmlPage) this.webClient.getPage("http://java.sun.com/javase/6/docs/api/index.html");

        // get page of the first Frame (upper left)
        HtmlPage packageListPage = (HtmlPage) mainPage.getFrames().get(0).getEnclosedPage();
        packageListPage.getAnchors().get(5).click();

        // get page of the Frame named 'packageFrame' (lower left)
        HtmlPage pakcagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();
        pakcagePage.getAnchors().get(1).click();

        // get page of the Frame named 'classFrame' (right)
        HtmlPage classPage = (HtmlPage) mainPage.getFrameByName("classFrame").getEnclosedPage();
        Assert.assertNotNull(classPage);
    }

    @Test
    public void testFramesByNames() throws IOException {
        this.webClient.setThrowExceptionOnScriptError(false);
        HtmlPage mainPage = (HtmlPage) this.webClient.getPage("http://java.sun.com/javase/6/docs/api/index.html");

        // Gets page of the first Frame (upper left)
        HtmlPage packageListPage = (HtmlPage) mainPage.getFrameByName("packageListFrame").getEnclosedPage();
        packageListPage.getAnchorByHref("java/lang/package-frame.html").click();

        // get page of the Frame named 'packageFrame' (lower left)
        HtmlPage packagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();
        packagePage.getAnchors().get(1).click();

        // get page of the Frame named 'classFrame' (right)
        HtmlPage classPage = (HtmlPage) mainPage.getFrameByName("classFrame").getEnclosedPage();
        Assert.assertNotNull(classPage);
    }
}

