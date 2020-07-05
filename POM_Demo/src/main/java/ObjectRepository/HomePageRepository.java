package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageRepository 
{

	WebDriver myD;
	By search=By.id("srchword");
	By searchBt=By.className("newsrchbtn");
	
	public HomePageRepository(WebDriver myD)
	{
		this.myD=myD;
	}
	
	public WebElement Search()
	{
		return myD.findElement(search);
	}
	
	public WebElement HomeSubmit()
	{
		return myD.findElement(searchBt);
		
	}
	
}
