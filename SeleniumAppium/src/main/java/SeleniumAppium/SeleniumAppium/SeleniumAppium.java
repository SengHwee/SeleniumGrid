package SeleniumAppium.SeleniumAppium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SeleniumAppium {
	
	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args)  {
		
		try {
			openCalculator();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		

	}
	public static void openCalculator() throws Exception  {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		//cap.setCapability("deviceName", "Samsung Galaxy S9");
		//cap.setCapability("udid", "22b222b23d047ece");
		cap.setCapability("deviceName", "Samsung Galaxy Note 4");
		//cap.setCapability("udid", "81dada59");	//Test Device
		cap.setCapability("udid", "4222c2db");		//Ben's Device
		//cap.setCapability("deviceName", "Samsung Galaxy S4");
		//cap.setCapability("udid", "4b816499");
		
		
		
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		URL url = new URL ("http://localhost:4444/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Open");
		
		MobileElement one= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_01"));
		MobileElement plus= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
		MobileElement equals= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
		
		one.click();
		plus.click();
		one.click();
		equals.click();
		
		driver.quit();
		
		
	}
}