package demo01;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class XPathTest extends ManagedWebClient {

    private static final String USCORE = "_";

    private HtmlPage mainPage;

    private void assertAlphabeticalOrder(List<DomNode> nodes) {
        if (nodes.size() <= 0) {
            return;
        }
        DomNode prevNode = nodes.get(0);
        for (DomNode currNode : nodes) {
            final String prevText = prevNode.getTextContent();
            final String currText = currNode.getTextContent();
            // Compare ignoring case.
            boolean inOrder = prevText.toLowerCase().compareTo(currText.toLowerCase()) <= 0;
            if (!inOrder && (prevText.contains(USCORE) || currText.contains(USCORE))) {
                // We know _ are trouble, ignore for the purpose of this demo.
                continue;
            }
            Assert.assertTrue("previous=" + prevText + ", current=" + currText, inOrder);
            prevNode = currNode;
        }
    }

    /**
     * Make logging pretty quiet, do not log warnings.
     */
    @BeforeClass
    public static void setUpLogging() {
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.SEVERE);
    }

    @Before
    public void initWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        this.webClient.setThrowExceptionOnScriptError(false);
        this.mainPage = (HtmlPage) this.webClient.getPage("http://java.sun.com/javase/6/docs/api/index.html");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAllClassesList() {
        HtmlPage classListPage = (HtmlPage) this.mainPage.getFrameByName("packageFrame").getEnclosedPage();
        List<DomNode> classes = (List<DomNode>) classListPage.getByXPath("//a");
        this.assertAlphabeticalOrder(classes);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAllPackagesList() {
        HtmlPage packageListPage = (HtmlPage) this.mainPage.getFrameByName("packageListFrame").getEnclosedPage();
        List<DomNode> anchors = (List<DomNode>) packageListPage
                .getByXPath("//a[contains(@href, 'package-frame.html') and @target='packageFrame']");
        this.assertAlphabeticalOrder(anchors);
    }
}
