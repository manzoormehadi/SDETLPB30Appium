package practise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class desktop {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		//capability.setCapability("deviceName", "Manzoor");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Manzoor");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='icon']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Computers')]//following-sibling::span")).click();
		driver.findElement(By.xpath("//li[@class='active']//ul//a[contains(text(),'Desktops')]")).click();
		WebElement drop=driver.findElement(By.xpath("//select[@id='products-orderby']"));
		Select sel = new Select(drop);
		sel.selectByVisibleText("Created on");

	}

}
