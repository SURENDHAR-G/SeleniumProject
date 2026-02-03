package AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	public static WebDriver driver;
	
	public  static void driver()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeClass
    public static WebDriver getDriver()
    {
    	return driver;
    }
    @AfterClass
    public static void quitDriver()
    {
    	driver.quit();
    }
}
