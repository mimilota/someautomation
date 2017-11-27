package PamTests;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BalanceHistory {

		
	public static WebDriver driver;
	
	@Before
	public void startUp2 () throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//Get url from excel file
		File source = new File("C:\\Users\\Mariya.Zlateva\\workspace\\NewPAM\\URLs.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb = new HSSFWorkbook(input);
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFHyperlink pageUrl = sheet.getRow(0).getCell(1).getHyperlink();
		String url = pageUrl.getAddress();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	
		
	@Test
	public void test() throws InterruptedException {
	
		// Check the values of the DropDown
		Select timeperiod = new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
		List<String> exp_options = Arrays.asList(new String[]{" Last 24 hours", " Last 3 Days", " Last 7 Days"," Last Month", " Last 3 Months", " Custom Period"});
    	List<String> act_options = new ArrayList<String>();
    	for(WebElement option : timeperiod.getOptions())
   		 act_options.add(option.getText());
    	assertArrayEquals(exp_options.toArray(),act_options.toArray());
    	
    	// select special value
    	timeperiod =  new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
    	timeperiod.selectByVisibleText(" Last Month");
    	
    	// click Search button 
    	
    	WebElement search = driver.findElement(By.id("_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search"));
		search.click();
		Thread.sleep(500);
		
		timeperiod =  new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
		timeperiod.selectByVisibleText(" Last 3 Days");
		search = driver.findElement(By.id("_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search"));
    	search.click();
		Thread.sleep(500);

		if(driver.getPageSource().contains("amount"))
		{System.out.println("\n"+"Search-a raboti!");
		    
		}

		else
		{
			if(driver.getPageSource().contains("No Records Found! "))
			{	System.out.println("\n"+"Search-a raboti!");
			}
			else {
				System.out.println("\n"+"Search-a ne raboti!");
			}
			}
		
			
		
		// Click Reset 
				driver.findElement(By.cssSelector(".btn.btn-link")).click();
						Thread.sleep(1000);
				//check if dropdown value is resetted
						
				
				if(driver.getPageSource().contains(" Last 24 hours"))
				{System.out.println("\n"+"RESET-a raboti!");
				    
				}

				else
					System.out.println("%n"+"RESET-a ne raboti!");
				
				
							}
	
	
	
	@Test
	public void test1() throws InterruptedException, Exception {
	Select timeperiod = new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
	timeperiod.selectByVisibleText(" Last Month");
	Thread.sleep(200);
	//@FindBy(how = How.ID, using = "_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search")
	WebElement search = driver.findElement(By.id("_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search"));	
	search.click();
	Thread.sleep(200);
			

	
	
	
	//public static void writeXLSFile() throws IOException {

		

		String excelFileName = "C:\\Users\\Mariya.Zlateva\\workspace\\BalanceHistoryData.xls";//name of excel file



		String sheetName = "MySheet";//name of sheet



		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet(sheetName) ;


		int rowCount = driver.findElements(By.xpath("//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainerSearchContainer']/table/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath("//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainerSearchContainer']/table/tbody/tr[1]/*")).size();
		System.out.println("Number of columns are:" + columnCount);
		System.out.println("Number of rows are:" + rowCount);
		//iterating r number of rows

		for (int i=1;i <= rowCount; i++)

		{

			HSSFRow row = sheet.createRow(i);

		

			//iterating c number of columns

			for (int j = 1; j <= columnCount; j++)

			{

				HSSFCell cell = row.createCell(j);

				WebElement value = driver.findElement(By.xpath("//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainerSearchContainer']/table/tbody/tr[" + i + "]/*["+j + "]"));
				//System.out.println(value);
				String text =  value.getText();
				System.out.println(text);
				row.createCell(j).setCellValue(text);;
				//cell.setCellValue("Cell "+r+" "+c);

			}

		}

		

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		

		//write this workbook to an Outputstream.

		wb.write(fileOut);

		fileOut.flush();

		fileOut.close();

	}
	
	
	
	}

	
