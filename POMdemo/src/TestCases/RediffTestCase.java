package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class RediffTestCase {

	@Test
	public void TS001() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		LoginPage LP = new LoginPage(driver);
		LP.username().sendKeys("samsaravananr");
		LP.password().sendKeys("12345");
		Thread.sleep(4000);
		LP.Login().click();
		LP.Home().click();
		HomePage HP = new HomePage(driver);
		HP.Search().sendKeys("Mobiles");
		HP.SearchButton().click();
		driver.close();
		
	}
}
