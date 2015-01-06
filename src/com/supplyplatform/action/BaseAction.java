package com.supplyplatform.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.supplyplatform.util.PropertiesUtil;

/**
 *  �㳬����
 * @author bxy
 *
 */
public class BaseAction extends ActionSupport {
	
	
	/**
	 * ��ͻ���д����
	 * @param data
	 */
	public void writeData(String data) {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/xml;charset=utf-8");  
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(data);  
			out.flush();
		} catch (Exception z) {
			z.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * ޼������
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		 PropertiesUtil util = PropertiesUtil.getInstance();
		 return util.getValue(key);
	}
	
}
