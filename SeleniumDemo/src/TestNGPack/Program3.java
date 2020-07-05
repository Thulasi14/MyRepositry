package TestNGPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Program3 {

	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("This is Before Class");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("This is Before Method");
	}
	
	@Test
	public void input()
	{
		System.out.println("Method1");
	}
	
	@Test
	public void processing()
	{
		System.out.println("Method3");
	}
	
	@Test
	public void output()
	{
		System.out.println("Method2");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("This is After Method");
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("This is After Class");
	}
	
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("This is Before Suite");
	}
	
	@org.testng.annotations.AfterSuite
	public void AfterSuite()
	{
		System.out.println("This is After Suite");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("This is Before Test");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("This is After Test");
	}
	
}
