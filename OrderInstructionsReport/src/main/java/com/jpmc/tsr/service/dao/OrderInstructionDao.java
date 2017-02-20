package com.jpmc.tsr.service.dao;

import java.util.List;

import com.jpmc.tsr.vo.OrderInstruction;

public interface OrderInstructionDao {

	public List<OrderInstruction> getOrderInstructions(String tradeOption);
	public void saveOrderInstructions(List<OrderInstruction> orderInstructions);
}
