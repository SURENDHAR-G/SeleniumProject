 package day1;
import java.util.List;

import org.openqa.selenium.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class selenium extends Base
{
	WebDriver driver;
	
	@Test(dataProvider = "testdata")
	public void visitWebsite(String java,String js) throws InterruptedException
	{
		//WebDriverManager().
		driver = Base.getDriver();
		driver.get("https://www.w3schools.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector(".ga-fp[placeholder='Search our tutorials, e.g. HTML']")).sendKeys(java);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@id = 'learntocode_searchicon']")).click();
		driver.navigate().back();
		driver.findElement(By.cssSelector(".ga-fp[placeholder='Search our tutorials, e.g. HTML']")).clear();
		driver.findElement(By.cssSelector(".ga-fp[placeholder='Search our tutorials, e.g. HTML']")).sendKeys(js);
		Thread.sleep(3000);
		//driver.findElement(By.partialLinkText("JA")).click();
		List<WebElement> link = driver.findElements(By.tagName("img"));
		System.out.println(link.size());
		driver.quit();
		
	}
	@DataProvider(name = "testdata")
	public Object[][] getTestData()
	{
		Object[][] data = { 
				{"java","javascript"},
				{"python","sql"},
		};
		return data;
	}
//	@Test(priority = 3, dependsOnMethods={"visitWebsite"})
//	public void logocheck()
//	{
//		boolean logo=driver.findElement(By.id("w3-logo")).isDisplayed();
//		System.out.println(logo);
//		boolean next = driver.findElement(By.xpath("//div[@class=\"w3-clear nextprev\"][1]/a[2]")).isEnabled();
//		Assert.assertTrue(next,"Next button is enabled");
//		driver.quit();
//	}
//	@Test(priority = 1)
//	public void frame() throws InterruptedException
//	{
//		driver = Base.driver();
//		driver.get("https://ui.vision/demo/webtest/frames/");
//		driver.manage().window().maximize();
//		WebElement frame = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
//		driver.switchTo().frame(frame);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,3000)","");
//		WebElement innerFrame =driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
//		driver.switchTo().frame(innerFrame);
//		JavascriptExecutor js1 = (JavascriptExecutor)driver;
//		js1.executeScript("window.scrollBy(0,3000)","");
//		driver.findElement(By.xpath("//div[@class='e2CuFe eU809d']")).click();
//		Thread.sleep(10000);
//		WebElement choose = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[2]/div[4]/span"));
//		JavascriptExecutor js2 = (JavascriptExecutor)driver;
//		js2.executeScript("arguments[0].click()",choose);
//		driver.close();
//	}
}
