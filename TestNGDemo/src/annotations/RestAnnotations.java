package annotations;

import org.testng.annotations.*;


public class RestAnnotations {
	
	@BeforeClass
	public void beforeC(){
		
		System.out.println("BeforeClass");
		
	}
	
	@AfterClass
	public void afterC(){
		
		System.out.println("AfterClass");
		
	}
	
	@BeforeMethod
	public void beforeM(){
		
		System.out.println("BeforeMethod");
		
	}
	
	@AfterMethod
	public void afterM(){
		
		System.out.println("AfterMethod");
		
	}
	
	@BeforeSuite
	public void beforeS(){
		
		System.out.println("BeforeSuite");
		
	}
	
	@AfterSuite
	public void afterS(){
		
		System.out.println("AfterSuite");
		
	}
	
	@Test
	public void testMethod(){
		
		System.out.println("TestMethodOutput");
		
	}
	
	@BeforeClass
	public void BeforeC1(){
		
		System.out.println("BeforeClass1");
		
	}
	
	@AfterClass
	public void AfterC1(){
		
		System.out.println("AfterClass1");
		
	}
	
	@BeforeGroups
	public void BeforeG(){
		
		System.out.println("BeforeGroups");
		
	}
	
	@AfterGroups
	public void AfterG(){
		
		System.out.println("AfterGroups");
		
	}
	
	
	

}
