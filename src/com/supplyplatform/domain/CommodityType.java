package com.supplyplatform.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品分类 
 * @author bxy
 *
 */
@Entity
@Table(name = "commodity_type")
public class CommodityType {
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)	
	private Long id;
	
	@OneToMany(mappedBy = "parentType", fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<CommodityType> childTypeList;  
	 
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,  optional = true)
	@JoinColumn(name="parent_id")
	private CommodityType parentType;
	
	@Column(name = "name", length = 50)	
	private String name;
	
	@OneToMany(mappedBy = "commodityType", cascade = { CascadeType.ALL })
	@OrderBy("name ASC")
	private List<Commodity> commodityList;
	
	@Column(name = "t_index", length = 10)	
	private Long index;

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

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public List<CommodityType> getChildTypeList() {
		return childTypeList;
	}

	public void setChildTypeList(List<CommodityType> childTypeList) {
		this.childTypeList = childTypeList;
	}

	public CommodityType getParentType() {
		return parentType;
	}

	public void setParentType(CommodityType parentType) {
		this.parentType = parentType;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

}
