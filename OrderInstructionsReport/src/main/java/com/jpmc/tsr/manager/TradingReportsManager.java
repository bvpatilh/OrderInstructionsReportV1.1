package com.jpmc.tsr.manager;

import java.util.List;

import com.jpmc.tsr.exception.NoDataFoundException;
import com.jpmc.tsr.to.TradeReport;

public interface TradingReportsManager {

	public List<TradeReport> getTradingReport(String tradeOption) throws NoDataFoundException;
	public Double getSettledAmountForDay(String tradeOption) throws NoDataFoundException;
}
