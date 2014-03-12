package com.car.dao;

import java.util.List;

import com.car.domain.FaqInfo;

/**
 * 常见问题dao接口
 * @Title: IFaqInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IFaqInfoDAO {
	
	/**
	 * 保存数据
	 * @param faqInfo
	 */
	void insertSelective(FaqInfo faqInfo);
	
	/**
	 * 主键单条查询
	 * @param faqInfo
	 * @return
	 */
	FaqInfo selectByPrimaryKey(FaqInfo faqInfo);
	
	/**
	 * 数量查询
	 * @param faqInfo
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
	List<FaqInfo> getPageList(FaqInfo faqInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param faqInfo
	 */
	int updateByPrimaryKeySelective(FaqInfo faqInfo);
	
	/**
	 * 条件删除
	 * @param faqInfo
	 */
	int deleteByExample(FaqInfo faqInfo);
	
}
