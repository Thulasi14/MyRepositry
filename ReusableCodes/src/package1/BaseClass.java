package package1;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import sun.net.ftp.FtpDirEntry.Type;

public class BaseClass {
	
	static Properties prop;
	
	static WebDriver driver;
	
	static TakesScreenshot shot;
	
	
	
	public static String getConfigValues(String key) {
		
		
		prop=new Properties();
		
		
			try {
				prop.load(new FileInputStream("C:\\Users\\home\\MadhuProject\\ReusableCodes\\ConfigFiles\\config.properties"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			String a=prop.getProperty(key);
				
		return a;
		
	}
	
public static String getElementAddress(String key1) {
		
		
		prop=new Properties();
		
		
			try {
				prop.load(new FileInputStream("C:\\Users\\home\\MadhuProject\\ReusableCodes\\ConfigFiles\\elementAddress.properties"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
			String b=prop.getProperty(key1);
			
			return b;
		
	}
	
	public static void initilisation(String key) {
		
		String browserName=getConfigValues(key);
		
		System.out.println(browserName);
		
		if(browserName.toUpperCase().equals("CHROME")) {
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			driver=new ChromeDriver();
			
			
		}
		
		else if(browserName.toUpperCase().equals("IE")){
			
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
			
		}
		
		else {
			
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			
			driver=new FirefoxDriver();
			
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getCurrentUrl()+" "+driver.getTitle());
		
		//screenshot("AfterLaunch");
		

		//driver.quit();
	}
	
	public static void screenshot(String testcasefile) {
		
		shot=(TakesScreenshot) driver;
		
		File temp=shot.getScreenshotAs(OutputType.FILE);	
		
		try {
			FileUtils.copyFile(temp, new File(System.getProperty("user.dir")+"/ScreenshotFiles"+ testcasefile + System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			
		}
		
	}
	
	public static void getUserName(String key1) {
		
		String value=getConfigValues(key1);
		
		WebElement location=driver.findElement(By.xpath("//input[@name='email']"));
		
		location.sendKeys(value);
		
		
	}
	
	public static void getPassword(String key2) {
		
		String value1=getConfigValues(key2);
		
		WebElement location1=driver.findElement(By.xpath("//input[@name='pass']"));
		
		location1.sendKeys(value1);
		
		
	}
	
	public static void getloginCred(String uname,String pwd) {
		
		String UserName=getConfigValues(uname);
		String password=getConfigValues(pwd);
		
		WebElement location=driver.findElement(By.xpath("//input[@name='email']"));
		location.sendKeys(UserName);
		
		WebElement location1=driver.findElement(By.xpath("//input[@name='pass']"));
		location1.sendKeys(password);
		
		click();
	
	}

	public static void click() {
		
		WebElement location3=driver.findElement(By.xpath("//*[@id='u_0_b']"));
		
		location3.click();

	}
	
	public static WebElement getWebElement(String locatorandvalue) {
		
		WebElement element;
		
		String locatedElement=getElementAddress(locatorandvalue);
		
		String[] s=locatedElement.split("#");	
		String locator=s[0];
		String value=s[1];
		
		//System.out.println(s[0]+" "+s[1]);
		
		switch(locator.toUpperCase()){
			
			case "NAME":
				 element= driver.findElement(By.name(value));
				break;
				
			case "ID":
				 element= driver.findElement(By.id(value));
				break;
				
			case "CLASS":
				 element= driver.findElement(By.className(value));
				break;
				
			case "LINKTEXT":
				 element= driver.findElement(By.linkText(value));
				break;
				
			case "PARTIALLINKTEXT":
				 element= driver.findElement(By.partialLinkText(value));
			
				break;
				
			case "TAGNAME":
				 element= driver.findElement(By.tagName(value));
				break;
				
			case "XPATH":
				 element= driver.findElement(By.xpath(value));
				break;
				
			default:
				 element= driver.findElement(By.cssSelector(value));
				break;
				
		}
		return element;
	
		
	}
	
	public static void enterText(String location, String key){
		
		getWebElement(location).sendKeys(getConfigValues(key));
		
	}
	
	public static void click(String location){
		
		getWebElement(location).click();	
		
	}
	
	public static void innerText(String text) {
		
		
		System.out.println(getWebElement(text).getAttribute("innerText"));
		
		
		
	}
	
	

}
