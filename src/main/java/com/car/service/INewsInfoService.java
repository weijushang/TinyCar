package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.NewsInfo;
import com.car.utils.CarException;

/**
 * 新闻sevice接口
 * @Title: INewsInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface INewsInfoService {
	
	/**
	 * 保存数据
	 * @param newsInfo
	 */
	boolean insertSelective(NewsInfo newsInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param newsInfo
	 * @return
	 */
	NewsInfo selectByPrimaryKey(NewsInfo newsInfo);
	
	/**
	 * 数量查询
	 * @param newsLogin
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
	@SuppressWarnings("rawtypes")
	Map getPageList(NewsInfo newsInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param newsInfo
	 */
	boolean updateByPrimaryKeySelective(NewsInfo newsInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param newsInfo
	 */
	boolean deleteByExample(NewsInfo newsInfo) throws CarException;
	
}
