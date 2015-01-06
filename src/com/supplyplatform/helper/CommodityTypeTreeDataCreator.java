package com.supplyplatform.helper;

import java.util.List;

import com.supplyplatform.domain.CommodityType;

/**
 * 生成界面需要的树数据
 * @author bxy
 *
 */
public interface CommodityTypeTreeDataCreator {

	/**
	 * 生成树数据
	 * @param commodityTypeList
	 * @return
	 */
	public String createTreeData(List<CommodityType> commodityTypeList);
	
	
	/**
	 * 生成域对象
	 * @param treeData
	 * @return
	 */
	public List createDominObj(String treeData);
	
	
}
