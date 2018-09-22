/**
 * 
 */
package com.igs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.Mobile_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author sambeetmohapatra
 *
 */
public class InstagramLikes extends Mobile_Utility{
	private DesiredCapabilities cap;
	private String pckg ="com.mixappgood.libest";
	private String activity ="com.mixappgood.libest.StartActivity";
	public Home_Page_POM home;
	
	private int noOfTimes; 
	private static double value_existing;

	@BeforeMethod
	public void bm() throws Exception {
		//startServer();
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Nexus 5"); // wifi
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("noReset", true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		cap.setCapability("appPackage", pckg);
		cap.setCapability("appActivity", activity );

}
	@Test(description=" Automate and increase Instagram Likes",priority=1,invocationCount=1)
	public void test_instagram_likes() throws MalformedURLException {
		String property = getProperty("followers", "./src/test/java/com/igs/Resource.properties");
		noOfTimes = Integer.parseInt(property.trim());
		
		driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		home = new Home_Page_POM(driver);
		Reporter.log("PreRequsite : Wait For Main Page ",true);
		customWait(10);
		
		//Step 1 : Go To Likes Tab 
		Reporter.log("Step 1 : Go To Likes Tab ",true);
		waitForElement(home.Likes_header_label);
		
		//Calculate existing likes
		 value_existing = Double.parseDouble(home.Likes_header_label.getAttribute("text").trim());
		double ExistingLikesEarned = Math.round(value_existing * 100D) / 100D;
		Reporter.log("Existing Likes : " +ExistingLikesEarned ,true);
		if(home.Likes_header_label.isDisplayed() ||home.Rate_Btn.isDisplayed() ) {
			while(true) {
				try {
					customWait(10);			 //Wait 10 seconds
					click(home.Like_Btn);
					if(home.Thumbs_Up_Btn.isDisplayed() || home.Wallpaper_Image.isDisplayed() || home.Skip_Btn.isDisplayed()) {
						break;
						}
					}
				catch(Exception e) {
					Assert.fail("Images Not Displayed");
				}
				
			}
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Likes Page Not Displayed");
		
	//Step 2 : Increase Likes
		Reporter.log("Step 2 : Increase Likes by "+noOfTimes +" no. of Time(s)",true);
		waitForElement(home.Thumbs_Up_Btn);
		if(home.Thumbs_Up_Btn.isDisplayed() || home.Wallpaper_Image.isDisplayed()) {
			Assert.assertTrue(true);
			
			for(int i =1;i<=noOfTimes;i++) {
			customWait(5); 
			
				while(true) {
					customWait(5); 
				try {
					if(home.No_Wallpaper_Text.isDisplayed()) {
							home.Skip_Btn.click();
							customWait(2); 
					}
				}
					catch(Exception e) {
						(home.Thumbs_Up_Btn).click();
						Reporter.log("Clicked "+i +" time(s)",true);
						customWait(2); 
						break;
					}
					
					}
				if(noOfTimes!=1)
					customWait(5); //Wait 5 seconds
				}
			
		}
			
			else
				Assert.fail("Likes Page Not Displayed correctly");
				
	// Step 3 : Validate No of Likes Earned
	Reporter.log("Step 3 : Validate No of Likes Earned ",true);
	customWait(1); 
	waitForElement(home.Images_Btn);
	click(home.Images_Btn);
	if(home.Likes_header_label.isDisplayed()) {
		String ExpectedLikesEarned = (Math.round((noOfTimes*0.6)* 100D) / 100D )+"";
		Reporter.log(" Expected Likes : "+ ExpectedLikesEarned,true);
		Reporter.log(" Total    Likes : " + Double.parseDouble(home.Likes_header_label.getAttribute("text").trim()),true);

		}
	// Step 4 : Buy Likes
	//buyLikes(imageIndex, BuyQuantity, home);
	}
	
	@AfterMethod
	public void am() {
		if(driver!=null)
			driver.quit();
		try {
			Runtime.getRuntime().exec("open /Users/sambeetmohapatra/Downloads/GIT/Appium_Practice_Android/test-output/html/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stopServer();
		}
	}
	

