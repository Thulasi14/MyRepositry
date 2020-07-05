package icici_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZTEST {
	
	@Test
	public void test() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	Thread.sleep(5000);
	driver.get("http://www.gmail.com");
	Thread.sleep(5000);
	driver.manage().window().maximize();// TODO Auto-generated method stub
	Thread.sleep(5000);
	driver.quit();
	}

}
