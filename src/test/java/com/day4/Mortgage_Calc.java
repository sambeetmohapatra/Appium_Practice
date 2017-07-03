package com.day4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ios.Appium_Start_Stop_Android;
import com.utilities.Mobile_Utility;

import io.appium.java_client.android.AndroidDriver;

public class Mortgage_Calc extends Mobile_Utility{
	
	private Process exec;
	

	@Test
	public void run_calc() throws IOException, InterruptedException{
		Appium_Start_Stop_Android a = new Appium_Start_Stop_Android();
		a.start_server();
		
	DesiredCapabilities capabilities= new DesiredCapabilities();
	
	capabilities.setCapability("deviceName",  "Nexus 5");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion", "6.0.1");
	capabilities.setCapability("noReset", true);
	
	capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
	capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");
	
	driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	/*//Identify Price element and enter values
			driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("10000");
			//IdentifyYears and enter values
			driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
			//Identify Interest and enter values
			driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("12");
			
			//Identify  element and click on the btn
			driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
			
			//get the output
			String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
			System.out.println(Output);
			
			String Actual_Res = Output.replace("$", "");
			System.out.println(Actual_Res);
			
			String Expected_Res="222.44";
			
			Assert.assertEquals(Actual_Res, Expected_Res,"Error ==FAIL");*/
			Thread.sleep(3000);
			driver.quit();
			Reporter.log("End Execution",true);
		    
			a.stop_server();
		    
	}
}
