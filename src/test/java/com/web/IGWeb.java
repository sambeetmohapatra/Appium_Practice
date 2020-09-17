/**
 * 
 */
package com.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * @author sambeetmohapatra
 *
 */
public class IGWeb extends BaseClass {
	
	public static String url = "https://www.instagram.com/";
	private String username ="sambeet.m";
	private String password ="Unshake_1992";
	private int loopVar=1;
	

	@Test(invocationCount=2)
	public void run_ig() throws Exception {
		String cmds[] = {"killall","Google Chrome"};
		//Runtime.getRuntime().exec(cmds);
		launchBrowser(url);
			IG_POM ig=new IG_POM(d);
		waitForElement(ig.Ig_h1,60);
		type(ig.username, username);
		type(ig.password, password);
		JS_Click(ig.loginBtn);
		Wait(3);
		
		waitForElement(ig.NotiFication_TurnOn,25);
		
		waitForElement(ig.NotiFication_NotNow,10);
		ig.NotiFication_NotNow.click();
		Wait(3);
		waitForElement(ig.ImGIg,10);
		ig.clickLikes(loopVar);
	//	Runtime.getRuntime().exec(cmds);
	}
	
	private void launchBrowser(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("/Users/sambeetmohapatra/Downloads/Torrent/extension_0_0_8_3.crx"));
		 //  options.addArguments("--kiosk"); // For Mac its --kiosk
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    d = new ChromeDriver(capabilities);
		    d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
			d.get(url);
			System.out.println(d.getTitle().trim().toUpperCase());
			
	}
}
