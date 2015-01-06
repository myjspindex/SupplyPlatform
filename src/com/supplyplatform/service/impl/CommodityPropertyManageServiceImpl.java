package com.supplyplatform.service.impl;

import java.util.List;

import com.supplyplatform.domain.CommodityPropertyType;
import com.supplyplatform.domain.CommodityPropertyValue;
import com.supplyplatform.repository.CommodityPropertyRepository;
import com.supplyplatform.service.CommodityPropertyManageService;

public class CommodityPropertyManageServiceImpl extends BaseService implements
		CommodityPropertyManageService {
	
	private CommodityPropertyRepository commodityPropertyRepository;
	
	@Override
	public boolean saveCommodityPropertyTypeList(
			List<CommodityPropertyType> commodityPropertyTypeList) {
		return false;
	}
	
	@Override
	public boolean saveCommodityPropertyType(
			CommodityPropertyType propertyType) {
		
		return commodityPropertyRepository.saveCommodityPropertyType(propertyType);
	}

	@Override
	public List<CommodityPropertyType> getPropertyType() {
		return null;
	}

	@Override
	public boolean removeCommodityPropertyType(Long typeId) {
		return false;
	}

	@Override
	public List<CommodityPropertyValue> getPropertyValue(Long typeId) {
		return null;
	}

	@Override
	public boolean removeCommodityPropertyValue(Long valueId) {
		return false;
	}
	
	public void setCommodityPropertyRepository(
			CommodityPropertyRepository commodityPropertyRepository) {
		this.commodityPropertyRepository = commodityPropertyRepository;
	}


}
