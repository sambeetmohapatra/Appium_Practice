/**
 * 
 */
package com.day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.POM.POM_DragAndDrop;
import com.utilities.Connect_Device;
import com.utilities.Mobile_Utility;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author sambeetmohapatra
 *
 */
@SuppressWarnings("rawtypes")
public class Test_DragAndDrop extends Mobile_Utility {

	
	private POM_DragAndDrop draganddrop;
	private DesiredCapabilities cap;
	private String expected_Basic_Header;


	@BeforeClass
	public void bc_config() throws Exception {
		cap = Connect_Device.connectDevice();
		cap.setCapability("appPackage", "com.mobeta.android.demodslv");
		cap.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void bm_config() {
		draganddrop = PageFactory.initElements(driver, POM_DragAndDrop.class);
		expected_Basic_Header ="Basic usage";
	}
	
	
	@Test
	public void verify_Drag_And_Drop(){
		
		//Click on Basic Usage Playground label
		Reporter.log("Click on Basic Usage Playground label",true);
		click(draganddrop.basic_Link);
		
		//Verify Basic Usage Page is displayed
		Reporter.log("Verify Basic Usage Page is displayed",true);
		Assert.assertEquals(draganddrop.basic_Header.getText(), expected_Basic_Header,"Header Mismatch = FAIL");
		
		/*Perform drag and drop operation
		 * 
		 */
		
		TouchAction act =  new TouchAction(driver);
		waitForElements(draganddrop.drag_handler);
		System.out.println(draganddrop.drag_handler.size());
		
		// Drag 1st element to 6th position
		Reporter.log("Drag 1st element to 6th position",true);

		act.longPress(draganddrop.drag_handler.get(0)).moveTo(draganddrop.drag_handler.get(5)).release().perform();
		customWait(3);
		
		goBack();
		
	}
	
	

	@AfterMethod
	public void ac_config(ITestResult i) {
		customWait(2);
		driver.quit();
		Reporter.log("Test Script Executed - " + i.getMethod().getMethodName().toUpperCase(), true);
		if(i.getStatus()==1)
		Reporter.log("Result : Success ", true);
		else if(i.getStatus()==2)
		Reporter.log("Result : Failure ", true);
	}
}
