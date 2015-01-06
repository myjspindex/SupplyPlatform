package com.supplyplatform.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.supplyplatform.domain.CommodityPropertyType;
import com.supplyplatform.domain.CommodityPropertyValue;
import com.supplyplatform.repository.CommodityPropertyRepository;

public class CommodityPropertyRepositoryImpl extends HiberateDAO implements
		CommodityPropertyRepository {

	@Override
	public boolean saveCommodityPropertyType(CommodityPropertyType type) {
		this.getSession().save(type);
		return type.getId() != null ? true : false;
	}

	@Override
	public List<CommodityPropertyType> getCommodityPropertyType(
			CommodityPropertyType query) {
		
		Criteria criteria = this.getSession().createCriteria(CommodityPropertyType.class);
		if (query.getId() != null) {
			Criterion idEq = Restrictions.eq("id", query.getId());
			criteria.add(idEq);
		}
		return criteria.list();
	}

	@Override
	public List<CommodityPropertyValue> getCommodityPropertyValueList(
			Long typeId) {
		Criteria criteria = this.getSession().createCriteria(CommodityPropertyValue.class);
		Criterion idEq = Restrictions.eq("propertyType.id", typeId);
		criteria.add(idEq);;
		return criteria.list();
	}

	@Override
	public boolean deleteCommodityPropertyType(CommodityPropertyType type) {
		this.getSession().delete(type);
		return type.getId() == null ? true : false;
	}

	@Override
	public boolean deleteCommodityPropertyValue(CommodityPropertyValue value) {
		this.getSession().delete(value);
		return value.getId() == null ? true : false;
	}

}
