package com.supplyplatform.action;

import com.supplyplatform.domain.SuperMarket;
import com.supplyplatform.service.RegisterAndLoginService;

/**
 * 超市用户登录Action
 * @author bxy
 *
 */
public class SupermarketRegisterAndLoginAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//服务对象
	private RegisterAndLoginService registerAndLoginService;
	
	//超市用户类
	private SuperMarket supermarket;
	
	
	public void  supermarketRegister() {
		int result = registerAndLoginService.supermarketRegister(supermarket);
		if (result == 0) {
			
		} else if (result == 1) {
			
		} else if (result == 2) {
			
		}
	}
	
	public void supermarketLogin() {
		SuperMarket returnSupermarket  = registerAndLoginService.supermarketLogin(supermarket); 
		if (returnSupermarket != null) {
			//登录成功
		} else {
			//登录失败
		}
	}

	public SuperMarket getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(SuperMarket supermarket) {
		this.supermarket = supermarket;
	}

	public RegisterAndLoginService getRegisterAndLoginService() {
		return registerAndLoginService;
	}

	public void setRegisterAndLoginService(
			RegisterAndLoginService registerAndLoginService) {
		this.registerAndLoginService = registerAndLoginService;
	}
	
}
