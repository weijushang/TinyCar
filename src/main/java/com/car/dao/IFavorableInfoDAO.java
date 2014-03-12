package com.car.dao;

import java.util.List;

import com.car.domain.FavorableInfo;

/**
 * 优惠dao接口
 * @Title: IFavorableInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IFavorableInfoDAO {
	
	/**
	 * 保存数据
	 * @param favorableInfo
	 */
	void insertSelective(FavorableInfo favorableInfo);
	
	/**
	 * 主键单条查询
	 * @param favorableInfo
	 * @return
	 */
	FavorableInfo selectByPrimaryKey(FavorableInfo favorableInfo);
	
	/**
	 * 数量查询
	 * @param favorableInfo
	 * @return
	 */
	int countByExample(FavorableInfo favorableInfo);
	
	/**
	 * 列表查询
	 * @param favorableInfo
	 * @return
	 */
	List<FavorableInfo> selectByExample(FavorableInfo favorableInfo);
	
	/**
	 * 返回分页数据
	 * @param favorableInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<FavorableInfo> getPageList(FavorableInfo favorableInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param favorableInfo
	 */
	int updateByPrimaryKeySelective(FavorableInfo favorableInfo);
	
	/**
	 * 条件删除
	 * @param favorableInfo
	 */
	int deleteByExample(FavorableInfo favorableInfo);
	
}
