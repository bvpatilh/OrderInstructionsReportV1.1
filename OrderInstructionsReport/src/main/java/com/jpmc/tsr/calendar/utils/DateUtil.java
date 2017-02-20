package com.jpmc.tsr.calendar.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getDayFromDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String day = new SimpleDateFormat("EE").format(date).toUpperCase();
		return day;
	}

	public static Date getNextDate(Date date, int nuomberOfDays) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, nuomberOfDays);
		date = c.getTime();
		return date;
	}

	public static void main(String args[]) {
		DateUtil.getDayFromDate(new Date());
		DateUtil.getNextDate(new Date(), 15);
	}
}
