package PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Concur {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.concur.co.in");
		driver.findElement(By.linkText("Learn more")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Download whitepaper")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("View our privacy policy")).click();
		Thread.sleep(3000);
		driver.quit();
		

	}

}
