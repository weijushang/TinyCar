package com.car.dao;

import java.util.List;

import com.car.domain.FavorExpertInfo;

/**
 * 优惠专家dao接口
 * @Title: IFavorExpertInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IFavorExpertInfoDAO {
	
	/**
	 * 保存数据
	 * @param favorExpertInfo
	 */
	void insertSelective(FavorExpertInfo favorExpertInfo);
	
	/**
	 * 主键单条查询
	 * @param favorExpertInfo
	 * @return
	 */
	FavorExpertInfo selectByPrimaryKey(FavorExpertInfo favorExpertInfo);
	
	/**
	 * 数量查询
	 * @param favorExpertInfo
	 * @return
	 */
	int countByExample(FavorExpertInfo favorExpertInfo);
	
	/**
	 * 列表查询
	 * @param favorExpertInfo
	 * @return
	 */
	List<FavorExpertInfo> selectByExample(FavorExpertInfo favorExpertInfo);
	
	/**
	 * 返回分页数据
	 * @param favorExpertInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<FavorExpertInfo> getPageList(FavorExpertInfo favorExpertInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param favorExpertInfo
	 */
	int updateByPrimaryKeySelective(FavorExpertInfo favorExpertInfo);
	
	/**
	 * 条件删除
	 * @param favorExpertInfo
	 */
	int deleteByExample(FavorExpertInfo favorExpertInfo);
	
}
