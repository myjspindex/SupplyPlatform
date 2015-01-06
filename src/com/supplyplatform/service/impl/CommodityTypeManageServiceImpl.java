package com.supplyplatform.service.impl;

import java.util.List;

import com.supplyplatform.domain.CommodityType;
import com.supplyplatform.repository.CommodityTypeRepository;
import com.supplyplatform.service.CommodityTypeManageService;

public class CommodityTypeManageServiceImpl extends BaseService implements
		CommodityTypeManageService {

	private CommodityTypeRepository commodityTypeRepository;

	@Override
	public int removeCommodityType(Long id) {
		CommodityType commodityType = commodityTypeRepository
				.getCommodityType(id);
		if (commodityType != null) {
			if (commodityType.getCommodityList().size() != 0) {
				return 3;
			} else if (commodityType.getChildTypeList().size() != 0) {
				return 2;
			}
			if (commodityTypeRepository.deleteCommodityType(commodityType)) {
				return 0;
			}
		}
		return 1;

	}

	public void setCommodityTypeRepository(
			CommodityTypeRepository commodityTypeRepository) {
		this.commodityTypeRepository = commodityTypeRepository;
	}

	@Override
	public List<CommodityType> getCommodityType() {
		return commodityTypeRepository.getCommodityTypeList();
	}

	@Override
	public boolean saveCommodityType(List<CommodityType> typeList) {

		// 将商家 的分类全部删除后再保存
		// boolean removeResult =
		// commodityTypeRepository.deleteCommodityType(mallId);
		boolean saveResult = commodityTypeRepository
				.saveCommodityTypeList(typeList);
		return saveResult;

	}

	private void newCommodityType(List<CommodityType> typeList,
			CommodityType parentType) {
		for (int i = 0; i < typeList.size(); ++i) {
			CommodityType type = (CommodityType) typeList.get(i);
			// 这里不考虑删除，因为删除走单独的方法
			// 如果Id大于0,说明之前已经被保存过，这里有可能是更新名称
			if (type.getId() > 0) {
			} else if (type.getId() < 0) {
				// 如果ID小于0，证明是新增的节点
			}
			type.setParentType(parentType);
			if (type.getChildTypeList() != null) {
				newCommodityType(type.getChildTypeList(), type);
			}
		}
	}

}
