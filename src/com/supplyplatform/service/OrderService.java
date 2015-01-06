package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.Order;
import com.supplyplatform.domain.OrderItem;

/**
 * 订单服务
 * @author bxy
 *
 */
public interface OrderService {
	
	
	/**
	 * 根据购物车生成订单
	 * @param cart
	 */
	//public Order createOrder(Cart cart);
	
	
	/**
	 * 根据以后的订单生成新订单
	 * @param order
	 */
	public Order createOrder(Order order);
	
	
	/**
	 * 为订单追加订单项
	 * @param itemList
	 * @return
	 */
	public Order createOrderItem(Long orderId, List<OrderItem> itemList);
	
	
}
