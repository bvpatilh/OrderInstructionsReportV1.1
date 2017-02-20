package com.jpmc.tsr.service;

import java.util.List;

import com.jpmc.tsr.manager.TradingReportsManager;
import com.jpmc.tsr.to.TradeReport;
import com.jpmc.tsr.vo.TradeOptions;

public class TradingReportsServiceImpl implements TradingReportsService {

	private TradingReportsManager tradingReportsManager;

	public TradingReportsServiceImpl(TradingReportsManager tradingReportsManager) {
		this.tradingReportsManager = tradingReportsManager;
	}

	public Double incomingSettlementReport() throws Exception {
		return tradingReportsManager.getSettledAmountForDay(TradeOptions.SELL
				.name());
	}

	public Double outgoingSettlementReport() throws Exception {
		return tradingReportsManager.getSettledAmountForDay(TradeOptions.BUY.name());
	}

	public List<TradeReport> incomingSettlementReportByRank() throws Exception {
		return tradingReportsManager.getTradingReport(TradeOptions.SELL.name());

	}

	public List<TradeReport> outgoingSettlementReportByRank() throws Exception {
		return tradingReportsManager.getTradingReport(TradeOptions.BUY.name());
	}
	
}
