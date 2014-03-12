package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.OrderInfo;
import com.car.utils.CarException;

/**
 * 预约sevice接口
 * @Title: IOrderInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IOrderInfoService {
	
	/**
	 * 保存数据
	 * @param orderInfo
	 */
	boolean insertSelective(OrderInfo orderInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param orderInfo
	 * @return
	 */
	OrderInfo selectByPrimaryKey(OrderInfo orderInfo);
	
	/**
	 * 数量查询
	 * @param orderLogin
	 * @return
	 */
	int countByExample(OrderInfo orderInfo);
	
	/**
	 * 列表查询
	 * @param orderInfo
	 * @return
	 */
	List<OrderInfo> selectByExample(OrderInfo orderInfo);
	
	/**
	 * 返回分页数据
	 * @param orderInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getPageList(OrderInfo orderInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param orderInfo
	 */
	boolean updateByPrimaryKeySelective(OrderInfo orderInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param orderInfo
	 */
	boolean deleteByExample(OrderInfo orderInfo) throws CarException;
	
}
