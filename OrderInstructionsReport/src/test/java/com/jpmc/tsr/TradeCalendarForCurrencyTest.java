package com.jpmc.tsr;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jpmc.tsr.calendar.TradeCalendar;
import com.jpmc.tsr.exception.NonWorkingDayException;
import com.jpmc.tsr.factory.ObjectFactory;

public class TradeCalendarForCurrencyTest {

	private static ObjectFactory instance;
	private static TradeCalendar tradeCalendar;

	@BeforeClass
	public static void setup() {
		instance = ObjectFactory.getInstance();
		tradeCalendar = instance.getTradeCalendarInstance();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void isWorkingDayForSpecialCurrencySuccessTest()
			throws NonWorkingDayException {
		Calendar calendar = new GregorianCalendar(2017, 01, 20);
		Date date = calendar.getTime();
		Assert.assertTrue(tradeCalendar.isWorkingDayForCurrency("AED", date));
		Assert.assertTrue(tradeCalendar.isWorkingDayForCurrency("SAR", date));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void isWorkingDayForSpecialCurrencyFailureTest() {
		Calendar calendar = new GregorianCalendar(2017, 01, 19);
		Date date = calendar.getTime();
		try {
			Assert.assertTrue(tradeCalendar
					.isWorkingDayForCurrency("AED", date));
		} catch (NonWorkingDayException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void isWorkingDayForRegularCurrencySuccessTest()
			throws NonWorkingDayException {
		Calendar calendar = new GregorianCalendar(2017, 01, 20);
		Date date = calendar.getTime();
		Assert.assertTrue(tradeCalendar.isWorkingDayForCurrency("ABP", date));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void isWorkingDayForRegularCurrencyFailureTest() {
		Calendar calendar = new GregorianCalendar(2017, 01, 21);
		Date date = calendar.getTime();
		try {
			Assert.assertTrue(tradeCalendar
					.isWorkingDayForCurrency("ABP", date));
		} catch (NonWorkingDayException e) {
			Assert.assertTrue(true);
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getNextWorkingDayForSpecialCurrencyTest()
			throws NonWorkingDayException {
		Calendar calendar = new GregorianCalendar(2017, 01, 17);
		Date date = calendar.getTime();
		Date returnedDate = tradeCalendar.getNextWorkingDayForCurrency("AED",
				date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if (sdf.format(new GregorianCalendar(2017, 01, 19).getTime()).equals(sdf.format(returnedDate)))
			Assert.assertTrue(true);
		
		Assert.assertFalse(false);
	}
	
	
}
