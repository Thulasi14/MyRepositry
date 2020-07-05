package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderClass {
	
static WebDriver driver;


	
	
	@Test(dataProviderClass=DataClass.class, dataProvider="TestDataProvider")
	public void login(String name,String pwd) {
		
		System.setProperty("webdriver.chrome.driver","./DriverFolder/chromedriver.exe");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(pwd);
		
	}

}
