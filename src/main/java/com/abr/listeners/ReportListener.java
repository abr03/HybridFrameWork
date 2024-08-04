package com.abr.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.abr.dataprovider.ConfigReader;
import com.abr.factory.BrowserFcatory;
import com.abr.helper.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ReportListener  implements ITestListener 
{
	ExtentReports extent=ExtentManager.getInstance();
	
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Starting Test");
		
		extentTest=extent.createTest(result.getMethod().getMethodName());
		
		test.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) 
	{
			if(ConfigReader.getProperty("screenshotOnSuccess").equalsIgnoreCase("true"))
			{
				WebDriver driver=BrowserFcatory.getdriver();
				String screenshot=Utility.CpatureScreenShotAsBas64CHPT(driver);

				test.get().pass("Test Passed ",MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
			}
			else
			{
				test.get().pass("Test Passed");
			}
	}

	public void onTestFailure(ITestResult result) 
	
	{
		
			if(ConfigReader.getProperty("screenshotOnFailure").equalsIgnoreCase("true"))
			{
				WebDriver driver= BrowserFcatory.getdriver();

				String screenshot=Utility.CpatureScreenShotAsBas64CHPT(driver);
		
			test.get().fail("Test Failed "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
			}
			else
			{
				test.get().fail("Test Failed "+result.getThrowable().getMessage());
			}
	}

	public void onTestSkipped(ITestResult result) {
		
			if(ConfigReader.getProperty("screenshotOnSkip").equalsIgnoreCase("true"))
			{
				WebDriver driver=BrowserFcatory.getdriver();
				String Screenshot=Utility.CpatureScreenShotAsBas64CHPT(driver);
			test.get().skip("Test Skipped ",MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot).build());
			}
			else
			{
				test.get().skip("Test Skipped ");
			}
		
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
