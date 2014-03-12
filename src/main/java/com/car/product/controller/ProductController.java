package com.car.product.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.car.base.BaseController;
import com.car.base.Page;
import com.car.domain.CreditExpertInfo;
import com.car.domain.FileInfo;
import com.car.domain.ProductInfo;
import com.car.service.ICreditExpertInfoService;
import com.car.service.IFileInfoService;
import com.car.service.IProductInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 产品服务
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class ProductController extends BaseController{

	
	private static Log log = LogFactory.getLog(ProductController.class);

	@Autowired
	private IProductInfoService productInfoService;
	@Autowired
	private IFileInfoService fileInfoService;
	@Autowired
	private ICreditExpertInfoService creditExpertInfoService;
	/**
	 * 产品服务首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/product.htm")
	public String product(Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入产品服务首页");
		//获取产品列表
		getList(null, pageNum, pageSize, request, response);
		//获取产品广告图片
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFile_type(Constant.FILE_TYPE_PRODUCT_AD);
		List<FileInfo> product_images = fileInfoService.selectByExample(fileInfo);
		request.getSession().setAttribute("product_images", product_images);
		return "/product/product";
	}
	
	/**
	 * 产品详情
	 * @param product_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/product_detail.htm")
	public String product_detail(@RequestParam("product_id") BigDecimal product_id,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入产品详情");
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProduct_id(product_id);
		productInfo = productInfoService.selectByPrimaryKey(productInfo);
		request.getSession().setAttribute("productInfo", productInfo);
		return "/product/product_detail";
	}
	

	/**
	 * 优惠专家－我要转介绍
	 * @param favorable_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/credit_expert.htm")
	public String favorable_expert(@RequestParam("product_id") BigDecimal product_id,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入优惠专家－我要转介绍");
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProduct_id(product_id);
		productInfo = productInfoService.selectByPrimaryKey(productInfo);
		request.getSession().setAttribute("productInfo", productInfo);
		return "/product/product_expert";
	}
	
	/**
	 * 贷款专家－保险预约
	 * @param favorExpertInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/car/credit_expert_save.htm")
	public void credit_expert_save(CreditExpertInfo creditExpertInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入贷款专家－保险预约");
		boolean bool = true;
		String message = "预约成功";
		try {

			if(StringUtils.isBlank(creditExpertInfo.getCust_name())||StringUtils.isBlank(creditExpertInfo.getCust_phone())||
					StringUtils.isBlank(creditExpertInfo.getCar_price())){
				throw new CarException("10001", "参数不能为空");
			}
			creditExpertInfo.setExpert_state(Constant.STATE_PRODUCT_EXPERT_00);
			creditExpertInfo.setExpert_id(new BigDecimal(Constant.HEADER_ID_PRODUCT_EXPERT+System.currentTimeMillis()));
			bool = creditExpertInfoService.insertSelective(creditExpertInfo);
			if(!bool){
				message = "预约失败";	
			}
		} catch (CarException e) {
			log.error("贷款专家－预约", e);	
			bool = false;
			message = e.getErrMsg();
		} catch (Exception e) {
			log.error("贷款专家－预约异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 产品列表
	 * @param productInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/product/list.htm")
	public String list(ProductInfo productInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入产品列表");
		getList(productInfo, pageNum, pageSize, request, response);
		return "/product/product_list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void getList(ProductInfo productInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response){
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = productInfoService.getPageList(productInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<ProductInfo> list = null;
		if(count > 0){
			list = (List<ProductInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<ProductInfo>();
		}
		request.setAttribute("productInfo", productInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
	}
	
	/**
	 * 删除产品信息
	 * @param product
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/product/productdel.htm")
	public void productDel(@RequestParam("product_id") BigDecimal product_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入产品信息删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(product_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				bool = productInfoService.deleteByExample(productInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除产品异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改product产品页面
	 * @param product_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/product/productinfo.htm")
	public String productinfo(BigDecimal product_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(product_id == null){
				log.info("进入新增product产品页面");
				request.getSession().removeAttribute("productInfo");
			}else{
				log.info("进入product产品修改页面");
				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct_id(product_id);
				productInfo = productInfoService.selectByPrimaryKey(productInfo);
				if(productInfo!=null && productInfo.getProduct_detail()!=null){
					productInfo.setProduct_detail_str(new String(productInfo.getProduct_detail(), "UTF-8"));
				}
				request.getSession().setAttribute("productInfo", productInfo);
				FileInfo fileInfo = new FileInfo();
				fileInfo.setParent_id(product_id);//父id
				fileInfo.setFile_type(Constant.FILE_TYPE_PRODUCT);//类型
				List<FileInfo> files = fileInfoService.selectByExample(fileInfo);
				if(files!=null && files.size() > 0){
					productInfo.setFileInfo(files.iterator().next());
				}
			}
		}
		return "/product/product_modify";
	}
	
	/**
	 * product产品保存
	 * @param productInfo
	 * @param image_file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/product/productsave.htm")
	public String productSave(ProductInfo productInfo, MultipartFile image_file, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		String err_msg = null;
		productInfo.setImage_file(image_file);//将文件重新设置
		String product_detail_str = productInfo.getProduct_detail_str();
		if(product_detail_str!=null && !"".equals(product_detail_str)){
			productInfo.setProduct_detail(product_detail_str.getBytes());
		}
		if(productInfo!=null && productInfo.getProduct_id()!=null){//修改
			String msg = modify(productInfo, request, response);
			err_msg = msg==null?"修改成功":msg;
		}else{//否则新增favorable保险
			String msg = add(productInfo, request, response);
			err_msg = msg==null?"新增成功":msg;
		}
		request.setAttribute("err_msg", err_msg);
		return "/product/product_modify";
	}
	
	/**
	 * 修改product产品信息
	 * @param productInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private String modify(ProductInfo productInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入product产品修改");
		String message = null;
		try {
			boolean bool = productInfoService.updateByPrimaryKeySelective(productInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改product产品信息异常", e);	
			message = e.getErrMsg();
		} 
		return message;
	}
	/**
	 * product产品新增
	 * @param productInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private String add(ProductInfo productInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入product产品新增");
		String message = "新增成功";
		try {
			productInfo.setProduct_id(new BigDecimal(Constant.HEADER_ID_PRODUCT+System.currentTimeMillis()));
			boolean bool = productInfoService.insertSelective(productInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增product产品信息异常", e);	
			message = e.getErrMsg();
		} 
		return message;
	}
}
