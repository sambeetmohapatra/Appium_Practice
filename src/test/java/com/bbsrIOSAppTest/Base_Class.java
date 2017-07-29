package com.bbsrIOSAppTest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.appium.java_client.ios.IOSDriver;

//ReportNG Listeners added
@Listeners({org.uncommons.reportng.HTMLReporter.class,org.uncommons.reportng.JUnitXMLReporter.class})
public class Base_Class {
	
	public static IOSDriver<WebElement> driver;
	public String device;
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
		   Wait(8);
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

	@Parameters("device")
	@BeforeSuite
	public void bs_config(String device) throws InterruptedException, IOException{
		// Run Appium Server
		this.device = device;
				Reporter.log("Run Appium Server",true);
				startServer();
	}
	
	@AfterSuite
	public void after_method() throws IOException {

		driver.quit();
		stopServer();
		Runtime.getRuntime().exec( "open /Users/sambeetmohapatra/Downloads/GIT/Appium_Practice_Android/test-output/html/index.html");
	}
	
	public void Wait(int seconds){
		try {
			Reporter.log("Waiting for : " + seconds + " second(s)",true);
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement waitForElement(WebElement wb){
		Reporter.log("Waiting for Element : "+wb,true);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public Alert waitForAlert(){
		Reporter.log("Waiting for Alert ",true);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.alertIsPresent());
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
		Reporter.log("Send Data :  "+wb,true);
	}
	
	public WebElement findElementByXpath(String PageName_ElementName) throws Exception {
		Reporter.log("Finding Element by xpath ",true);
		return waitForElement(driver.findElementByXPath(PageObjects_XML_Parser.get_Page_Object_XML_Parser(PageName_ElementName)));
	}
	
	public void Validate_Is_Displayed(WebElement wb) {
		Reporter.log("Validating Element by Displayed " + wb,true);
		Assert.assertTrue(isElementDisplayed(wb));

	}
}
