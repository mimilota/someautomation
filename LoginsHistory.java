package PamTests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

public class LoginsHistory extends LoadableComponent<LoginsHistory>{
	//Get url from excel file
	File source = new File("C:\\Users\\Mariya.Zlateva\\workspace\\NewPAM\\URLs.xls");
	FileInputStream input = new FileInputStream(source);
	HSSFWorkbook wb = new HSSFWorkbook(input);
	HSSFSheet sheet = wb.getSheetAt(0);
	HSSFHyperlink pageUrl = sheet.getRow(2).getCell(1).getHyperlink();
	String url = pageUrl.getAddress();
			
			
	//loading page		
	private WebDriver driver;
	
	@FindBy(how = How.CSS, using = "select#_cashierplayerloginshistory_WAR_CashierPlayerLoginsHistoryportlet_period")
	private WebElement timeperiodL;	
	@FindBy(how = How.ID, using = "_cashierplayerloginshistory_WAR_CashierPlayerLoginsHistoryportlet_search")
	private WebElement searchL;	
	@FindBy(how = How.CSS, using = ".btn.btn-link")
	private WebElement resetlinkL;
	

public LoginsHistory() throws IOException {
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
public void openB() {
	this.driver.get(url);
}

public void timeperiodselectL () throws InterruptedException{
	Select timeperiodL = new Select(driver.findElement(By.cssSelector("#_cashierplayerloginshistory_WAR_CashierPlayerLoginsHistoryportlet_period")));
	timeperiodL.selectByVisibleText(" Last Month");
	Thread.sleep(1000);
}

public void searchbuttonL () throws InterruptedException{
	searchL.click();
	Thread.sleep(1000);
}


//Check if elements are present on the page after Search is performed
	public void checkelementpresentL() {
		
	if(driver.getPageSource().contains("Login Date"))
			{System.out.println("\n"+"Search-a v Logins History raboti!");
			    
			}

			else
			{
				if(driver.getPageSource().contains("No Records Found! "))
				{	System.out.println("\n"+"Search-a v Logins History raboti!");
				}
				else {
					System.out.println("\n"+"Search-a v Logins History ne raboti!");
				}
				}
	}

	// Click Reset link
	
		public void resetL() throws InterruptedException{
			//driver.findElement(By.cssSelector(".btn.btn-link")).click();
			resetlinkL.click();
			Thread.sleep(1000);
		}
		
		// Check the values of the DropDown
		public void checktimeperiodvaluesL() {
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

		//check if dropdown value is reseted
		public void isresettedL(){		
		if(driver.getPageSource().contains(" Custom Period"))
				{System.out.println("\n"+"RESET-a raboti!");
				    
				}

				else
					System.out.println("%n"+"RESET-a ne raboti!");
		}

		@Override
		protected void isLoaded() throws Error {
			// TODO Auto-generated method stub
			
		}
		public void closeB() {
			this.driver.quit();
		}

}