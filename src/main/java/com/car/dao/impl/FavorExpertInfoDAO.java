package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IFavorExpertInfoDAO;
import com.car.domain.FavorExpertInfo;
import com.car.utils.DateUtil;

/**
 * 优惠专家dao实现类
 * @Title: FavorExpertInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class FavorExpertInfoDAO extends BaseDAO implements IFavorExpertInfoDAO {

	private final String namespace = FavorExpertInfo.class.getName();

	@Override
	public void insertSelective(FavorExpertInfo favorExpertInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		favorExpertInfo.setCreate_time(date);
		favorExpertInfo.setUpdate_time(date);
		insertSelective(namespace, favorExpertInfo);
	}

	@Override
	public FavorExpertInfo selectByPrimaryKey(FavorExpertInfo favorExpertInfo) {
		
		return (FavorExpertInfo) selectByPrimaryKey(namespace, favorExpertInfo);
	}

	@Override
	public int countByExample(FavorExpertInfo favorExpertInfo) {
		
		return countByExample(namespace, favorExpertInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FavorExpertInfo> selectByExample(FavorExpertInfo favorExpertInfo) {
		
		return selectByExample(namespace, favorExpertInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(FavorExpertInfo favorExpertInfo) {
		
		favorExpertInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, favorExpertInfo);
	}

	@Override
	public int deleteByExample(FavorExpertInfo favorExpertInfo) {
		
		return deleteByExample(namespace, favorExpertInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FavorExpertInfo> getPageList(FavorExpertInfo favorExpertInfo, int pageNum, int pageSize) {
		
		return getPageList(favorExpertInfo, namespace, pageNum, pageSize);
	}

}
