package com.car.dao;

import java.util.List;

import com.car.domain.NewsInfo;

/**
 * 新闻dao接口
 * @Title: INewsInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface INewsInfoDAO {
	
	/**
	 * 保存数据
	 * @param newsInfo
	 */
	void insertSelective(NewsInfo newsInfo);
	
	/**
	 * 主键单条查询
	 * @param newsInfo
	 * @return
	 */
	NewsInfo selectByPrimaryKey(NewsInfo newsInfo);
	
	/**
	 * 数量查询
	 * @param newsInfo
	 * @return
	 */
	int countByExample(NewsInfo newsInfo);
	
	/**
	 * 列表查询
	 * @param newsInfo
	 * @return
	 */
	List<NewsInfo> selectByExample(NewsInfo newsInfo);
	
	/**
	 * 返回分页数据
	 * @param newsInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<NewsInfo> getPageList(NewsInfo newsInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param newsInfo
	 */
	int updateByPrimaryKeySelective(NewsInfo newsInfo);
	
	/**
	 * 条件删除
	 * @param newsInfo
	 */
	int deleteByExample(NewsInfo newsInfo);
	
}
