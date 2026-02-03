package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import PageObjectModel.WeTest;

public class WeTestMain {

	  WebDriver driver;
	  @Test(priority = 0)
      public void getDriver()
      {
    	  driver = Base.getDriver();
      }
	  
	@Test(priority = 1)
	  public void wetestAutomation() throws InterruptedException
	  {
		  ChromeOptions options = new ChromeOptions();
	      options.addArguments("--disable-notifications"); // Block notifications
	 
	      WebDriver driver = new ChromeDriver(options);
		  driver.get("https://www.wetest.net/");
		  WeTest wt = new WeTest(driver);
		  driver.manage().window().maximize();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  Thread.sleep(10000);
	        // Locate the Shadow Host element (usercentrics-root)
		// Locate the Shadow Host
		  WebElement shadowHost = driver.findElement(By.id("usercentrics-root"));
		   
		  // Get the Shadow Root
		  SearchContext shadowRoot = shadowHost.getShadowRoot();
		   
		  // Now locate the element inside Shadow DOM
		  WebElement denyButton = shadowRoot.findElement(By.cssSelector("button[data-testid='uc-deny-all-button']"));
		   
		  // Click the Deny button
		  denyButton.click();
		  Thread.sleep(10000);
		  wt.whyUsTab();
	  }
}
