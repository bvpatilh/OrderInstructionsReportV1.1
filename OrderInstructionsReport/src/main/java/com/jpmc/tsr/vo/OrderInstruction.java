package com.jpmc.tsr.vo;

import java.util.Date;

public class OrderInstruction {

	private String entity;
	private TradeOptions tradeOption;
	
	private String currency;
	private Date instructionDate;
	private Date SettlementDateDate;
	private int units;
	private Double pricePerUnits;
	private Double agreedFx;

	//This constructor is used to set the test data 
	public OrderInstruction(String entity, TradeOptions tradeOption, Double agreedFx,
			Date instructionDate, Date SettlementDateDate, int units, Double pricePerUnits, String currency) {
		this.entity = entity;
		this.tradeOption = tradeOption;
		this.agreedFx = agreedFx;
		this.instructionDate = instructionDate;
		this.SettlementDateDate = SettlementDateDate;
		this.units = units;
		this.pricePerUnits = pricePerUnits;
		this.currency = currency;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDateDate() {
		return SettlementDateDate;
	}

	public void setSettlementDateDate(Date settlementDateDate) {
		SettlementDateDate = settlementDateDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Double getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(Double pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}

	public Double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public TradeOptions getTradeOption() {
		return tradeOption;
	}

	public void setTradeOption(TradeOptions tradeOption) {
		this.tradeOption = tradeOption;
	}
}
