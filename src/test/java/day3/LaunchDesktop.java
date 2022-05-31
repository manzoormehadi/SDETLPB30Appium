package day3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchDesktop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		ChromeOptions browserOptions= new ChromeOptions();
		browserOptions.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		browserOptions.setCapability(MobileCapabilityType.DEVICE_NAME, "Manzoor");
		browserOptions.setCapability("unicodeKeyboard", true);
		browserOptions.setCapability("resetKeyboard", true);
		
		WebDriver driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), browserOptions);
		driver.get("http://demowebshop.tricentis.com");
		driver.findElement(By.xpath("//*[@id='mob-menu-button']//span[@class='icon']")).click();
		driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//*[contains(text(),'Computers')]//following-sibling::span")).click();
		driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//*[contains(text(),'Desktops')]")).click();
		Thread.sleep(3000);
		WebElement product=driver.findElement(By.xpath("//select[@id='products-orderby']"));
		Select sel= new Select(product);
		sel.selectByVisibleText("Name: A to Z");
	}

}
