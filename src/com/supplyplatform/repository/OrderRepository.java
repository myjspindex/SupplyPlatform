package com.supplyplatform.repository;

import com.supplyplatform.domain.Order;
import com.supplyplatform.domain.OrderItem;

/**
 * �����ֿ�
 * @author bxy
 *
 */
public interface OrderRepository {
	
	/**
	 * ���� ����
	 * @param order
	 */
	public boolean saveOrder(Order order);
	
	/**
	 * ɾ������
	 * @param id
	 */
	public boolean removeOrder(Long id);
	
	
	/**
	 * ���Ӷ�����
	 * @param orderId
	 * @param item
	 */
	public boolean saveOrderItem(Long orderId, OrderItem item);
	
	
	/**
	 * ɾ��������
	 * @param itemId
	 */
	public boolean removeOrderItem(Long itemId);
	
	
}
