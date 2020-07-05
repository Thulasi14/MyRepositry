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

public class Readfile {

	public WebDriver driver;
	public static int xR_TD,xC_TD;
	public static String xData[][];
	public static String vKW, vCh;
	
	@BeforeTest
	public void setup() throws Exception
	{
		xlRead("D:\\Study\\DDF1.xlt");
	}
	

	@Test
	public void test1()
	{ 
		for (int i=1; i<xR_TD; i++)
		{
			vKW = xData[i][1];
			vCh = xData[i][2];
		
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("https://www.youtube.com");
	driver.findElement(By.id("search")).sendKeys(vKW);
	driver.findElement(By.id("search-icon-legacy")).click();
	
	//Get the top 3 videos
	String s1 = driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer[1]/div/div/div/ytd-video-meta-block/div/div/div/yt-formatted-string/a")).getText();
	String s2 = driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer[2]/div/div/div/ytd-video-meta-block/div/div/div/yt-formatted-string/a")).getText();
	String s3 = driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer[3]/div/div/div/ytd-video-meta-block/div/div/div/yt-formatted-string/a")).getText();
	
	//print them
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	
	//Compare
	if(s1.contains(vCh) || s2.contains(vCh) || s3.contains(vCh))
	{
		System.out.println("PASS: Channel Appears");
		xData[i][4] = "PASS";
		xData[i][5] = s1;
		xData[i][6] = s2;
		xData[i][7] = s3;
				
	}
	else
		System.out.println("FAIL: Channel didnot Appear");
		xData[i][4] = "FAIL";
		xData[i][5] = s1;
		xData[i][6] = s2;
		xData[i][7] = s3;
		driver.quit();
	}
	driver.quit();
	}
	
	@AfterTest
	public void Endtest() throws Exception
	{
		xlwrite("D:\\Study\\Result.xlt", xData);
	}
	
	public static void xlRead(String vURL) throws Exception
	{
		File myfile = new File(vURL);
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
				String value = cell.getStringCellValue();
				xData[i][j] = value;
				System.out.print("   "+xData[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void xlwrite(String xlpath1, String[][] xData) throws Exception
	{
		File myfile = new File(xlpath1);
		FileOutputStream mystream = new FileOutputStream(myfile);
		HSSFWorkbook myworkbook = new HSSFWorkbook();
		HSSFSheet mysheet = myworkbook.createSheet("Test Results");
		for(int i=0; i<xR_TD; i++)
		{
			HSSFRow row1 = mysheet.createRow(i);
			for(int j=0; j<xC_TD; j++)
			{
				HSSFCell cell1 = row1.createCell(j);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell1.setCellValue(xData[i][j]);
			}
		}
		myworkbook.write(mystream);
		mystream.flush();
		mystream.close();
	}
}

