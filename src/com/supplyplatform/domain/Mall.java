package com.supplyplatform.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


/**
 * �̳���
 * @author bxy
 *
 */
@Entity
@DiscriminatorValue("M")
public class Mall extends Member {

	//��Ʒ�е���Ʒ
	@OneToMany(mappedBy = "mall", cascade = { CascadeType.ALL })
	@OrderBy("name ASC")
	private List<Commodity> commodityList;
	
	//��Ʒ�Ķ���
	@OneToMany(mappedBy = "mall", cascade = { CascadeType.ALL })
	@OrderBy("id ASC")
	private List<Order> orderList;
	
	//״̬
	@Column(name = "status", length = 10)
	private String status;
	
	//�̺�
	@Column(name = "code", length = 10)
	private String code;
	
	@Column(name = "remark", length = 1000)	
	private String remark;


	public List<Commodity> getCommodityList() {
		return commodityList;
	}


	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
