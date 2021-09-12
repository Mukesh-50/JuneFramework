package com.learnautomation.hybrid.dataProviders;

import org.testng.annotations.DataProvider;

public class CustomDataProvider 
{
	
	@DataProvider(name="Login")
	public static Object[][] getData()
	{	
		System.out.println("LOG:INFO- Loading Test Data from data provider");
		return ExcelUtility.getDataFromExcel("login");
	}
	
	@DataProvider(name="AccountUser")
	public static Object[][] getDataFromAccounts()
	{	
		System.out.println("LOG:INFO- Loading Test Data from data provider");
		return ExcelUtility.getDataFromExcel("account");
	}

}
