package com.supplyplatform.helper;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.supplyplatform.domain.CommodityType;

/**
 * XML树数据生成器
 * @author bxy
 *
 */
public class CommodityTypeTreeXMLDataCreator implements
		CommodityTypeTreeDataCreator {
	
	private Long index = 0l;

	@Override
	public String createTreeData(List<CommodityType> commodityTypeList) {
		StringBuffer treeData = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?><tree id='0'><item text=\"商品分类\" id=\"-1\">"); 
			create(commodityTypeList, treeData);
		treeData.append("</item></tree>");
		return treeData.toString();
	}
	
	private void create(List<CommodityType> commodityTypeList, StringBuffer treeData) {
		
		for (int i = 0; i < commodityTypeList.size(); ++i) {
			CommodityType commodityType =commodityTypeList.get(i);
			treeData.append("<item text=\"" +  commodityType.getName() + "\" id=\"" + commodityType.getId() + "\">");
			if (commodityType.getChildTypeList() != null) {
				create(commodityType.getChildTypeList(), treeData);
			}
			treeData.append("</item>");
		}
	}

	@Override
	public List createDominObj(String treeData) {
		
		List<CommodityType> commodityTypeList = new ArrayList<CommodityType>();
		 try {
			Document document = DocumentHelper.parseText(treeData);
			Element root= document.getRootElement();  
			List<Element> list = root.elements();
			create(list, commodityTypeList, null);
			index = 0l;
		} catch (DocumentException e) {
			e.printStackTrace();
		}  
		return commodityTypeList;
	}
	
	private void create(List elemntList, List commodityTypeList, CommodityType parentType) {
		
		for (int i  = 0; i < elemntList.size(); ++i) {
			Element element = (Element)  elemntList.get(i);
			CommodityType type  = new CommodityType();
			type.setName(element.attributeValue("text"));
			type.setIndex(index++);
			if (element.attributeValue("parentid") != null) {
				String parentId = element.attributeValue("parentid");
				parentType = new CommodityType();
				parentType.setId(Long.parseLong(parentId));
			} 
			type.setParentType(parentType);
			commodityTypeList.add(type);
			if (element.elements().size() != 0) {
				List<CommodityType> childCommodityTypeList = new ArrayList<CommodityType>();
				create(element.elements(), childCommodityTypeList, type);
				type.setChildTypeList(childCommodityTypeList);
			}
		}
		
		
	}

}
