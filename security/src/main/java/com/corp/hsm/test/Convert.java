package com.corp.hsm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {

	public static Date toDate(String gregorianDate, String dateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);		
		return sdf.parse(gregorianDate);
	}

	public static String toString(Date gregorianDate, String dateFormat) {		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);		
		return sdf.format(gregorianDate);
	}
}
