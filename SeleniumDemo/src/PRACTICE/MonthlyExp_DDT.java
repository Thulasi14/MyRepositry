package PRACTICE;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MonthlyExp_DDT {

	public WebDriver driver;
	public WebElement vborr;
	public static int a,b;
	public static String xData[][];
	
	@BeforeTest
	public void readfile() throws Exception
	{
		xlread("D:\\Study\\Testdata\\inputfile22.xlt");
	}
	
	@Test
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
	}
	
	@Test(priority= 0)
	public void Openlink()
	{
		driver.get("http://www.youcandealwithit.com");
	}
	
	@Test(priority= 1)
	public void navigateToBorrowers()
	{
		vborr = driver.findElement(By.xpath("//a[text()='Borrowers']"));
		Actions act = new Actions(driver);
		act.moveToElement(vborr).build().perform();
	}
	
	@Test(priority= 2)
	public void navigateToCalcRes()
	{
		driver.findElement(By.linkText("Calculators & Resources")).click();
	}
	
	@Test(priority= 3)
	public void navigateToBudgetCalculator() throws InterruptedException
	{
		driver.findElement(By.linkText("Calculators")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Budget Calculator")).click();
		Thread.sleep(3000);
	}
	
	@Test (priority= 4)
	public void inputValues() throws InterruptedException
	{
		driver.findElement(By.id("food")).sendKeys("5000");
		driver.findElement(By.id("clothing")).sendKeys("3000");
		driver.findElement(By.id("shelter")).sendKeys("8000");
		driver.findElement(By.id("monthlyPay")).sendKeys("20000");
		Thread.sleep(5000);
	}
	
	@Test (priority= 5)
	public void outputValues() throws InterruptedException
	{
		String vtext_1 = driver.findElement(By.id("totalMonthlyExpenses")).getAttribute("value");
		String vtext_2 = driver.findElement(By.id("totalMonthlyIncome")).getAttribute("value");
		String vtext_3 = driver.findElement(By.id("underOverBudget")).getAttribute("value");
	
		System.out.println("Total Monthly Expense = " +vtext_1);
		System.out.println("Total Monthly Income = "+vtext_2);
		System.out.println("Under/OverBudget= "+vtext_3);
		
		Thread.sleep(5000);
	}
		
	@Test(priority= 6)
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	public static void xlread(String vurl) throws Exception
	{
		File myfile = new File(vurl);
		FileInputStream mystream = new FileInputStream(myfile);
		HSSFWorkbook mywb = new HSSFWorkbook(mystream);
		HSSFSheet mysheet = mywb.getSheetAt(0);
		a = mysheet.getLastRowNum()+1;
		System.out.println(a);
		b = mysheet.getRow(0).getLastCellNum();
		xData = new String[a][b];
		for(int i=0;i<a;i++)
		{
			HSSFRow row = mysheet.getRow(i);
			for(int j=0;j<b;j++)
			{
				HSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				xData[i][j] = value;
				System.out.print("  "+xData[i][j]);
			}
			System.out.println();
		}
	}
}
