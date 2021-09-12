package com.learnautomation.hybrid.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.learnautomation.hybrid.base.BaseClass;
import com.learnautomation.hybrid.dataProviders.CustomDataProvider;
import com.learnautomation.hybrid.pages.Dashboard;
import com.learnautomation.hybrid.pages.LoginPage;


public class LoginTest extends BaseClass
{

	public WebDriver driver;
	
	@BeforeMethod
	public void setupDriver()
	{
		driver=getDriver();
	}
	
	
	@Test(dataProvider="Login",dataProviderClass=CustomDataProvider.class,priority=1)
	public void loginTest(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginValidUser(username, password);
		
		Assert.assertTrue(login.getURLAfterLogin().contains("dashboard"));	
	}
	
	@Test(dataProvider="AccountUser",dataProviderClass=CustomDataProvider.class,priority=2,enabled=false)
	public void createAccount(String empName,String uname,String pass)
	{
		Dashboard dashboard=new Dashboard(driver);
		
		String textToValidate=dashboard.createAccount(empName, uname, pass);
		
		Assert.assertTrue(textToValidate.contains("Successfully"));		
				
	}
	
	@Test(priority=2)
	public void createAccountNew()
	{
		Dashboard dashboard=new Dashboard(driver);
		
		Faker fake=new Faker();
		
		String textToValidate=dashboard.createAccount("John Smith", fake.name().firstName(), fake.name().fullName());
		
		Assert.assertTrue(textToValidate.contains("Successfully"));		
				
	}
	

}
