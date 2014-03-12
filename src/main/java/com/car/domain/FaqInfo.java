package com.car.domain;

import java.math.BigDecimal;

/**
 * 常见问题
 * @Title: FaqInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class FaqInfo {

	//id
	private BigDecimal faq_id;
	//类型id
	private BigDecimal type_id;
	//类型
	private String type_name;
	//问题
	private String faq_request;
	//答案
	private byte[] faq_answer;
	//答案
	private String faq_answer_str;
	//序号，用来排序
	private Integer faq_seq;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	//查询条件
	private String search_word;
	
	public FaqInfo(){}

	public BigDecimal getFaq_id() {
		return faq_id;
	}

	public void setFaq_id(BigDecimal faq_id) {
		this.faq_id = faq_id;
	}

	public String getFaq_request() {
		return faq_request;
	}

	public void setFaq_request(String faq_request) {
		this.faq_request = faq_request;
	}

	public byte[] getFaq_answer() {
		return faq_answer;
	}

	public void setFaq_answer(byte[] faq_answer) {
		this.faq_answer = faq_answer;
	}

	public String getFaq_answer_str() {
		return faq_answer_str;
	}

	public void setFaq_answer_str(String faq_answer_str) {
		this.faq_answer_str = faq_answer_str;
	}

	public Integer getFaq_seq() {
		return faq_seq;
	}

	public void setFaq_seq(Integer faq_seq) {
		this.faq_seq = faq_seq;
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

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

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

}
