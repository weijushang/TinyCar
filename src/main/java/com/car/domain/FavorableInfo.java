package com.car.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

/**
 * 优惠信息
 * @Title: FavorableInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class FavorableInfo {
	
	//优惠id
	private BigDecimal favor_id;
	//品牌
	private Integer car_type;
	//车系
	private Integer car_type_son;
	//车系名称
	private String car_type_name;
	//优惠标题
	private String favor_title;
	//优惠简介
	private String favor_intro;
	//优惠详情
	private byte[] favor_detail;
	//优惠详情(字符串)
	private String favor_detail_str;
	//顾问
	private String favor_counselor;
	//电话
	private String favor_phone;
	//咨询电话
	private String hot_line;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	//优惠开始时间
	private String favor_bdate;
	//优惠结束时间
	private String favor_edate;
	
	private String file_path;//图片路径
	//对应的图片
	private MultipartFile image_file;
	
	private FileInfo fileInfo;//图片内容
	
	public FavorableInfo(){}

	public BigDecimal getFavor_id() {
		return favor_id;
	}

	public void setFavor_id(BigDecimal favor_id) {
		this.favor_id = favor_id;
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

	public String getFavor_title() {
		return favor_title;
	}

	public void setFavor_title(String favor_title) {
		this.favor_title = favor_title;
	}

	public String getFavor_intro() {
		return favor_intro;
	}

	public void setFavor_intro(String favor_intro) {
		this.favor_intro = favor_intro;
	}

	public byte[] getFavor_detail() {
		return favor_detail;
	}

	public void setFavor_detail(byte[] favor_detail) {
		this.favor_detail = favor_detail;
	}

	public String getFavor_counselor() {
		return favor_counselor;
	}

	public void setFavor_counselor(String favor_counselor) {
		this.favor_counselor = favor_counselor;
	}

	public String getFavor_phone() {
		return favor_phone;
	}

	public void setFavor_phone(String favor_phone) {
		this.favor_phone = favor_phone;
	}

	public String getHot_line() {
		return hot_line;
	}

	public void setHot_line(String hot_line) {
		this.hot_line = hot_line;
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

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public MultipartFile getImage_file() {
		return image_file;
	}

	public void setImage_file(MultipartFile image_file) {
		this.image_file = image_file;
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	public String getFavor_detail_str() {
		return favor_detail_str;
	}

	public void setFavor_detail_str(String favor_detail_str) {
		this.favor_detail_str = favor_detail_str;
	}

	public String getFavor_bdate() {
		return favor_bdate;
	}

	public void setFavor_bdate(String favor_bdate) {
		this.favor_bdate = favor_bdate;
	}

	public String getFavor_edate() {
		return favor_edate;
	}

	public void setFavor_edate(String favor_edate) {
		this.favor_edate = favor_edate;
	}
}
