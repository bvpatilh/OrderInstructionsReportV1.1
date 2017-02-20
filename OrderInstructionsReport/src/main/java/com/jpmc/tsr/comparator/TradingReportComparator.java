package com.jpmc.tsr.comparator;

import java.util.Comparator;

import com.jpmc.tsr.to.TradeReport;

public class TradingReportComparator implements Comparator<TradeReport> {

	public int compare(TradeReport arg0, TradeReport arg1) {

		if (arg0.getTradeAmount() > arg1.getTradeAmount())
			return - 1;
		else if (arg0.getTradeAmount() < arg1.getTradeAmount())
			return 1;
		else return 0;
		
	}

}
