package day3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class LoginIntodemoWebShop {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		ChromeOptions browserOptions= new ChromeOptions();
		browserOptions.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		browserOptions.setCapability(MobileCapabilityType.DEVICE_NAME, "Manzoor");
		browserOptions.setCapability("unicodeKeyboard", true);
		browserOptions.setCapability("resetKeyboard", true);
		
		WebDriver driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), browserOptions);
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("manz@mass.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("mass123");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		
	}
}