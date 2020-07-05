package BudgetCalculator;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BudgetCalc2_TC01 {

	public static int a,b;
	public static String xData[][];
	
	@BeforeSuite
	public void setup() throws Exception
	{
		xlread("D:\\Study\\BudgetCalc\\TD_BC1.xls");
	}
	
	@Test
	public static void BudCalc() throws InterruptedException
	{
		for(int i=1; i<a; i++)
		{
		if(xData[i][1].equals("Y"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youcandealwithit.com");
		Thread.sleep(3000);
		WebElement vBorr = driver.findElement(By.xpath("//a[text()='Borrowers']"));
		Actions act = new Actions(driver);
		act.moveToElement(vBorr).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Calculators & Resources")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Calculators")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Budget Calculator")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("food")).clear();
		driver.findElement(By.id("food")).sendKeys(xData[i][2]);
		driver.findElement(By.id("clothing")).clear();
		driver.findElement(By.id("clothing")).sendKeys(xData[i][3]);
		driver.findElement(By.id("shelter")).clear();
		driver.findElement(By.id("shelter")).sendKeys(xData[i][4]);
		driver.findElement(By.id("health")).clear();
		driver.findElement(By.id("health")).sendKeys(xData[i][5]);
		driver.findElement(By.id("personal")).clear();
		driver.findElement(By.id("personal")).sendKeys(xData[i][6]);
		driver.findElement(By.id("car")).clear();
		driver.findElement(By.id("car")).sendKeys(xData[i][7]);
		driver.findElement(By.id("vacation")).clear();
		driver.findElement(By.id("vacation")).sendKeys(xData[i][8]);
		driver.findElement(By.id("other")).clear();
		driver.findElement(By.id("other")).sendKeys(xData[i][9]);
		driver.findElement(By.id("monthlyPay")).clear();
		driver.findElement(By.id("monthlyPay")).sendKeys(xData[i][10]);
		driver.findElement(By.id("monthlyOther")).clear();
		driver.findElement(By.id("monthlyOther")).sendKeys(xData[i][11]);
		
		xData[i][12] = driver.findElement(By.id("totalMonthlyExpenses")).getAttribute("value");
		xData[i][13] = driver.findElement(By.id("totalMonthlyIncome")).getAttribute("value");
		xData[i][14] = driver.findElement(By.id("underOverBudget")).getAttribute("value");
		driver.quit();
		}
		}
	}

	@AfterTest
	public void endtest() throws Exception
	{
		xlwrite("D:\\Study\\BudgetCalc\\Result_BC_TC01.xls",xData);
	}
		
	public static void xlread(String vUrl) throws Exception
	{
		File myfile = new File(vUrl);
		FileInputStream mystream = new FileInputStream(myfile);
		HSSFWorkbook wb = new HSSFWorkbook(mystream);
		HSSFSheet mysheet = wb.getSheetAt(2);
		a = mysheet.getLastRowNum()+1;
		b = mysheet.getRow(0).getLastCellNum();
		xData = new String[a][b];
		for (int i=0; i<a; i++)
		{
			HSSFRow row = mysheet.getRow(i);
			for(int j=0; j<b; j++)
			{
				HSSFCell cell = row.getCell(j);
				String value = celltostring(cell);
				xData[i][j] = value;
				System.out.print("  "+xData[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void xlwrite(String vUrl, String xData[][]) throws Exception
	{
		File myfile = new File(vUrl);
		FileOutputStream fout = new FileOutputStream(myfile);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet mysheet = wb.createSheet();
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
		wb.write(fout);
		fout.flush();
		fout.close();
	}
	
	
	public static String celltostring(HSSFCell cell)
	{
		int type = cell.getCellType();
		Object result;
		
		switch(type)
		{
		case HSSFCell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue();
			break;
			
		case HSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
			
		case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("We cannot evaluate formula");
			
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
			
		case HSSFCell.CELL_TYPE_BLANK:
			result="-";
			break;
			
		case HSSFCell.CELL_TYPE_ERROR:
			result="This cell has some error";
			break;
			
		default:
			throw new RuntimeException("We do not support this cell type");
		}
		return result.toString();
	}
	
}
