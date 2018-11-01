package com.leadgain.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.leadgain.utility.AbstractPage;

@Component
public class CampaignPageDelete extends AbstractPage{

  @Value("#{'${xpath.campaignbtn}'}")
  private String xpathCampaignBtn;
  
  @Value("#{'${xpath.table.rows}'}")
  private String xpathTableRows;
  
  @Value("#{'${select.campaign.name}'}")
  private String campaignName;
  
  @Value("#{'${xpath.delete.popup.msg}'}")
  String xpathDeletePopupMsg;
  
  @Value("#{'${xpath.delete.ok}'}")
  String xpathDeleteOk;
  
  @Value("#{'${xpath.loader.delete.campaign}'}")
  String xpathLoaderDeleteCampaign;
  
  @Value("#{'${xpath.logoutbtn}'}")
  private String xpathLogoutBtn;
  
  public String dashboardClassDelete= "anticon-delete";
  
  public void verifyCampaignPageDelete() throws InterruptedException{
    assertAndClick(xpathCampaignBtn);
    WebElement element = findWebElement(xpathTableRows, campaignName);
    System.out.println(campaignName);
    
    
    element.findElement(By.className(dashboardClassDelete)).click();
    
    waitForElementVisible(xpathDeletePopupMsg);
    waitForElementVisible(xpathDeleteOk);
    
    assertAndClick(xpathDeleteOk, 0);
    Thread.sleep(5000);
    pageReady(xpathLoaderDeleteCampaign);
    pageRefresh();
    


    
    WebElement element1 = findWebElement(xpathTableRows, campaignName);
    System.out.println(element1);
    System.out.println("d2 "+campaignName);
    Assert.assertNull(element1, "Campaign : " +campaignName+ " not deleted ");
    System.out.println(element1);
    
    assertAndClick(xpathLogoutBtn);
   
  }
  
 
  
}
