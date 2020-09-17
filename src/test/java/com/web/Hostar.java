/**
 * 
 */
package com.web;

import org.testng.annotations.Test;

/**
 * @author sambeetmohapatra
 *
 */
public class Hostar extends BaseClass {
	
	public static String url = "https://www.hotstar.com/sports/hockey/qf-india-vs-netherlands/2001708841";

	@Test(invocationCount=10)
	public void run_hotstar() {
		launch_Browser(url);
		Wait(61);
		d.quit();
	}
}
