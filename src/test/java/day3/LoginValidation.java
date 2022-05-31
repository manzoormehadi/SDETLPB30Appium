package day3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class LoginValidation {
	WebDriver driver;
	@Test
	public void loginApplication() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("manz@mass.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("mass123");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		Thread.sleep(3000);
		String expected="manz@mass.com";
		String actual=driver.findElement(By.linkText("manz@mass.com")).getText();
		Assert.assertEquals(actual, expected);
	}

	@BeforeClass
	public void lauchBrowser() throws MalformedURLException {
		ChromeOptions browserOptions= new ChromeOptions();
		browserOptions.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		browserOptions.setCapability(MobileCapabilityType.DEVICE_NAME, "Manzoor");
		browserOptions.setCapability("unicodeKeyboard", true);
		browserOptions.setCapability("resetKeyboard", true);
		driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), browserOptions);
		driver.get("http://demowebshop.tricentis.com/login");
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
