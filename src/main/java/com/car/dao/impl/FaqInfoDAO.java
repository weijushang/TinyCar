package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IFaqInfoDAO;
import com.car.domain.FaqInfo;
import com.car.utils.DateUtil;

/**
 * 常见问题dao实现类
 * @Title: FaqInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class FaqInfoDAO extends BaseDAO implements IFaqInfoDAO {

	private final String namespace = FaqInfo.class.getName();

	@Override
	public void insertSelective(FaqInfo faqInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		faqInfo.setCreate_time(date);
		faqInfo.setUpdate_time(date);
		insertSelective(namespace, faqInfo);
	}

	@Override
	public FaqInfo selectByPrimaryKey(FaqInfo faqInfo) {
		
		return (FaqInfo) selectByPrimaryKey(namespace, faqInfo);
	}

	@Override
	public int countByExample(FaqInfo faqInfo) {
		
		return countByExample(namespace, faqInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FaqInfo> selectByExample(FaqInfo faqInfo) {
		
		return selectByExample(namespace, faqInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(FaqInfo faqInfo) {
		
		faqInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, faqInfo);
	}

	@Override
	public int deleteByExample(FaqInfo faqInfo) {
		
		return deleteByExample(namespace, faqInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FaqInfo> getPageList(FaqInfo faqInfo, int pageNum, int pageSize) {
		
		return getPageList(faqInfo, namespace, pageNum, pageSize);
	}

}
