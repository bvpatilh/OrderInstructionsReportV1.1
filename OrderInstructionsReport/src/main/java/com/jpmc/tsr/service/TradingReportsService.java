package com.jpmc.tsr.service;

import java.util.List;

import com.jpmc.tsr.to.TradeReport;

public interface TradingReportsService {

	public Double incomingSettlementReport() throws Exception;

	public Double outgoingSettlementReport() throws Exception;

	public List<TradeReport> incomingSettlementReportByRank()
			throws Exception;

	public List<TradeReport> outgoingSettlementReportByRank()
			throws Exception;
}
