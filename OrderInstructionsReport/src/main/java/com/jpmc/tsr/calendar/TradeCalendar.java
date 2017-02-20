package com.jpmc.tsr.calendar;

import java.util.Date;

import com.jpmc.tsr.exception.NonWorkingDayException;

public interface TradeCalendar {

	public boolean isWorkingDayForCurrency(String currency, Date date) throws NonWorkingDayException;

	public Date getNextWorkingDayForCurrency(String currency, Date date);
}
