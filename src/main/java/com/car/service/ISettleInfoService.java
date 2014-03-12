package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.SettleInfo;
import com.car.utils.CarException;

/**
 * 结清预约sevice接口
 * @Title: ISettleInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface ISettleInfoService {
	
	/**
	 * 保存数据
	 * @param settleInfo
	 */
	boolean insertSelective(SettleInfo settleInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param settleInfo
	 * @return
	 */
	SettleInfo selectByPrimaryKey(SettleInfo settleInfo);
	
	/**
	 * 数量查询
	 * @param faqLogin
	 * @return
	 */
	int countByExample(SettleInfo settleInfo);
	
	/**
	 * 列表查询
	 * @param settleInfo
	 * @return
	 */
	List<SettleInfo> selectByExample(SettleInfo settleInfo);
	
	/**
	 * 返回分页数据
	 * @param settleInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getPageList(SettleInfo settleInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param settleInfo
	 */
	boolean updateByPrimaryKeySelective(SettleInfo settleInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param settleInfo
	 */
	boolean deleteByExample(SettleInfo settleInfo) throws CarException;
	
}
