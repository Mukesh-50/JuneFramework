package com.learnautomation.hybrid.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.hybrid.dataProviders.ExcelUtility;

public class ExcelTest 
{
	
	@Test
	public void testExcel()
	{
		Assert.assertNotNull(ExcelUtility.getDataFromExcel("login"));	
	}

}
