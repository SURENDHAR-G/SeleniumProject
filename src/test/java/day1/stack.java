package day1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class stack extends Base{

	WebDriver driver = Base.getDriver();
	@Test()
     public void BrowseStack() throws InterruptedException
     {
    	 driver.get("https://www.browserstack.com/guide/extent-reports-in-selenium");
    	 Thread.sleep(4000);
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 driver.manage().window().maximize();
    	 PageObjectModel pom= new PageObjectModel(driver);
    	 pom.browserStack();
    	 
     }

}
