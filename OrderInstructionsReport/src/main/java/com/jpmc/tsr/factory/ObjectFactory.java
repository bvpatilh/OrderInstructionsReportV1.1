package com.jpmc.tsr.factory;

import com.jpmc.tsr.calculator.TradeAmountCalculator;
import com.jpmc.tsr.calculator.TradeCalculator;
import com.jpmc.tsr.calendar.TradeCalendar;
import com.jpmc.tsr.calendar.TradeCalendarForCurrency;
import com.jpmc.tsr.manager.TradingReportsManager;
import com.jpmc.tsr.manager.TradingReportsManagerImpl;
import com.jpmc.tsr.service.TradingReportsService;
import com.jpmc.tsr.service.TradingReportsServiceImpl;
import com.jpmc.tsr.service.dao.OrderInstructionDao;
import com.jpmc.tsr.service.dao.OrderInstructionDaoImpl;

public class ObjectFactory {

	private static ObjectFactory instance;
	private OrderInstructionDao orderInstructionDao;
	TradeCalendar tradeCalendar;
	TradeCalculator tradeCalculator;
	TradingReportsManager tradingReportsManager;
	TradingReportsService tradingReportsService;

	private ObjectFactory() {
		orderInstructionDao = new OrderInstructionDaoImpl();
		tradeCalendar = new TradeCalendarForCurrency();
		tradeCalculator = new TradeAmountCalculator();
		tradingReportsManager = new TradingReportsManagerImpl(
				orderInstructionDao, tradeCalendar, tradeCalculator);
		tradingReportsService = new TradingReportsServiceImpl(
				tradingReportsManager);
	}

	public static ObjectFactory getInstance() {
		if (instance == null)
			instance = new ObjectFactory();
		return instance;
	}

	public TradeCalendar getTradeCalendarInstance() {
		return tradeCalendar;
	}

	public TradeCalculator getTradeCalculatorInstance() {
		return tradeCalculator;
	}

	public OrderInstructionDao getOrderInstructionDaoInstance() {
		return orderInstructionDao;
	}

	public TradingReportsManager getTradingReportsManagerInstance() {
		return tradingReportsManager;
	}

	public TradingReportsService getTradingReportsServiceInstance() {
		return tradingReportsService;
	}
}
