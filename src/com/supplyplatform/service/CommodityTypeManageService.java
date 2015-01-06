package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.CommodityType;

/**
 * 商品分类 管理服务
 * @author bxy
 *
 */
public interface CommodityTypeManageService {
	

	/**
	 * 删除一个分类 
	 * @param id
 	 * @return  0:删除成功    1:删除失败   2:该类别下村子类别  3:该类别 下存在商品
	 */
	public int removeCommodityType(Long id);
	
	
	/**
	 * 获得会员下的商品类别 列表 
	 * @param memeberId
	 * @return
	 */
	public List<CommodityType> getCommodityType();
	

	/**
	 *  保存一个商城的商品类型
	 * @param memberId
	 * @return
	 */
	public boolean saveCommodityType( List<CommodityType> typeList);
	
	
}
