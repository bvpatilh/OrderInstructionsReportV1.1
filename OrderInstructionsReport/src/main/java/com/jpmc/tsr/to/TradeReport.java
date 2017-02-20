package com.jpmc.tsr.to;

import java.util.Date;

import com.jpmc.tsr.vo.TradeOptions;

public class TradeReport {
	@Override
	public String toString() {
		return "TradeReport [entity=" + entity + ", instructionDate="
				+ instructionDate + ", settlementDate=" + settlementDate
				+ ", tradeAmount=" + tradeAmount + "]";
	}

	private int rank;
	private String entity;
	private TradeOptions tradeOption;
	private Date instructionDate;
	private Date settlementDate;
	private Double tradeAmount;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public TradeOptions getTradeOption() {
		return tradeOption;
	}

	public void setTradeOption(TradeOptions tradeOption) {
		this.tradeOption = tradeOption;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Double getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(Double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

}
