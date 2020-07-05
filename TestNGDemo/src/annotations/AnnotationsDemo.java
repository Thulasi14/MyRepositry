package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	
		
		static WebDriver driver;
		
		//@Test(priority=1,timeOut=15000)
		public void login() {
			
			System.setProperty("webdriver.chrome.driver","./DriverFolder/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
		//	Assert.fail();
			
			 
		}

		//@Test(priority=2,timeOut=15000,dependsOnMethods="login",alwaysRun=true,enabled=false)
		public void Credential() {
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Thulasi");;
			driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456");
		}
		
	//	@Test(timeOut=30000,invocationCount=3,threadPoolSize=3,description="Google HomePage Launch")
				public void googleLogin() {
					
					System.setProperty("webdriver.chrome.driver","./DriverFolder/chromedriver.exe");
					System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
					driver=new ChromeDriver();
					driver.get("https://www.google.com/");
					System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
	}
		
		//@Test(invocationTimeOut=30000,invocationCount=3,description="Facebook HomePage Launch")
		public void facebook() {
			
			System.setProperty("webdriver.chrome.driver","./DriverFolder/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
}
		@Test(expectedExceptions=Exception.class)
		public void exceptionMethod(){
			
			System.out.println(10/0);	
			System.out.println("Exception Suppressed");
			
		}
		
		
		
		
		
		

}