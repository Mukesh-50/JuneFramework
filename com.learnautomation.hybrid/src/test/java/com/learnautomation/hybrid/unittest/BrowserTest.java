package com.learnautomation.hybrid.unittest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.hybrid.factory.BrowserFactory;

public class BrowserTest 
{
	
	@Test
	public void testBrowser()
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://www.google.com");
		Assert.assertNotNull(driver);
		driver.quit();
		
	}

}
