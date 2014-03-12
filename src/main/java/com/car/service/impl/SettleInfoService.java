package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.ISettleInfoDAO;
import com.car.domain.SettleInfo;
import com.car.service.ISettleInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 结清预约service实现类
 * @Title: SettleInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class SettleInfoService implements ISettleInfoService {

	private static Log log = LogFactory.getLog(SettleInfoService.class);

	@Autowired
	private ISettleInfoDAO settleInfoDAO;
	
	@Override
	public boolean insertSelective(SettleInfo settleInfo) throws CarException {
		
		boolean bool = true;
		try{

			settleInfoDAO.insertSelective(settleInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public SettleInfo selectByPrimaryKey(SettleInfo settleInfo) {
		
		return settleInfoDAO.selectByPrimaryKey(settleInfo);
	}

	@Override
	public int countByExample(SettleInfo settleInfo) {
		
		return settleInfoDAO.countByExample(settleInfo);
	}

	@Override
	public List<SettleInfo> selectByExample(SettleInfo settleInfo) {
		
		return settleInfoDAO.selectByExample(settleInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(SettleInfo settleInfo) throws CarException {
		
		try{
			return settleInfoDAO.updateByPrimaryKeySelective(settleInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新常见问题数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(SettleInfo settleInfo) throws CarException {
		
		try{

			return settleInfoDAO.deleteByExample(settleInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除常见问题异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(SettleInfo settleInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = settleInfoDAO.countByExample(settleInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<SettleInfo> list = settleInfoDAO.getPageList(settleInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
