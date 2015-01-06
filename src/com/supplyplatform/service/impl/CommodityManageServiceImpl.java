package com.supplyplatform.service.impl;

import java.util.List;

import com.supplyplatform.domain.Commodity;
import com.supplyplatform.repository.CommodityRepository;
import com.supplyplatform.service.CommodityManageService;

public class CommodityManageServiceImpl implements CommodityManageService{

	private CommodityRepository commodityRepository;
	
	@Override
	public boolean saveCommodity(Commodity Commodity) {
		return false;
	}

	@Override
	public boolean removeCommodity(Long id) {
		return false;
	}
	
	public void setCommodityRepository(CommodityRepository commodityRepository) {
		this.commodityRepository = commodityRepository;
	}

	@Override
	public List<Commodity> getCommodityByTypeId(Long commodityTypeId) {
		return commodityRepository.getCommodityByTypeId(commodityTypeId);
	}

}
