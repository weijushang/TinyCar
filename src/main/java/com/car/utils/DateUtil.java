package com.car.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间常用方法
 * @Title: DateUtil.java
 * @author wangyh
 * @date 2014-2-23 上午11:51:21
 * @Description: 
 */
public class DateUtil {
	
	//时间格式
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String YYMMDDhHMMSS = "yyyyMMddHHmmss";
	
	/**
	 * 获取yyyy-MM-dd格式的时间串
	 * @return
	 */
	public static String getCurrentDate(){
		return getCurrentDate(YYYY_MM_DD);
	}
	
	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式的时间串
	 * @return
	 */
	public static String getCurrentDateTime(){
		return getCurrentDate(Y_M_D_H_M_S);
	}
	
	/**
	 * 获取自定义格式的时间串
	 * @param format
	 * @return
	 */
	public static String getCurrentDate(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
}
