/**
 * 
 */
package com.naukri;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
public class OAOB extends BaseClass {
	
	public static String url = "http://oaob.nitrkl.ac.in/view/title/";
	//private int loopVar=10;
	

	@Test(invocationCount=1)
	public void run_ig() throws Exception {
		String cmds[] = {"killall","Google Chrome"};
		//Runtime.getRuntime().exec(cmds);
		launchBrowser(url);
		List<WebElement> odiaBooks = d.findElements(By.xpath("//div[text()='Please select a value to browse from the list below.']/..//ul//a/."));
		
		for(int i=0;i<odiaBooks.size();i++) {
			Wait(3);
			click(odiaBooks.get(i));
			Wait(3);
			WebElement bookLink = d.findElement(By.xpath("//div[contains(text(),'Number of items')]/..//a/."));
			click(bookLink);
			Wait(5);
			WebElement pdfLink = d.findElement(By.xpath("//a[contains(text(),'PDF')]/."));
			click(pdfLink);
			Wait(5);
			d.navigate().back();
			Wait(5);
			d.navigate().back();
			Wait(5);
		}
		
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
	
}
