package com.day3;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilities.Connect_Device;
import com.utilities.Mobile_Utility;

import io.appium.java_client.android.AndroidDriver;

public class Test_Ola_App_Restricted extends Mobile_Utility {

	private DesiredCapabilities cap;

	@BeforeClass
	public void bc_config() throws Exception {
		cap = Connect_Device.connectDevice();
		cap.setCapability("appPackage", "com.olacabs.customer");
		cap.setCapability("appActivity", "com.olacabs.customer");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void verify_Ola_App_Restricted(){
		
		
	}
}
