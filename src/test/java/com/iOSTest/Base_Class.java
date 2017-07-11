package com.iOSTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import io.appium.java_client.AppiumDriver;

//ReportNG Listeners added
@Listeners({org.uncommons.reportng.HTMLReporter.class,org.uncommons.reportng.JUnitXMLReporter.class})
public class Base_Class {
	
	public static AppiumDriver<WebElement> driver;

	private Process process;

	/*public void startServer() {
		 //Displays on the terminal
		  * 
		CommandLine command = new CommandLine(
				"/usr/local/bin/node");
		command.addArgument(
				"/usr/local/bin/appium",
				false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(10000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
	public void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
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
	
	public void Wait(int seconds){
		try {
			Reporter.log("Waiting for : " + seconds + " second(s)",true);
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElement(WebElement wb){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public void waitForAlert(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean isElementDisplayed(WebElement wb){
		
		if(wb.isDisplayed())
			return true;
		else 
			return false;
	}
	public void click(WebElement wb){
		waitForElement(wb);
		wb.click();
		Reporter.log("Clicked :  "+wb,true);

	}
	
	public void type(WebElement wb,String values){
		waitForElement(wb);
		wb.clear();
		wb.sendKeys(values);
		Reporter.log("Send Keys :  "+wb,true);
	}
	
	
}
