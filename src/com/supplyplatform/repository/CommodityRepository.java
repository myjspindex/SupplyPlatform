package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.Commodity;

/**
 * 商品仓库
 * @author bxy
 *
 */
public interface CommodityRepository {
	
	/**
	 * 增加一个商品
	 * @param commodity
	 */
	public boolean saveCommodity(Commodity commodity);
	
	
	/**
	 * 删除一个商品
	 * @param commodityId
	 */
	public boolean deleteCommodity(Commodity commodity);
	
	
	/**
	 * 获得一个类别下的所有商品
	 * @param commodityTypeId
	 * @return
	 */
	public List<Commodity> getCommodityByTypeId(Long commodityTypeId);
	
	
}
