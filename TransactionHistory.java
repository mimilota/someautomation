package PamTests;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
	import static org.junit.Assert.*;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.WebElement;

	public class TransactionHistory {

		public static WebDriver driver;

		@Before
		public void startUp2() throws Exception {
			//Get url from excel file
			File source = new File("C:\\Users\\Mariya.Zlateva\\workspace\\NewPAM\\URLs.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb = new HSSFWorkbook(input);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFHyperlink pageUrl = sheet.getRow(1).getCell(1).getHyperlink();
			String url = pageUrl.getAddress();
			System.out.println(url);
			
			//load page
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
		@Test
		public void test() throws InterruptedException {
			// Fill the date in the drop downs
			
			WebElement from = driver.findElement(By.id("_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_from"));
			from.click();
			from.sendKeys("01/09/2017");
			WebElement to = driver.findElement(By.id("_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_to"));
			to.click();
			to.sendKeys("15/09/2017");
				// Click Search button
			WebElement search = driver.findElement(By.id("_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_search"));
			search.click();
			Thread.sleep(1000);
			
			//FInd the cell in the table with the date and assert the value
			WebElement date = driver.findElement (By.cssSelector("#_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_transactionWrappersSearchContainerSearchContainer tr:nth-child(2) td:nth-child(4)")); 
		   if(date.getText().equals("15/09/17")) 
			{System.out.println("\n"+"Search-a raboti!");
			    
			}

			else
			{
				System.out.println("\n"+"Search-a ne raboti!");
				}
				
			//Check Reset link
			 driver.findElement(By.partialLinkText("Reset")).click(); 
			 WebElement fromfield = driver.findElement (By.cssSelector("#_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_from"));
			 if(fromfield.getText().equals("")) 
				{System.out.println("\n"+"Reset-a raboti!");
				    
				}
			 
				else
				{
					System.out.println("\n"+"Reset-a ne raboti!");
					}
			 // Click Print 
			
			 driver.findElement(By.cssSelector("#_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_printLink")).click();
				 Thread.sleep(1000);
				
				 
				 driver.close();
		}
	}
	
