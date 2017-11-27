package PamTests;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class RegisterDeposit {
	public static WebDriver driver;

	@Before
	public void startUp2() {
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"http://192.168.200.116:8080/web/mariatestpage/register-deposit?username=MARIAPTBGEUR&password=Secret123&clientPlatform=download&clientVersion=10H&clientType=casino&languageCode=EN&htcmdSupport=false");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {

		WebElement used = driver.findElement(By.xpath("//*[@id='payment-cat']/li[2]/a"));
		used.click();
		Thread.sleep(1000);
		WebElement visa = driver.findElement(By.xpath("//*[@class='payment_method selected' and contains(@data-methodcode,'VISA')]"));
		visa.click();
		Thread.sleep(1000);
				
		CreditCardGenerator a = new CreditCardGenerator();
		String[] numberCC = a.generateVisaCardNumbers(1);
							
		WebElement 	cardnum = driver.findElement(By.xpath("//*[@id='_cashierdeposit_WAR_CashierDepositportlet_cardNumber']"));
		cardnum.click();
		cardnum.sendKeys(numberCC);
		
		Select expyear = new Select(driver.findElement(By.cssSelector("select#_cashierdeposit_WAR_CashierDepositportlet_year")));
		expyear.selectByVisibleText("2020");
		Select expmonth = new Select(driver.findElement(By.cssSelector("select#_cashierdeposit_WAR_CashierDepositportlet_month")));
		expmonth.selectByVisibleText("10");
		WebElement 	cvv = driver.findElement(By.xpath("//*[@id='_cashierdeposit_WAR_CashierDepositportlet_CVV2']"));
		cvv.click();
		cvv.sendKeys("123");
		// Click Register
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-large")).click();
		Thread.sleep(1000);
		// Click Ok in Modal
		driver.findElement(By.xpath("//*[.='Ok']")).click();
		// Click Ok in next Modal
		driver.findElement(By.xpath("//*[.='Ok']")).click();
		driver.close();
	}
			
}