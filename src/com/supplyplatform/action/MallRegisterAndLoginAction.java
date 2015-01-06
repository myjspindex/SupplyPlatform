package com.supplyplatform.action;

import com.supplyplatform.domain.Mall;
import com.supplyplatform.service.RegisterAndLoginService;

/**
 * 商城注册与登录
 * @author bxy
 *
 */
public class MallRegisterAndLoginAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//商城注册与登录服务
	private RegisterAndLoginService registerAndLoginService;
	
	//商城对象
	private Mall mall;

	
	public void  mallRegister() {
		int result = registerAndLoginService.mallRegister(mall);
		if (result == 0) {
			
		} else if (result == 1) {
			
		} else if (result == 2) {
			
		}

	}
	
	public void mallLogin() {
		Mall returnMall  = registerAndLoginService.mallLogin(mall); 
		if (returnMall != null) {
			//登录成功
		} else {
			//登录失败
		}

	}

	public void setMall(Mall mall) {
		this.mall = mall;
	}
	
	public Mall getMall() {
		return mall;
	}

	public void setRegisterAndLoginService(
			RegisterAndLoginService registerAndLoginService) {
		this.registerAndLoginService = registerAndLoginService;
	}
	
}
