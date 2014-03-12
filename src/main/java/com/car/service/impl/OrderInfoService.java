package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.IOrderInfoDAO;
import com.car.domain.OrderInfo;
import com.car.service.IOrderInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 预约service实现类
 * @Title: OrderInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class OrderInfoService implements IOrderInfoService {

	private static Log log = LogFactory.getLog(OrderInfoService.class);

	@Autowired
	private IOrderInfoDAO orderInfoDAO;
	
	@Override
	public boolean insertSelective(OrderInfo orderInfo) throws CarException {
		
		boolean bool = true;
		try{

			orderInfoDAO.insertSelective(orderInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public OrderInfo selectByPrimaryKey(OrderInfo orderInfo) {
		
		return orderInfoDAO.selectByPrimaryKey(orderInfo);
	}

	@Override
	public int countByExample(OrderInfo orderInfo) {
		
		return orderInfoDAO.countByExample(orderInfo);
	}

	@Override
	public List<OrderInfo> selectByExample(OrderInfo orderInfo) {
		
		return orderInfoDAO.selectByExample(orderInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(OrderInfo orderInfo) throws CarException {
		
		try{
			return orderInfoDAO.updateByPrimaryKeySelective(orderInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(OrderInfo orderInfo) throws CarException {
		
		try{

			return orderInfoDAO.deleteByExample(orderInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(OrderInfo orderInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = orderInfoDAO.countByExample(orderInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<OrderInfo> list = orderInfoDAO.getPageList(orderInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
