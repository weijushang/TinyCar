package com.car.dao;

import java.util.List;

import com.car.domain.CreditExpertInfo;

/**
 * 贷款专家dao接口
 * @Title: ICreditExpertInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface ICreditExpertInfoDAO {
	
	/**
	 * 保存数据
	 * @param creditExpertInfo
	 */
	void insertSelective(CreditExpertInfo creditExpertInfo);
	
	/**
	 * 主键单条查询
	 * @param creditExpertInfo
	 * @return
	 */
	CreditExpertInfo selectByPrimaryKey(CreditExpertInfo creditExpertInfo);
	
	/**
	 * 数量查询
	 * @param creditExpertInfo
	 * @return
	 */
	int countByExample(CreditExpertInfo creditExpertInfo);
	
	/**
	 * 列表查询
	 * @param creditExpertInfo
	 * @return
	 */
	List<CreditExpertInfo> selectByExample(CreditExpertInfo creditExpertInfo);
	
	/**
	 * 返回分页数据
	 * @param creditExpertInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<CreditExpertInfo> getPageList(CreditExpertInfo creditExpertInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param creditExpertInfo
	 */
	int updateByPrimaryKeySelective(CreditExpertInfo creditExpertInfo);
	
	/**
	 * 条件删除
	 * @param creditExpertInfo
	 */
	int deleteByExample(CreditExpertInfo creditExpertInfo);
	
}
