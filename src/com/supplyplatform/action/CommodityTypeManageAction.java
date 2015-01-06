package com.supplyplatform.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.supplyplatform.domain.Commodity;
import com.supplyplatform.domain.CommodityType;
import com.supplyplatform.helper.CommodityTypeTreeDataCreator;
import com.supplyplatform.service.CommodityManageService;
import com.supplyplatform.service.CommodityTypeManageService;
import com.supplyplatform.util.Constant;

/**
 * 商品类别管理
 * 
 * @author bxy
 * 
 */
public class CommodityTypeManageAction extends BaseAction {

	private CommodityTypeManageService commodityTypeManageService;
	
	private CommodityManageService commodityManageService;

	private CommodityTypeTreeDataCreator commodityTypeTreeDataCreator;

	private String treeData;

	private String modifyData;

	private Long removeTypeId;
	
	private Long commodityTypeId;
	
	private List<Commodity> commodityList;
	

	/**
	 * 获得树形菜单
	 */
	public void getTypeList() {

		List<CommodityType> list = commodityTypeManageService
				.getCommodityType();
		String data = commodityTypeTreeDataCreator.createTreeData(list);
		this.writeData(data);

	}

	/**
	 * 修改商品类别
	 */
	public void modifyCommodityType() {

		JSONArray obj = JSONArray.fromObject(modifyData);
		List list = JSONArray.toList(obj, CommodityType.class);
		boolean result = commodityTypeManageService.saveCommodityType(list);
		JSONObject json = new JSONObject();
		String message = null;
		if (result == true) {
			message = this.getValue(Constant.COMMODITY_TYPE_SAVE_SUCCESS);
			json.accumulate("success", true);
		} else {
			message = this.getValue(Constant.COMMODITY_TYPE_SAVE_ERROR);
			json.accumulate("success", false);
		}
		json.accumulate("message", message);
		this.writeData(json.toString());
		
	}
	
	
	public String searchCommodity() {
		
		commodityList = commodityManageService.getCommodityByTypeId(commodityTypeId);
		return "commodity_view";
	}
	

	/**
	 * 删除一个分类 
	 */
	public void removeCommodityType() {

		int result = commodityTypeManageService.removeCommodityType(removeTypeId);
		
		// 商品类别删除成功
		JSONObject json = new JSONObject();
		String message = null;
		if (result == 0) {
			message = this.getValue(Constant.COMMODITY_TYPE_SAVE_SUCCESS);
			json.accumulate("success", true);
		} else if (result == 1) {
			// 商品类别删除失败
			message = this.getValue(Constant.COMMODITY_TYPE_SAVE_ERROR);
			json.accumulate("success", false);
		} else if (result == 2) {
			// 该类别下有子分类
			message = this.getValue(Constant.COMMODITY_TYPE_REMOVE_EXISTCHILDTYPE);
			json.accumulate("success", false);
		} else if (result == 3) {
			// 该类别 下有商品
			message = this.getValue(Constant.COMMODITY_TYPE_REMOVE_EXISTCOMMODITY);
			json.accumulate("success", false);
		}

		json.accumulate("message", message);
		this.writeData(json.toString());
	}

	/**
	 * 增加类别
	 * 
	 * @return
	 */
	public void addCommodityType() {
		// 获得mall
		// 调用 creator生成域对象
		List<CommodityType> list = commodityTypeTreeDataCreator
				.createDominObj(treeData);
		// 调用 service 保存
		boolean result = commodityTypeManageService.saveCommodityType(list);
		
	}
	

	public void setCommodityManageService(
			CommodityManageService commodityManageService) {
		this.commodityManageService = commodityManageService;
	}

	public void setRemoveTypeId(Long removeTypeId) {
		this.removeTypeId = removeTypeId;
	}

	public void setCommodityTypeTreeDataCreator(
			CommodityTypeTreeDataCreator commodityTypeTreeDataCreator) {
		this.commodityTypeTreeDataCreator = commodityTypeTreeDataCreator;
	}

	public void setCommodityTypeManageService(
			CommodityTypeManageService commodityTypeManageService) {
		this.commodityTypeManageService = commodityTypeManageService;
	}

	public void setTreeData(String treeData) {
		this.treeData = treeData;
	}

	public void setModifyData(String modifyData) {
		this.modifyData = modifyData;
	}

}
