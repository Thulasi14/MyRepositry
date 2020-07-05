package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Class1 {
	
	@Test(priority=0,invocationCount=2,threadPoolSize=2)
	public void aurlLaunch() {
		//Assert.fail();
		System.out.println("Lauched");
		System.out.println("ThreadID:"+Thread.currentThread().getId());
		
		
	}
	
	@Test(priority=1,dependsOnMethods="aurlLaunch")
	public void login() {
		
		System.out.println("Logined");
		System.out.println("Login ThreadID:"+Thread.currentThread().getId());
	}
	
	@Test
	public void defaultMethod() {
		System.out.println("Default");
		System.out.println("default ThreadID:"+Thread.currentThread().getId());
	}


}
