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
	
	
	@FindBy(id="com.mixappgood.libest:id/text_no_photo")
	public WebElement No_Wallpaper_Text;
	@FindBy(id="com.mixappgood.libest:id/container_no_photo")
	public WebElement No_Wallpaper_Container;
	@FindBy(id="com.mixappgood.libest:id/image_no_photo")
	public WebElement No_Wallpaper_Image;
	
	@FindBy(id="background")
	public WebElement AdPage;
	
	
	/*----------------FOLLOW SCREEN --------------------*/
	
	@FindBy(id="com.devmaxmil.analysis:id/textBalance")
	public WebElement Follow_header_label;
	
	@FindBy(id="com.devmaxmil.analysis:id/to_follow")
	public WebElement Thumbs_Up_Btn_Follow;
		
	@FindBy(xpath="//android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[@index='1']")
	public WebElement Followers_Btn;
	}
	
