package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeTest {
	  WebDriver driver; 
	  Actions action;
      public WeTest(WebDriver driver)
      {
   	   this.driver = driver;
   	   PageFactory.initElements(driver,this); 	   
      }
    
      //Locators
      @FindBy(xpath = "(//div[@class=\"title-item\"][contains(text(),'Overseas Local User Testing')])[1]")
      WebElement title;
      
      @FindBy(xpath="//span[@class='nav-inner'][text()='Why Us']")
      WebElement whyUS;
      
      @FindBy(xpath="//div[@class='menu-title'][text()='About WeTest']")
      WebElement aboutWeTest;
      
      @FindBy(xpath="//h1[@class='title']")
      WebElement headerWeTest;
      
      @FindBy(xpath="//div[@class=\"fixed-header-container\"]//img[@src=\"https://assets.wetest.net/wetest-web-net/pro/img/733ba113.svg\"]")
      WebElement logo;
      
      //Action Methods
      public void whyUsTab() throws InterruptedException
      {
    	 action = new Actions(driver);
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 //WebElement element = driver.findElement(By.id("elementID")); // Change to your element's locator
    	  
    	 // Create and dispatch a mouse over event
//    	 js.executeScript(
//    	     "var event = new MouseEvent('mouse over', {bubbles: true, cancelable: true, view: window});" +
//    	     "arguments[0].dispatchEvent(event);",
//    	     whyUS
//    	 );
    	 
    	 Thread.sleep(20);
    	 System.out.println(logo.isDisplayed());
    	 System.out.println(title.getText());
    	 WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(15));
    	 mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='nav-inner'][text()='Why Us']//i")));
    	 action.moveToElement(whyUS);
    	 aboutWeTest.click();
    	 String title = headerWeTest.getText();
    	 System.out.println("This is "+title+" Page");
    	 
      }
      
}
