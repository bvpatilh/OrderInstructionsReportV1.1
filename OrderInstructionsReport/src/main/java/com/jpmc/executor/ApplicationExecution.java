package com.jpmc.executor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.jpmc.tsr.factory.ObjectFactory;
import com.jpmc.tsr.service.TradingReportsService;
import com.jpmc.tsr.service.dao.OrderInstructionDao;
import com.jpmc.tsr.to.TradeReport;
import com.jpmc.tsr.vo.OrderInstruction;
import com.jpmc.tsr.vo.TradeOptions;

public class ApplicationExecution {

	public static void main(String args[]) throws Exception {
		new ApplicationExecution().execute();
	}

	private void execute() throws Exception {
		ObjectFactory instance = ObjectFactory.getInstance();
		OrderInstructionDao orderInstructionDao = instance
				.getOrderInstructionDaoInstance();
		TradingReportsService tradingReportsService = instance
				.getTradingReportsServiceInstance();
		orderInstructionDao
				.saveOrderInstructions(getIncomingOrderInstrcutions());
		System.out.println("Amount settled incoming $"
				+ tradingReportsService.incomingSettlementReport());

		orderInstructionDao
				.saveOrderInstructions(getOutGoingOrderInstrcutions());
		System.out.println("Amount settled outgoing $"
				+ tradingReportsService.outgoingSettlementReport());

		orderInstructionDao
		.saveOrderInstructions(getIncomingOrderInstrcutions());
		List<TradeReport> incomingReport = tradingReportsService
				.incomingSettlementReportByRank();
		System.out.println("Incoming by Rank --------------");
		for (TradeReport report : incomingReport) {
			System.out.println(report);
		}

		orderInstructionDao
		.saveOrderInstructions(getOutGoingOrderInstrcutions());
		List<TradeReport> outgoingReport = tradingReportsService
				.outgoingSettlementReportByRank();
		System.out.println("OutGoing by Rank --------------");
		for (TradeReport report : outgoingReport) {
			System.out.println(report);
		}
	}

	private List<OrderInstruction> getOutGoingOrderInstrcutions() {
		List<OrderInstruction> orderInstructions = new ArrayList<OrderInstruction>();
		orderInstructions.add(new OrderInstruction("ABDP", TradeOptions.BUY,
				0.50, new Date(), new Date(), 200, 100.25, "INR"));
		orderInstructions.add(new OrderInstruction("AASC", TradeOptions.BUY,
				0.80, new Date(), new Date(), 250, 200.25, "GBP"));

		// Months are zero based
		Calendar calendar5 = new GregorianCalendar(2017, 01, 20);
		Date date5 = calendar5.getTime();
		orderInstructions.add(new OrderInstruction("SAR", TradeOptions.BUY,
				0.50, new Date(), date5, 500, 300.25, "SAR"));

		Calendar calendar = new GregorianCalendar(2017, 01, 24);
		Date date = calendar.getTime();
		orderInstructions.add(new OrderInstruction("SAR", TradeOptions.BUY,
				0.50, new Date(), date, 500, 300.25, "SAR"));

		Calendar calendar1 = new GregorianCalendar(2017, 01, 21);
		Date date1 = calendar1.getTime();
		orderInstructions.add(new OrderInstruction("AED", TradeOptions.BUY,
				0.50, new Date(), date1, 130, 100.25, "AED"));

		Calendar calendar2 = new GregorianCalendar(2017, 01, 21);
		Date date2 = calendar2.getTime();
		orderInstructions.add(new OrderInstruction("AVX", TradeOptions.BUY,
				0.50, new Date(), date2, 100, 700.25, "GBP"));

		Calendar calendar3 = new GregorianCalendar(2017, 01, 22);
		Date date3 = calendar3.getTime();
		orderInstructions.add(new OrderInstruction("DMC", TradeOptions.BUY,
				0.20, new Date(), date3, 200, 500.25, "ASD"));

		Calendar calendar4 = new GregorianCalendar(2017, 01, 25);
		Date date4 = calendar4.getTime();
		orderInstructions.add(new OrderInstruction("DMC", TradeOptions.BUY,
				0.20, date4, date4, 200, 500.25, "EUR"));
		
		return orderInstructions;
	}

	private List<OrderInstruction> getIncomingOrderInstrcutions() {
		List<OrderInstruction> orderInstructions = new ArrayList<OrderInstruction>();

		orderInstructions.add(new OrderInstruction("ADIG", TradeOptions.SELL,
				0.70, new Date(), new Date(), 300, 300.25, "INR"));
		orderInstructions.add(new OrderInstruction("ADN", TradeOptions.SELL,
				0.80, new Date(), new Date(), 300, 300.25, "ASD"));
		orderInstructions.add(new OrderInstruction("AED", TradeOptions.SELL,
				0.50, new Date(), new Date(), 100, 300.25, "AED"));
		
		// Months are zero based
		Calendar calendar = new GregorianCalendar(2017, 01, 20);
		Date date = calendar.getTime();
		orderInstructions.add(new OrderInstruction("SAR", TradeOptions.SELL,
				0.50, new Date(), date, 100, 300.25, "SAR"));

		Calendar calendar1 = new GregorianCalendar(2017, 01, 24);
		Date date1 = calendar1.getTime();
		orderInstructions.add(new OrderInstruction("AED", TradeOptions.SELL,
				0.50, new Date(), date1, 170, 100.25, "AED"));

		Calendar calendar2 = new GregorianCalendar(2017, 01, 21);
		Date date2 = calendar2.getTime();
		orderInstructions.add(new OrderInstruction("ACX", TradeOptions.SELL,
				0.50, new Date(), date2, 100, 700.25, "INR"));

		Calendar calendar3 = new GregorianCalendar(2017, 01, 24);
		Date date3 = calendar3.getTime();
		orderInstructions.add(new OrderInstruction("AFX", TradeOptions.SELL,
				0.20, new Date(), date3, 200, 500.25, "EUR"));

		return orderInstructions;
	}
}
