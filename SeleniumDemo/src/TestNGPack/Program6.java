package TestNGPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Program6 {
	
	public static String Url = "https://www.google.com";
	public static WebDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
	}
	
	@Test
	public void search() throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys("TestNG");
		Thread.sleep(3000);
		driver.findElement(By.className("gNO89b")).click();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "search")
	public void navigate() throws InterruptedException
	{
		driver.findElement(By.className("LC20lb")).click();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "navigate")
	public void verifyTitle()
	{
		String expTitle = "TestNG - Download Current Release and Beta Versions";
		driver.findElement(By.linkText("Download")).click();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(enabled=false)
	public void gettext()
	{
		String vtext = driver.findElement(By.xpath("//h2[text()='Downloading TestNG']")).getText();
		System.out.println(vtext);
	}
	
	@AfterTest
	public void CloseUrl()
	{
		driver.quit();		
	}

}
