package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.utilities.Mobile_Utility;

public class POM_DragAndDrop {
	
	@FindBy(xpath="//android.widget.TextView[@text='Basic usage']")
	public WebElement basic_Header;
	
	
	@FindBy(id="com.mobeta.android.demodslv:id/activity_title")
	public WebElement basic_Link;

	@FindBys(@FindBy(id="com.mobeta.android.demodslv:id/drag_handle"))
	public List<WebElement> drag_handler;
	
	@FindBy(xpath="//*[@index='0'][@text='CursorAdapter'][@class='android.widget.TextView']")
	public WebElement cursorAdapter_link;
	
	@FindBy(id="com.mobeta.android.demodslv:id/text")
	public List<WebElement> text_values;
	
	@FindBy(id="com.mobeta.android.demodslv:id/click_remove")
	public List<WebElement> text_remove_Btns;
	
	
	@FindBy(xpath="//*[@text='Michael Brecker'][@class='android.widget.TextView']")
	public WebElement michael_brecker_name;
}
