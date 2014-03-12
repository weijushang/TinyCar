package com.car.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

/**
 * 产品信息
 * @Title: ProductInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class ProductInfo {
	
	//产品id
	private BigDecimal product_id;
	//产品标题
	private String product_title;
	//产品详情
	private byte[] product_detail;
	//产品详情
	private String product_detail_str;
	//顾问
	private String p_counselor;
	//电话
	private String phone_call;
	//咨询电话
	private String hot_line;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;

	private String file_path;//图片路径
	//对应的图片
	private MultipartFile image_file;
	
	private FileInfo fileInfo;//图片内容
	
	public ProductInfo(){}

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

	public byte[] getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(byte[] product_detail) {
		this.product_detail = product_detail;
	}

	public String getProduct_detail_str() {
		return product_detail_str;
	}

	public void setProduct_detail_str(String product_detail_str) {
		this.product_detail_str = product_detail_str;
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

	public String getP_counselor() {
		return p_counselor;
	}

	public void setP_counselor(String p_counselor) {
		this.p_counselor = p_counselor;
	}

	public String getPhone_call() {
		return phone_call;
	}

	public void setPhone_call(String phone_call) {
		this.phone_call = phone_call;
	}

	public String getHot_line() {
		return hot_line;
	}

	public void setHot_line(String hot_line) {
		this.hot_line = hot_line;
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

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

}
