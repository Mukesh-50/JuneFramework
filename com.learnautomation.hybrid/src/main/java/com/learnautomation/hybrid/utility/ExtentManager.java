package com.learnautomation.hybrid.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	
	static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			createInstance();
		}
		
		return extent;
	}
	
	
	public static ExtentReports createInstance()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReport"+System.currentTimeMillis()+".html");
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Sprint Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		return extent;
		
	}
	
	
	
	
	
	

}
