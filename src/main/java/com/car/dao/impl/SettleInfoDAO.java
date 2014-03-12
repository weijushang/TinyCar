package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.ISettleInfoDAO;
import com.car.domain.SettleInfo;
import com.car.utils.DateUtil;

/**
 * 结清预约dao实现类
 * @Title: SettleInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class SettleInfoDAO extends BaseDAO implements ISettleInfoDAO {

	private final String namespace = SettleInfo.class.getName();

	@Override
	public void insertSelective(SettleInfo settleInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		settleInfo.setCreate_time(date);
		settleInfo.setUpdate_time(date);
		insertSelective(namespace, settleInfo);
	}

	@Override
	public SettleInfo selectByPrimaryKey(SettleInfo settleInfo) {
		
		return (SettleInfo) selectByPrimaryKey(namespace, settleInfo);
	}

	@Override
	public int countByExample(SettleInfo settleInfo) {
		
		return countByExample(namespace, settleInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SettleInfo> selectByExample(SettleInfo settleInfo) {
		
		return selectByExample(namespace, settleInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(SettleInfo settleInfo) {
		
		settleInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, settleInfo);
	}

	@Override
	public int deleteByExample(SettleInfo settleInfo) {
		
		return deleteByExample(namespace, settleInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SettleInfo> getPageList(SettleInfo settleInfo, int pageNum, int pageSize) {
		
		return getPageList(settleInfo, namespace, pageNum, pageSize);
	}

}
