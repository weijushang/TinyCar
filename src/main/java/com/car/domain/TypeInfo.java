package com.car.domain;

import java.math.BigDecimal;


/**
 * 类别
 * @Title: TypeInfo.java
 * @author wangyh
 * @date 2014-3-11 下午7:43:51
 * @Description: 
 */
public class TypeInfo {
	
	//id
	private BigDecimal type_id;
	//类别名称
	private String type_name;
	//类型00新闻01faq
	private String type_classify;
	//备注说明
	private String type_remark;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	
	public TypeInfo(){}

	public BigDecimal getType_id() {
		return type_id;
	}

	public void setType_id(BigDecimal type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_classify() {
		return type_classify;
	}

	public void setType_classify(String type_classify) {
		this.type_classify = type_classify;
	}

	public String getType_remark() {
		return type_remark;
	}

	public void setType_remark(String type_remark) {
		this.type_remark = type_remark;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
}
