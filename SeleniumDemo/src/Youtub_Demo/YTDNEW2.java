package Youtub_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YTDNEW2 {
	public WebDriver driver;
	public static int xC_TD,xR_TD;
	public static String xData[][];
	public static String a,b;
	
	@BeforeTest
	public void setup() throws Exception
	{
		xlread("D:\\Study\\New\\DDF21.xls");
	}
	
	@Test
	public void test1()
	{
		for(int i=1; i<xC_TD; i++)
		{
			if(xData[i][0].equals("N"))
			{
			a = xData[i][1];
			b = xData[i][2];
			
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//Go to Youtube.com
	driver.get("https://www.youtube.com");
	
	//Type the Search Keyword
	driver.findElement(By.id("search")).sendKeys(a);
	
	//Click Search Button and Wait for Search Results
	driver.findElement(By.id("search-icon-legacy")).click();
	
	//Capture the Channel name on Top 3 search results
	String s1 = driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer[1]/div/div/div/ytd-video-meta-block/div/div/div/yt-formatted-string/a")).getText();
	String s2 = driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer[2]/div/div/div/ytd-video-meta-block/div/div/div/yt-formatted-string/a")).getText();
	String s3 = driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer[3]/div/div/div/ytd-video-meta-block/div/div/div/yt-formatted-string/a")).getText();
	
	//print them
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	
	//Compare with our expected Channel Name.Pass if atleast one of them is a pass.
	if(s1.contains(b) || s2.contains(b) || s3.contains(b))
	{
		System.out.println("PASS: Channel Appears");
		xData[i][4] = "PASS";
		xData[i][5] = s1;
		xData[i][6] = s2;
		xData[i][7] = s3;
		
	}
	else
	{
		System.out.println("FAIL: Channel didnot Appear");
		xData[i][4] = "FAIL";
		xData[i][5] = s1;
		xData[i][6] = s2;
		xData[i][7] = s3;
	}
		
	driver.quit();
		}
	}
	}
	
	@AfterTest
	public void endtest() throws Exception
	{
		xlwrite("D:\\Study\\New\\Result_YTDNEW2.xls",xData);
	}

	
	public static void xlread(String vUrl) throws Exception
	{
		File myfile = new File(vUrl);
		FileInputStream mystream = new FileInputStream(myfile);
		HSSFWorkbook myworkbook = new HSSFWorkbook(mystream);
		HSSFSheet mysheet = myworkbook.getSheetAt(1);
		xC_TD = mysheet.getLastRowNum()+1;
		xR_TD = mysheet.getRow(0).getLastCellNum();
		xData = new String[xC_TD][xR_TD];
		for (int i=0; i<xC_TD; i++)
		{
			HSSFRow row = mysheet.getRow(i);
			for(int j=0; j<xR_TD; j++)
			{
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				xData[i][j] = value;
				System.out.print("  "+xData[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void xlwrite(String url,String[][] xData) throws Exception
	{
		File myfile = new File(url);
		FileOutputStream fout = new FileOutputStream(myfile);
		HSSFWorkbook myworkbook = new HSSFWorkbook();
		HSSFSheet mysheet = myworkbook.createSheet("Test Result");
		for(int i=0; i<xC_TD; i++)
		{
			HSSFRow row1 = mysheet.createRow(i);
			for(int j=0; j<xR_TD; j++)
			{
				HSSFCell cell1 = row1.createCell(j);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell1.setCellValue(xData[i][j]);
			}
		}
		myworkbook.write(fout);
		fout.flush();
		fout.close();
	}
	
	public static String cellToString(HSSFCell cell)
	{
		int type = cell.getCellType();
		Object result;
		switch(type)
		{
		case HSSFCell.CELL_TYPE_NUMERIC:
			result=cell.getNumericCellValue();
			break;
			
		case HSSFCell.CELL_TYPE_STRING:
			result=cell.getStringCellValue();
			break;
			
		case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("We cannot evaluate formula");
			
		case HSSFCell.CELL_TYPE_BLANK:
			result = "-";
			break;
			
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result=cell.getBooleanCellValue();
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
