package com.car.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

/**
 * 新闻信息
 * @Title: NewsInfo.java
 * @author wangyh
 * @date 2013-12-29 下午5:26:26
 * @Description: 
 */
public class NewsInfo {
	
	//新闻编码
	private BigDecimal news_id;
	//新闻标题
	private String news_title;
	//新闻类型id
	private BigDecimal type_id;
	//类型名称
	private String type_name;
	//外部链接
	private String outer_url;
	//新闻内容
	private byte[] news_content;
	//
	private String news_content_str;
	//创建时间
	private String create_time;
	//更新时间
	private String update_time;
	
	private String file_path;//图片路径
	
	//对应的图片
	private MultipartFile image_file;
	
	private FileInfo fileInfo;//图片内容
	
	public NewsInfo(){}

	public BigDecimal getNews_id() {
		return news_id;
	}

	public void setNews_id(BigDecimal news_id) {
		this.news_id = news_id;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
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

	public byte[] getNews_content() {
		return news_content;
	}

	public void setNews_content(byte[] news_content) {
		this.news_content = news_content;
	}

	public String getNews_content_str() {
		return news_content_str;
	}

	public void setNews_content_str(String news_content_str) {
		this.news_content_str = news_content_str;
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

	public String getOuter_url() {
		return outer_url;
	}

	public void setOuter_url(String outer_url) {
		this.outer_url = outer_url;
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
	
}
