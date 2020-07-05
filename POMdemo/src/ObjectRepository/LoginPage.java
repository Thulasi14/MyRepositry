package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	By username = By.id("login1");
	By password=By.id("password");
	By name = By.name("proceed");
	By Home = By.linkText("Home");
	

public LoginPage(WebDriver driver)
{
	this.driver =driver;
}

public WebElement username()
{
	return driver.findElement(username);
}

public WebElement password()
{
	return driver.findElement(password);
}

public WebElement Login()
{
	return driver.findElement(name);
}

public WebElement Home()
{
	return driver.findElement(Home);
}

}




