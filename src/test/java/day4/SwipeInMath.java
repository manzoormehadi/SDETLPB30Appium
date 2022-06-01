package day4;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeInMath {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
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
		TouchActions act= new TouchActions(driver);
		Dimension d= driver.manage().window().getSize();
		int width=d.width;
		int height=d.height;
		int x1=width/2;
		int y1=4*height/5;
		int x2=width/2;
		int y2=height/5;

		while(driver.findElements(AppiumBy.androidUIAutomator("UiSelector().text(\"Class 9 math (India)\")")).size()==0) {
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input swipe"+x1+" "+y1+" "+x2+" "+y2));
			Thread.sleep(3000);
		}
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Class 9 math (India)\")")).click();
	}

}
