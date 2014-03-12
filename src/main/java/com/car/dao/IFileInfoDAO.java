package com.car.dao;

import java.util.List;

import com.car.domain.FileInfo;

/**
 * 文件信息dao接口
 * @Title: IFileInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IFileInfoDAO {
	
	/**
	 * 保存数据
	 * @param fileInfo
	 */
	void insertSelective(FileInfo fileInfo);
	
	/**
	 * 主键单条查询
	 * @param fileInfo
	 * @return
	 */
	FileInfo selectByPrimaryKey(FileInfo fileInfo);
	
	/**
	 * 数量查询
	 * @param fileInfo
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
	List<FileInfo> getPageList(FileInfo fileInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param fileInfo
	 */
	int updateByPrimaryKeySelective(FileInfo fileInfo);
	
	/**
	 * 条件删除
	 * @param fileInfo
	 */
	int deleteByExample(FileInfo fileInfo);
	
}
