package com.jpmc.tsr.service.dao;

import java.util.List;

import com.jpmc.tsr.vo.OrderInstruction;

public class OrderInstructionDaoImpl implements OrderInstructionDao {

	private List<OrderInstruction> orderInstructions = null;

	public List<OrderInstruction> getOrderInstructions(String tradeOption) {
		return orderInstructions;
	}

	public void setOrderInstructions(List<OrderInstruction> orderInstructions) {
		this.orderInstructions = orderInstructions;
	}

	public void saveOrderInstructions(List<OrderInstruction> orderInstructions) {
		setOrderInstructions(orderInstructions);
	}
}
