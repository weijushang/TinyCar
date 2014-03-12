package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.ICreditExpertInfoDAO;
import com.car.domain.CreditExpertInfo;
import com.car.service.ICreditExpertInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 贷款专家service实现类
 * @Title: CreditExpertInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class CreditExpertInfoService implements ICreditExpertInfoService {

	private static Log log = LogFactory.getLog(CreditExpertInfoService.class);

	@Autowired
	private ICreditExpertInfoDAO creditExpertInfoDAO;
	
	@Override
	public boolean insertSelective(CreditExpertInfo creditExpertInfo) throws CarException {
		
		boolean bool = true;
		try{

			creditExpertInfoDAO.insertSelective(creditExpertInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public CreditExpertInfo selectByPrimaryKey(CreditExpertInfo creditExpertInfo) {
		
		return creditExpertInfoDAO.selectByPrimaryKey(creditExpertInfo);
	}

	@Override
	public int countByExample(CreditExpertInfo creditExpertInfo) {
		
		return creditExpertInfoDAO.countByExample(creditExpertInfo);
	}

	@Override
	public List<CreditExpertInfo> selectByExample(CreditExpertInfo creditExpertInfo) {
		
		return creditExpertInfoDAO.selectByExample(creditExpertInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(CreditExpertInfo creditExpertInfo) throws CarException {
		
		try{
			return creditExpertInfoDAO.updateByPrimaryKeySelective(creditExpertInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新常见问题数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(CreditExpertInfo creditExpertInfo) throws CarException {
		
		try{

			return creditExpertInfoDAO.deleteByExample(creditExpertInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除常见问题异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(CreditExpertInfo creditExpertInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = creditExpertInfoDAO.countByExample(creditExpertInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<CreditExpertInfo> list = creditExpertInfoDAO.getPageList(creditExpertInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
