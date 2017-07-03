/**
 * 
 */
package com.day1;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.POM_DragAndDrop;
import com.utilities.Connect_Device;
import com.utilities.Mobile_Utility;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author sambeetmohapatra
 *
 */
public class Test_Remove_Item extends Mobile_Utility{

	private DesiredCapabilities cap;
	private POM_DragAndDrop draganddrop;
	private String exp_value="Michael Brecker";

	@BeforeClass
	public void bc_config() throws Exception {
		cap = Connect_Device.connectDevice();
		cap.setCapability("appPackage", "com.mobeta.android.demodslv");
		cap.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void bm_config() {
		draganddrop = PageFactory.initElements(driver, POM_DragAndDrop.class);

	}
	
	@Test
	public void verify_remove_item(){
		customWait(2);
		Reporter.log("Remove Michael Brecker from the list",true);
		click(draganddrop.cursorAdapter_link);
		waitForElements(draganddrop.text_values);
		
		// Remove Michael Brecker from the list
		
		for(int i=0;i<draganddrop.text_values.size();i++){
			
			if(draganddrop.text_values.get(i).getText().equals(exp_value)){
				click(draganddrop.text_remove_Btns.get(i));
				Reporter.log(exp_value+ " is removed ",true);
				
				break;
			}
		}
		customWait(2);
		Reporter.log("Verify Michael Brecker is removed",true);

		//Verify Michael Brecker is removed
		for(WebElement ele:draganddrop.text_values){
			Assert.assertTrue(!(ele.getText().equals(exp_value)), exp_value + " : Value is still present");

		}
	
		
	}
}