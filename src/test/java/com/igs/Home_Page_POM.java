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
	@FindBy(xpath="//android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.developerincorp.likesforinstagram:id/lblLikes']")
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
	
	@FindBy(xpath="//android.widget.RelativeLayout//android.widget.EditText[@resource-id='com.developerincorp.likesforinstagram:id/link']")
	public WebElement Links_editbox;
	
	@FindBy(xpath="//android.widget.RelativeLayout//android.widget.ImageView[@resource-id='com.developerincorp.likesforinstagram:id/imgDetails']")
	public WebElement Image_details_view;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id='com.developerincorp.likesforinstagram:id/btnBack']")
	public WebElement Back_btn;


	
	/* ---------------  LIKES Screen ---------------*/

	@FindBy(id="com.developerincorp.likesforinstagram:id/btnLike")
	public WebElement Thumbs_Up_Btn;
	
	@FindBy(id="com.developerincorp.likesforinstagram:id/btnSkip")
	public WebElement Skip_Btn;
	
	@FindBy(id="com.developerincorp.likesforinstagram:id/glide_slider_viewpager")
	public WebElement Wallpaper_Image;
	
		
		
	}
	
