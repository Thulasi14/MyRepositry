package PRACTICE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MonthlyExp_DDT_2 {

	public WebDriver driver;
	public WebElement vborr;
	public static int a,b;
	public static String xData[][];
	public static String c,d;
	
	@BeforeTest
	public void readfile() throws Exception
	{
		xlread("D:\\Study\\Testdata\\inputfile22.xlt");
	}
	
	@Test
	public void process() throws InterruptedException
	{
		for(int i=1; i<=a; i++)
		{
			String c =xData[i][0];
			String d = xData[i][1];
			
		//1.Open Browser
		if(c.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome");
			System.out.println("------");
		}
		else if(c.equals("Firefox"))
		{
		    System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox");
			System.out.println("------");
		}
		else
		{
			System.out.println("Invalid Browser");
			xData[i][2]="FAIL";
			driver.quit();
			
		}
		driver.manage().window().maximize();
	
		//2.Open link
		driver.get(d);
	
		//3.navigateToBorrowers()
		vborr = driver.findElement(By.xpath("//a[text()='Borrowers']"));
		Actions act = new Actions(driver);
		act.moveToElement(vborr).build().perform();
	
		//4.navigateToCalcRes()
		driver.findElement(By.linkText("Calculators & Resources")).click();
	
		//5.navigateToBudgetCalculator() 	{
		driver.findElement(By.linkText("Calculators")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Budget Calculator")).click();
		Thread.sleep(3000);
	
		//6.inputValues
		driver.findElement(By.id("food")).sendKeys("5000");
		driver.findElement(By.id("clothing")).sendKeys("3000");
		driver.findElement(By.id("shelter")).sendKeys("8000");
		driver.findElement(By.id("monthlyPay")).sendKeys("20000");
	
		//7.outputValues
	
		String vtext_1 = driver.findElement(By.id("totalMonthlyExpenses")).getAttribute("value");
		String vtext_2 = driver.findElement(By.id("totalMonthlyIncome")).getAttribute("value");
		String vtext_3 = driver.findElement(By.id("underOverBudget")).getAttribute("value");
	
		System.out.println("Total Monthly Expense = " +vtext_1);
		System.out.println("Total Monthly Income = "+vtext_2);
		System.out.println("Under/OverBudget= "+vtext_3);
		Thread.sleep(5000);
		xData[i][2]="PASS";
		//8.CloseBrowser
		driver.quit();
		}
	}	
	
	@AfterTest
	public void writefile() throws Exception
	{
		xlwrite("D:\\Study\\Testdata\\Result.xlt",xData);
	}
	
	public static void xlread(String vurl) throws Exception
	{
		File myfile = new File(vurl);
		FileInputStream mystream = new FileInputStream(myfile);
		HSSFWorkbook mywb = new HSSFWorkbook(mystream);
		HSSFSheet mysheet = mywb.getSheetAt(0);
		a = mysheet.getLastRowNum()+1;
		//System.out.println(a);
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
				System.out.print(" |  "+xData[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void xlwrite(String path, String xData[][]) throws Exception
	{
		File myfile = new File(path);
		FileOutputStream mystream = new FileOutputStream(myfile);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet mysheet = wb.createSheet("Test Results");
		for(int i=0; i<a; i++)
		{
			HSSFRow row1 = mysheet.createRow(i);
			for(int j=0; j<b; j++)
			{
				HSSFCell cell = row1.createCell(j);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(xData[i][j]);
			}
		}
		wb.write(mystream);
		mystream.flush();
		mystream.close();
	}
}
