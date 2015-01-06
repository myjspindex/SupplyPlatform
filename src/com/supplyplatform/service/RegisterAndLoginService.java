package com.supplyplatform.service;

import com.supplyplatform.domain.Mall;
import com.supplyplatform.domain.SuperMarket;

/**
 * 用户登录与注册服务
 * @author bxy
 *
 */
public interface RegisterAndLoginService {
	
	
	/**
	 * 商城用户登录
	 * @param userName
	 * @param pwd
	 * @return 如果为空则表示用户不存在
	 */
	public Mall mallLogin(Mall mall);
	
	
	/**
	 * 超市用户登录
	 * @param userName
	 * @param pwd
	 * @return 如果为空则表示用户不存在
	 */
	public SuperMarket supermarketLogin(SuperMarket superMarket);
	
	
	/**
	 * 商城注册
	 * @param mall
	 * @return  0:成功     1:保存失败   2:用户已存在
	 */
	public int mallRegister(Mall mall);
	
	
	/**
	 * 超市注册 
	 * @param superMarket
	 * @return  0:成功    1:保存失败      2:用户已存在  
	 */
	public int supermarketRegister(SuperMarket superMarket);
	
	
}
