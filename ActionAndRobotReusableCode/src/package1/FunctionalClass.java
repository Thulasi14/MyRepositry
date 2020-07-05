package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FunctionalClass {
	
	static Properties prop;
	
	static WebDriver driver;
	
	static Actions a;
	
	public static String getPropertyFile(String key)  {
		
		prop=new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\Users\\home\\MadhuProject\\ActionAndRobotReusableCode\\ConfigFiles\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		return prop.getProperty(key);	
	}
	
	/*
	 * public WebElement getWebElement(String locatorandvalue) {
	 * 
	 * WebElement element;
	 * 
	 * String locatedElement=getPropertyFile(locatorandvalue);
	 * 
	 * String[] s=locatedElement.split("#"); String locator=s[0]; String value=s[1];
	 * 
	 * switch(locator.toUpperCase()){
	 * 
	 * case "NAME": element= driver.findElement(By.name(value)); break;
	 * 
	 * case "ID": element= driver.findElement(By.id(value)); break;
	 * 
	 * case "CLASS": element= driver.findElement(By.className(value)); break;
	 * 
	 * case "LINKTEXT": element= driver.findElement(By.linkText(value)); break;
	 * 
	 * case "PARTIALLINKTEXT": element=
	 * driver.findElement(By.partialLinkText(value));
	 * 
	 * break;
	 * 
	 * case "TAGNAME": element= driver.findElement(By.tagName(value)); break;
	 * 
	 * case "XPATH": element= driver.findElement(By.xpath(value)); break;
	 * 
	 * default: element= driver.findElement(By.cssSelector(value)); break;
	 * 
	 * } return element;
	 * 
	 * }
	 */
		public static void actionFunction(WebElement element) {
			
			a=new Actions(driver);
			
			a.sendKeys(getPropertyFile("userNametoPass")).perform();
			
			//element.a.sendKeys(FunctionalClass.getPropertyFile(key)).perform();
	
		}

	

}
