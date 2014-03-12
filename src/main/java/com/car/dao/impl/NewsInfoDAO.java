package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.INewsInfoDAO;
import com.car.domain.NewsInfo;
import com.car.utils.DateUtil;

/**
 * 新闻信息dao实现类
 * @Title: NewsInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class NewsInfoDAO extends BaseDAO implements INewsInfoDAO {

	private final String namespace = NewsInfo.class.getName();

	@Override
	public void insertSelective(NewsInfo newsInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		newsInfo.setCreate_time(date);
		newsInfo.setUpdate_time(date);
		insertSelective(namespace, newsInfo);
	}

	@Override
	public NewsInfo selectByPrimaryKey(NewsInfo newsInfo) {
		
		return (NewsInfo) selectByPrimaryKey(namespace, newsInfo);
	}

	@Override
	public int countByExample(NewsInfo newsInfo) {
		
		return countByExample(namespace, newsInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsInfo> selectByExample(NewsInfo newsInfo) {
		
		return selectByExample(namespace, newsInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(NewsInfo newsInfo) {
		
		newsInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, newsInfo);
	}

	@Override
	public int deleteByExample(NewsInfo newsInfo) {
		
		return deleteByExample(namespace, newsInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsInfo> getPageList(NewsInfo newsInfo, int pageNum, int pageSize) {
		
		return getPageList(newsInfo, namespace, pageNum, pageSize);
	}

}
