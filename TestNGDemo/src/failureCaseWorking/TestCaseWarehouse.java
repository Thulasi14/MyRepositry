package failureCaseWorking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseWarehouse {
	

	@Test
	public void test1() {
		
		
		System.out.println("TestCase1");
		
	}
	
	@Test
	public void test2() {
		
		Assert.fail();
		
		System.out.println("TestCase2");
		
	}
	
	
	@Test
	 public void test3() {
	 
	 System.out.println("TestCase3");
	 
	 }

}
