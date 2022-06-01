package day4;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClickMathInExplore {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomation");
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		RemoteWebDriver driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("Search tab")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Math\")")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Class 9 (Foundation)\")")).click();
		}

}
