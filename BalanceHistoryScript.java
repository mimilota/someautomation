package PamTests;
import org.junit.Test;

//import ScriptsVersion.BalanceHistory;
public class BalanceHistoryScript {
	@Test
	public void TimePeriod() throws Throwable,InterruptedException {
		BalanceHistory2 page = new BalanceHistory2 ();
		page.openB();
		Thread.sleep(500);
		page.checktimeperiodvalues();
		page.timeperiodselect();
		page.searchbutton();
		page.checkelementpresent();
		page.reset();
		page.isresetted();
		page.closeB();
	}
}
