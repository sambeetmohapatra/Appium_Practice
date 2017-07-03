package com.utilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class Connect_Device {

	private static DesiredCapabilities cap;

	public  static DesiredCapabilities connectDevice(){
		//Connect to Device - Nexus 5
		cap = new DesiredCapabilities();
//		cap.setCapability("deviceName", "0762a69df0eafb0d"); //usb
		cap.setCapability("deviceName", "172.20.10.2:5555"); // wifi

		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("noReset", true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		return cap;
	}
}
