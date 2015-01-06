package com.supplyplatform.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * 超市用户类
 * @author bxy
 *
 */
@Entity
@DiscriminatorValue("S")
public class SuperMarket  extends Member {
	
	//超市的订单
	@OneToMany(mappedBy = "superMarket", cascade = { CascadeType.ALL })
	@OrderBy("id ASC")
	private List<Order> orderList;

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
}
