package com.ios;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.appium.java_client.ios.IOSDriver;


public class Test_iOS_App{
	

	private IOSDriver<WebElement> driver;
	private Process exec;
	
	
	@Test
	public void Test_iOS_App_Ui_Catalog() throws InterruptedException, IOException{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "10.3"); 
		caps.setCapability("deviceName", "iPhone Simulator");
		caps.setCapability("noReset", true);
		
		caps.setCapability("bundleid", "com.example.apple-samplecode.UICatalog");
		caps.setCapability("app", "/Users/sambeetmohapatra/Downloads/ios-uicatalog-master/build/Release-iphonesimulator/UICatalog.app"); 
		
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		 //Get the size of screen.
		  Dimension size = driver.manage().window().getSize();
		  System.out.println("size of screen"+size);
		   
		  int starty = (int) (size.height * 0.80);
		  
		  int endy = (int) (size.height * 0.20);
		  
		  int startx = size.width / 2;
		  
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		  //Swipe from Bottom to Top.
		  driver.swipe(startx, starty, startx, endy, 1000);
		  Thread.sleep(2000);
		  //Swipe from Top to Bottom.
		  driver.swipe(startx, endy, startx, starty, 1000);
		  Thread.sleep(2000);
		  
		 if(driver!=null)
			 driver.closeApp();
		
	}

@BeforeMethod
public void before_config() throws IOException, InterruptedException{
	String[] command = { "/usr/bin/killall", "-9", "node" };
	Runtime.getRuntime().exec(command);
	String[] commandProxy = { "/usr/bin/killall", "-9", "ios_webkit_debug_proxy" };
	Runtime.getRuntime().exec(commandProxy);
	//Start Appium Server 
	
	String start_server = "/usr/local/bin/node /usr/local/bin/appium";
	exec = Runtime.getRuntime().exec(start_server);
	Thread.sleep(8000);
			
	if(exec!=null)
		System.out.println("Started Appium Server");
	
	else
		System.out.println("Unable to launch Appium Server");
}

@AfterMethod
public void after_config(){
	//customize the below in stop appium server-
	driver.quit();
	//kill appium node after end of your execution
	String[] command = { "/usr/bin/killall", "-9", "node" };
	try {
	Runtime.getRuntime().exec(command);
	System.out.println("Appium server stopped.");
	} catch (IOException e) {
	e.printStackTrace();
	}
	//Kill webkit proxy for iOS
	String[] commandProxy = { "/usr/bin/killall", "-9", "ios_webkit_debug_proxy" };
	try {
	Runtime.getRuntime().exec(commandProxy);
	System.out.println("iOS Webkit proxy stopped");
	} catch (IOException e) {
	e.printStackTrace();
}
}
	
	
}
