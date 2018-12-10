package com.web;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Youtube_Views extends BaseClass {
	String url ="https://www.proxysite.com/";
	@Test(invocationCount=10)
	public void youtube_views_increase() {
		// Enter Youtube URL Here
		
		String youtube_url= "https://www.youtube.com/watch?v=75lwspp5dQE";
		
		
		launch_Browser(url);
		JSwaitForLoad(100);
		waitForElement(d.findElement(By.xpath("//img[@alt='ProxySite.com']")));
		if(isElementDisplayed(d.findElement(By.xpath("//img[@alt='ProxySite.com']")))) {
			type(d.findElement(By.xpath("(//input[@placeholder='Enter Url'])[1]")), youtube_url);
			Wait(1);
			JS_Click(d.findElement(By.xpath("(//input[@placeholder='Enter Url']/following-sibling::button)[1]")));
			waitForElement(d.findElement(By.cssSelector("#eow-title")));
			System.out.println(d.findElement(By.cssSelector("#eow-title")).getText().trim().toUpperCase());
			//JS_ScrollToView(d.findElement(By.cssSelector("#eow-title")));
			System.out.println("Likes : " + d.findElement(By.xpath("(//div[contains(@id,'views-info')]/following-sibling::span//button/span)[1]")).getText());
			
		}
		Wait(125);
		d.quit();
	}
}
