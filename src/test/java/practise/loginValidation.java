package practise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class loginValidation {
	public WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("xy49312@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("xyz123");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		Thread.sleep(2000);
		String expected="xy49312@gmail.com";
		String actual=driver.findElement(By.xpath("//a[text()='xy49312@gmail.com']")).getText();
		Assert.assertEquals(actual, expected);
	}
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		browserOptions.setCapability(MobileCapabilityType.DEVICE_NAME, "Manzoor");
		browserOptions.setCapability("unicodeKeyboard", true);
		browserOptions.setCapability("resetKeyboard", true);
		
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), browserOptions);
		
		driver.get("http://demowebshop.tricentis.com/login");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
