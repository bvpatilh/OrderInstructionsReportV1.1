package com.jpmc.tsr.calculator;

public class TradeAmountCalculator implements TradeCalculator {

	public Double calculate(CalculatorInput input) {

		Double tradeAmount = input.getPricePerUnits() * input.getUnits()
				* input.getAgreedFx();

		return tradeAmount;
	}

}
