package com.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BoxOfficeMojo extends BaseClass {
	static String url = "https://www.boxofficemojo.com/";
	@Test(priority=0)
	public void check_news_mojo() {
		launch_Browser(url);
		JSwaitForLoad(100);
		waitForElement(d.findElement(By.cssSelector("#storyspc>h2>a")));
		WebElement News = d.findElement(By.cssSelector("#storyspc>h2>a"));
		if(isElementDisplayed(News)){
			Reporter.log(News.getText().trim().toUpperCase(),true);
			JS_Click(News);
			d.navigate().back();
			
			
		}
	}
	@Test(enabled=true,priority =1)
	public void worldwidetop5() {
		
		WebElement TopGrossing = d.findElement(By.xpath("//div[text()='Worldwide 2018']/following-sibling::div"));
		System.out.println(TopGrossing.getText().trim());
	}
}
