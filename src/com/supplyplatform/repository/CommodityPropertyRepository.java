package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.CommodityPropertyType;
import com.supplyplatform.domain.CommodityPropertyValue;

/**
 * 商品属性仓库
 * @author bxy
 *
 */
public interface CommodityPropertyRepository {

	
	/**
	 * 保存商品属性类别 
	 * @param type
	 * @return
	 */
	public boolean  saveCommodityPropertyType(CommodityPropertyType type);
	
	
	/**
	 * 获得商品类别
	 * @param query
	 * @return
	 */
	public List<CommodityPropertyType> getCommodityPropertyType(CommodityPropertyType query);
	
	
	/**
	 * 删除一个商品类别
	 * @param typeId
	 */
	public boolean deleteCommodityPropertyType(CommodityPropertyType type);
	
	
	/**
	 * 获得一个类别下的所有值
	 * @param typeId
	 * @return
	 */
	public List<CommodityPropertyValue> getCommodityPropertyValueList(Long typeId);
	
	
	/**
	 * 删除一个属性值
	 * @param valueId
	 * @return
	 */
	public boolean deleteCommodityPropertyValue(CommodityPropertyValue value);
	
}
