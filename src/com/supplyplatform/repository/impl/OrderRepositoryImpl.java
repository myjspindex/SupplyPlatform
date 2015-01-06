package com.supplyplatform.repository.impl;

import com.supplyplatform.domain.Order;
import com.supplyplatform.domain.OrderItem;
import com.supplyplatform.repository.OrderRepository;

public class OrderRepositoryImpl extends HiberateDAO implements OrderRepository {

	@Override
	public boolean saveOrder(Order order) {
		this.getSession().save(order);
		return order.getId() != null ? true : false;
	}

	@Override
	public boolean removeOrder(Long id) {
		return false;
	}
	

	@Override
	public boolean saveOrderItem(Long orderId, OrderItem item) {
		return false;
	}

	@Override
	public boolean removeOrderItem(Long itemId) {
		return false;
	}

}
