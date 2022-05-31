package day2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class launchKhanAcademy {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomation");
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		AppiumDriver driver= new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);

	}

}
