package com.car.utils;

import java.util.ResourceBundle;

/**
 * 从car.properties获取
 * @Title: CarConfig.java
 * @author wangyh
 * @date 2014-2-23 上午11:50:44
 * @Description: 
 */
public class CarConfig {
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("car");
	
	public static String getString(String key){
		return bundle.getString(key);
	}

}
