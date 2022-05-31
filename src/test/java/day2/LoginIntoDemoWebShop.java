package day2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginIntoDemoWebShop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		/*DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		//capability.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");*/
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		browserOptions.setCapability(MobileCapabilityType.DEVICE_NAME, "Manzoor");
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), browserOptions);
		
		//AndroidDriver driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),options);
		driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("manz@mass.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("mass123");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
	}

}
