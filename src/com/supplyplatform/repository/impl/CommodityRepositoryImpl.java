package com.supplyplatform.repository.impl;

import java.util.List;

import com.supplyplatform.domain.Commodity;
import com.supplyplatform.repository.CommodityRepository;

public class CommodityRepositoryImpl extends HiberateDAO implements CommodityRepository {
	
	
	@Override
	public boolean saveCommodity(Commodity commodity) {
		this.getSession().save(commodity);
		return commodity.getId() != null ? true : false;
	}
	
	

	@Override
	public boolean deleteCommodity(Commodity commodity) {
		this.getSession().delete(commodity);
		return commodity.getId() == null ? true : false;
	}



	@Override
	public List<Commodity> getCommodityByTypeId(Long commodityTypeId) {
		//HQL
		return null;
	}

}
