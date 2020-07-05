package JAVA_PACKAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MonthlyExp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youcandealwithit.com");
		Thread.sleep(3000);
		driver.get("http://www.youcandealwithit.com/borrowers/calculators-and-resources/index.shtml");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Calculators")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Budget Calculator")).click();
		driver.findElement(By.id("food")).sendKeys("2000");
		driver.findElement(By.id("clothing")).sendKeys("1000");
		driver.findElement(By.id("shelter")).sendKeys("2500");
		driver.findElement(By.id("monthlyPay")).sendKeys("10000");
		String tme = driver.findElement(By.id("totalMonthlyExpenses")).getAttribute("value");
		String id_tme = driver.findElement(By.id("totalMonthlyExpenses")).getAttribute("id");
		System.out.println("Total monthly Expense is Rs."+tme);
		System.out.println(id_tme);
		String tmi = driver.findElement(By.id("totalMonthlyIncome")).getAttribute("value");
		String id_tmi = driver.findElement(By.id("totalMonthlyIncome")).getAttribute("id");
		System.out.println("Total monthly Income is Rs."+tmi);
		System.out.println(id_tmi);
		driver.quit();

	}

}
