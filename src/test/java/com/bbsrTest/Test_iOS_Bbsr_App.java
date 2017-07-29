/**
 * 
 */
package com.bbsrTest;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

/**
 * @author sambeetmohapatra
 * PAGE OBJECTS FROM XML FILE 
 */
public class Test_iOS_Bbsr_App extends Base_Class{
	private HashMap<String, String> data;
	
	@Test
	@Parameters("device")
	public void test_iOS_Bbsr_App_01(String device) throws Exception {
		startServer();
		
		data = new HashMap<String, String>();
		data.put("name", "sambeet");
		data.put("phone", "9438455599");
		data.put("email", "sambeetabc2@icloud.com");
		data.put("address", "plot-295/2312, Jayadev Vihar, Odisha");
		data.put("query", "Which is the best place to Visit in Dec - march ");
		
		Reporter.log("Set Desired Capabilities - iOS",true);
		DesiredCapabilities caps = new DesiredCapabilities();
		
		
		if(device.equalsIgnoreCase("iphone")) 
		caps.setCapability("deviceName", "iPhone 6");
		else if(device.equalsIgnoreCase("ipad")) 
			caps.setCapability("deviceName", "iPad Air 2");
		
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "10.3"); 
		caps.setCapability("noReset", true);
		caps.setCapability("bundleId", "com.sam.Bhubaneswar");
		// Launch iOSDriver
		Reporter.log("Launch iOSDriver",true);
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Reporter.log("Step 1 : Validate the Bhubaneswar Header is displayed",true);

		WebElement bbsr_header = findElementByXpath("bhubaneswar_mainPage/bhubaneswar_header");
		Validate_Is_Displayed(bbsr_header);
		
		Reporter.log("Step 2 : Click on Images button in Nav bar",true);
		Validate_Is_Displayed(findElementByXpath("common_elements/nav_bar_images"));
		click(findElementByXpath("common_elements/nav_bar_images"));
		
		Reporter.log("Step 3 : Click on More button in Nav bar",true);
		Validate_Is_Displayed(findElementByXpath("common_elements/nav_bar_more"));
		click(findElementByXpath("common_elements/nav_bar_more"));
		
		
		Reporter.log("Step 4 : Validate Support is displayed",true);
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/support_header"));
		
		Reporter.log("Step 5 : Validate Elements displayed in the Support Section",true);
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/bhubaneswar_enquiry"));
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/name"));
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/phone"));
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/email"));
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/address"));
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/submitBtn"));
		Validate_Is_Displayed(findElementByXpath("bhubaneswar_supportpage/querytxtbox"));

		Reporter.log("Step 6 : Enter Data and Click on Submit Button",true);
		type(findElementByXpath("bhubaneswar_supportpage/name"), data.get("name"));
		type(findElementByXpath("bhubaneswar_supportpage/phone"), data.get("phone"));

		type(findElementByXpath("bhubaneswar_supportpage/email"), data.get("email"));

		type(findElementByXpath("bhubaneswar_supportpage/address"), data.get("address"));
		driver.hideKeyboard();
		type(findElementByXpath("bhubaneswar_supportpage/querytxtbox"), data.get("query"));
		driver.tap(1, findElementByXpath("bhubaneswar_supportpage/bhubaneswar_enquiry"), 1000);
		click(findElementByXpath("bhubaneswar_supportpage/submitBtn"));

		Reporter.log("Step 7 : Wait for and verify the alert is displayed",true);
		Alert alert = waitForAlert();
		alert.accept();
		
		Reporter.log("Step 8 : Navigate to Home Screen ",true);
		click(findElementByXpath("common_elements/nav_bar_featured"));
	}
	
}
