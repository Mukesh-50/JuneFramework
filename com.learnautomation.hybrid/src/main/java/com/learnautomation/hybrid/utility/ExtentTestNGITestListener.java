package com.learnautomation.hybrid.utility;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ExtentTestNGITestListener implements ITestListener 
{

	private static ExtentReports extent = ExtentManager.getInstance();
	
	ExtentTest child;
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	

	public  void onStart(ITestContext context) {
    	
	}

	
	public  void onFinish(ITestContext context) 
	{
		System.out.println("*************** Writing Result to report******************");
		
		extent.flush();
		
		System.out.println("*************** Report completed******************");
		
	}
	
	
	public  void onTestStart(ITestResult result) 
	{
		System.out.println("*************** Creating Test******************");
		
		ExtentTest parent=extent.createTest(result.getMethod().getMethodName());
		
		parentTest.set(parent);
	
	}

	
	public  void onTestSuccess(ITestResult result) 
	{
		System.out.println("*************** Test Passed******************");
		
		parentTest.get().pass("Test Passed");
	}

	
	public  void onTestFailure(ITestResult result) 
	{
		System.out.println("*************** Test Failed******************");
		
		WebDriver driver=null;
		
		try 
		{
			Field f=result.getTestClass().getRealClass().getDeclaredField("driver");
			
			Object obj=f.get(result.getInstance());
			
			driver=(WebDriver)obj;
			
			//driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			
		} catch (Exception e1) 
		{
			System.out.println("Can not access runtime class");
		} 
		
		try 
		{
			parentTest.get().fail("	 "+result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getScreenshotInBase64(driver)).build());
		} 
		catch (IOException e) 
		{
			System.out.println("Not able to add screenshot");
		}
	}

	
	public  void onTestSkipped(ITestResult result) 
	{
		System.out.println("*************** Test Skipped******************");
		
		parentTest.get().skip("Test skipped");
	}

	
	public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}
