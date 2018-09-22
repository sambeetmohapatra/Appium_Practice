/**
 * 
 */
package com.igs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author sambeetmohapatra
 *
 */
public class Home_Page_POM  {

	public Home_Page_POM(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	

	/* ---------------  Top Header Navigation ---------------*/
	@FindBy(id="com.mixappgood.libest:id/lblLikes")
	public WebElement Likes_header_label;
	
	@FindBy(xpath="//android.widget.Button[@text='rate the app']")
	public WebElement Rate_Btn;
	
	
	
	/* ---------------  HOME Screen ---------------*/
	@FindBy(xpath="//android.widget.RelativeLayout//*[contains(@class,'v7.app.ActionBar') and @index='0']")
	public WebElement Images_Btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout//*[contains(@class,'v7.app.ActionBar') and @index='1']")
	public WebElement Like_Btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout//*[contains(@class,'v7.app.ActionBar') and @index='2']")
	public WebElement Order_Btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout//*[contains(@class,'v7.app.ActionBar') and @index='3']")
	public WebElement Buy_More_Btn;
	

	
	/* ---------------  LIKES Screen ---------------*/

	@FindBy(id="com.mixappgood.libest:id/btnLike")
	public WebElement Thumbs_Up_Btn;
	
	@FindBy(id="com.mixappgood.libest:id/btnSkip")
	public WebElement Skip_Btn;
	
	@FindBy(id="com.mixappgood.libest:id/container_yes_photo")
	public WebElement Wallpaper_Image;
	
		
		
	}
	
