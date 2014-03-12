package com.car.domain;

import java.math.BigDecimal;


/**
 * 结清预约对象
 * @Title: SettleInfo.java
 * @author wangyh
 * @date 2014-3-5 上午11:46:18
 * @Description: 
 */
public class SettleInfo {
	
	//id
	private BigDecimal settle_id;
	//姓名
	private String settle_name;
	//手机
	private String settle_phone;
	//预约状态00未处理01已处理
	private String settle_state;
	//说明备注
	private String settle_remark;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;

	public SettleInfo(){}

	public BigDecimal getSettle_id() {
		return settle_id;
	}

	public void setSettle_id(BigDecimal settle_id) {
		this.settle_id = settle_id;
	}

	public String getSettle_name() {
		return settle_name;
	}

	public void setSettle_name(String settle_name) {
		this.settle_name = settle_name;
	}

	public String getSettle_phone() {
		return settle_phone;
	}

	public void setSettle_phone(String settle_phone) {
		this.settle_phone = settle_phone;
	}

	public String getSettle_state() {
		return settle_state;
	}

	public void setSettle_state(String settle_state) {
		this.settle_state = settle_state;
	}

	public String getSettle_remark() {
		return settle_remark;
	}

	public void setSettle_remark(String settle_remark) {
		this.settle_remark = settle_remark;
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
