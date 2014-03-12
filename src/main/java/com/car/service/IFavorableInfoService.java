package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.FavorableInfo;
import com.car.utils.CarException;

/**
 * 优惠sevice接口
 * @Title: IFavorableInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IFavorableInfoService {
	
	/**
	 * 保存数据
	 * @param favorableInfo
	 */
	boolean insertSelective(FavorableInfo favorableInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param favorableInfo
	 * @return
	 */
	FavorableInfo selectByPrimaryKey(FavorableInfo favorableInfo);
	
	/**
	 * 数量查询
	 * @param favorableLogin
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
	@SuppressWarnings("rawtypes")
	Map getPageList(FavorableInfo favorableInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param favorableInfo
	 */
	boolean updateByPrimaryKeySelective(FavorableInfo favorableInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param favorableInfo
	 */
	boolean deleteByExample(FavorableInfo favorableInfo) throws CarException;
	
}
