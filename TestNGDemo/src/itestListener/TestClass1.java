package itestListener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(itestListener.ListenerClass.class)
public class TestClass1 {
	
	@Test
	public void metd_a() {
		
		System.out.println("Method A");
	}
	
	@Test
	public void metd_b() {
		
		System.out.println("Method B");
		Assert.fail();
	}
	
	@Test
	public void metd_c() {
		
		int i=0;
		if(i!=1){
		throw new SkipException("This method is skipped");
		}
		
		System.out.println("UnSkipped");
		
	}
}
