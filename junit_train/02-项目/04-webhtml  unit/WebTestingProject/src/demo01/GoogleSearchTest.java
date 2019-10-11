package demo01;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class GoogleSearchTest extends ManagedWebClient {

    @Test
    public void testSearchPage() throws Exception {
        this.webClient.setThrowExceptionOnScriptError(false);
        HtmlPage page = (HtmlPage) this.webClient.getPage("http://www.google.com");
        HtmlForm form = page.getForms().get(0);
        HtmlTextInput queryText = (HtmlTextInput) form.getInputByName("q");
        queryText.setValueAttribute("Manning Publications Co.");
        HtmlSubmitInput searchButton = (HtmlSubmitInput) form.getInputByName("btnG");
        HtmlPage resultPage = (HtmlPage) searchButton.click();
        HtmlAnchor link = resultPage.getAnchorByHref("http://www.manning.com/");
        HtmlPage page3 = (HtmlPage) link.click();
        WebAssert.assertTitleEquals(page3, "Manning Publications Co.");
    }

    @Test
    public void testSearchPageEnter() throws Exception {
        this.webClient.setThrowExceptionOnScriptError(false);
        HtmlPage page = (HtmlPage) this.webClient.getPage("http://www.google.com");
        HtmlForm form = page.getForms().get(0);
        HtmlTextInput queryText = (HtmlTextInput) form.getInputByName("q");
        queryText.setValueAttribute("Manning Publications Co.");
        HtmlPage resultPage = (HtmlPage) queryText.type('\n');
        HtmlAnchor link = resultPage.getAnchorByHref("http://www.manning.com/");
        HtmlPage page3 = (HtmlPage) link.click();
        WebAssert.assertTitleEquals(page3, "Manning Publications Co.");
    }

}

