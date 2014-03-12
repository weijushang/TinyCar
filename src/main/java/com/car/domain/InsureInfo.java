package com.car.domain;

import java.math.BigDecimal;

/**
 * 保险信息
 * @Title: InsureInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class InsureInfo {
	
	//保险id
	private BigDecimal insure_id;
	//保险标题
	private String insure_title;
	//保险简介
	private String insure_intro;
	//保险详情
	private byte[] insure_detail;
	//保险详情
	private String insure_detail_str;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	
	public InsureInfo(){}

	public BigDecimal getInsure_id() {
		return insure_id;
	}

	public void setInsure_id(BigDecimal insure_id) {
		this.insure_id = insure_id;
	}

	public String getInsure_title() {
		return insure_title;
	}

	public void setInsure_title(String insure_title) {
		this.insure_title = insure_title;
	}

	public String getInsure_intro() {
		return insure_intro;
	}

	public void setInsure_intro(String insure_intro) {
		this.insure_intro = insure_intro;
	}

	public byte[] getInsure_detail() {
		return insure_detail;
	}

	public void setInsure_detail(byte[] insure_detail) {
		this.insure_detail = insure_detail;
	}

	public String getInsure_detail_str() {
		return insure_detail_str;
	}

	public void setInsure_detail_str(String insure_detail_str) {
		this.insure_detail_str = insure_detail_str;
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
