package com.jpmc.tsr;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jpmc.tsr.exception.NoDataFoundException;
import com.jpmc.tsr.factory.ObjectFactory;
import com.jpmc.tsr.manager.TradingReportsManager;
import com.jpmc.tsr.service.dao.OrderInstructionDao;
import com.jpmc.tsr.vo.TradeOptions;

public class TradingReportsManagerTest {
	private static ObjectFactory instance;
	private static TradingReportsManager tradingReportsManager;
	private static 	OrderInstructionDao orderInstructionDao;
	
	@BeforeClass
	public static void setup() {
		instance = ObjectFactory.getInstance();
		tradingReportsManager = instance.getTradingReportsManagerInstance();
		orderInstructionDao = instance.getOrderInstructionDaoInstance();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getSettledAmountForDayNoDataExceptionTest() {
		try{
			tradingReportsManager.getSettledAmountForDay(TradeOptions.SELL.name());
		}catch(NoDataFoundException w){
			Assert.assertTrue(true);
			return;
		}
		Assert.assertTrue(false);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getgetTradingReportNoDataExceptionTest() {
		try{
			tradingReportsManager.getTradingReport(TradeOptions.SELL.name());
		}catch(NoDataFoundException w){
			Assert.assertTrue(true);
			return;
		}
		Assert.assertTrue(false);
	}
}
