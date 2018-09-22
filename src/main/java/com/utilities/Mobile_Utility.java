package com.utilities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
@Listeners({org.uncommons.reportng.HTMLReporter.class,org.uncommons.reportng.JUnitXMLReporter.class})
public class Mobile_Utility extends Connect_Device{
	private static final long TimeOut = 30;
	public  AndroidDriver<WebElement> driver;
	public static Process process;
	
	public void customWait(int secs){
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitForElement(WebElement wb){
		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	public void waitForElements(List<WebElement> wb){
		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(wb));
	}
	public void click(WebElement wb){
		wb.click();
		System.out.println("Clicked on"+wb);
	}
	
	public void type(WebElement wb,String values){
		waitForElement(wb);
		wb.clear();
		wb.sendKeys(values);
	}
	
	public void pressKey(int androidKeyCode){
		driver.pressKeyCode(androidKeyCode);
	}
	
	public void goBack(){
		driver.navigate().back();

	}
	public void swipeDown_Vertical(int noOfTimes){
		//Get the size of screen.
		  Dimension size = driver.manage().window().getSize();
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  //int startx = size.width / 2;
		  int startx = (int) (size.width * 0.70);

		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		for(int i = 0 ;i<noOfTimes;i++){
		driver.swipe(startx, starty, startx, endy, 1000);
		}
	}
	
	public void swipeUp_Vertical(int noOfTimes){
		//Get the size of screen.
		  Dimension size = driver.manage().window().getSize();
		  int starty = (int) (size.height * 0.60);
		  int endy = (int) (size.height * 0.20);
		  int startx = (int) (size.width * 0.70);
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		for(int i = 0 ;i<noOfTimes;i++){
		driver.swipe(startx, endy, startx, starty, 1000);
		}
	}
	
	public void startServer() throws InterruptedException, IOException{
		Reporter.log("Start Execution",true);
		  process = Runtime.getRuntime().exec("/usr/bin/open -a /Applications/Utilities/Terminal.app /bin/bash /usr/local/bin/appium");
		    process.waitFor();	
		    Thread.sleep(8000);
	}
	
	public void stopServer(){
		
		process.destroy();
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
