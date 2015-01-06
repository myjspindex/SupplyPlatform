package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.Commodity;

/**
 * ��Ʒ����
 * @author bxy
 *
 */
public interface CommodityManageService {
	
	/**
	 * ����һ����Ʒ
	 * @param Commodity
	 * @return
	 */
	public boolean saveCommodity(Commodity commodity);
	
	/**
	 * ɾ��һ����Ʒ
	 * @param Commodity
	 * @return
	 */
	public boolean removeCommodity(Long id);
	
	
	
	/**
	 * 
	 * @param commodityTypeId
	 * @return
	 */
	public List<Commodity> getCommodityByTypeId(Long commodityTypeId);
	
	

}
