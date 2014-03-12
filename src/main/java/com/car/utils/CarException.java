package com.car.utils;

/**
 * 自定义异常
 * @Title: CarException.java
 * @author wangyh
 * @date 2014-2-23 上午11:50:33
 * @Description: 
 */
public class CarException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8072443334825807547L;
	//错误码
	private String errCode;
	//错误信息
	private String errMsg;
	
	public CarException(){}
	
	public CarException(String errCode, String errMsg){
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer("{errCode:");
		str.append(errCode).append(", errMsg:").append(errMsg).append("}");
		return str.toString();
	}
}
