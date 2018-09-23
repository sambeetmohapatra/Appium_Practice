package com.igs;

import java.io.IOException;

import org.testng.annotations.*;

import com.utilities.Mobile_Utility;

public class TestBase extends Mobile_Utility{

	@BeforeSuite
	public void beforeClass() {
		//startServer();
	}
	@AfterSuite
	public void afterClass() {
		//stopServer();
		try {
			customWait(2);
			Runtime.getRuntime().exec("open /Users/sambeetmohapatra/Downloads/GIT/Appium_Practice_Android/test-output/html/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
