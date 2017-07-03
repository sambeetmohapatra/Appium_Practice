package com.ios;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class Webbased_app {

	private IOSDriver<WebElement> driver;
	private Process exec;	
	
@Test
public  void Test_ios_web_App() throws InterruptedException, IOException {
			
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "10.3"); 
		caps.setCapability("deviceName", "iPhone Simulator"); 
		caps.setCapability("bundleId","TAmobiletest.safarlauncher");
		caps.setCapability("noReset", true);

		//caps.setCapability("app", safariLauncher); 

		driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);

		Set<String> contextHandles = driver.getContextHandles();
		System.out.println(contextHandles.size());
		
		for(String contextname:contextHandles)
		{
			System.out.println(contextname);
			
			if(contextname.contains("WEBVIEW"))
			{
				driver.context(contextname);
			}
			
			
		}
		driver.get("https://in.yahoo.com/");
		
		driver.findElementById("placeHolder-search-btn").click();
		
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys("India"+"\n");
		
		Thread.sleep(2000);
		
		
		
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
