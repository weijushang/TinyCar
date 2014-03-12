package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.FaqInfo;
import com.car.utils.CarException;

/**
 * 常见问题sevice接口
 * @Title: IFaqInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IFaqInfoService {
	
	/**
	 * 保存数据
	 * @param faqInfo
	 */
	boolean insertSelective(FaqInfo faqInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param faqInfo
	 * @return
	 */
	FaqInfo selectByPrimaryKey(FaqInfo faqInfo);
	
	/**
	 * 数量查询
	 * @param faqLogin
	 * @return
	 */
	int countByExample(FaqInfo faqInfo);
	
	/**
	 * 列表查询
	 * @param faqInfo
	 * @return
	 */
	List<FaqInfo> selectByExample(FaqInfo faqInfo);
	
	/**
	 * 返回分页数据
	 * @param faqInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getPageList(FaqInfo faqInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param faqInfo
	 */
	boolean updateByPrimaryKeySelective(FaqInfo faqInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param faqInfo
	 */
	boolean deleteByExample(FaqInfo faqInfo) throws CarException;
	
}
