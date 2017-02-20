package com.jpmc.tsr;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jpmc.tsr.calculator.CalculatorInput;
import com.jpmc.tsr.calculator.TradeCalculator;
import com.jpmc.tsr.factory.ObjectFactory;

public class TradeAmountCalculatorTest {
	private static ObjectFactory instance;
	private static TradeCalculator tradeCalculator;

	@BeforeClass
	public static void setup() {
		instance = ObjectFactory.getInstance();
		tradeCalculator = instance.getTradeCalculatorInstance();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void calculateTradeAmountTest() {
		CalculatorInput input = new CalculatorInput();
		input.setAgreedFx(120);
		input.setPricePerUnits(100.23);
		input.setUnits(200);
		Assert.assertEquals(120*100.23*200, tradeCalculator.calculate(input));
	}
}
