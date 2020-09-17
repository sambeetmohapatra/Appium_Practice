/**
 * 
 */
package com.naukri;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.web.BaseClass;



/**
 * @author sambeetmohapatra
 *
 */
public class Naukri_POM extends BaseClass {

	public Naukri_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	@FindBy(css="a[title='Jobseeker Login']")
	public WebElement Naukri_Login;
				
				@FindBy(css="input[placeholder='Enter your active Email ID / Username']")
				public WebElement username;
				@FindBy(css="input[placeholder='Enter your password']")
				public WebElement password;
				@FindBy(css="button[type=submit]")
				public WebElement loginBtn;
				
				@FindBy(xpath="//span[text()='Profile Performance']")
				public WebElement Profile_Performance;
				
				@FindBy(xpath="//span[normalize-space()='Resume Headline' and contains(@class,'widget')]")
				public WebElement Resume_Headline;
				
				
				
				@FindBy(xpath="//span[normalize-space()='Resume Headline' and contains(@class,'widget')]/../following-sibling::div")
				public WebElement Resume_Headline_Text; 
				
				@FindBy(xpath="//span[normalize-space()='Resume Headline' and contains(@class,'widget')]/following-sibling::span")
				public WebElement Resume_Headline_PencilIcon;
				
				@FindBy(xpath="//form[@name='resumeHeadlineForm']")
				public WebElement resumeHeadlineForm;
				@FindBy(css="textarea[id='resumeHeadlineTxt']")
				public WebElement resumeHeadlineTxt;
				
				@FindBy(xpath="(//button[text()='Save'])[2]")
				public WebElement saveBtn;
				
				@FindBy(xpath="//li//span[text()='Personal Details']")
				public WebElement PersonalDetails;
				
				
				
				
				public void getDataEnterData() {
					
							waitForElement(Resume_Headline_Text,50);	
							String inp = Resume_Headline_Text.getText().toString().trim();
							Wait(1);
							JS_Click(Resume_Headline_PencilIcon);
							waitForElement(resumeHeadlineForm,50);
							Wait(1);
							resumeHeadlineTxt.clear();
							Wait(1);
							type(resumeHeadlineTxt, inp);
							Wait(1);
							JS_Click(saveBtn);
							waitForElement(Resume_Headline_PencilIcon,60);
							Reporter.log("Data Updated "+inp,true);
							Wait(4);
							JS_Click(PersonalDetails);
							Wait(2);
							d.quit();
					}
	}
	
