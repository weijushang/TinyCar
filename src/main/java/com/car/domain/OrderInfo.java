package com.car.domain;

import java.math.BigDecimal;

/**
 * 在线申请
 * @Title: OrderInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class OrderInfo {
	
	//id
	private BigDecimal order_id;
	//客户名称
	private String cust_name;
	//客户手机号码
	private String cust_phone;
	//客户性别00女01男
	private String cust_sex;
	//身份证号码
	private String cust_card;
	//省份id
	private String province_id;
	//城市id
	private String city_id;
	//车价
	private String car_price;
	//车型／品牌
	private Integer car_type;
	//车系
	private Integer car_type_son;
	//品牌名称
	private String car_type_name;
	//申请状态00未处理01已处理
	private String order_state;
	//推荐人信息
	private BigDecimal expert_id;
	//推荐人信息
	private FavorExpertInfo favorExpertInfo;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	//youhui
	private BigDecimal favor_id;
	
	public OrderInfo(){}

	public BigDecimal getOrder_id() {
		return order_id;
	}

	public void setOrder_id(BigDecimal order_id) {
		this.order_id = order_id;
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

	public String getCust_sex() {
		return cust_sex;
	}

	public void setCust_sex(String cust_sex) {
		this.cust_sex = cust_sex;
	}

	public String getCust_card() {
		return cust_card;
	}

	public void setCust_card(String cust_card) {
		this.cust_card = cust_card;
	}

	public String getProvince_id() {
		return province_id;
	}

	public void setProvince_id(String province_id) {
		this.province_id = province_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCar_price() {
		return car_price;
	}

	public void setCar_price(String car_price) {
		this.car_price = car_price;
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

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
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

	public BigDecimal getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(BigDecimal expert_id) {
		this.expert_id = expert_id;
	}

	public FavorExpertInfo getFavorExpertInfo() {
		return favorExpertInfo;
	}

	public void setFavorExpertInfo(FavorExpertInfo favorExpertInfo) {
		this.favorExpertInfo = favorExpertInfo;
	}

	public BigDecimal getFavor_id() {
		return favor_id;
	}

	public void setFavor_id(BigDecimal favor_id) {
		this.favor_id = favor_id;
	}

}
