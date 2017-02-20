package com.jpmc.tsr.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.jpmc.tsr.calculator.CalculatorInput;
import com.jpmc.tsr.calculator.TradeCalculator;
import com.jpmc.tsr.calendar.TradeCalendar;
import com.jpmc.tsr.comparator.TradingReportComparator;
import com.jpmc.tsr.exception.NoDataFoundException;
import com.jpmc.tsr.exception.NonWorkingDayException;
import com.jpmc.tsr.service.dao.OrderInstructionDao;
import com.jpmc.tsr.to.TradeReport;
import com.jpmc.tsr.vo.OrderInstruction;

public class TradingReportsManagerImpl implements TradingReportsManager {
	private static final String SIMPLE_DATE_FORMAT = "yyyyMMdd";
	private OrderInstructionDao orderInstructionDao;
	private TradeCalendar tradeCalendar;
	private TradeCalculator tradeCalculator;
	private static final Logger LOGGER = Logger.getLogger(TradingReportsManagerImpl.class.getName());

	public TradingReportsManagerImpl(OrderInstructionDao orderInstructionDao,
			TradeCalendar tradeCalendar, TradeCalculator tradeCalculator) {
		this.orderInstructionDao = orderInstructionDao;
		this.tradeCalendar = tradeCalendar;
		this.tradeCalculator = tradeCalculator;
	}

	public Double getSettledAmountForDay(String tradeOption) throws NoDataFoundException {
		Double tradeAmount = 0.0;
		List<OrderInstruction> orderInstructions = orderInstructionDao
				.getOrderInstructions(tradeOption);
		
		if (orderInstructions == null || orderInstructions.size() < 1)
			throw new NoDataFoundException("No data available");
		for (OrderInstruction orderInstruction : orderInstructions) {
			Date settelmentDate = null;
			try {
				if (tradeCalendar.isWorkingDayForCurrency(
						orderInstruction.getCurrency(),
						orderInstruction.getSettlementDateDate()))
					settelmentDate = orderInstruction.getSettlementDateDate();
				else
					settelmentDate = tradeCalendar
							.getNextWorkingDayForCurrency(
									orderInstruction.getCurrency(),
									orderInstruction.getSettlementDateDate());
			} catch (NonWorkingDayException e) {
				LOGGER.warning(e.getMessage() + ": Entity : " + orderInstruction.getEntity());
				continue;
			}
			Date todayDate = new Date();
			if (!isSettlementMadeToday(settelmentDate, todayDate))
				continue;

			CalculatorInput input = new CalculatorInput();
			input.setAgreedFx(orderInstruction.getAgreedFx());
			input.setPricePerUnits(orderInstruction.getPricePerUnits());
			input.setUnits(orderInstruction.getUnits());

			tradeAmount = tradeAmount + tradeCalculator.calculate(input);
		}
		return tradeAmount;
	}

	private boolean isSettlementMadeToday(Date settelmentDate, Date todayDate) {

		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		if (sdf.format(settelmentDate).equals(sdf.format(todayDate)))
			return true;

		return false;
	}

	public List<TradeReport> getTradingReport(String tradeOption) throws NoDataFoundException {
		List<OrderInstruction> orderInstructions = orderInstructionDao
				.getOrderInstructions(tradeOption);
		List<TradeReport> reports = new ArrayList<TradeReport>();
		if (orderInstructions == null || orderInstructions.size() < 1)
			throw new NoDataFoundException("No data available");

		for (OrderInstruction orderInstruction : orderInstructions) {
			Date settelmentDate = null;
			try {
				if (tradeCalendar.isWorkingDayForCurrency(
						orderInstruction.getCurrency(),
						orderInstruction.getSettlementDateDate())) {
					settelmentDate = orderInstruction.getSettlementDateDate();
				} else
					settelmentDate = tradeCalendar.getNextWorkingDayForCurrency(
							orderInstruction.getCurrency(),
							orderInstruction.getSettlementDateDate());
			} catch (NonWorkingDayException e) {
				LOGGER.warning(e.getMessage() + ": Entity : " + orderInstruction.getEntity());
				continue;
			}
			Date todayDate = new Date();
			if (!isSettlementMadeToday(settelmentDate, todayDate))
				continue;
			TradeReport report = new TradeReport();
			report.setSettlementDate(settelmentDate);
			CalculatorInput input = new CalculatorInput();
			input.setAgreedFx(orderInstruction.getAgreedFx());
			input.setPricePerUnits(orderInstruction.getPricePerUnits());
			input.setUnits(orderInstruction.getUnits());

			report.setTradeAmount(tradeCalculator.calculate(input));
			report.setEntity(orderInstruction.getEntity());
			report.setInstructionDate(orderInstruction.getInstructionDate());
			reports.add(report);
		}

		Collections.sort(reports, new TradingReportComparator());
		return reports;
	}
}
