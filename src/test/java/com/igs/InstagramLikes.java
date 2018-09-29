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
public class InstagramLikes extends TestBase{
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
		System.out.println("Running Test : "+this.getClass().getName().trim());
		System.out.println("Launching App : "+this.pckg);
		
		String property = getProperty("likes", "./src/test/java/com/igs/Resource.properties");
		int number = Integer.parseInt(property.trim());
		noOfTimes=((number*10)/6);
		
		driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		home = new Home_Page_POM(driver);
		Reporter.log("PreRequsite : Wait For Main Page ",true);
		customWait(15);
		
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
				customWait(12);			
				click(home.Like_Btn);
				
					if(home.Skip_Btn.isDisplayed()) {
						break;
						}
					}
				catch(Exception e2) {
					click(home.Order_Btn);
					click(home.Like_Btn);
					customWait(1);
					
					break;
				}
				
			}
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Likes Page Not Displayed");
		
	//Step 2 : Increase Likes
		Reporter.log("Requested Likes : "+number ,true);
		Reporter.log("Step 2 : Increase Likes by "+noOfTimes +" no. of Time(s)",true);
		customWait(5);
		waitForElement(home.Skip_Btn);
		if(home.Skip_Btn.isDisplayed()) {
			Assert.assertTrue(true);
			for(int i =1;i<=noOfTimes;i++) {
			
				while(true) {
					customWait(10); 
				try {
					if(home.No_Wallpaper_Text.isDisplayed()) {
							if(i==1) {
							click(home.Skip_Btn);
							customWait(2);
							click(home.Order_Btn);
							customWait(2);
							click(home.Like_Btn);
							customWait(2); 
							}
							else
							{
								click(home.Skip_Btn);
								customWait(7);
							}
					}
						}
					
				catch(Exception e) {
							while(true) {	
								try {
									if(home.Thumbs_Up_Btn.isDisplayed()) {
									click(home.Thumbs_Up_Btn);
									Reporter.log("Clicked "+i +" time(s)",true);
									customWait(4); 
									break;
									}
								}
								catch (Exception e1) {
									goBack();
									customWait(20); 
									click(home.Thumbs_Up_Btn);
									Reporter.log("Clicked : "+i +" time(s)",true);
									customWait(4); 
									break;
							
									}
								}
					break;
					}
				}
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
		Reporter.log("Existing Likes : "+ ExistingLikesEarned,true);
		Reporter.log("Expected Likes : "+ ExpectedLikesEarned,true);
		Reporter.log("Total    Likes : "+ Double.parseDouble(home.Likes_header_label.getAttribute("text").trim()),true);
		
		}
	// Step 4 : Buy Likes
	}
	
	@AfterMethod
	public void am() {
		if(driver!=null)
			driver.quit();
	
		}
	}
	

