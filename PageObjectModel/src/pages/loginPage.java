package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends UtilityClass {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(name="txtUsername")
	WebElement user;
	
	@FindBy(name="txtPassword")
	WebElement pwd;
	
	@FindBy(name="Submit")
	WebElement lgn;
	
	/*
	 * By name=By.name("txtUsername");
	 * 
	 * By pwd=By.name("txtPassword");
	 * 
	 * By lgn=By.name("Submit");
	 */

	/*
	 * public WebElement getName() { return driver.findElement(name) ; }
	 * 
	 * public WebElement getPwd() { return driver.findElement(pwd); }
	 * 
	 * public WebElement getLgn() { return driver.findElement(lgn); }
	 */
	
	public WebElement getName() {
		return user ;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLgn() {
		return lgn;
	}
	
	
	public void login(String userName, String pwd) {
		
		getName().sendKeys(readPropertyFile(userName));
		
		getPwd().sendKeys(readPropertyFile(pwd));
		
		getLgn().click();
	}
	
	
}
