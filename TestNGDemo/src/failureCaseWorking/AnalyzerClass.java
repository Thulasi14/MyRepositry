package failureCaseWorking;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class AnalyzerClass implements IRetryAnalyzer {
	
	int min=1;
	int maxRun=2;
	
	public boolean retry(ITestResult result){
		
		while(min<=maxRun) {
		
		min++;
		
		return true;
		
		}
		
		return false;
		
	}

}
