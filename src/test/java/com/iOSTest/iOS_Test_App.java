/**
 * 
 */
package com.iOSTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

/**
 * @author sambeetmohapatra
 * iOS_Test_App
 */
public class iOS_Test_App extends Base_Class {

	@BeforeSuite
	public void bs_config() throws InterruptedException, IOException{
		// Run Appium Server
				Reporter.log("Run Appium Server",true);
				startServer();
	}
	@Test(invocationCount=1)
	public void test_ios_App() throws MalformedURLException{
		
		
		
		//Set Desired Capabilities
		Reporter.log("Set Desired Capabilities - iOS",true);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "10.3"); 
		caps.setCapability("deviceName", "iPhone Simulator");
		caps.setCapability("noReset", true);
		
		caps.setCapability("bundleId", "io.appium.TestApp");
		//caps.setCapability("app", "/Users/sambeetmohapatra/Downloads/ios-test-app-master/build/Release-iphonesimulator/TestApp.app"); 
		// Launch iOSDriver
		Reporter.log("Launch iOSDriver",true);
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Create object of POM Class
		Reporter.log("Create object of POM Class",true);

		POM_iOS_TestApp test_app = new POM_iOS_TestApp(driver);
		// Perform Actions on iOS Test App 
		
		Reporter.log("Sum Operation",true);
		type(test_app.Integer_A_txtbox	, "200");
		type(test_app.Integer_B_txtbox	, "100");
		click(test_app.Sum_Btn);
		
		waitForElement(test_app.Answer_Value);
		Reporter.log("Answer is "+test_app.Answer_Value.getText(),true);
		Assert.assertTrue(test_app.Answer_Value.getText().equals("300"));
		
		// Click on Alert 
		
		Reporter.log("Click on Alert ",true);
		
		click(test_app.show_Alert);
		waitForAlert();
		Assert.assertTrue(isElementDisplayed(test_app.Alert_title));
		Reporter.log("Alert Title is : "+test_app.Alert_title.getText().trim(),true);
		driver.switchTo().alert().dismiss();
		
		click(test_app.show_Alert);
		waitForAlert();
		Assert.assertTrue(isElementDisplayed(test_app.Alert_title));
		Reporter.log("Alert Title is : "+test_app.Alert_title.getText().trim(),true);
		driver.switchTo().alert().accept();
		
		
	}
	
	@AfterMethod
	public void am_config(){
		Wait(1);
		if(driver!=null)
			driver.quit();
	}
	@AfterSuite
	public void as_config(){
		//Stop Appium Server
				Reporter.log("Stop Appium Server",true);
				stopServer();
	}
}
