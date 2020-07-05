package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

	
	public static void main(String[] args) {
		
		String setProperty = System.setProperty("webdriver.chrome.driver","./driver1/chromedriver.exe");
		
		
		
		System.out.println(setProperty);
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		By id=By.id("email");
		
		WebElement e=driver.findElement(id);
		
		//e.submit();
		
	}
}
