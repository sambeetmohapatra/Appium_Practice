package com.iOSTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class POM_iOS_TestApp extends Base_Class{
	
	public POM_iOS_TestApp(AppiumDriver<WebElement> driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="IntegerA")
	public WebElement Integer_A_txtbox;
	
	
	@FindBy(name="IntegerB")
	public WebElement Integer_B_txtbox;
	
	@FindBy(name="ComputeSumButton")
	public WebElement Sum_Btn;
	
	@FindBy(name="Answer")
	public WebElement Answer_Value;

	
	@FindBy(name="show alert")
	public WebElement show_Alert;

		// Alert Fields 
		@FindBy(name="Cool title")
		public WebElement Alert_title;

	
	
}
