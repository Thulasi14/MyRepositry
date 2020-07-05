package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	public WebDriver driver;
	By Search = By.id("srchword");
	By SearchButton = By.className("newsrchbtn");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Search()
	{
		return driver.findElement(Search);
	}
	
	public WebElement SearchButton()
	{
		return driver.findElement(SearchButton);
	}
}
