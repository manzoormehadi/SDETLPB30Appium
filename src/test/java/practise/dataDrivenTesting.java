package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class dataDrivenTesting {
	
	public static void main(String[] args) throws IOException {
		DesiredCapabilities capability = new DesiredCapabilities();
		//capability.setCapability("deviceName", "Manzoor");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Manzoor");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file= new File("E:\\Appium Training\\Test Data\\TestData.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rc= sheet.getLastRowNum();
		System.out.println(rc);
		for (int i=1;i<=rc;i++) {
			String username=sheet.getRow(i).getCell(0).getStringCellValue();
			String password=sheet.getRow(i).getCell(1).getStringCellValue();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
			driver.hideKeyboard();
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			driver.findElement(By.linkText("Log out")).click();
		}
	}
}
