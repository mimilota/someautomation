package PamTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Withdraw {

	public static WebDriver driver;

	@Before
	public void startUp2() throws Exception {
		
		//Get url from excel file
		File source = new File("C:\\Users\\Mariya.Zlateva\\workspace\\NewPAM\\URLs.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb = new HSSFWorkbook(input);
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFHyperlink pageUrl = sheet.getRow(3).getCell(1).getHyperlink();
		String url = pageUrl.getAddress();
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@Test
	public void test() throws InterruptedException {
	
		WebElement 	amount = driver.findElement(By.xpath("//*[@id='_cashierwithdraw_WAR_CashierWithdrawportlet_amount']"));
		amount.click();
		amount.sendKeys("10");
driver.findElement(By.cssSelector(".btn.btn-primary.btn-large")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[.='Ok']")).click();
//Click Ok in next Modal
driver.findElement(By.xpath("//*[.='Ok']")).click();
driver.findElement(By.xpath("//*[.='Ok']")).click();
Thread.sleep(1000);
if(driver.getPageSource().contains("Success"))
{System.out.println("Correct withdraw");
   }

else {
	System.out.println("Something is wrong!");
}
driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
// open Pending withdraws tab
driver.findElement(By.xpath("//span[contains(text(),' Pending Withdrawals')]")).click();

driver.findElement(By.xpath("//*[@id='_cashiertransactionhistory_WAR_CashierTransactionHistoryportlet_cancel']")).click();

driver.findElement(By.xpath("//button[contains(text(),'Confirm Cancel')]")).click();
Thread.sleep(500);

if(driver.getPageSource().contains("Your pending withdrawal is canceled successfully!"))
System.out.println("Correct cancel withdraw");
   

else {
	System.out.println("Something is wrong canceling withdrawal!");
}

driver.close();


}
}
