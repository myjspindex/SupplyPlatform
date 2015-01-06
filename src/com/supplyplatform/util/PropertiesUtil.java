package com.supplyplatform.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具
 * @author bxy
 *
 */
public class PropertiesUtil {
	
	private  static Properties  prop;
	
	private final static String FILE_PATH = "config/properties/message.properties";
	
	private static PropertiesUtil util;
	
	private PropertiesUtil(){
		try {
			prop = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(FILE_PATH);
			prop.load(in);
		} catch (Exception z) {
			z.printStackTrace();
		}
	}
	
	public static PropertiesUtil getInstance() {
		
		if (util == null) {
			util = new PropertiesUtil();
		}
		return util;
	}
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}

}
