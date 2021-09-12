package com.learnautomation.hybrid.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.hybrid.dataProviders.ConfigUtility;

public class ConfigTest 
{
	@Test
	public void getValue()
	{
		Assert.assertNotNull(ConfigUtility.getProperty("browser"));
	}

}
