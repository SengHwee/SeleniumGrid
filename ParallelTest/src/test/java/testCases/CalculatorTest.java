package testCases;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import devices.LocalDevices;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorTest{
	
	@Test
	public void sampleTest() {
		
		MobileElement one= LocalDevices.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_01"));
		MobileElement plus= LocalDevices.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
		MobileElement equals= LocalDevices.driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));

		one.click();
		plus.click();
		one.click();
		equals.click();
	}



}
