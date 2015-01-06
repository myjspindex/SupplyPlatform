package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.Order;
import com.supplyplatform.domain.OrderItem;

/**
 * ��������
 * @author bxy
 *
 */
public interface OrderService {
	
	
	/**
	 * ���ݹ��ﳵ���ɶ���
	 * @param cart
	 */
	//public Order createOrder(Cart cart);
	
	
	/**
	 * �����Ժ�Ķ��������¶���
	 * @param order
	 */
	public Order createOrder(Order order);
	
	
	/**
	 * Ϊ����׷�Ӷ�����
	 * @param itemList
	 * @return
	 */
	public Order createOrderItem(Long orderId, List<OrderItem> itemList);
	
	
}
