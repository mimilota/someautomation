package PamTests;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BalanceHistory2  extends LoadableComponent<BalanceHistory2>{
private WebDriver driver;
private String url = ("http://192.168.200.116:8080/web/mariatestpage/balance-history?username=MARIAPTBGEUR&password=Secret123&clientPlatform=download&clientVersion=10H&clientType=casino&languageCode=EN&htcmdSupport=false");

@FindBy(how = How.CSS, using = "select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")
private WebElement timeperiod;	
@FindBy(how = How.ID, using = "_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_search")
private WebElement search;	
@FindBy(how = How.CSS, using = ".btn.btn-link")
private WebElement resetlink;


	public BalanceHistory2() throws IOException {
		super();
		//this.driver = new FirefoxDriver();
				
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	@Override
	protected void load() {
		this.driver.get(url);
	}
//checked if page is loaded
//	@Override
//	protected void isLoaded() {
//		Assert.assertTrue(driver.getPageSource().contains("Hi,"));
//	}
	public void openB() {
		this.driver.get(url);
	}
	
	public void timeperiodselect () throws InterruptedException{
		Select timeperiod = new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
		timeperiod.selectByVisibleText(" Last Month");
		Thread.sleep(1000);
	}
	
	public void searchbutton () throws InterruptedException{
		search.click();
		Thread.sleep(500);
		int rowCount = driver.findElements(By.xpath(".//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainer']/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath(".//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainer']/tbody/tr(1)/*")).size();
		System.out.println("Number of rows are:" + columnCount);
		System.out.println("Number of rows are:" + rowCount);
	}
	
	// Check if elements are present on the page after Search is performed
	public void checkelementpresent() {
		
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
	}
	// Click Reset link
	
	public void reset() throws InterruptedException{
		//driver.findElement(By.cssSelector(".btn.btn-link")).click();
		resetlink.click();
		Thread.sleep(1000);
	}
	//check if dropdown value is reseted
	public void isresetted(){		
	if(driver.getPageSource().contains(" Last 24 hours"))
			{System.out.println("\n"+"RESET-a raboti!");
			    
			}

			else
				System.out.println("%n"+"RESET-a ne raboti!");
	}

	// Check the values of the DropDown
	public void checktimeperiodvalues() {
		Select timeperiod = new Select(driver.findElement(By.cssSelector("select#_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_period")));
		List<String> exp_options = Arrays.asList(new String[]{" Last 24 hours", " Last 3 Days", " Last 7 Days"," Last Month", " Last 3 Months", " Custom Period"});
    	List<String> act_options = new ArrayList<String>();
    	for(WebElement option : timeperiod.getOptions())
   		 act_options.add(option.getText());
    	assertArrayEquals(exp_options.toArray(),act_options.toArray());
	}
	private void assertArrayEquals(Object[] array, Object[] array2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}
	
	public void exractTableElements(){
		int rowCount = driver.findElements(By.xpath(".//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainer']/tbody/tr")).size();
		int columnCount = driver.findElements(By.xpath(".//*[@id='_cashierbalancehistory_WAR_CashierBalanceHistoryportlet_walletTransactionWrappersSearchContainer']/tbody/tr(1)/*")).size();
		System.out.println("Number of rows are:" + columnCount);
		System.out.println("Number of rows are:" + rowCount);
	}
	
	
	public void closeB() {
		this.driver.quit();
	}

	}
	
			
	
			
					
	




