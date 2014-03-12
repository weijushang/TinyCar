package com.car.domain;

import java.math.BigDecimal;

/**
 * 文件信息
 * @Title: FileInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class FileInfo {

	//文件id
	private BigDecimal file_id;
	//父id
	private BigDecimal parent_id;
	//文件类型00产品01优惠02新闻
	//03优惠广告图片04产品广告图片
	private String file_type;
	//文件名称
	private String file_name;
	//文件相对路径
	private String file_path;
	//文件后缀
	private String file_suffix;
	//文件原名称
	private String file_ori_name;
	//序号
	private Integer file_seq;
	//别名
	private String file_alise;
	//外部链接地址
	private String outer_url;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	
	public FileInfo(){}

	public BigDecimal getFile_id() {
		return file_id;
	}

	public void setFile_id(BigDecimal file_id) {
		this.file_id = file_id;
	}

	public BigDecimal getParent_id() {
		return parent_id;
	}

	public void setParent_id(BigDecimal parent_id) {
		this.parent_id = parent_id;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_suffix() {
		return file_suffix;
	}

	public void setFile_suffix(String file_suffix) {
		this.file_suffix = file_suffix;
	}

	public String getFile_ori_name() {
		return file_ori_name;
	}

	public void setFile_ori_name(String file_ori_name) {
		this.file_ori_name = file_ori_name;
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

	public Integer getFile_seq() {
		return file_seq;
	}

	public void setFile_seq(Integer file_seq) {
		this.file_seq = file_seq;
	}

	public String getFile_alise() {
		return file_alise;
	}

	public void setFile_alise(String file_alise) {
		this.file_alise = file_alise;
	}

	public String getOuter_url() {
		return outer_url;
	}

	public void setOuter_url(String outer_url) {
		this.outer_url = outer_url;
	}

}
