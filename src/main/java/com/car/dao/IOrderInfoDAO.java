package com.car.dao;

import java.util.List;

import com.car.domain.OrderInfo;

/**
 * 预约dao接口
 * @Title: IOrderInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IOrderInfoDAO {
	
	/**
	 * 保存数据
	 * @param orderInfo
	 */
	void insertSelective(OrderInfo orderInfo);
	
	/**
	 * 主键单条查询
	 * @param orderInfo
	 * @return
	 */
	OrderInfo selectByPrimaryKey(OrderInfo orderInfo);
	
	/**
	 * 数量查询
	 * @param orderInfo
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
	List<OrderInfo> getPageList(OrderInfo orderInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param orderInfo
	 */
	int updateByPrimaryKeySelective(OrderInfo orderInfo);
	
	/**
	 * 条件删除
	 * @param orderInfo
	 */
	int deleteByExample(OrderInfo orderInfo);
	
}
