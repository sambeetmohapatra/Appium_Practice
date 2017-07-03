package com.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_Utility extends Connect_Device{
	public  AndroidDriver<WebElement> driver;
	
	public void customWait(int secs){
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitForElement(WebElement wb){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public void waitForElements(List<WebElement> wb){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElements(wb));
	}
	public void click(WebElement wb){
		waitForElement(wb);
		wb.click();
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
	
}
