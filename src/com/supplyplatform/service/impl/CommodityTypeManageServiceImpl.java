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

		// ���̼� �ķ���ȫ��ɾ�����ٱ���
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
			// ���ﲻ����ɾ������Ϊɾ���ߵ����ķ���
			// ���Id����0,˵��֮ǰ�Ѿ���������������п����Ǹ�������
			if (type.getId() > 0) {
			} else if (type.getId() < 0) {
				// ���IDС��0��֤���������Ľڵ�
			}
			type.setParentType(parentType);
			if (type.getChildTypeList() != null) {
				newCommodityType(type.getChildTypeList(), type);
			}
		}
	}

}
