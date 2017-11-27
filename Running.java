package SanityPMGW;


	import org.junit.runner.JUnitCore;
	import org.junit.runner.Result;
	import org.junit.runner.notification.Failure;

	public class Running {

		public static void main(String[] args) {
			Result result = JUnitCore.runClasses(Deposit.class);
		     for (Failure failure : result.getFailures()) {
		         System.err.println(failure.toString());
		   }
		      
		     System.out.println();
		     System.out.println(result.wasSuccessful());
		     
		     Result result1 = JUnitCore.runClasses(Deposit3D.class);
		     for (Failure failure : result1.getFailures()) {
		         System.err.println(failure.toString());
		   }
		      
		     System.out.println();
		     System.out.println(result.wasSuccessful());
	}

}
