package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IFileInfoDAO;
import com.car.domain.FileInfo;
import com.car.utils.DateUtil;

/**
 * 文件信息dao实现类
 * @Title: FileInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class FileInfoDAO extends BaseDAO implements IFileInfoDAO {

	private final String namespace = FileInfo.class.getName();

	@Override
	public void insertSelective(FileInfo fileInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		fileInfo.setCreate_time(date);
		fileInfo.setUpdate_time(date);
		insertSelective(namespace, fileInfo);
	}

	@Override
	public FileInfo selectByPrimaryKey(FileInfo fileInfo) {
		
		return (FileInfo) selectByPrimaryKey(namespace, fileInfo);
	}

	@Override
	public int countByExample(FileInfo fileInfo) {
		
		return countByExample(namespace, fileInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileInfo> selectByExample(FileInfo fileInfo) {
		
		return selectByExample(namespace, fileInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(FileInfo fileInfo) {
		
		fileInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, fileInfo);
	}

	@Override
	public int deleteByExample(FileInfo fileInfo) {
		
		return deleteByExample(namespace, fileInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileInfo> getPageList(FileInfo fileInfo, int pageNum, int pageSize) {
		
		return getPageList(fileInfo, namespace, pageNum, pageSize);
	}

}
