package PamTests;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class WriteTableDataInFIle {



		public static WebDriver driver;
		@Before
		public void startUp2() {
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(
				"http://192.168.200.116:8080/web/mariatestpage/balance-history?username=MARIAPTBGEUR&password=Secret123&clientPlatform=download&clientVersion=10H&clientType=casino&languageCode=EN&htcmdSupport=false");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
		
		@Test
		public void test() throws InterruptedException, Exception {
		Select timeperiod = new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
		timeperiod.selectByVisibleText(" Last Month");
		Thread.sleep(200);
		//@FindBy(how = How.ID, using = "_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search")
		WebElement search = driver.findElement(By.id("_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search"));	
		search.click();
		Thread.sleep(200);
				
	
		
		
		
		//public static void writeXLSFile() throws IOException {

			

			String excelFileName = "D:/Test.xls";//name of excel file



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


