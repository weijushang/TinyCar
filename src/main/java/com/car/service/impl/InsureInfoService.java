package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.IInsureInfoDAO;
import com.car.domain.InsureInfo;
import com.car.service.IInsureInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 保险service实现类
 * @Title: InsureInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class InsureInfoService implements IInsureInfoService {

	private static Log log = LogFactory.getLog(InsureInfoService.class);

	@Autowired
	private IInsureInfoDAO insureInfoDAO;
	
	@Override
	public boolean insertSelective(InsureInfo insureInfo) throws CarException {
		
		boolean bool = true;
		try{

			insureInfoDAO.insertSelective(insureInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public InsureInfo selectByPrimaryKey(InsureInfo insureInfo) {
		
		return insureInfoDAO.selectByPrimaryKey(insureInfo);
	}

	@Override
	public int countByExample(InsureInfo insureInfo) {
		
		return insureInfoDAO.countByExample(insureInfo);
	}

	@Override
	public List<InsureInfo> selectByExample(InsureInfo insureInfo) {
		
		return insureInfoDAO.selectByExample(insureInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(InsureInfo insureInfo) throws CarException {
		
		try{
			return insureInfoDAO.updateByPrimaryKeySelective(insureInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(InsureInfo insureInfo) throws CarException {
		
		try{

			return insureInfoDAO.deleteByExample(insureInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(InsureInfo insureInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = insureInfoDAO.countByExample(insureInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<InsureInfo> list = insureInfoDAO.getPageList(insureInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
