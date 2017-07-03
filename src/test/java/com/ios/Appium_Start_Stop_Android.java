package com.ios;

import java.io.IOException;

import org.testng.Reporter;

public class Appium_Start_Stop_Android {

	
	private Process process;

	public void start_server() throws InterruptedException, IOException{
		Reporter.log("Start Execution",true);
		  process = Runtime.getRuntime().exec("/usr/bin/open -a /Applications/Utilities/Terminal.app /bin/bash /usr/local/bin/appium");
		    process.waitFor();	
		    Thread.sleep(8000);
	}
	
	public void stop_server(){
		
		process.destroyForcibly();
	}
}
