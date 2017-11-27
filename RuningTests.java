package PamTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RuningTests {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(RegisterDeposit.class);
	     for (Failure failure : result.getFailures()) 
	         System.err.println(failure.toString());
	   
	      
	     System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     Result result1 = JUnitCore.runClasses(Deposit.class);
	    for (Failure failure : result.getFailures()) {
	        System.err.println(failure.toString());
	   }
	      
	     System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	     Result result2 = JUnitCore.runClasses(BalanceHistory.class);
	    for (Failure failure : result.getFailures()) {
	         System.err.println(failure.toString());
	   }
	     System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	    // Result result3 = JUnitCore.runClasses(Withdraw.class);
	    // for (Failure failure : result.getFailures()) {
	    //     System.err.println(failure.toString());
	  // }
	      
	   //  System.out.println();
	   //  System.out.println(result.wasSuccessful());
	     
	     Result result4 = JUnitCore.runClasses(LoginsHistoryScript.class);
	     for (Failure failure : result.getFailures()) {
	         System.err.println(failure.toString());
	   }
	      
	     System.out.println();
	     System.out.println(result.wasSuccessful());
	     
	  //   Result result5 = JUnitCore.runClasses(TransactionHistory.class);
	  ////  for (Failure failure : result.getFailures()) {
	    //    System.err.println(failure.toString());
	  // }
	      
	  //   System.out.println();
	  //  System.out.println(result.wasSuccessful());
	     
}
	
}

	


