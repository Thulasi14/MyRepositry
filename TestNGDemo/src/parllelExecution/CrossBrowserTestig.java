package parllelExecution;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestig {
	
	static WebDriver driver;
	@Parameters({"browser"})
	@Test
	public void testCase1(String browserName) {
		
		if(browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./DriverFolder/chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println(Thread.currentThread().getId()+":"+Calendar.getInstance().getTimeInMillis()+":"+Calendar.getInstance().getTime());
			//driver.get("https://www.Google.com/");
		}
		else if(browserName.equals("Ie")) {
			
			System.setProperty("webdriver.ie.driver","./DriverFolder/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			System.out.println(Thread.currentThread().getId()+":"+Calendar.getInstance().getTimeInMillis()+":"+Calendar.getInstance().getTime());
			//driver.get("https://www.Google.com/");
		}
		/*else {
			
			System.setProperty("webdriver.gecko.driver","./DriverFolder/geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println(Thread.currentThread().getId()+":"+Calendar.getInstance().getTimeInMillis());
			//driver.get("https://www.Google.com/");
		}*/
		
		driver.get("https://www.Google.com/");
	}

}
