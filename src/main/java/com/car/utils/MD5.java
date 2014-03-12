package com.car.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 
 * 32位的加密类
 * @Title: MD5.java
 * @author wangyh
 * @date 2014-2-23 上午11:51:55
 * @Description: 
 */
public class MD5 {

	private static Log log = LogFactory.getLog(MD5.class);
	
	/**
	 * md5 加密
	 * @param value
	 * @return
	 */
	public final static String encrypt(String value) {
		// 返回字符串
		String md5Str = null;
		try {
			// 操作字符串
			StringBuffer buf = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 添加要进行计算摘要的信息,使用 plainText 的 byte 数组更新摘要。
			md.update(value.getBytes());
			// 计算出摘要,完成哈希计算。
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				// 将整型 十进制 i 转换为16位，用十六进制参数表示的无符号整数值的字符串表示形式。
				buf.append(Integer.toHexString(i));
			}
			// 32位的加密
			md5Str = buf.toString();
		} catch (Exception e) {
			log.error("MD5加密异常"+e);
		}
		return md5Str;
	}
	
	/**
	 * 获取唯一id
	 * @return
	 */
	public static BigDecimal getID(String flag, Long index){
		
		return new BigDecimal(flag+(System.currentTimeMillis()+index));
	}
	
	public static void main(String[] args){
	
		log.info(encrypt("admin"));//21232f297a57a5a743894a0e4a801fc3
		
	}
}
