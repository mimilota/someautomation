package PamTests;
import org.junit.Test;

public class LoginsHistoryScript {
	@Test

		public void LoginsPeriod() throws Throwable,InterruptedException {
			LoginsHistory page = new LoginsHistory ();
			page.openB();
			Thread.sleep(1000);
			page.checktimeperiodvaluesL();
			page.timeperiodselectL();
			page.searchbuttonL();
			page.checkelementpresentL();
			page.resetL();
			page.isresettedL();
			//page.closeB();
		}

	}


