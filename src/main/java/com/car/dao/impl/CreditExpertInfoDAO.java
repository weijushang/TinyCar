package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.ICreditExpertInfoDAO;
import com.car.domain.CreditExpertInfo;
import com.car.utils.DateUtil;

/**
 * 贷款专家dao实现类
 * @Title: CreditExpertInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class CreditExpertInfoDAO extends BaseDAO implements ICreditExpertInfoDAO {

	private final String namespace = CreditExpertInfo.class.getName();

	@Override
	public void insertSelective(CreditExpertInfo creditExpertInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		creditExpertInfo.setCreate_time(date);
		creditExpertInfo.setUpdate_time(date);
		insertSelective(namespace, creditExpertInfo);
	}

	@Override
	public CreditExpertInfo selectByPrimaryKey(CreditExpertInfo creditExpertInfo) {
		
		return (CreditExpertInfo) selectByPrimaryKey(namespace, creditExpertInfo);
	}

	@Override
	public int countByExample(CreditExpertInfo creditExpertInfo) {
		
		return countByExample(namespace, creditExpertInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditExpertInfo> selectByExample(CreditExpertInfo creditExpertInfo) {
		
		return selectByExample(namespace, creditExpertInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(CreditExpertInfo creditExpertInfo) {
		
		creditExpertInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, creditExpertInfo);
	}

	@Override
	public int deleteByExample(CreditExpertInfo creditExpertInfo) {
		
		return deleteByExample(namespace, creditExpertInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditExpertInfo> getPageList(CreditExpertInfo creditExpertInfo, int pageNum, int pageSize) {
		
		return getPageList(creditExpertInfo, namespace, pageNum, pageSize);
	}

}
