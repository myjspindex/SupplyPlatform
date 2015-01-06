package com.supplyplatform.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品属性值
 * @author bxy
 *
 */
@Entity
@Table(name = "commodity_property_value")
public class CommodityPropertyValue {
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)	
	private Long id;
	
	@Column(name = "value", length = 100)	
	private String value;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name="pk_property_type")
	private CommodityPropertyType propertyType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CommodityPropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(CommodityPropertyType propertyType) {
		this.propertyType = propertyType;
	}

	
}
