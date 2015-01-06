package com.supplyplatform.action;

import com.supplyplatform.service.CommodityManageService;

/**
 * 商品管理Action
 * @author bxy
 *
 */
public class CommodityManageAction extends BaseAction {
	
	private CommodityManageService commodityManageService;
	
	
	

	public void setCommodityManageService(
			CommodityManageService commodityManageService) {
		this.commodityManageService = commodityManageService;
	}
	

}
