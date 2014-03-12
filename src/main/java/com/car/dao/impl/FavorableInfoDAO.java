package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IFavorableInfoDAO;
import com.car.domain.FavorableInfo;
import com.car.utils.DateUtil;

/**
 * 优惠信息dao实现类
 * @Title: FavorableInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class FavorableInfoDAO extends BaseDAO implements IFavorableInfoDAO {

	private final String namespace = FavorableInfo.class.getName();

	@Override
	public void insertSelective(FavorableInfo favorableInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		favorableInfo.setCreate_time(date);
		favorableInfo.setUpdate_time(date);
		insertSelective(namespace, favorableInfo);
	}

	@Override
	public FavorableInfo selectByPrimaryKey(FavorableInfo favorableInfo) {
		
		return (FavorableInfo) selectByPrimaryKey(namespace, favorableInfo);
	}

	@Override
	public int countByExample(FavorableInfo favorableInfo) {
		
		return countByExample(namespace, favorableInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FavorableInfo> selectByExample(FavorableInfo favorableInfo) {
		
		return selectByExample(namespace, favorableInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(FavorableInfo favorableInfo) {
		
		favorableInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, favorableInfo);
	}

	@Override
	public int deleteByExample(FavorableInfo favorableInfo) {
		
		return deleteByExample(namespace, favorableInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FavorableInfo> getPageList(FavorableInfo favorableInfo, int pageNum, int pageSize) {
		
		return getPageList(favorableInfo, namespace, pageNum, pageSize);
	}

}
