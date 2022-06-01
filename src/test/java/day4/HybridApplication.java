package day4;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridApplication {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomation");
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		capability.setCapability("unicodeKeyboard", true);
		capability.setCapability("resetKeyboard", true);
		RemoteWebDriver driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"India\")")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Manzoor");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

}
