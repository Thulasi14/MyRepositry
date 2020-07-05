package TestNGPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Program5 {
	
	public static String Url = "https://www.google.com";
	public static WebDriver driver;
	
	@BeforeTest(groups = "P1")
	public void openUrl()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
	}
	
	@Test(priority=0, groups = "P1")
	public void search() throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys("TestNG");
		Thread.sleep(3000);
		driver.findElement(By.className("gNO89b")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1, groups = "P1")
	public void navigate() throws InterruptedException
	{
		driver.findElement(By.className("LC20lb")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3, groups = "P1")
	public void verifyTitle()
	{
		String expTitle = "TestNG - Download Current Release and Beta Versions";
		driver.findElement(By.linkText("Download")).click();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@AfterTest(groups = "P1")
	public void CloseUrl()
	{
		driver.quit();		
	}

}
