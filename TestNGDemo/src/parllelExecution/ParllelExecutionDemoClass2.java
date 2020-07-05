package parllelExecution;

import org.testng.annotations.Test;

@Test
public class ParllelExecutionDemoClass2 {

	@Test(groups= {"Sanity"})
	public void case4() {
		
		System.out.println("Printing TestCase4");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups= {"Smoke"})
	public void case5() {
		
		System.out.println("Printing TestCase5");
		System.out.println(Thread.currentThread().getId());
		
	}
	
	@Test(groups= {"Regression"})
	public void case6() {
		
		System.out.println("Printing TestCase6");
		System.out.println(Thread.currentThread().getId());
		
	}
	
}
