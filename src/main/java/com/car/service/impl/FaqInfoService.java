package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.IFaqInfoDAO;
import com.car.domain.FaqInfo;
import com.car.service.IFaqInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 常见问题service实现类
 * @Title: FaqInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class FaqInfoService implements IFaqInfoService {

	private static Log log = LogFactory.getLog(FaqInfoService.class);

	@Autowired
	private IFaqInfoDAO faqInfoDAO;
	
	@Override
	public boolean insertSelective(FaqInfo faqInfo) throws CarException {
		
		boolean bool = true;
		try{

			faqInfoDAO.insertSelective(faqInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public FaqInfo selectByPrimaryKey(FaqInfo faqInfo) {
		
		return faqInfoDAO.selectByPrimaryKey(faqInfo);
	}

	@Override
	public int countByExample(FaqInfo faqInfo) {
		
		return faqInfoDAO.countByExample(faqInfo);
	}

	@Override
	public List<FaqInfo> selectByExample(FaqInfo faqInfo) {
		
		return faqInfoDAO.selectByExample(faqInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(FaqInfo faqInfo) throws CarException {
		
		try{
			return faqInfoDAO.updateByPrimaryKeySelective(faqInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新常见问题数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(FaqInfo faqInfo) throws CarException {
		
		try{

			return faqInfoDAO.deleteByExample(faqInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除常见问题异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(FaqInfo faqInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = faqInfoDAO.countByExample(faqInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<FaqInfo> list = faqInfoDAO.getPageList(faqInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
