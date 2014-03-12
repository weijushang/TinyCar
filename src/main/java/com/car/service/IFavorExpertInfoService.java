package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.FavorExpertInfo;
import com.car.utils.CarException;

/**
 * 优惠专家sevice接口
 * @Title: IFavorExpertInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IFavorExpertInfoService {
	
	/**
	 * 保存数据
	 * @param favorExpertInfo
	 */
	boolean insertSelective(FavorExpertInfo favorExpertInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param favorExpertInfo
	 * @return
	 */
	FavorExpertInfo selectByPrimaryKey(FavorExpertInfo favorExpertInfo);
	
	/**
	 * 数量查询
	 * @param faqLogin
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
	@SuppressWarnings("rawtypes")
	Map getPageList(FavorExpertInfo favorExpertInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param favorExpertInfo
	 */
	boolean updateByPrimaryKeySelective(FavorExpertInfo favorExpertInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param favorExpertInfo
	 */
	boolean deleteByExample(FavorExpertInfo favorExpertInfo) throws CarException;
	
}
