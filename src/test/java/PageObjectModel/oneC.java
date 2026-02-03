package PageObjectModel;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class oneC {
	  WebDriver driver; 
	  Actions action;
      public oneC(WebDriver driver)
      {
   	   this.driver = driver;
   	   PageFactory.initElements(driver,this); 	   
      }
    
      @FindBy(id ="oneC_searchAutoComplete")
      WebElement searchBar;
      
      @FindBy(xpath="//div[@id='newSearchQALST']//div[@aria-label='Submit Timesheet Opens in a new tab']")
      WebElement clickOnTimeSheet;
      
      @FindBy(xpath="(//div[@class='ps_box-scrollarea scroll_area_card']//descendant::a)[1]")
      WebElement timeSheetPeriod;
      
      @FindBy(xpath ="//tbody//tr[3]//td[@class='PSLEVEL1GRIDODDROW'][3]//div//a")
      WebElement tastActivity;
      
      @FindBy(id="RESULT0$6")
      WebElement qaTesting;
      
      @FindBy(xpath="//img[@aria-label='Search Onsite/Offshore opens a dialog']")
      WebElement offShore;
      
      @FindBy(id="SEARCH_RESULT1")
      WebElement off;
      
      @FindBy(xpath = "//img[@aria-label='Search Billing Location opens a dialog']")
      WebElement deFault;
      
      @FindBy(id="SEARCH_RESULT1")
      WebElement deFaultClick;
      
      @FindBy(xpath="//img[@aria-label='Search Project ID opens a dialog']")
      WebElement projectIdMain;
      
      @FindBy(xpath="//a[text()='1000443307']")
      WebElement projectId;
      
      @FindBy(id="CTS_EX_PRJ1_VW_DESCR$0")
      WebElement projectName;
      
      @FindBy(id="CTS_MSTASK_DVW_DESCR50$0")
      WebElement qaTestingName;
      
      @FindBy(xpath="//input[@value='Update Totals']")
      WebElement updateTotals;
      
      @FindBy(id="EX_TIME_HDR_WRK_GRAND_TOTAL")
      WebElement grandTotals;
      
      @FindBy(xpath="//div[@id='newSearchAppsLST']//div[1]//div[1]//div[2]")
      WebElement myPay;
      
      @FindBy(xpath="//div[@id='login']//descendant::input[2]")
      WebElement password;
      
      @FindBy(xpath="//div[@id='login']//descendant::input[3]")
      WebElement loginButton;
      
      public void searchTruTime()
      {
    	  WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(15));
    	  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oneC_searchAutoComplete")));
    	  searchBar.sendKeys("TimeSheet");
    	  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='newSearchQALST']//div[@aria-label='Submit Timesheet Opens in a new tab']")));
    	  System.out.println(driver.getWindowHandle());
    	  clickOnTimeSheet.click();
      }
      public void timeSheetPage() throws InterruptedException
      {
    	  String currentWinId = driver.getWindowHandle();
    	  Thread.sleep(5000);
    	  Set<String> windowId = driver.getWindowHandles();
    	  System.out.println(windowId);
    	  for(String winId:windowId)
    	  {
    		  if(!winId.equals(currentWinId))
    		  {
    			  System.out.println(winId);
    			  driver.switchTo().window(winId);
    			  break;
    		  }
    	  }
    	  System.out.println(driver.getWindowHandle());
    	  WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(25));
    	  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("win0divCTS_TS_LAND_PER_DESCR30$0")));
    	  timeSheetPeriod.click();
      }
      public void enterHours() throws InterruptedException
      {
    	  driver.switchTo().frame("ptifrmtgtframe");
    	  projectIdMain.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptModFrame_0");
    	  projectId.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptifrmtgtframe");
    	  String project_Name = projectName.getText();
    	  Assert.assertEquals(project_Name, "Ford Mo-ISIS & SV2 Migration t");
    	  Thread.sleep(10);
    	  tastActivity.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptModFrame_1");
    	  qaTesting.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptifrmtgtframe");
    	  String QATestingName = qaTestingName.getText();
    	  Assert.assertEquals(QATestingName, "QA Testing");
    	  offShore.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptModFrame_2");
    	  off.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptifrmtgtframe");
    	  Select select = new Select(driver.findElement(By.xpath("//select[@class='CT_TS_BILL_ACT_BRDR_B']")));
    	  select.selectByVisibleText("Billable");
    	  deFault.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptModFrame_3");
    	  deFaultClick.click();
    	  driver.switchTo().defaultContent();
    	  driver.switchTo().frame("ptifrmtgtframe");

    	  for(int i=3;i<=7;i++)
    	  {
    		  try {
    		  WebElement element = driver.findElement(By.xpath("//div[@id='win0divTIME"+i+"$0']//input"));
    		  element.sendKeys("9");
    		  }
    		  catch(NoSuchElementException e)
    		  {
    			  e.printStackTrace();
    		  }
    		  
    	  }
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    	  updateTotals.click();
    	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    	  Thread.sleep(5000);
    	  String grand_Totals = grandTotals.getText();
    	  System.out.println(grand_Totals);
    	  if(grand_Totals.equals("45.00"))
    	  {
    		  System.out.println("able to submit the timesheet");
    	  }
    	  else
    	  {
    		  System.out.println("Not able to submit the timesheet");
    	  }
      }
      public void myPay() throws InterruptedException
      {
    	  String currentWinId = driver.getWindowHandle();
    	  Thread.sleep(5000);
    	  Set<String> windowId = driver.getWindowHandles();
    	  System.out.println(windowId);
    	  for(String winId:windowId)
    	  {
    		  if(!winId.equals(currentWinId))
    		  {
    			  System.out.println(winId);
    			  driver.switchTo().window(winId);
    			  break;
    		  }
    	  }
    	  WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(15));
    	  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oneC_searchAutoComplete")));
    	  searchBar.clear();
    	  searchBar.sendKeys("MyPay");
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  Thread.sleep(5000);
    	  js.executeScript("arguments[0].click();", myPay);
    	  //myPay.click();
    	  driver.switchTo().frame("appFrame");
    	  password.sendKeys("Jayagopalmuruga@1703");
    	  loginButton.click();
      }
}
