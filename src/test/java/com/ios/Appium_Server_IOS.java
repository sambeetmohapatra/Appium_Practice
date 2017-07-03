package com.ios;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

/**
 *  Appium_Server_ Start and Stop ... NOTE : Results Will be displayed in the console during execution
 * @author sambeetmohapatra
 *
 */
public class Appium_Server_IOS {
		 
		public void startServer() {
	 
			CommandLine command = new CommandLine(
					"/usr/local/bin/node");
			command.addArgument(
					"/usr/local/bin/appium",
					false);
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(1);
			try {
				executor.execute(command, resultHandler);
				Thread.sleep(10000);
				System.out.println("Appium server started.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	 
		public void stopServer() {
			String[] command = { "/usr/bin/killall", "-KILL", "node" };
			try {
				Runtime.getRuntime().exec(command);
				System.out.println("Appium server stopped.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void main(String[] args) {
			Appium_Server_IOS as = new Appium_Server_IOS();
					as.startServer();
			System.out.println("hello");
				as.stopServer();
		}
}
