package com.supplyplatform.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.supplyplatform.domain.CommodityType;
import com.supplyplatform.repository.CommodityTypeRepository;

public class CommodityTypeRepositoryImpl extends HiberateDAO implements
		CommodityTypeRepository {

	@Override
	public boolean deleteCommodityType(CommodityType commodityType) {
		this.getSession().delete(commodityType);
		if (commodityType.getId() == null) {
			return true;
		}
		return false;
	}

	@Override
	public List<CommodityType> getCommodityTypeList() {
		
		Criteria criteria = getSession().createCriteria(CommodityType.class);
		// 先查询父节点 是null,证明是第一级节点
		criteria.add(Restrictions.isNull("parentType"));
		//criteria.addOrder(Order.asc("index"));
		List list = criteria.list(); 
		//loadChildCommodityType(list);
		//this.getSession().saveOrUpdate(arg0, arg1);
		return list;
		
	}
	
	private void loadChildCommodityType(List<CommodityType> parentList) {
		for (int i = 0; i < parentList.size(); ++i) {
			List <CommodityType> childList = parentList.get(i).getChildTypeList();
			loadChildCommodityType(childList);
		}
	}
	

	private List<CommodityType> getChildType(Criteria criteria) {
		return null;

	}

	@Override
	public boolean saveCommodityTypeList(List<CommodityType> commodityTypeList) {
		Session session = this.getSession();
		for (int i = 0 ; i < commodityTypeList.size(); ++i) {
			session.persist(commodityTypeList.get(i));
		}
		return true;
	}

	@Override
	public boolean saveCommodityType(CommodityType commodityType) {
		this.getSession().save(commodityType);
		return commodityType.getId() != null ? true : false;
	}

	@Override
	public CommodityType getCommodityType(Long id) {
		Object obj =  this.getSession().load(CommodityType.class, id);
		if (obj != null) {
			return (CommodityType) obj;
		}
		return null;
	}

}

