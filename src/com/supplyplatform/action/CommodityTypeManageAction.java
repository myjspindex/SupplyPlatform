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
 * ��Ʒ������
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
	 * ������β˵�
	 */
	public void getTypeList() {

		List<CommodityType> list = commodityTypeManageService
				.getCommodityType();
		String data = commodityTypeTreeDataCreator.createTreeData(list);
		this.writeData(data);

	}

	/**
	 * �޸���Ʒ���
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
	 * ɾ��һ������ 
	 */
	public void removeCommodityType() {

		int result = commodityTypeManageService.removeCommodityType(removeTypeId);
		
		// ��Ʒ���ɾ���ɹ�
		JSONObject json = new JSONObject();
		String message = null;
		if (result == 0) {
			message = this.getValue(Constant.COMMODITY_TYPE_SAVE_SUCCESS);
			json.accumulate("success", true);
		} else if (result == 1) {
			// ��Ʒ���ɾ��ʧ��
			message = this.getValue(Constant.COMMODITY_TYPE_SAVE_ERROR);
			json.accumulate("success", false);
		} else if (result == 2) {
			// ����������ӷ���
			message = this.getValue(Constant.COMMODITY_TYPE_REMOVE_EXISTCHILDTYPE);
			json.accumulate("success", false);
		} else if (result == 3) {
			// ����� ������Ʒ
			message = this.getValue(Constant.COMMODITY_TYPE_REMOVE_EXISTCOMMODITY);
			json.accumulate("success", false);
		}

		json.accumulate("message", message);
		this.writeData(json.toString());
	}

	/**
	 * �������
	 * 
	 * @return
	 */
	public void addCommodityType() {
		// ���mall
		// ���� creator���������
		List<CommodityType> list = commodityTypeTreeDataCreator
				.createDominObj(treeData);
		// ���� service ����
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
