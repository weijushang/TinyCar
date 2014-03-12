package com.car.dao;

import java.util.List;

import com.car.domain.ProductInfo;

/**
 * 产品dao接口
 * @Title: IProductInfoDAO.java
 * @author wangyh
 * @date 2014-2-24 上午11:22:24
 * @Description: 
 */
public interface IProductInfoDAO {
	
	/**
	 * 保存数据
	 * @param productInfo
	 */
	void insertSelective(ProductInfo productInfo);
	
	/**
	 * 主键单条查询
	 * @param productInfo
	 * @return
	 */
	ProductInfo selectByPrimaryKey(ProductInfo productInfo);
	
	/**
	 * 数量查询
	 * @param productInfo
	 * @return
	 */
	int countByExample(ProductInfo productInfo);
	
	/**
	 * 列表查询
	 * @param productInfo
	 * @return
	 */
	List<ProductInfo> selectByExample(ProductInfo productInfo);
	
	/**
	 * 返回分页数据
	 * @param productInfo 条件查询
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * @return
	 */
	List<ProductInfo> getPageList(ProductInfo productInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param productInfo
	 */
	int updateByPrimaryKeySelective(ProductInfo productInfo);
	
	/**
	 * 条件删除
	 * @param productInfo
	 */
	int deleteByExample(ProductInfo productInfo);
	
}
