package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.TypeInfo;
import com.car.utils.CarException;

/**
 * 类别sevice接口
 * @Title: ITypeInfoService.java
 * @author wangyh
 * @date 2014-3-11 下午7:54:06
 * @Description: 
 */
public interface ITypeInfoService {
	
	/**
	 * 保存数据
	 * @param typeInfo
	 */
	boolean insertSelective(TypeInfo typeInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param typeInfo
	 * @return
	 */
	TypeInfo selectByPrimaryKey(TypeInfo typeInfo);
	
	/**
	 * 数量查询
	 * @param typeLogin
	 * @return
	 */
	int countByExample(TypeInfo typeInfo);
	
	/**
	 * 列表查询
	 * @param typeInfo
	 * @return
	 */
	List<TypeInfo> selectByExample(TypeInfo typeInfo);
	
	/**
	 * 返回分页数据
	 * @param typeInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getPageList(TypeInfo typeInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param typeInfo
	 */
	boolean updateByPrimaryKeySelective(TypeInfo typeInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param typeInfo
	 */
	boolean deleteByExample(TypeInfo typeInfo) throws CarException;
	
}
