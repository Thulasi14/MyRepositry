package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class MainClass extends UtilityClass{
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	
	driver=new ChromeDriver();
	
	driver.get(MainClass.readPropertyFile("url"));
	
	driver.manage().window().maximize();
	
	loginPage l=new loginPage(driver);
	
	l.login("username","password");
	
	HomePage h=new HomePage(driver);
	
	h.quickLaunchTab("QuickLaunch");
	
	h.legendTab("legend");
	
	
	}
	

}
