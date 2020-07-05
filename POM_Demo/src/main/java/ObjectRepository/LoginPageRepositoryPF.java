package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRepositoryPF 
{

	WebDriver myD;
	/*By username =By.id("login1");
	By password =By.id("password");
	By go=By.name("proceed");
	By home=By.linkText("Home");*/
	
	
	public LoginPageRepositoryPF(WebDriver myD)
	{
		this.myD=myD;
		PageFactory.initElements(myD, this);
	}
	
	
	@FindBy(id="login1") 
	public WebElement username;
	
	@FindBy(id="password") 
	public WebElement password;
	
	@FindBy(name="proceed") 
	public WebElement go;
	
	@FindBy(xpath="//a[@href='http://www.rediff.com']") 
	WebElement home;
	
		
	public WebElement Username()
	{
	return username;
	}
	
	public WebElement Password()
	{
	return password;
	}
	
	public WebElement Submit()
	{
	return go;
	}
	
	
	
	public WebElement Home()
	{
	return home;
	}
	
}
