package com.supplyplatform.service.impl;

import java.util.List;

import com.supplyplatform.domain.Order;
import com.supplyplatform.domain.OrderItem;
import com.supplyplatform.repository.OrderRepository;
import com.supplyplatform.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;

	//@Override
	//public Order createOrder(Cart cart) {
	//	Order order = new Order();
	//	return null;
	//}

	@Override
	public Order createOrder(Order order) {
		return null;
	}

	@Override
	public Order createOrderItem(Long orderId, List<OrderItem> itemList) {
		return null;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
