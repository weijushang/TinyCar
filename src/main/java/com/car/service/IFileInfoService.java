package com.car.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.car.domain.FileInfo;
import com.car.utils.CarException;

/**
 * 文件信息sevice接口
 * @Title: IFileInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IFileInfoService {
	
	/**
	 * 保存数据
	 * @param fileInfo
	 */
	boolean insertSelective(FileInfo fileInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param fileInfo
	 * @return
	 */
	FileInfo selectByPrimaryKey(FileInfo fileInfo);
	
	/**
	 * 数量查询
	 * @param fileLogin
	 * @return
	 */
	int countByExample(FileInfo fileInfo);
	
	/**
	 * 列表查询
	 * @param fileInfo
	 * @return
	 */
	List<FileInfo> selectByExample(FileInfo fileInfo);
	
	/**
	 * 返回分页数据
	 * @param fileInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getPageList(FileInfo fileInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param fileInfo
	 */
	boolean updateByPrimaryKeySelective(FileInfo fileInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param fileInfo
	 */
	boolean deleteByExample(FileInfo fileInfo) throws CarException;
	
	/**
	 * 批量保存图片
	 * @param image_files
	 * @param file_type 图片类型
	 * @return
	 */
	boolean saveFiles(MultipartFile[] image_files, String[] file_type) throws CarException;
	
	/**
	 * 批量保存图片
	 * @param image_files
	 * @param file_alise 名称
	 * @param outer_url 外部链接地址
	 * @param file_seq 序号
	 * @return
	 * @throws CarException
	 */
	boolean saveFiles(MultipartFile[] image_files, String[] file_alise, String[] outer_url, Integer[] file_seq) throws CarException;
	
}
