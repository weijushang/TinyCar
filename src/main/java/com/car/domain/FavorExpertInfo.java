package com.car.domain;

import java.math.BigDecimal;

/**
 * 优惠专家
 * @Title: ExpertInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class FavorExpertInfo {

	//id
	private BigDecimal expert_id;
	//优惠id
	private BigDecimal favor_id;
	//优惠标题
	private String favor_title;
	//推荐车型／品牌
	private Integer car_type;
	//车系类型
	private Integer car_type_son;
	//车系名称
	private String car_type_name;
	//推荐人姓名
	private String cust_name;
	//推荐人手机号码
	private String cust_phone;
	//被推荐人姓名
	private String presentee_name;
	//被推荐人手机号码
	private String presentee_phone;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	
	public FavorExpertInfo(){}

	public BigDecimal getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(BigDecimal expert_id) {
		this.expert_id = expert_id;
	}

	public BigDecimal getFavor_id() {
		return favor_id;
	}

	public void setFavor_id(BigDecimal favor_id) {
		this.favor_id = favor_id;
	}

	public String getFavor_title() {
		return favor_title;
	}

	public void setFavor_title(String favor_title) {
		this.favor_title = favor_title;
	}

	public Integer getCar_type() {
		return car_type;
	}

	public void setCar_type(Integer car_type) {
		this.car_type = car_type;
	}

	public Integer getCar_type_son() {
		return car_type_son;
	}

	public void setCar_type_son(Integer car_type_son) {
		this.car_type_son = car_type_son;
	}

	public String getCar_type_name() {
		return car_type_name;
	}

	public void setCar_type_name(String car_type_name) {
		this.car_type_name = car_type_name;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getPresentee_name() {
		return presentee_name;
	}

	public void setPresentee_name(String presentee_name) {
		this.presentee_name = presentee_name;
	}

	public String getPresentee_phone() {
		return presentee_phone;
	}

	public void setPresentee_phone(String presentee_phone) {
		this.presentee_phone = presentee_phone;
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
