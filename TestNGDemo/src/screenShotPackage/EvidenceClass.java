package screenShotPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class EvidenceClass {
	
	public static void reusable(WebDriver driver,String filename) {
		
		TakesScreenshot tk= (TakesScreenshot)driver;
		
		File temp=tk.getScreenshotAs(OutputType.FILE);
		
		
		try {
			FileUtils.copyFile(temp, new File("./ScreenShots/"+filename+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	

}
