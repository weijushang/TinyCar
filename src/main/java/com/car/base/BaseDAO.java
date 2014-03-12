package com.car.base;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 基础dao类-公共方法
 * @author wangyh
 *
 */
public class BaseDAO extends SqlMapClientDaoSupport {
	
	/**
	 * 数据保存
	 * @param namespace
	 * @param object
	 */
	public void insertSelective(String namespace, Object object) {
		
		getSqlMapClientTemplate().insert(namespace+".insertSelective", object);
	}

	/**
	 * 根据主键查询
	 * @param namespace
	 * @param object
	 * @return
	 */
	public Object selectByPrimaryKey(String namespace, Object object) {
		
		return getSqlMapClientTemplate().queryForObject(namespace+".selectByPrimaryKey", object);
	}

	/**
	 * 数量查询
	 * @param namespace
	 * @param object
	 * @return
	 */
	public int countByExample(String namespace, Object object) {
		
		return (Integer) getSqlMapClientTemplate().queryForObject(namespace+".countByExample", object);
	}
	
	/**
	 * 列表查询
	 * @param namespace
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List selectByExample(String namespace, Object object) {
		
		return getSqlMapClientTemplate().queryForList(namespace+".selectByExample", object);
	}

	/**
	 * 根据主键更新
	 * @param namespace
	 * @param object
	 * @return
	 */
	public int updateByPrimaryKeySelective(String namespace, Object object) {
		
		return getSqlMapClientTemplate().update(namespace+".updateByPrimaryKeySelective", object);
	}

	/**
	 * 删除方法
	 * @param namespace
	 * @param object
	 * @return
	 */
	public int deleteByExample(String namespace, Object object) {
		
		return (Integer) getSqlMapClientTemplate().delete(namespace+".deleteByExample", object);
	}
	
	/**
	 * 分页查询
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getPageList(Object object, String namespace, int pageNo, int pageSize) {
		return getSqlMapClientTemplate().queryForList(namespace+".selectByExample", object, pageNo, pageSize);
	}
}
