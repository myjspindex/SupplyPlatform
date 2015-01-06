package com.supplyplatform.service;

import java.util.List;

import com.supplyplatform.domain.CommodityType;

/**
 * ��Ʒ���� �������
 * @author bxy
 *
 */
public interface CommodityTypeManageService {
	

	/**
	 * ɾ��һ������ 
	 * @param id
 	 * @return  0:ɾ���ɹ�    1:ɾ��ʧ��   2:������´������  3:����� �´�����Ʒ
	 */
	public int removeCommodityType(Long id);
	
	
	/**
	 * ��û�Ա�µ���Ʒ��� �б� 
	 * @param memeberId
	 * @return
	 */
	public List<CommodityType> getCommodityType();
	

	/**
	 *  ����һ���̳ǵ���Ʒ����
	 * @param memberId
	 * @return
	 */
	public boolean saveCommodityType( List<CommodityType> typeList);
	
	
}
