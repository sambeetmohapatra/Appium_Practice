package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.utilities.Mobile_Utility;

public class POM_Send_SMS_Verify extends Mobile_Utility{

	@FindBy(id ="com.google.android.apps.messaging:id/start_new_conversation_button")
	public  WebElement new_msg_Btn;
	
	@FindBy(id="com.google.android.apps.messaging:id/recipient_text_view")
	public  WebElement search_msg_Btn;
	
	@FindBy(id="com.google.android.apps.messaging:id/compose_message_text")
	public WebElement compose_msg_Text;
	
	@FindBy(id="com.google.android.apps.messaging:id/send_message_button_icon")
	public WebElement send_msg_Btn;
	
	@FindBys(@FindBy (id ="com.google.android.apps.messaging:id/conversation_name"))
	public List<WebElement> contacts_msg;
	
	
	
}
