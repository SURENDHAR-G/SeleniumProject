package AutomationPractice;

import org.openqa.selenium.WebDriver;

public class TimeSheet {
	
	WebDriver driver;
	PageObjectModel pom;

public void onecognizantNavigation()
{
	driver = Base.getDriver();
	driver.get("https://onecognizant.cognizant.com/welcome");
	driver.manage().window().maximize();
}
public void clickTimeSheet()
{
	pom = new PageObjectModel(driver);
	pom.clickTimeSheet();
}
public static void main(String arg[])
{
}
}
