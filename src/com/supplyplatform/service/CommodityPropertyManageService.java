package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.CommodityPropertyType;
import com.supplyplatform.domain.CommodityPropertyValue;

/**
 * 属性维护
 * @author bxy
 *
 */
public interface CommodityPropertyManageService {
	
	
	
	/**
	 * 批量保存属性类别  
	 * @param commodityPropertyTypeList
	 * @return
	 */
	public boolean saveCommodityPropertyTypeList(List<CommodityPropertyType> commodityPropertyTypeList);

	
	/**
	 * 保存一个属性类别
	 * @param propertyType
	 * @return
	 */
	public boolean saveCommodityPropertyType(CommodityPropertyType propertyType);
	
	
	/**
	 * 获得所有的属性类别 (包括属性值)
	 * @return
	 */
	public List<CommodityPropertyType> getPropertyType();
	
	
	/**
	 * 删除一个属性类别 
	 * @param typeId
	 * @return
	 */
	public boolean removeCommodityPropertyType(Long typeId);
	
	
	/**
	 * 获得一个类别下的属性值
	 * @param typeId
	 * @return
	 */
	public List<CommodityPropertyValue> getPropertyValue(Long typeId);
	

	/**
	 * 删除某个属性值
	 * @param valueId
	 * @return
	 */
	public boolean removeCommodityPropertyValue(Long valueId);
	
}
