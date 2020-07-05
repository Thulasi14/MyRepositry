package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class UtilityClass {
	
	static Properties prop;

	public static String readPropertyFile(String key) {
		
		prop=new Properties();
		
		//prop.getProperty("C:\\Users\\home\\MadhuProject\\PageObjectModel\\ConfigurationFiles\\file.properties");
		
		try {
			prop.load(new FileInputStream("C:\\Users\\home\\MadhuProject\\PageObjectModel\\ConfigurationFiles\\file.properties"));
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
	 * public static void browserSelect(String key2) {
	 * 
	 * String browserName=readPropertyFile(key2);
	 * 
	 * //System.out.println(browserName);
	 */		
			
			
			
			
			
			
		
	
	

}
