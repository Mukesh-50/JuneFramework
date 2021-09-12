package com.learnautomation.hybrid.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility 
{
	
	static Properties pro;
	
	public static String getProperty(String key)
	{
		createInstance();
		return pro.getProperty(key);
	}
	
	
	public static Properties createInstance()
	{
		
		if(pro==null)
		{
			System.out.println("LOG:INFO- Property is null - Loading Properties file");
			
			pro=new Properties();
			
			try 
			{
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
				
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("File does not exist "+e.getMessage());

			} catch (IOException e) 
			{
				System.out.println("Could not load file "+e.getMessage());
			}
			return pro;
		}
		else
		{
			System.out.println("LOG:INFO- Property exists - reusing existing file");
			return pro;
		}
		
		
	}

}
