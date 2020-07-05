package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends UtilityClass {
	
	WebDriver driver;
	
	public  HomePage(WebDriver driver) {
		
		this.driver=driver;
		
	}
		public void quickLaunchTab(String label) {
			
			String address= readPropertyFile(label);
		
			List<WebElement> l=driver.findElements(By.xpath(address));
			
			for(WebElement a:l) {
				
			System.out.println(a.getText());
			
		}
			
		}
			
		public void legendTab(String label1) {
			
			String add=readPropertyFile(label1);
			
			List<WebElement> l1=driver.findElements(By.xpath(add));
			
			for(WebElement a1:l1) {
				
			System.out.println(a1.getText());
			}
			
		}
			
		
		
	}
	
