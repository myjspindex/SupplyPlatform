package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.CommodityPropertyType;
import com.supplyplatform.domain.CommodityPropertyValue;

/**
 * ����ά��
 * @author bxy
 *
 */
public interface CommodityPropertyManageService {
	
	
	
	/**
	 * ���������������  
	 * @param commodityPropertyTypeList
	 * @return
	 */
	public boolean saveCommodityPropertyTypeList(List<CommodityPropertyType> commodityPropertyTypeList);

	
	/**
	 * ����һ���������
	 * @param propertyType
	 * @return
	 */
	public boolean saveCommodityPropertyType(CommodityPropertyType propertyType);
	
	
	/**
	 * ������е�������� (��������ֵ)
	 * @return
	 */
	public List<CommodityPropertyType> getPropertyType();
	
	
	/**
	 * ɾ��һ��������� 
	 * @param typeId
	 * @return
	 */
	public boolean removeCommodityPropertyType(Long typeId);
	
	
	/**
	 * ���һ������µ�����ֵ
	 * @param typeId
	 * @return
	 */
	public List<CommodityPropertyValue> getPropertyValue(Long typeId);
	

	/**
	 * ɾ��ĳ������ֵ
	 * @param valueId
	 * @return
	 */
	public boolean removeCommodityPropertyValue(Long valueId);
	
}
