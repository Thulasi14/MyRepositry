package package1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./driver1/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
	//	WebDriverWait wt=new WebDriverWait(driver,15);
		
		Wait wt1=new FluentWait(driver).pollingEvery(20,SECONDS);
		
		
		
		//wt.until(ExpectedConditions.urlToBe("https://www.facebook.com"));
		driver.get("https://www.facebook.com");
		
//		WebElement wb=driver.findElement(By.xpath(("//div[contains(text(),'Create')]")));
//		System.out.println(wb.getAttribute("innerText"));
//		
		
		WebElement date=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select s=new Select(date);
		
		s.selectByIndex(5);
		
		System.out.println(s.isMultiple());
		
		List<WebElement> option=s.getAllSelectedOptions();
		
		Iterator<WebElement> it=option.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().getText());
		}
		
		WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
		
		Select s1=new Select(month);
		
		s1.selectByVisibleText("May");
		
		WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
		
		Select s2=new Select(year);
		
		s2.selectByValue("1995");
		
		driver.manage().deleteAllCookies();
		
		driver.quit();
	}
		
	}
