package demo01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;


@RunWith(value = Parameterized.class)
public class JavadocPageAllBrowserTest {

    @Parameters
    public static Collection<BrowserVersion[]> getBrowserVersions() {
        return Arrays.asList(new BrowserVersion[][] { { BrowserVersion.FIREFOX_2 }, { BrowserVersion.FIREFOX_3 },
                { BrowserVersion.INTERNET_EXPLORER_6 }, { BrowserVersion.INTERNET_EXPLORER_7 } });
    }

    private BrowserVersion browserVersion;

    public JavadocPageAllBrowserTest(BrowserVersion browserVersion) {
        this.browserVersion = browserVersion;
    }

    @Test
    public void testClassNav() throws IOException {
        WebClient webClient = new WebClient(this.browserVersion);
        webClient.setThrowExceptionOnScriptError(false);
        HtmlPage mainPage = (HtmlPage) webClient.getPage("file:E:\\培训\\软件设计 实战案例\\06-单元测试与TDD\\21-界面测试\\02-Web测试\\htmlunit-2.7\\htmlunit-2.7\\apidocs\\index.html");
        HtmlPage packagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();
        HtmlPage bVerPage = packagePage.getAnchorByHref("com/gargoylesoftware/htmlunit/BrowserVersion.html").click();
        HtmlParagraph p = (HtmlParagraph) bVerPage.getElementsByTagName("p").item(0);
        Assert.assertTrue("Unexpected text", p.asText().startsWith(
                "Objects of this class represent one specific version of a given browser."));
    }
}
