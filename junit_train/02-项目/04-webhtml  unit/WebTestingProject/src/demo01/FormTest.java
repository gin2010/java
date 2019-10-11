package demo01;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.CollectingAlertHandler;
import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class FormTest extends ManagedWebClient {

    @Test
    public void testForm() throws IOException {
        this.webClient.setThrowExceptionOnScriptError(false);
        HtmlPage page = (HtmlPage) this.webClient.getPage("file:src/webapp/formtest.html");
        HtmlForm form = page.getFormByName("validated_form");
        HtmlTextInput input = (HtmlTextInput) form.getInputByName("in_text");
        input.setValueAttribute("typing...");
        HtmlSubmitInput submitButton = (HtmlSubmitInput) form.getInputByName("submit");
        HtmlPage resultPage = (HtmlPage) submitButton.click();
        WebAssert.assertTitleEquals(resultPage, "Result");
    }

    @Test
    public void testFormAlert() throws IOException {
        this.webClient.setThrowExceptionOnScriptError(false);
        CollectingAlertHandler alertHandler = new CollectingAlertHandler();
        this.webClient.setAlertHandler(alertHandler);
        HtmlPage page = (HtmlPage) this.webClient.getPage("file:src/webapp/formtest.html");
        HtmlForm form = page.getFormByName("validated_form");
        HtmlSubmitInput submitButton = (HtmlSubmitInput) form.getInputByName("submit");
        HtmlPage resultPage = (HtmlPage) submitButton.click();
        Assert.assertEquals(resultPage.getTitleText(), page.getTitleText());
        Assert.assertEquals(resultPage, page);
        List<String> collectedAlerts = alertHandler.getCollectedAlerts();
        List<String> expectedAlerts = Collections.singletonList("Please enter a value.");
        Assert.assertEquals(expectedAlerts, collectedAlerts);
    }

    @Test
    public void testFormNoAlert() throws IOException {
        WebClient webClient = new WebClient();
        webClient.setThrowExceptionOnScriptError(false);
        CollectingAlertHandler alertHandler = new CollectingAlertHandler();
        webClient.setAlertHandler(alertHandler);
        HtmlPage page = (HtmlPage) webClient.getPage("file:src/webapp/formtest.html");
        HtmlForm form = page.getFormByName("validated_form");
        HtmlTextInput input = (HtmlTextInput) form.getInputByName("in_text");
        input.setValueAttribute("typing...");
        HtmlSubmitInput submitButton = (HtmlSubmitInput) form.getInputByName("submit");
        HtmlPage resultPage = (HtmlPage) submitButton.click();
        WebAssert.assertTitleEquals(resultPage, "Result");
        Assert.assertTrue("No alerts expected", alertHandler.getCollectedAlerts().isEmpty());
    }

}

