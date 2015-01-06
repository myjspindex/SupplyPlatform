package com.supplyplatform.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品属性类别
 * @author bxy
 *
 */
@Entity
@Table(name = "commodity_property_type")
public class CommodityPropertyType {

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)	
	private Long id;
	
	@Column(name = "name", length = 50)	
	private String name;
	
	@OneToMany(mappedBy = "propertyType", fetch=FetchType.EAGER, cascade={CascadeType.MERGE,CascadeType.REMOVE})
	@OrderBy("id ASC")
	private List<CommodityPropertyValue> valueList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
