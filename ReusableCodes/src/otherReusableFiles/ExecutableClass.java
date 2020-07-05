package otherReusableFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecutableClass {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		File1 f=new File1(driver);
		
		/*f.locating("username","password");
		
		f.clickMethod("xpath");
		
		driver.get("https://www.google.com");
		
		File1 f=new File1(driver);
		
		f.actionsClick("link");*/
		
		f.dropdown("select3");
		
		
		
		
	}
	

}
