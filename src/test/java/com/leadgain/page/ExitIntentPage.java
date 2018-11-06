package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.leadgain.utility.AbstractPage;

@Component
public class ExitIntentPage extends AbstractPage {


  @Value("#{'${xpath.title.popup.pdf}'}")
  private String xpathPopupPdfTitle;

  @Value("#{'${title.popup.pdf}'}")
  private String whitePaperPdfTitle;
  
  @Value("#{'${xpath.downloadbtn}'}")
  private String xpathDownloadBtn;
  
  /*@Value("#{'${xpath.emailfield}'}")
  private String xpathEmailField;*/
  
  @Value("#{'${id.emailfield}'}")
  private String idEmailField;
  
  @Value("#{'${xpath.imintrestedbtn}'}")
  private String xpathImIntretsedBtn;
  
  @Value("#{'${xpath.popup.iframe}'}")
  private String xpathIframe;
 
/*  @Value("#{'${xpath.pdfpageloader}'}")
  private String xpathPdfpage;*/
  
  @Value("#{'${xpath.popup.init.loader}'}")
  private String xpathInitLoaderDiv;
 
  @Value("#{'${xpath.pdf.loader}'}")
  private String xpathPdfLoader;
  
    public void verifyExitPopupIsDisplayed() throws InterruptedException, AWTException {
      waitForDOMReady();
      System.out.println("before::");
      moveMouseOut();
      System.out.println("after :: ");
      assertElementPresentByXpath(xpathIframe);
      
    }
 /*  public void verifyExitIntentPopupTitle() {
      waitForElement(xpathPopupPdfTitle);
      WebElement headerEle = webDriver.findElement(By.xpath(xpathPopupPdfTitle));
      String actualHeading = headerEle.getText();
      assertEquals(actualHeading, whitePaperPdfTitle,
          "Actual heading '" + actualHeading + "' should be same as expected '" + whitePaperPdfTitle + "'.");
      
      
    }*/
    
    public void verifyDownloadButtonClick() throws InterruptedException {
     /* webDriver.switchTo().frame(webDriver.findElement(By.xpath(xpathIframe)));
      System.out.println("before focus:");
      ((org.openqa.selenium.JavascriptExecutor) webDriver).executeScript("window.focus();");
       waitForDOMReady();*/
      windowFocus(xpathIframe);
      System.out.println("before click");
//	  waitForElementInVisible(xpathInitLoaderDiv); 
	  System.out.println("before click 1");
//	  waitForElementClickable(xpathDownloadBtn, 60 );
	  System.out.println("before click 2");
	  Thread.sleep(15000);
	  assertAndClickByScript(xpathDownloadBtn);
	// assertAndClickById("leadgain-downloadButton",0);
      System.out.println("after click");
      System.out.println("after focus:");
    }
    
    public void verifyAndSubmitEmail(String emailval) throws InterruptedException {
//      windowFocus(xpathIframe);
      
      assertAndSendKeysByID(idEmailField, emailval);
      assertAndClickByScript(xpathImIntretsedBtn);
     // assertAndClick(xpathImIntretsedBtn);
      
    }
  
    public void veifyScrollPagePdf() {
      // TODO Auto-generated method stub
      System.out.println("before find");
     // waitForElementVisible(xpathPdfLoader);
     // waitForElementInVisible(xpathPdfLoader);
      System.out.println("after found");
      scrollPage(5);
    }


}
