package com.jpmc.tsr.calendar;

import java.util.Date;

import com.jpmc.tsr.calendar.utils.DateUtil;
import com.jpmc.tsr.exception.NonWorkingDayException;

public class TradeCalendarForCurrency implements TradeCalendar {

	public enum NonWorkingDay {
		SAT, SUN
	}

	public enum SpecialNonWorkingDay {
		FRI, SAT
	}

	public enum SpecialCurrency {
		AED, SAR
	}

	public boolean isWorkingDayForCurrency(String currency, Date date) throws NonWorkingDayException {

		String day = DateUtil.getDayFromDate(date);

		if (isSpecialCurrency(currency)) {
			if (SpecialNonWorkingDay.FRI.name().toString().equalsIgnoreCase(day)
					|| SpecialNonWorkingDay.SAT.name().toString().equalsIgnoreCase(day)) {
				throw new NonWorkingDayException(" Nonworking day for the currency " + currency);
			}
		} else {
			if (NonWorkingDay.SAT.name().toString().equalsIgnoreCase(day)
					|| NonWorkingDay.SUN.name().toString().equalsIgnoreCase(day))
				throw new NonWorkingDayException(" Nonworking day for the currency " + currency);
		}

		return true;
	}

	private boolean isSpecialCurrency(String currency) {
		return SpecialCurrency.AED.name().toString().equalsIgnoreCase(currency)
				|| SpecialCurrency.SAR.name().toString().equalsIgnoreCase(currency);
	}

	public Date getNextWorkingDayForCurrency(String currency, Date date) {
		String day = DateUtil.getDayFromDate(date);
		Date nextdate = null;
		if (isSpecialCurrency(currency))
			nextdate = getNextDayForSpecialCurrency(date, day, nextdate);
		else
			nextdate = getNextDay(date, day, nextdate);
		return nextdate;
	}

	private Date getNextDay(Date date, String day, Date nextdate) {
		if (NonWorkingDay.SAT.name().toString().equalsIgnoreCase(day))
			nextdate = DateUtil.getNextDate(date, 2);

		if (NonWorkingDay.SUN.name().toString().equalsIgnoreCase(day))
			nextdate = DateUtil.getNextDate(date, 1);
		return nextdate;
	}

	private Date getNextDayForSpecialCurrency(Date date, String day,
			Date nextdate) {
		if (SpecialNonWorkingDay.FRI.name().toString().equalsIgnoreCase(day))
			nextdate = DateUtil.getNextDate(date, 2);

		if (SpecialNonWorkingDay.SAT.name().toString().equalsIgnoreCase(day))
			nextdate = DateUtil.getNextDate(date, 1);
		return nextdate;
	}
}
