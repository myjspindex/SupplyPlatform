package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.CommodityType;

/**
 * ��Ʒ����ֿ�
 * @author bxy
 *
 */
public interface CommodityTypeRepository {
	
	
	/**
	 * ���һ����� 
	 * @param id
	 * @return
	 */
	public CommodityType getCommodityType(Long id);
	
	
	/**
	 * ����һ����� 
	 * @param parentId
	 * @param commodity
	 */
	public boolean saveCommodityTypeList(List<CommodityType> commodityTypeList);
	
	
	/**
	 * ɾ��һ���̼� ����Ʒ���� 
	 * @param commodityId
	 */
	public boolean deleteCommodityType(CommodityType commodityType);
	
	
	
	/**
	 * ��÷���
	 * @return
	 */
	public List<CommodityType> getCommodityTypeList();
	

	
	/**
	 * ����һ����� 
	 * @param commodityType
	 * @return
	 */
	public boolean saveCommodityType(CommodityType commodityType);

}
