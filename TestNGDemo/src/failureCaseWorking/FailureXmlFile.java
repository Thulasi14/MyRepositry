package failureCaseWorking;

import java.util.Arrays;

import org.testng.TestNG;

public class FailureXmlFile {

	
	public static void main(String[] args) {
		
		TestNG tg=new TestNG();
		
		tg.setTestSuites(Arrays.asList("C:\\Users\\home\\MadhuProject\\TestNGDemo\\test-output\\testng-failed.xml"));
		
		tg.run();
		
		
		
		
	}
}