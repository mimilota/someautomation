package SanityPMGW;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Deposit3D {
	public static WebDriver driver;

	@Before
	public void startUp2() {
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://intstg-pam-privil-admin-01.staging.ptec:8080/web/ptstg_sportium/deposit?clientChannel=&clientPlatform=web&clientType=portal&clientVersion=1&languageCode=EN&callId=&username=MARIAPTBGBP&password=Secret123&notChangeOrg=true"  

);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@Test
	public void test() throws InterruptedException {
	//fill the cvv code and amount
		WebElement 	cvv = driver.findElement(By.xpath("//*[@id='_cashierdeposit_WAR_CashierDepositportlet_CVV2']"));
		cvv.click();
		cvv.sendKeys("123");
		WebElement amount =  driver.findElement(By.cssSelector("#_cashierdeposit_WAR_CashierDepositportlet_amount"));
		amount.click();
		amount.sendKeys("10");
		driver.findElement(By.cssSelector(".btn")).click(); 
		Thread.sleep(1000);
		
		//Check Deposit result
				
				if (driver.findElement(By.className("modal-body")).getText().contains("Your credit card transaction has been declined by your bank"))
				System.out.println("\n"+"3D Deposit error!");
				else
				{
					if (driver.findElement(By.className("modal-header")).getText().contains("Deposit"))
				
					{	System.out.println("\n"+"3D Deposit was successful!");
					}
					else{
						System.out.println("\n"+"I don't know what is going on!");
					}
					}
					}
//driver.close();
}