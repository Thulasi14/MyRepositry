package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class MainClass extends FunctionalClass {
	
	static WebDriver driver;
	
	public static void main() {
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		driver=new ChromeDriver();
		
		driver.get(getPropertyFile("url"));
		
		WebElement e=driver.findElement(By.name("email"));
		
		MainClass.actionFunction(e);
		
		
	}

}
