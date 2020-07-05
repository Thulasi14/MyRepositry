package testPackage;

import org.testng.annotations.DataProvider;

public class DataClass {
	
	@DataProvider(name="TestDataProvider")
	public Object[][] testData() {

	Object[][] data={{"username1","pasword1"},{"username2","pasword2"},{"username3","pasword3"}};

	return data;
		
	}

}
