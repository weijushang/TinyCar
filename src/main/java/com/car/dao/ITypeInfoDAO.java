package com.car.dao;

import java.util.List;

import com.car.domain.TypeInfo;

/**
 * 类别dao接口
 * @Title: ITypeInfoDAO.java
 * @author wangyh
 * @date 2014-3-11 下午7:52:23
 * @Description: 
 */
public interface ITypeInfoDAO {
	
	/**
	 * 保存数据
	 * @param typeInfo
	 */
	void insertSelective(TypeInfo typeInfo);
	
	/**
	 * 主键单条查询
	 * @param typeInfo
	 * @return
	 */
	TypeInfo selectByPrimaryKey(TypeInfo typeInfo);
	
	/**
	 * 数量查询
	 * @param typeInfo
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
	List<TypeInfo> getPageList(TypeInfo typeInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param typeInfo
	 */
	int updateByPrimaryKeySelective(TypeInfo typeInfo);
	
	/**
	 * 条件删除
	 * @param typeInfo
	 */
	int deleteByExample(TypeInfo typeInfo);
	
}
