package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.IFavorExpertInfoDAO;
import com.car.domain.FavorExpertInfo;
import com.car.service.IFavorExpertInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 优惠专家service实现类
 * @Title: FavorExpertInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class FavorExpertInfoService implements IFavorExpertInfoService {

	private static Log log = LogFactory.getLog(FavorExpertInfoService.class);

	@Autowired
	private IFavorExpertInfoDAO favorExpertInfoDAO;
	
	@Override
	public boolean insertSelective(FavorExpertInfo favorExpertInfo) throws CarException {
		
		boolean bool = true;
		try{

			favorExpertInfoDAO.insertSelective(favorExpertInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public FavorExpertInfo selectByPrimaryKey(FavorExpertInfo favorExpertInfo) {
		
		return favorExpertInfoDAO.selectByPrimaryKey(favorExpertInfo);
	}

	@Override
	public int countByExample(FavorExpertInfo favorExpertInfo) {
		
		return favorExpertInfoDAO.countByExample(favorExpertInfo);
	}

	@Override
	public List<FavorExpertInfo> selectByExample(FavorExpertInfo favorExpertInfo) {
		
		return favorExpertInfoDAO.selectByExample(favorExpertInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(FavorExpertInfo favorExpertInfo) throws CarException {
		
		try{
			return favorExpertInfoDAO.updateByPrimaryKeySelective(favorExpertInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新常见问题数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(FavorExpertInfo favorExpertInfo) throws CarException {
		
		try{

			return favorExpertInfoDAO.deleteByExample(favorExpertInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除常见问题异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(FavorExpertInfo favorExpertInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = favorExpertInfoDAO.countByExample(favorExpertInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<FavorExpertInfo> list = favorExpertInfoDAO.getPageList(favorExpertInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
