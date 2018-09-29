/**
 * 
 */
package com.igs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author sambeetmohapatra
 *
 */
public class InstagramFollowers extends TestBase{
	private DesiredCapabilities cap;
	private String pckg ="com.devmaxmil.analysis";
	private String activity ="com.devmaxmil.analysis.views.activity.StartActivity";
	public Home_Page_POM home;
	
	private int noOfTimes;
	private static double value_existing;

	@BeforeMethod
	public void bm() throws Exception {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Nexus 5"); // wifi
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("noReset", true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		cap.setCapability("appPackage", pckg);
		cap.setCapability("appActivity", activity );

}
	@Test(description=" Automate and increase Instagram Followers",priority=2,invocationCount=1)
	public void test_instagram_followers() throws MalformedURLException {
		System.out.println("Running Test : "+this.getClass().getName().trim());
		System.out.println("Launching App : "+this.pckg);

		String property = getProperty("followers", "./src/test/java/com/igs/Resource.properties");
		int number = Integer.parseInt(property.trim());
		noOfTimes=((number*10)/6);
		
		driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		home = new Home_Page_POM(driver);
		Reporter.log("PreRequsite : Wait For Main Page ",true);
		customWait(10);
		
		//Step 1 : Go To Followers Tab 
		Reporter.log("Step 1 : Go To Followers Tab ",true);
		waitForElement(home.Follow_header_label);
		
		//Calculate existing added
		 value_existing = Double.parseDouble(home.Follow_header_label.getAttribute("text").trim());
		double ExistingFollowEarned = Math.round(value_existing * 100D) / 100D;
		Reporter.log("Existing Followers : " +ExistingFollowEarned ,true);
		if(home.Follow_header_label.isDisplayed()) {
			customWait(15); //Wait 10 seconds
			if(home.Followers_Btn.isDisplayed());{
				click(home.Followers_Btn);
			}
			
			while(true) {
			if(home.Thumbs_Up_Btn_Follow.isDisplayed()) 
				break;
			else 
				click(home.Followers_Btn);
			}
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Followers Page Not Displayed");
		
	//Step 2 : Increase Followers
		Reporter.log("Step 2 : Increase Followers by "+noOfTimes +" no. of Time(s)",true);
		waitForElement(home.Thumbs_Up_Btn_Follow);
		if(home.Thumbs_Up_Btn_Follow.isDisplayed()) {
			Assert.assertTrue(true);
			for(int i =1;i<=noOfTimes;i++) {
				customWait(10); 
			
				while(true) {
				try {
						(home.Thumbs_Up_Btn_Follow).click();
						Reporter.log("Clicked "+i +" time(s)",true);
						customWait(2); 
						if(i== noOfTimes/2) {
							click(home.Order_Btn);
							customWait(1);
							click(home.Followers_Btn);
							customWait(1);
						}
						break;
					}
					catch(Exception e) {
						goBack();
						waitForElement(home.Thumbs_Up_Btn_Follow);
						break;
					}
					
				}
				if(noOfTimes!=1)
					customWait(5); //Wait 5 seconds
				}
			
		}
			
			else
				Assert.fail("Followers Page Not Displayed correctly");
				
	}
	
	@AfterMethod
	public void am() {
		if(driver!=null)
			driver.quit();
		}
	}
	

