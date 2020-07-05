package JAVA_PACKAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandling_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		try
		{
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.id("login1")).sendKeys("intestingconsultant");
		driver.findElement(By.id("password")).sendKeys("9840401130kjk");
		driver.findElement(By.name("proceed")).click();
		driver.findElement(By.className("rd_logout")).click();
		}
		catch(Exception e)
		{
			driver.close();
		}
		driver.close();
	}

}
