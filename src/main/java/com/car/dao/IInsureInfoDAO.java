package com.car.dao;

import java.util.List;

import com.car.domain.InsureInfo;

/**
 * 保险dao接口
 * @Title: IInsureInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IInsureInfoDAO {
	
	/**
	 * 保存数据
	 * @param insureInfo
	 */
	void insertSelective(InsureInfo insureInfo);
	
	/**
	 * 主键单条查询
	 * @param insureInfo
	 * @return
	 */
	InsureInfo selectByPrimaryKey(InsureInfo insureInfo);
	
	/**
	 * 数量查询
	 * @param insureInfo
	 * @return
	 */
	int countByExample(InsureInfo insureInfo);
	
	/**
	 * 列表查询
	 * @param insureInfo
	 * @return
	 */
	List<InsureInfo> selectByExample(InsureInfo insureInfo);
	
	/**
	 * 返回分页数据
	 * @param insureInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<InsureInfo> getPageList(InsureInfo insureInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param insureInfo
	 */
	int updateByPrimaryKeySelective(InsureInfo insureInfo);
	
	/**
	 * 条件删除
	 * @param insureInfo
	 */
	int deleteByExample(InsureInfo insureInfo);
	
}
