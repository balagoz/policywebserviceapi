package com.policywebserviceapi.service;

import java.util.Calendar;
import java.util.Date;

public class ServiceUtil {
	
	/* GET NEXT YEAR TODAY DATE */
	 public static Date getNextYearToday(){
	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.YEAR, 1);
	        Date nextYear = cal.getTime();
	        return nextYear;
	    }
	 
	 /* GET TODAY DATE */ 
	 public static Date getToday(){
	        Calendar cal = Calendar.getInstance();
	        Date today = cal.getTime();
	        cal.add(Calendar.YEAR, 1);
	        return today;
	    }
	 
	 /* GET GENERATE KEY */ 
	 public static String generateKey() {
			
			int n=20;
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"; 
	        StringBuilder sb = new StringBuilder(n); 
	        for (int i = 0; i < n; i++) { 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
        return sb.toString();
	}

}
