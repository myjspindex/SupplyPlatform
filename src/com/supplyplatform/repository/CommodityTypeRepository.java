package com.supplyplatform.repository;

import java.util.List;

import com.supplyplatform.domain.CommodityType;

/**
 * 商品分类仓库
 * @author bxy
 *
 */
public interface CommodityTypeRepository {
	
	
	/**
	 * 获得一个类别 
	 * @param id
	 * @return
	 */
	public CommodityType getCommodityType(Long id);
	
	
	/**
	 * 增加一组分类 
	 * @param parentId
	 * @param commodity
	 */
	public boolean saveCommodityTypeList(List<CommodityType> commodityTypeList);
	
	
	/**
	 * 删除一个商家 的商品分类 
	 * @param commodityId
	 */
	public boolean deleteCommodityType(CommodityType commodityType);
	
	
	
	/**
	 * 获得分类
	 * @return
	 */
	public List<CommodityType> getCommodityTypeList();
	

	
	/**
	 * 保存一个类别 
	 * @param commodityType
	 * @return
	 */
	public boolean saveCommodityType(CommodityType commodityType);

}
