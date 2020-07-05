package otherReusableFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.tools.DocumentationTool.Location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class File1 {
	
	
	
	WebDriver driver;
	
	static Properties p;
	
	public  File1(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public String propertyFile(String key) {
		
		p=new Properties();
		
		try {

			p.load(new FileInputStream("./ConfigFiles/DataFile.properties"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s=p.getProperty(key);
		
		return s;
	}
	
	public String propertyFile1(String key) {
		
		p=new Properties();
		
		try {

			p.load(new FileInputStream("./ConfigFiles/GoogleFile.properties"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s=p.getProperty(key);
		
		return s;
	}
	
	public void locating(String uname,String password) {
		
			String name=propertyFile(uname);
			String pwd=propertyFile(password);	
			WebElement loc1=driver.findElement(By.name("email")); 
			WebElement loc2=driver.findElement(By.name("pass"));
			loc1.sendKeys(name);
			loc2.sendKeys(pwd);		
	}

	public void clickMethod(String xpath) {
		
		String xpathValue=propertyFile(xpath);
		WebElement loc3=driver.findElement(By.xpath(xpathValue));
		loc3.click();
	}
	
	
	static Actions a;
	
	public void actionsClick(String key) {
		
		String locator=propertyFile1(key);
		
		String[] d=locator.split("#");
		
		//String attributeName=d[0];
		String attributeValue=d[1];
		//String action=d[2];
		
		a=new Actions(driver);
		
		WebElement wb=driver.findElement(By.linkText(attributeValue));
		
				a.click(wb).perform();
		
		}
	
	public void dropdown(String selectOption) {
		
		String s=propertyFile(selectOption);
		
		String[] s1=s.split("#");
		
		WebElement we=driver.findElement(By.id(s1[1]));
		
			Select sel=new Select(we);
		
		switch(s1[2].toUpperCase()){
		
		case "BYINDEX":
			sel.selectByIndex(2);
			break;
		
		case "BYVALUE":
			sel.selectByValue("4");
			break;
		
		default:
			sel.selectByVisibleText("Oct");
			break;
			
		}
		
		getWindow();
			
		}
		
	public void getWindow() {
		
		String windowAddress=driver.getWindowHandle();
		
		System.out.println(windowAddress);
		
	}
	
	
		
		
	}
	
