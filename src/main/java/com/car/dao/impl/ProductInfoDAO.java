package com.car.dao.impl;

import java.util.List;

import com.car.base.BaseDAO;
import com.car.dao.IProductInfoDAO;
import com.car.domain.ProductInfo;
import com.car.utils.DateUtil;

/**
 * 产品信息dao实现类
 * @Title: ProductInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:36
 * @Description: 
 */
public class ProductInfoDAO extends BaseDAO implements IProductInfoDAO {

	private final String namespace = ProductInfo.class.getName();

	@Override
	public void insertSelective(ProductInfo productInfo) {
		
		String date = DateUtil.getCurrentDateTime();
		productInfo.setCreate_time(date);
		productInfo.setUpdate_time(date);
		insertSelective(namespace, productInfo);
	}

	@Override
	public ProductInfo selectByPrimaryKey(ProductInfo productInfo) {
		
		return (ProductInfo) selectByPrimaryKey(namespace, productInfo);
	}

	@Override
	public int countByExample(ProductInfo productInfo) {
		
		return countByExample(namespace, productInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductInfo> selectByExample(ProductInfo productInfo) {
		
		return selectByExample(namespace, productInfo);
	}

	@Override
	public int updateByPrimaryKeySelective(ProductInfo productInfo) {
		
		productInfo.setUpdate_time(DateUtil.getCurrentDateTime());
		return updateByPrimaryKeySelective(namespace, productInfo);
	}

	@Override
	public int deleteByExample(ProductInfo productInfo) {
		
		return deleteByExample(namespace, productInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductInfo> getPageList(ProductInfo productInfo, int pageNum, int pageSize) {
		
		return getPageList(productInfo, namespace, pageNum, pageSize);
	}

}
