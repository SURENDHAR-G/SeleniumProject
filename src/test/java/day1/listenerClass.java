package day1;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerClass implements ITestListener{
     public void onTestStart(ITestResult result)
     {
    	 System.out.println("Test started");
     }
     public void onTestSuccess(ITestResult result)
     {
    	 System.out.println("Test Success");
     }
     public void onTestFailure(ITestResult result)
     {
    	 System.out.println("Test failed");
     }
}
