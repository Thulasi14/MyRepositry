package JAVA_PACKAGE;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class READ_FILE {

	public static int xR_TD,xC_TD;
	public static String xData[][],a;

	
	@BeforeTest
	public void setup() throws Exception
	{
		xlread("D:\\Study\\DDF21.xls");
	}
	
	public static void xlread(String vUrl) throws Exception
	{
		File myfile = new File(vUrl);
		FileInputStream mystream = new FileInputStream(myfile);
		HSSFWorkbook myworkbook = new HSSFWorkbook(mystream);
		HSSFSheet mysheet = myworkbook.getSheetAt(1);
		xR_TD = mysheet.getLastRowNum()+1;
		xC_TD = mysheet.getRow(0).getLastCellNum();
		xData = new String[xR_TD][xC_TD];
		for(int i=0; i<xR_TD; i++)
		{
			HSSFRow row = mysheet.getRow(i);
			for(int j=0; j<xC_TD; j++)
			{
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				xData[i][j] = value;
				System.out.print("  "+xData[i][j]);
			}
			System.out.println();		
		}
	}
	
	public static String cellToString(HSSFCell cell )
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
				
		case HSSFCell.CELL_TYPE_BLANK:
			result = "-";
			break;
			
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
			
		case HSSFCell.CELL_TYPE_ERROR:
			result="This cell has some error";
			break;
			
		default:
			throw new RuntimeException("We do not support this cell type");
		}
		return result.toString();
	}
		
	
		@Test
		public void test()
		{
		for(int i=1; i<xR_TD; i++)
		{
				a = xData[i][1];
							
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys(a);
		driver.findElement(By.className("gNO89b")).click();
		driver.quit();
		}
		}
}
