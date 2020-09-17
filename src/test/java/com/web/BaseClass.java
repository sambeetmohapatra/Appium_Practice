package com.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public  class BaseClass {

	
	public static ChromeDriver d;

	public void launch_Browser(String url) {
		
		 ChromeOptions options = new ChromeOptions();
		 //  options.addArguments("--kiosk"); // For Mac its --kiosk
		    d = new ChromeDriver(options);
		    d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
			d.get(url);
			System.out.println(d.getTitle().trim().toUpperCase());
			
	}
	
	

	public void Wait(int seconds){
		try {
			Reporter.log("Waiting for : " + seconds + " second(s)",true);
			Thread.sleep(seconds*1000);
			System.out.println();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElement(WebElement wb){
		WebDriverWait wait = new WebDriverWait(d, 50);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public void waitForElement(WebElement wb,int TimeOut){
		System.out.println("Waiting For "+wb);
		WebDriverWait wait = new WebDriverWait(d,TimeOut);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public void waitForAlert(){
		WebDriverWait wait = new WebDriverWait(d, 20);
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
		System.out.println();

	}
	
	public void type(WebElement wb,String values){
		waitForElement(wb);
		wb.sendKeys(values);
		Reporter.log("Send Keys :  "+wb,true);
		System.out.println();
	}
	
	public void JS_Click(WebElement wb) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)d;
			executor.executeScript("arguments[0].click();", wb);
			
			Reporter.log("JS Clicked :  "+wb,true);
			
		}
		catch (Exception e) {
			
		System.out.println("Not Clicked");
		
		}
		
		System.out.println();
	}
	
	public void JS_ScrollToView(WebElement wb) {
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", wb);
		Wait(1);
	}
	
	public void ScrollToTop(WebElement wb) {
		
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView();", wb); 
		
	}
	
	public void ScrollToBottom() {
		
	((JavascriptExecutor) d).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	void JSwaitForLoad(long TimeOut ) {
		WebDriverWait wait = new WebDriverWait(d, TimeOut);
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}
	
	@AfterSuite
	public void quit() {
		Wait(2);
		d.quit();
		//System.exit(0);
	}
}

