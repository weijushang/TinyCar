package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IInsureInfoDAO;
import com.car.domain.InsureInfo;
import com.car.utils.DateUtil;

/**
 * 保险信息dao实现类
 * @Title: InsureInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class InsureInfoDAO extends BaseDAO implements IInsureInfoDAO {

	private final String namespace = InsureInfo.class.getName();

	@Override
	public void insertSelective(InsureInfo insureInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		insureInfo.setCreate_time(date);
		insureInfo.setUpdate_time(date);
		insertSelective(namespace, insureInfo);
	}

	@Override
	public InsureInfo selectByPrimaryKey(InsureInfo insureInfo) {
		
		return (InsureInfo) selectByPrimaryKey(namespace, insureInfo);
	}

	@Override
	public int countByExample(InsureInfo insureInfo) {
		
		return countByExample(namespace, insureInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InsureInfo> selectByExample(InsureInfo insureInfo) {
		
		return selectByExample(namespace, insureInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(InsureInfo insureInfo) {
		
		insureInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, insureInfo);
	}

	@Override
	public int deleteByExample(InsureInfo insureInfo) {
		
		return deleteByExample(namespace, insureInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InsureInfo> getPageList(InsureInfo insureInfo, int pageNum, int pageSize) {
		
		return getPageList(insureInfo, namespace, pageNum, pageSize);
	}

}
