package PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickLearnmoreGmail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumJars\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.gmail.com");
		Thread.sleep(2000);
		String vtitle = driver.getTitle();
		if(vtitle.equals("Gmail"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
			System.out.println(driver.getCurrentUrl());
		}
		driver.findElement(By.linkText("Learn more")).click();
		Thread.sleep(2000);
		driver.quit();

	}
}
