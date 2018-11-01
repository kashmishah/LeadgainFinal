package com.leadgain.config;
import javax.servlet.ServletContextEvent;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextCleanupListener;

public class LeadGainApplicationCleanupListener extends ContextCleanupListener {

	
	
	@Override
    public void contextInitialized(ServletContextEvent event) {
		System.out.println("Starting test suite execution ...");
    }
	
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    	System.out.println("Shutting down execution... \n Cleaning up resources...");
    	WebDriver driver = ContextProvider.getBean(WebDriver.class);
    	if(null!=driver) {
    	  driver.close();
    	  driver.quit();
    	}
    	
    }

}