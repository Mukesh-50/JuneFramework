package com.learnautomation.hybrid.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.hybrid.utility.Utility;

public class Dashboard 
{
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Logout
	By welcome=By.id("welcome");
	By logoutText=By.linkText("Logout");
	
	//CreateAccount
	By adminTab=By.xpath("//b[text()='Admin']");
	By addButton=By.xpath("//input[@value='Add']");
	By empName=By.xpath("//*[text()='Employee Name']//following::input[1]");
	By username=By.xpath("//*[text()='Username']//following::input[1]");
	By password=By.xpath("//*[text()='Password']//following::input[1]");
	By confirmPassword=By.xpath("//*[text()='Confirm Password']//following::input[1]");
	By saveButton=By.xpath("//input[@value='Save']");
	By successMsg=By.xpath("//*[contains(text(),'Successfully Saved') and @class]");

	
	public String createAccount(String employeeName,String uname,String pass)
	{
		Utility.click(driver, adminTab);
		Utility.click(driver, addButton);
		Utility.type(driver, empName, employeeName);
		Utility.type(driver, username, uname);
		Utility.type(driver, password, pass);
		Utility.type(driver, confirmPassword, pass);
		Utility.sleep(2);
		Utility.click(driver, saveButton);
		return Utility.getText(driver, successMsg);
		
	}
	
	
	
	public void logoutFromApplication()
	{
		driver.findElement(welcome).click();
	
		driver.findElement(logoutText).click();
	}
	
	public String getURLAfterLogout()
	{
		return driver.getCurrentUrl();
	}


}
