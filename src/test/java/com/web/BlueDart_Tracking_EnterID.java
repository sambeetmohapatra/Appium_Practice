package com.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BlueDart_Tracking_EnterID extends BaseClass {
	static String url ="https://www.bluedart.com/home";
	
	static String[] trackingid = {"35729344151"};
	@Test
	public void Test_BlueDart_Tracking_EnterID() {
		launch_Browser("https://www.bluedart.com/home");
	try {	
		for(int i=0;i<trackingid.length;i++) {
		d.navigate().to(url);
		
		JSwaitForLoad(50);
		JS_Click(d.findElement(By.cssSelector("#upArrow")));
		type(d.findElement(By.cssSelector("#trackingNoTrackDart")), trackingid[i]);
		click(d.findElement(By.cssSelector("#goBtnTrackDart")));
		JSwaitForLoad(50);
		waitForElement(d.findElement(By.xpath("//label[contains(text(),'Expected Date of Delivery')]/..")));
		JSwaitForLoad(50);
		if(d.findElement(By.xpath("//th[contains(text(),'Waybill No')]/../td[1]")).getText().trim().contains(trackingid[i])) {
		WebElement Expected_Delivery = d.findElement(By.xpath("//label[contains(text(),'Expected Date of Delivery')]/.."));
		Reporter.log("Details : "+Expected_Delivery.getText().trim(),true);
		Reporter.log("****************************************",true);
		System.out.println();
		//PART 1
		WebElement Details = d.findElement(By.xpath("//th[contains(text(),'Expected Date of Delivery')]/ancestor::table[1]"));
		Reporter.log("Full Details : "+Details.getText(),true);
		System.out.println();
		Reporter.log("****************************************",true);
		System.out.println();
	
		
		
		//PART 2
		waitForElement(d.findElement(By.xpath("//a[normalize-space()='Status and Scan']")));
		JS_Click(d.findElement(By.xpath("//a[normalize-space()='Status and Scan']")));
		JSwaitForLoad(50);
		waitForElement(d.findElement(By.xpath("//th[normalize-space()='Status and Scans']")));
		if(isElementDisplayed(d.findElement(By.xpath("//th[normalize-space()='Status and Scans']")))) {
			String VerboseStatus = d.findElement(By.xpath("//th[normalize-space()='Status and Scans']/ancestor::table")).getText().trim();
			System.out.println();
			
			Reporter.log("****************************************",true);
			Reporter.log(VerboseStatus.toUpperCase(),true);
			Reporter.log("****************************************",true);
			
			System.out.println();
			Wait(1);
		}
		}
		JSwaitForLoad(10);
		JS_Click(d.findElement(By.cssSelector("span[id='moreDiv']")));
	}
	
	}
	catch(Exception e) {
		System.out.println("TRACKING ID Doesn't exist " +trackingid);
	}
	}
}
