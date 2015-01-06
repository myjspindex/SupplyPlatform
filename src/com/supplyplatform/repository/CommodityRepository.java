package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.Commodity;

/**
 * ��Ʒ�ֿ�
 * @author bxy
 *
 */
public interface CommodityRepository {
	
	/**
	 * ����һ����Ʒ
	 * @param commodity
	 */
	public boolean saveCommodity(Commodity commodity);
	
	
	/**
	 * ɾ��һ����Ʒ
	 * @param commodityId
	 */
	public boolean deleteCommodity(Commodity commodity);
	
	
	/**
	 * ���һ������µ�������Ʒ
	 * @param commodityTypeId
	 * @return
	 */
	public List<Commodity> getCommodityByTypeId(Long commodityTypeId);
	
	
}
