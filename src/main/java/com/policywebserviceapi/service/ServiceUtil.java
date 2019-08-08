package com.policywebserviceapi.service;

import java.util.Calendar;
import java.util.Date;

public class ServiceUtil {
	
	 public static Date getNextYearToday(){
	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.YEAR, 1);
	        Date nextYear = cal.getTime();
	        return nextYear;
	    }
	 
	 public static Date getToday(){
	        Calendar cal = Calendar.getInstance();
	        Date today = cal.getTime();
	        cal.add(Calendar.YEAR, 1);
	        return today;
	    }

}
