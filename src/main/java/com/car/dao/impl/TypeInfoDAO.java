package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.ITypeInfoDAO;
import com.car.domain.TypeInfo;
import com.car.utils.DateUtil;

/**
 * 类别dao实现类
 * @Title: TypeInfoDAO.java
 * @author wangyh
 * @date 2014-3-11 下午7:53:12
 * @Description: 
 */
public class TypeInfoDAO extends BaseDAO implements ITypeInfoDAO {

	private final String namespace = TypeInfo.class.getName();

	@Override
	public void insertSelective(TypeInfo typeInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		typeInfo.setCreate_time(date);
		typeInfo.setUpdate_time(date);
		insertSelective(namespace, typeInfo);
	}

	@Override
	public TypeInfo selectByPrimaryKey(TypeInfo typeInfo) {
		
		return (TypeInfo) selectByPrimaryKey(namespace, typeInfo);
	}

	@Override
	public int countByExample(TypeInfo typeInfo) {
		
		return countByExample(namespace, typeInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeInfo> selectByExample(TypeInfo typeInfo) {
		
		return selectByExample(namespace, typeInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(TypeInfo typeInfo) {
		
		typeInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, typeInfo);
	}

	@Override
	public int deleteByExample(TypeInfo typeInfo) {
		
		return deleteByExample(namespace, typeInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeInfo> getPageList(TypeInfo typeInfo, int pageNum, int pageSize) {
		
		return getPageList(typeInfo, namespace, pageNum, pageSize);
	}

}
