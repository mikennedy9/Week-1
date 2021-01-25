import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class helperMethods {
	
	public static int findIndex(int[] array, int x) {
		if(array == null) {
			return -1;
		}
		
		int value = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == x) {
				value = i;
			}
		}
		return value;
	}
	
	
	public static List<String> combineArray(String[] customers, double[][] payments) {
		
		List<String> customerPayments = new ArrayList<>();

		for (int i = 0; i < customers.length; i++) {
	        StringJoiner sj = new StringJoiner(", ");
	        int missedPayments = 0;
	        int total = 0;
	        
	        for (double x : payments[i]) {
	        	if(x == 0) {
	        		total = total + 1;
	        	}
	        	missedPayments = total;
	            sj.add(String.format("%.0f", x));
	        }
	        
	       String acctStanding = "";
	        
	        if(missedPayments == 0) {
	        	acctStanding = "Good";
	        }
	        if(missedPayments == 1) {
	        	acctStanding = "Fair";
	        }
	        if(missedPayments == 2) {
	        	acctStanding = "Poor";
	        }
	        if(missedPayments > 2) {
	        	acctStanding = "Closed";
	        }

	        sj.add(acctStanding);
	        customerPayments.add(String.format("%s %s", customers[i], sj));
	    }

		return customerPayments;
	}
	
	
	public static String findAccount(List<String> accounts, int acctNumber) {
		
		String acct = Integer.toString(acctNumber);
		String locatedAcct = "";
		
		for(String x : accounts) {
			if(x.contains(acct)) {
				locatedAcct = x;
			}else {
				return "No account found!";
			}
		}
		return locatedAcct;
	}
	
	public static List<String> missedPaymentAccts(List<String> accounts){
		List<String> accts = new ArrayList<>();
		for(String x : accounts) {
			if(x.contains(" 0,")) {
				accts.add(x);
			}
		}
		return accts;
	
	}
	
	public static List<String> closedAccounts(List<String> accounts){
		List<String> accts = new ArrayList<>();
		for(String x : accounts) {
			if(x.contains("Closed")) {
				accts.add(x);
			}
		}
		return accts;
	
	}

	
	

}
