package OneCPortal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.oneC;
import day1.Base;

public class oneCPortal {
	 WebDriver driver;
	 oneC onec;
	 @Test(priority=0)
	 public void getDriver()
	 {
		 Base.driver();
		 driver = Base.getDriver();
	 }
	 @Test(priority=1)
	 public void launchOneCPortal()
	 {
		 driver.get("https://onecognizant.cognizant.com/Home");
		 driver.manage().window().maximize();	
		 onec = new oneC(driver);
		 onec.searchTruTime();
		 Assert.fail();
	 }
	 @Test(priority=2, dependsOnMethods="launchOneCPortal")
	 public void timeSheet() throws InterruptedException
	 {
		 onec.timeSheetPage();
		 onec.enterHours();
		 onec.myPay();
	 }
}
