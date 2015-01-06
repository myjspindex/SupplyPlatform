package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.Commodity;

/**
 * 商品管理
 * @author bxy
 *
 */
public interface CommodityManageService {
	
	/**
	 * 增加一件商品
	 * @param Commodity
	 * @return
	 */
	public boolean saveCommodity(Commodity commodity);
	
	/**
	 * 删除一件商品
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
