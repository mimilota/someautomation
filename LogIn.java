package PamTests;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
	public static WebDriver driver;
	private String portlet;
	private String portleturl;
	
	public LogIn(String portlet) {
	this.portlet = portlet;
		}
	
	public String getPortletName() {
	return portlet;
	}
	
	public void setPortletName(String portlet) {
	this.portlet = portlet;
	}

	
	public void startUp(String portlet) throws Exception {
		//Get url from excel file
		
		
		
	public String getPortleturl(String portlet) {
			File source = new File("C:\\Users\\Mariya.Zlateva\\workspace\\NewPAM\\URLs.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb = new HSSFWorkbook(input);
			HSSFSheet sheet = wb.getSheetAt(0);
			
		switch(portlet) {
			case "BalanceHistory":
		HSSFHyperlink pageUrl = sheet.getRow(0).getCell(1).getHyperlink();
		String portleturl = pageUrl.getAddress();
		System.out.println(portleturl);
		return;
		break;
		
			case"TransactionHistory":
		pageUrl = sheet.getRow(1).getCell(1).getHyperlink();
		portleturl = pageUrl.getAddress();
		System.out.println(portleturl);
		return;
		break;
		
		
		}
		
		//load page
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(portleturl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		
	}
	
}
