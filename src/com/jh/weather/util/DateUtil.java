/**
 * 
 */
package com.jh.weather.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author sumit
 *
 */
public class DateUtil {
	
	/**
	 * DEFAULT_DATE_TIME
	 */
	private static final String DEFAULT_DATE_TIME = "MM-dd-yyyy HH:mm:ss Z"; 
	
	/**
	 * DEFAULT_DATE
	 */
	private static final String DEFAULT_DATE = "MM-dd-yyyy"; 
	
	/**
	 * DEFAULT_TIME
	 */
	private static final String DEFAULT_TIME = "HH:mm:ss Z"; 
	
	/**
	 * @return the defaultDateTime
	 */
	public static String getDEFAULT_DATE_TIME() {
		return DEFAULT_DATE_TIME;
	}

	/**
	 * @return the defaultDate
	 */
	public static String getDEFAULT_DATE() {
		return DEFAULT_DATE;
	}

	/**
	 * @return the defaultTime
	 */
	public static String getDEFAULT_TIME() {
		return DEFAULT_TIME;
	}

	/**
	 * @param format
	 * @return
	 */
	public String getCurrentTime(String format) {
		String formattedDate = "";
		try {
			if(format.trim() == null || format.trim().isEmpty()) {
				format = DEFAULT_DATE_TIME;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			formattedDate = sdf.format(Calendar.getInstance().getTime());
		} catch(NullPointerException npe) {
			System.out.println(Calendar.getInstance().getTime().toString() 
					+ " : NullPointerException occurred in DateUtil.getCurrentTime(): ");
			npe.printStackTrace();
		}catch(IllegalArgumentException iae) {
			System.out.println(Calendar.getInstance().getTime().toString() 
				+ " : IllegalArgumentException occurred in DateUtil.getCurrentTime(): ");
			iae.printStackTrace();
		}catch(Exception e) {
			System.out.println(Calendar.getInstance().getTime().toString() 
					+ " : Error occurred in DateUtil.getCurrentTime(): ");
			e.printStackTrace();
		}
		return formattedDate;
	}
	
	/**
	 * @return
	 */
	public String getDefault() {
		String formattedDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_TIME);
			formattedDate = sdf.format(Calendar.getInstance().getTime());
		} catch(NullPointerException npe) {
			System.out.println(Calendar.getInstance().getTime().toString() 
					+ " : NullPointerException occurred in DateUtil.getCurrentTime(): ");
			npe.printStackTrace();
		}catch(IllegalArgumentException iae) {
			System.out.println(Calendar.getInstance().getTime().toString() 
				+ " : IllegalArgumentException occurred in DateUtil.getCurrentTime(): ");
			iae.printStackTrace();
		}catch(Exception e) {
			System.out.println(Calendar.getInstance().getTime().toString() 
					+ " : Error occurred in DateUtil.getCurrentTime(): ");
			e.printStackTrace();
		}
		return formattedDate;
	}
	
}
