package androidscript;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestNGwithAndroid {
 //static String reportDirectory = "reports";
// static String reportFormat = "xml";
// static String testName = "testname";
 
 protected AndroidDriver<AndroidElement> driver;

 DesiredCapabilities dc = new DesiredCapabilities();
 
 @BeforeMethod
 public void setUp() throws MalformedURLException {

  //   dc.setCapability("reportDirectory", reportDirectory);
   //  dc.setCapability("reportFormat", reportFormat);
  //   dc.setCapability("testName", testName);
     dc.setCapability("deviceName", "Samsung S4");
  //   dc.setCapability("platformName", "Android");
 //    dc.setCapability("platformVersion", "5.0.1");
    // dc.setCapability("udid", "4b816499");
     dc.setCapability(MobileCapabilityType.UDID, "81dada59");
     dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
     dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
     
    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
     
  //   dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sec.android.app.popupcalculator");
   //  dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.sec.android.app.popupcalculator.Calculator");
   

     driver = new AndroidDriver<>(new URL("http://172.19.202.241:4444/wd/hub"), dc);
     
     driver.setLogLevel(Level.INFO);
 }

 @Test
 public void AppScript() {
 driver.rotate(ScreenOrientation.PORTRAIT);

 driver.hideKeyboard();
 
 driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
 driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
 driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.experitest.ExperiBank:id/makePaymentButton")));
     driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
     new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.experitest.ExperiBank:id/phoneTextField")));
     driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("0541234567");
     driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("Jon Snow");
     driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("50");
     driver.findElement(By.id("com.experitest.ExperiBank:id/countryButton")).click();
     driver.findElement(By.id("com.experitest.ExperiBank:id/Switzerland")).click();
     driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
     driver.findElement(By.id("com.experitest.ExperiBank:id/Yes")).click();
// driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
 //driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_01")).click();
 //driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();



 }

 @AfterMethod
 public void tearDown() {
     driver.quit();
 }
}

