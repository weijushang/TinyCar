package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.CreditExpertInfo;
import com.car.utils.CarException;

/**
 * 贷款专家sevice接口
 * @Title: ICreditExpertInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface ICreditExpertInfoService {
	
	/**
	 * 保存数据
	 * @param creditExpertInfo
	 */
	boolean insertSelective(CreditExpertInfo creditExpertInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param creditExpertInfo
	 * @return
	 */
	CreditExpertInfo selectByPrimaryKey(CreditExpertInfo creditExpertInfo);
	
	/**
	 * 数量查询
	 * @param faqLogin
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
	@SuppressWarnings("rawtypes")
	Map getPageList(CreditExpertInfo creditExpertInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param creditExpertInfo
	 */
	boolean updateByPrimaryKeySelective(CreditExpertInfo creditExpertInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param creditExpertInfo
	 */
	boolean deleteByExample(CreditExpertInfo creditExpertInfo) throws CarException;
	
}
