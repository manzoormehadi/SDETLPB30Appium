package day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchGoogleApplicationInMobile {

	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		browserOptions.setCapability(MobileCapabilityType.DEVICE_NAME, "Manzoor");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), browserOptions);
		driver.get("http://www.google.com");
	}

}