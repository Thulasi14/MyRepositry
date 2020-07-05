package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.HomePageRepository;
import ObjectRepository.LoginPageRepository;

public class TCLogin 
{
	
	@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
		WebDriver myD=new ChromeDriver();
		myD.get("https://mail.rediff.com/cgi-bin/login.cgi");
		LoginPageRepository LP=new LoginPageRepository(myD);
		System.out.println(LP.Title());
		LP.username().sendKeys("samsaravananr");
		LP.Password().sendKeys("12345");
		LP.Submit().click();
		LP.Home().click();
		HomePageRepository HP=new HomePageRepository(myD);
		HP.Search().sendKeys("Watches");
		HP.HomeSubmit().click();
		myD.close();
	
	}
}
