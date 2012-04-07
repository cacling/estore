package com.google.code.estore.domain.shared.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	
	public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
	
	public static Date parseDate(String date) {
		try {
			return DateUtils.parseDate(date, new String[]{DEFAULT_DATE_FORMAT});
		} catch (ParseException e) {
			throw new RuntimeException("Error when parse "+ date +" with format " + DEFAULT_DATE_FORMAT,e);
		}
	}
	

}
