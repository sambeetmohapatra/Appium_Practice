/**
 * 
 */
package com.naukri;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.web.BaseClass;

/**
 * @author sambeetmohapatra
 *
 */
public class NaukriWeb extends BaseClass {
	
	public static String url = "https://www.naukri.com/";
	private static String username ="souravabc123@gmail.com";
	public static String name = "Sourav Mohapatra";
	private static String password ="sourav_1996";
	//private int loopVar=10;
	

	@Test(invocationCount=2)
	public void run_ig() throws Exception {
		String cmds[] = {"killall","Google Chrome"};
		//Runtime.getRuntime().exec(cmds);
		launchBrowser(url);
		Naukri_POM ig=new Naukri_POM(d);
			
		waitForElement(ig.Naukri_Login,60);
		closeMultiWindows(url);
		JS_Click(ig.Naukri_Login);
		waitForElement(ig.username,60);
		type(ig.username, username);
		type(ig.password, password);
		JS_Click(ig.loginBtn);
		Wait(3);
		//Naukri profile loaded
		Reporter.log("Naukri profile loaded " +name,true);
		waitForElement(ig.Profile_Performance,100);
		
		//Click on Profile Name
		
		WebElement user = d.findElement(By.xpath("//div[text()='"+name+"']"));
		JS_Click(user);
		Reporter.log("Clicked on Profile Name " +name,true);
		Wait(2);
		waitForElement(ig.Resume_Headline,100);
		ig.getDataEnterData();
		Wait(120);
	}
	
	private void launchBrowser(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("/Users/sambeetmohapatra/Downloads/Torrent/extension_0_0_8_3.crx"));
		 //  options.addArguments("--kiosk"); // For Mac its --kiosk
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    d = new ChromeDriver(capabilities);
		    d.manage().window().setPosition(new Point(-2000,0));
		    d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
			d.get(url);
			System.out.println(d.getTitle().trim().toUpperCase());
			
	}
	
	private void closeMultiWindows(String s) {
		String mainTab = d.getWindowHandle();
		ArrayList<String> newTabs = new ArrayList<String>(d.getWindowHandles());
		newTabs.remove(mainTab);
		for( String i: newTabs) {
			d.switchTo().window(i);Wait(1);
			d.close();Wait(1);
			d.switchTo().window(mainTab);
		}
	}
}
