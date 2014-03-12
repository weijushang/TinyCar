package com.car.domain;

import java.math.BigDecimal;

/**
 * 贷款专家
 * @Title: ExpertInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class CreditExpertInfo {

	//id
	private BigDecimal expert_id;
	//产品id
	private BigDecimal product_id;
	//产品标题
	private String product_title;
	//预约状态00未处理01已处理
	private String expert_state;
	//车价
	private String car_price;
	//客户姓名
	private String cust_name;
	//客户手机号码
	private String cust_phone;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	
	public CreditExpertInfo(){}

	public BigDecimal getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(BigDecimal expert_id) {
		this.expert_id = expert_id;
	}

	public BigDecimal getProduct_id() {
		return product_id;
	}

	public void setProduct_id(BigDecimal product_id) {
		this.product_id = product_id;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getCar_price() {
		return car_price;
	}

	public void setCar_price(String car_price) {
		this.car_price = car_price;
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

	public String getExpert_state() {
		return expert_state;
	}

	public void setExpert_state(String expert_state) {
		this.expert_state = expert_state;
	}

}
