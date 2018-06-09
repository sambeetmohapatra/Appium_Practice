/**
 * 
 */
package com.day4;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.utilities.Mobile_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author sambeetmohapatra
 *
 */
public class Test_Whatsapp extends Mobile_Utility {

	private DesiredCapabilities cap;

	@BeforeMethod
	public void bm() {

		cap = new DesiredCapabilities();
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "192.168.0.100:5555"); // wifi

		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("noReset", true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		
		cap.setCapability("appPackage", "com.whatsapp");
		cap.setCapability("appActivity", "com.whatsapp.HomeActivity");

}
	@Test
	public void test_whatsapp() throws MalformedURLException {

		driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		click(driver.findElementByXPath("//android.widget.TextView[@text='Chin2']"));
	}
	
	
	@AfterMethod
	public void am() {
		if(driver!=null)
			driver.quit();
	}
}
