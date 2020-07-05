package icici_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZTEST2 {
	
	String vURL,vUN,vPwd,vChrome,vChromepath;
	Properties ps;
	
	@BeforeTest
	public void setup() throws IOException
	{
		ps = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\home\\MadhuProject\\icici\\Datafile.properties");
		ps.load(fis);
		vURL=ps.getProperty("url");
		vUN=ps.getProperty("username");
		vPwd=ps.getProperty("password");
		vChrome=ps.getProperty("chromedri");
		vChromepath=ps.getProperty("drivepath");
	}
	
	@Test
	public void test() throws InterruptedException
	{
	System.setProperty(vChrome,vChromepath);
	WebDriver driver = new ChromeDriver();
	Thread.sleep(5000);
	driver.get("http://www.gmail.com");
	Thread.sleep(5000);
	driver.manage().window().maximize();// TODO Auto-generated method stub
	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).sendKeys(vUN);
	driver.findElement(By.className("CwaK9")).click();
	driver.quit();
	}

}
