package devices;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;



public class LocalDevices {
	
	public static AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void setup(){
	
	DesiredCapabilities caps = new DesiredCapabilities();
	
	//Define mobile parameter
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

	//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0"); 	//version number not needed, will cause error
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S9");
	caps.setCapability(MobileCapabilityType.UDID, "22b222b23d047ece");

	//caps.setCapability(MobileCapabilityType.VERSION, "6.0.1"); //version number not needed, will cause error
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy Note 4");
	caps.setCapability(MobileCapabilityType.UDID, "81dada59");
			
	//		caps.setCapability(MobileCapabilityType.VERSION, "5.0.1"); //version number not needed, will cause error
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung S4");
	caps.setCapability(MobileCapabilityType.UDID, "4b816499");	
			
	//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1"); //version number not needed, will cause error
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy Note 4"); //Ben's device
	caps.setCapability(MobileCapabilityType.UDID, "4222c2db");	

}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
