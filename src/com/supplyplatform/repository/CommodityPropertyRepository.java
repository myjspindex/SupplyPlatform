package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.CommodityPropertyType;
import com.supplyplatform.domain.CommodityPropertyValue;

/**
 * ��Ʒ���Բֿ�
 * @author bxy
 *
 */
public interface CommodityPropertyRepository {

	
	/**
	 * ������Ʒ������� 
	 * @param type
	 * @return
	 */
	public boolean  saveCommodityPropertyType(CommodityPropertyType type);
	
	
	/**
	 * �����Ʒ���
	 * @param query
	 * @return
	 */
	public List<CommodityPropertyType> getCommodityPropertyType(CommodityPropertyType query);
	
	
	/**
	 * ɾ��һ����Ʒ���
	 * @param typeId
	 */
	public boolean deleteCommodityPropertyType(CommodityPropertyType type);
	
	
	/**
	 * ���һ������µ�����ֵ
	 * @param typeId
	 * @return
	 */
	public List<CommodityPropertyValue> getCommodityPropertyValueList(Long typeId);
	
	
	/**
	 * ɾ��һ������ֵ
	 * @param valueId
	 * @return
	 */
	public boolean deleteCommodityPropertyValue(CommodityPropertyValue value);
	
}
