package com.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.ITypeInfoDAO;
import com.car.domain.TypeInfo;
import com.car.service.ITypeInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 类别service实现类
 * @Title: TypeInfoService.java
 * @author wangyh
 * @date 2014-3-11 下午7:54:49
 * @Description: 
 */
public class TypeInfoService implements ITypeInfoService {

	private static Log log = LogFactory.getLog(TypeInfoService.class);

	@Autowired
	private ITypeInfoDAO typeInfoDAO;
	
	@Override
	public boolean insertSelective(TypeInfo typeInfo) throws CarException {
		
		boolean bool = true;
		try{

			typeInfoDAO.insertSelective(typeInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public TypeInfo selectByPrimaryKey(TypeInfo typeInfo) {
		
		return typeInfoDAO.selectByPrimaryKey(typeInfo);
	}

	@Override
	public int countByExample(TypeInfo typeInfo) {
		
		return typeInfoDAO.countByExample(typeInfo);
	}

	@Override
	public List<TypeInfo> selectByExample(TypeInfo typeInfo) {
		
		return typeInfoDAO.selectByExample(typeInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(TypeInfo typeInfo) throws CarException {
		
		try{
			return typeInfoDAO.updateByPrimaryKeySelective(typeInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新类别数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(TypeInfo typeInfo) throws CarException {
		
		try{

			return typeInfoDAO.deleteByExample(typeInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除类别异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(TypeInfo typeInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = typeInfoDAO.countByExample(typeInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<TypeInfo> list = typeInfoDAO.getPageList(typeInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
