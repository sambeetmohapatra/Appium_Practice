/**
 * 
 */
package com.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



/**
 * @author sambeetmohapatra
 *
 */
public class IG_POM extends BaseClass {

	public IG_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//h1[normalize-space()='Instagram']")
	public WebElement Ig_h1;
				
				@FindBy(css="input[name='username']")
				public WebElement username;
				@FindBy(css="input[name='password']")
				public WebElement password;
				@FindBy(css="button[type=submit]")
				public WebElement loginBtn;
				
				@FindBy(xpath="//h2[text()='Turn on Notifications']")
				public WebElement NotiFication_TurnOn;
				
				@FindBy(xpath="//button[text()='Not Now']")
				public WebElement NotiFication_NotNow;
				
				@FindBy(css="img[alt='Instagram']")
				public WebElement ImGIg;
				
				@FindBys({@FindBy(xpath="//*[name()='svg' and @aria-label='Like']/..")})
				public List<WebElement> likeBtn; 
				
				public void clickLikes(int loopVar) {
					for(int i=0;i<loopVar;i++) {
						Reporter.log("Total Pics "+likeBtn.size(),true);
								for(int j =0;j<likeBtn.size();j++) {
									JS_ScrollToView(likeBtn.get(j));
									Wait(1);
									JS_Click(likeBtn.get(j));
									Wait(1);
								}
								
					}
					d.quit();
				}
	}
	
