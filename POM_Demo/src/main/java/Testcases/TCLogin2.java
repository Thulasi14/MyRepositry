package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.HomePageRepository;
import ObjectRepository.LoginPageRepository;
import ObjectRepository.LoginPageRepositoryPF;

public class TCLogin2 
{
	
	@Test
	public void Login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
		WebDriver myD=new ChromeDriver();
		myD.get("https://mail.rediff.com/cgi-bin/login.cgi");
		LoginPageRepositoryPF LP=new LoginPageRepositoryPF(myD);
		//System.out.println(myD.getTitle());
		//Thread.sleep(5000);
		LP.Username().sendKeys("samsaravananr");
		LP.Password().sendKeys("1234");
		Thread.sleep(5000);
		myD.close();
	
	}
}
