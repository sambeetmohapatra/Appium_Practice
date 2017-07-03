/**
 * 
 */
package com.day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.POM.POM_Send_SMS_Verify;
import com.utilities.Connect_Device;
import com.utilities.Mobile_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author sambeetmohapatra
 *
 */
@SuppressWarnings("rawtypes")
public class Test_Send_SMS_Verify extends Mobile_Utility {
	

	private POM_Send_SMS_Verify sendsms;
	private String exp_phone_number;
	private String message_input;
	private Iterator<WebElement> contacts_msg;
	private int flag;
	private DesiredCapabilities cap;

	
	@BeforeClass
	public void bc_config() throws Exception {
		cap = Connect_Device.connectDevice();
		cap.setCapability("appPackage", "com.google.android.apps.messaging");
		cap.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void bm_config() {
		sendsms = PageFactory.initElements(driver, POM_Send_SMS_Verify.class);
		exp_phone_number="911111";
		message_input="Welcome to Appium on MacOSX";
		flag =0;
	}

	@Test
	public void verify_SMS() {

		//Click on Send SMS Button 
		Reporter.log("Click on Send SMS Button",true);
		click(sendsms.new_msg_Btn);
		
		//Enter the phone number 
		Reporter.log("Enter the phone number "+exp_phone_number,true);
		type(sendsms.search_msg_Btn,exp_phone_number);
		pressKey(AndroidKeyCode.ENTER);
		
		//Verify the SMS Button is disabled
		Reporter.log("Verify the SMS Button is disabled ",true);
		Assert.assertFalse(sendsms.send_msg_Btn.isEnabled(),"Sens SMS button is enabled = FAIL");
		
		//Enter the message and click on send
		Reporter.log("Enter the message",true);
		type(sendsms.compose_msg_Text,message_input);
		Assert.assertTrue(sendsms.send_msg_Btn.isEnabled(),"Sens SMS button is disabled = FAIL");
		click(sendsms.send_msg_Btn);
		
		//Click on Back and verify the contact is displayed in the list
		Reporter.log("Click on Back and verify the contact is displayed in the list",true);
		
		goBack();goBack();
		
		waitForElements(sendsms.contacts_msg);
		contacts_msg = sendsms.contacts_msg.iterator();
		while(contacts_msg.hasNext()){
			if(contacts_msg.next().getText().trim().equals(exp_phone_number)){
				flag=1;
				break;
			}
		}
		
		Assert.assertTrue(flag==1,"Mismatch = FAIL");
		
	}

	@AfterMethod
	public void ac_config(ITestResult i) {
		customWait(2);
		driver.quit();
		Reporter.log("Test Script Executed - " + i.getMethod().getMethodName().toUpperCase(), true);
		if(i.getStatus()==1)
		Reporter.log("Result : Success ", true);
		else if(i.getStatus()==2)
		Reporter.log("Result : Failure ", true);
	}
}