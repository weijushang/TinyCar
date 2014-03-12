package com.car.domain;


/**
 * 车型、品牌
 * @Title: CarType.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class CarType {
	
	//车类型
	private Integer id;
	//类型名称
	private String value;

	public CarType(){}
	
	public CarType(Integer id, String value){
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
