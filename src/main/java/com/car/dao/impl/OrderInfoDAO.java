package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IOrderInfoDAO;
import com.car.domain.OrderInfo;
import com.car.utils.DateUtil;

/**
 * 预约信息dao实现类
 * @Title: OrderInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class OrderInfoDAO extends BaseDAO implements IOrderInfoDAO {

	private final String namespace = OrderInfo.class.getName();

	@Override
	public void insertSelective(OrderInfo orderInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		orderInfo.setCreate_time(date);
		orderInfo.setUpdate_time(date);
		insertSelective(namespace, orderInfo);
	}

	@Override
	public OrderInfo selectByPrimaryKey(OrderInfo orderInfo) {
		
		return (OrderInfo) selectByPrimaryKey(namespace, orderInfo);
	}

	@Override
	public int countByExample(OrderInfo orderInfo) {
		
		return countByExample(namespace, orderInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderInfo> selectByExample(OrderInfo orderInfo) {
		
		return selectByExample(namespace, orderInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderInfo orderInfo) {
		
		orderInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, orderInfo);
	}

	@Override
	public int deleteByExample(OrderInfo orderInfo) {
		
		return deleteByExample(namespace, orderInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderInfo> getPageList(OrderInfo orderInfo, int pageNum, int pageSize) {
		
		return getPageList(orderInfo, namespace, pageNum, pageSize);
	}

}
