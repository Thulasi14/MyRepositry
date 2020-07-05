package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageRepository 
{

	WebDriver myD;
	By username =By.id("login1");
	By password =By.id("password");
	By go=By.name("proceed");
	By home=By.linkText("Home");
	
	public LoginPageRepository(WebDriver myD)
	{
		this.myD=myD;
	}
	
	public WebElement username()
	{
		return myD.findElement(username);
	}
	
	public WebElement Password()
	{
		return myD.findElement(password);
	}
	
	public WebElement Submit()
	{
		return myD.findElement(go);
	}
	
	public String Title()
	{
		return myD.getTitle();
	}
	
	public WebElement Home()
	{
		return myD.findElement(home);
	}
	
}
