package com.car.service;

import java.util.List;
import java.util.Map;

import com.car.domain.ProductInfo;
import com.car.utils.CarException;

/**
 * 产品列表sevice接口
 * @Title: IProductInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:24:06
 * @Description: 
 */
public interface IProductInfoService {
	
	/**
	 * 保存数据
	 * @param productInfo
	 */
	boolean insertSelective(ProductInfo productInfo) throws CarException;
	
	/**
	 * 主键单条查询
	 * @param productInfo
	 * @return
	 */
	ProductInfo selectByPrimaryKey(ProductInfo productInfo);
	
	/**
	 * 数量查询
	 * @param productLogin
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
	@SuppressWarnings("rawtypes")
	Map getPageList(ProductInfo productInfo, int pageNum, int pageSize);
	
	/**
	 * 通过主键更新
	 * @param productInfo
	 */
	boolean updateByPrimaryKeySelective(ProductInfo productInfo) throws CarException;
	
	/**
	 * 条件删除
	 * @param productInfo
	 */
	boolean deleteByExample(ProductInfo productInfo) throws CarException;
	
}
