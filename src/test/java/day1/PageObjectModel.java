package day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class PageObjectModel {
	
           WebDriver driver; 
           public PageObjectModel(WebDriver driver)
           {
        	   this.driver = driver;
        	   PageFactory.initElements(driver,this); 	   
           }
           
           @FindBy(xpath = "//button[@aria-label='Products']")
           WebElement product;
            
           @FindBy(xpath = "//button[@title='App Testing']")
           WebElement apiTesting;
           
           @FindBy(xpath = "//*[@id='products-dd-tabpanel-2-inner-1']/div[2]/div[2]/a")
           WebElement automate;
           
           @FindBy(xpath = "//span[text()='Features']")
           WebElement feature;
           
           @FindBy(xpath = "//a[@title='Real Device Features']")
           WebElement real;
           
           @FindBy(xpath = "//span[text()='20000+ real devices']")
           WebElement real_devices;
           
           @FindBy(id="developers-dd-toggle")
           WebElement developer_Menu;
           
           @FindBy(xpath="//div[@id='developers-dd-menu']//span[text()='Release Notes']")
           WebElement Release_Notes;
           
           @FindBy(xpath="//div[@id='panel-nav']//nav//div//ul[3]//li//a//span")
           List<WebElement> Product_List;
           
           @FindBy(xpath="//div[@id=\"panel-nav\"]//ul[1]//li[@class=\"catItem group\"][4]//span")
           WebElement release_type;
           
           public void browserStack() throws InterruptedException
           {
        	   Actions action =  new Actions(driver);
        	   action.moveToElement(product).perform();
        	   action.moveToElement(apiTesting).perform();
        	   Thread.sleep(4000);
        	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        	   //WebElement automateClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='current-menu-ancestor current-menu-parent bstack-mm-sub-nav-tabcol']//div[2]//a")));
        	   //action.moveToElement(automate).perform();
        	   JavascriptExecutor js= (JavascriptExecutor)driver;
        	   js.executeScript("arguments[0].click()", automate);
        	   //automateClick.click();
        	   Thread.sleep(4000);
        	   action.moveToElement(feature).perform();
        	   Thread.sleep(4000);
        	   action.moveToElement(real).perform();
        	   Thread.sleep(4000);
        	   real_devices.click();
        	   System.out.println(driver.getWindowHandle());
        	   action.moveToElement(developer_Menu).perform();
        	   Release_Notes.click();
        	   Thread.sleep(4000);
        	   System.out.println(driver.getWindowHandle());
        	   
        	   // Find the scrollable container
               WebElement container = driver.findElement(By.cssSelector(".container"));
        
               // Scroll down by 200 pixels inside the container
               JavascriptExecutor js3 = (JavascriptExecutor) driver;
               js3.executeScript("arguments[0].scrollTop += 250;", container);
        
                String str = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/nav/div[2]/ul/ul[3]/li[7]/a/span")).getText();
                System.out.println(str);;

        	   Thread.sleep(5000);
        	   List<String> productList = new ArrayList<String>();
        	   System.out.println(Product_List.size());
        	   for(int i=0;i<Product_List.size();i++)
        	   {
        		   JavascriptExecutor js4 = (JavascriptExecutor) driver;
        	        String text = (String) js4.executeScript("return arguments[0].textContent;", Product_List.get(i));
        	        System.out.println(text);
        	   }
        	   System.out.println(productList);
        		   for(int i=0;i<Product_List.size();i++)
            	   {
        			   JavascriptExecutor js4 = (JavascriptExecutor) driver;
           	           String text = (String) js4.executeScript("return arguments[0].textContent;", Product_List.get(i));
           	        System.out.println(text+" y");
            		   if((text == "				live") || (text == "percy") || (text == "app percy"));
            		   {
            			   System.out.println("1");
            			   System.out.println(text);
            			   Product_List.get(i).click();
//            			   JavascriptExecutor js5 = (JavascriptExecutor) driver;
//               	           js5.executeScript("arguments[0].click();",Product_List.get(i));
               	           Thread.sleep(5000);
            		   }
            	   }
        	   
        	   
           }
           
}
