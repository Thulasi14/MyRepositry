package failureCaseWorking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import screenShotPackage.*;


public class GoogleLauchTestWarehouse {
	
	static WebDriver driver;
	static WebElement ele;
	@Test
	public void test1() {
		
		
		System.setProperty("webdriver.chrome.driver","./DriverFolder/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void test2() {
	
		
		ele=driver.findElement(By.name("q"));
		ele.sendKeys("Selenium Training");
		
	}
	
	@Test
	public void test3() {
	
		Assert.fail();
		ele.clear();
		
	}
	
	@AfterMethod
	public void shots(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
		
		EvidenceClass.reusable(driver,result.getName());
		
		}
		
	}

}
