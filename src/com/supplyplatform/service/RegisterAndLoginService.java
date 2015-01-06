package com.supplyplatform.service;

import com.supplyplatform.domain.Mall;
import com.supplyplatform.domain.SuperMarket;

/**
 * �û���¼��ע�����
 * @author bxy
 *
 */
public interface RegisterAndLoginService {
	
	
	/**
	 * �̳��û���¼
	 * @param userName
	 * @param pwd
	 * @return ���Ϊ�����ʾ�û�������
	 */
	public Mall mallLogin(Mall mall);
	
	
	/**
	 * �����û���¼
	 * @param userName
	 * @param pwd
	 * @return ���Ϊ�����ʾ�û�������
	 */
	public SuperMarket supermarketLogin(SuperMarket superMarket);
	
	
	/**
	 * �̳�ע��
	 * @param mall
	 * @return  0:�ɹ�     1:����ʧ��   2:�û��Ѵ���
	 */
	public int mallRegister(Mall mall);
	
	
	/**
	 * ����ע�� 
	 * @param superMarket
	 * @return  0:�ɹ�    1:����ʧ��      2:�û��Ѵ���  
	 */
	public int supermarketRegister(SuperMarket superMarket);
	
	
}
