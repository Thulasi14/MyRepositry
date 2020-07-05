package parllelExecution;

import org.testng.annotations.Test;


public class ParllelDemoClass {
	
	@Test(groups= {"Windows-Smoke","Sanity"})
	public void case1() {
		
		System.out.println("Printing TestCase1");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test(groups= {"Regression","Smoke"})
	public void case2() {
		
		System.out.println("Printing TestCase2");
		System.out.println(Thread.currentThread().getId());
		
		
	}
	
	@Test(groups= {"Sanity-Windows"})
	public void case3() {
		
		System.out.println("Printing TestCase3");
		System.out.println(Thread.currentThread().getId());	
	}

}
