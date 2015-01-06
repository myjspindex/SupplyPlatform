package com.supplyplatform.helper;

import java.util.List;

import com.supplyplatform.domain.CommodityType;

/**
 * ���ɽ�����Ҫ��������
 * @author bxy
 *
 */
public interface CommodityTypeTreeDataCreator {

	/**
	 * ����������
	 * @param commodityTypeList
	 * @return
	 */
	public String createTreeData(List<CommodityType> commodityTypeList);
	
	
	/**
	 * ���������
	 * @param treeData
	 * @return
	 */
	public List createDominObj(String treeData);
	
	
}
