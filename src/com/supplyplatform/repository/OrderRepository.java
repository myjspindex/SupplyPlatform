package com.supplyplatform.repository;

import com.supplyplatform.domain.Order;
import com.supplyplatform.domain.OrderItem;

/**
 * 订单仓库
 * @author bxy
 *
 */
public interface OrderRepository {
	
	/**
	 * 创建 订单
	 * @param order
	 */
	public boolean saveOrder(Order order);
	
	/**
	 * 删除订单
	 * @param id
	 */
	public boolean removeOrder(Long id);
	
	
	/**
	 * 增加订单项
	 * @param orderId
	 * @param item
	 */
	public boolean saveOrderItem(Long orderId, OrderItem item);
	
	
	/**
	 * 删除订单项
	 * @param itemId
	 */
	public boolean removeOrderItem(Long itemId);
	
	
}
