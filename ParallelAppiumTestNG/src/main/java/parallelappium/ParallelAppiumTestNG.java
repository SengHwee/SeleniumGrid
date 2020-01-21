package parallelappium;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ParallelAppiumTestNG {

	static AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup () {

		try {
			DesiredCapabilities caps = new DesiredCapabilities();

			//Define mobile parameter
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

			//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0"); 	//version number not needed, will cause error
			//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S9");
			//		caps.setCapability(MobileCapabilityType.UDID, "22b222b23d047ece");

			//		caps.setCapability(MobileCapabilityType.VERSION, "6.0.1"); //version number not needed, will cause error
			//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy Note 4");
			//		caps.setCapability(MobileCapabilityType.UDID, "81dada59");
			//		
			//		caps.setCapability(MobileCapabilityType.VERSION, "5.0.1"); //version number not needed, will cause error
			//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung S4");
			//		caps.setCapability(MobileCapabilityType.UDID, "4b816499");
			//		
					
			//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1"); //version number not needed, will cause error
					caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy Note 4"); //Ben's device
					caps.setCapability(MobileCapabilityType.UDID, "4222c2db");	
					
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			//		
			//open Application
			caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
			caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

			URL url = new URL ("http://localhost:4444/wd/hub");
			driver= new AndroidDriver<AndroidElement> (url,caps);

		}catch(Exception exp) {
			System.out.println("Cause is: " +exp.getCause());
			System.out.println("Message is: " +exp.getMessage());
			exp.printStackTrace();
		}
	}


	@Test
	public void sampleTest() {
		MobileElement one= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_01"));
		MobileElement plus= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
		MobileElement equals= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));

		one.click();
		plus.click();
		one.click();
		equals.click();
	}


	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
