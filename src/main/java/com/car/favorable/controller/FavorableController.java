package com.car.favorable.controller;

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
import com.car.domain.CarType;
import com.car.domain.FavorExpertInfo;
import com.car.domain.FavorableInfo;
import com.car.domain.FileInfo;
import com.car.service.ICarTypeService;
import com.car.service.IFavorExpertInfoService;
import com.car.service.IFavorableInfoService;
import com.car.service.IFileInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 优惠列表
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class FavorableController extends BaseController{

	
	private static Log log = LogFactory.getLog(FavorableController.class);

	@Autowired
	private IFavorableInfoService favorableInfoService;
	@Autowired
	private IFavorExpertInfoService favorExpertInfoService;
	@Autowired
	private IFileInfoService fileInfoService;
	@Autowired
	private ICarTypeService carTypeService;
	/**
	 * 优惠列表首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/favorable.htm")
	public String favorable(Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入优惠列表首页");
		//获取优惠广告图片
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFile_type(Constant.FILE_TYPE_FAVORABLE_AD);
		List<FileInfo> favorable_images = fileInfoService.selectByExample(fileInfo);
		request.getSession().setAttribute("favorable_images", favorable_images);
		//优惠列表
		getList(null, pageNum, pageSize, request, response);
		return "/favorable/favorable";
	}
	
	/**
	 * 优惠详情
	 * @param favorable_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/favorable_detail.htm")
	public String favorable_detail(@RequestParam("favorable_id") BigDecimal favorable_id,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入优惠详情");
		FavorableInfo favorableInfo = new FavorableInfo();
		favorableInfo.setFavor_id(favorable_id);
		favorableInfo = favorableInfoService.selectByPrimaryKey(favorableInfo);
		if(favorableInfo.getFavor_detail()!=null){
			favorableInfo.setFavor_detail_str(new String(favorableInfo.getFavor_detail(), "UTF-8"));
		}
		request.getSession().setAttribute("favorableInfo", favorableInfo);
		return "/favorable/favorable_detail";
	}
	
	/**
	 * 优惠专家－我要转介绍
	 * @param favorable_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/favorable_expert.htm")
	public String favorable_expert(@RequestParam("favorable_id") BigDecimal favorable_id,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入优惠专家－我要转介绍");
		FavorableInfo favorableInfo = new FavorableInfo();
		favorableInfo.setFavor_id(favorable_id);
		favorableInfo = favorableInfoService.selectByPrimaryKey(favorableInfo);
		request.getSession().setAttribute("favorableInfo", favorableInfo);
		return "/favorable/favorable_expert";
	}
	
	/**
	 * 优惠专家－我要转介绍数据保存
	 * @param favorExpertInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/car/favorable_expert_save.htm")
	public void favorable_expert_save(FavorExpertInfo favorExpertInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入优惠专家－我要转介绍数据保存");
		boolean bool = true;
		String message = "介绍成功";
		try {
			if(StringUtils.isBlank(favorExpertInfo.getCust_name())||StringUtils.isBlank(favorExpertInfo.getCust_phone())||
					StringUtils.isBlank(favorExpertInfo.getPresentee_name())||StringUtils.isBlank(favorExpertInfo.getPresentee_phone())){
				throw new CarException("10001", "参数不能为空");
			}
			favorExpertInfo.setExpert_id(new BigDecimal(Constant.HEADER_ID_FAVORABLE_EXPERT+System.currentTimeMillis()));
			bool = favorExpertInfoService.insertSelective(favorExpertInfo);
			if(!bool){
				message = "介绍失败";	
			}
		} catch (CarException e) {
			log.error("优惠专家－我要转介绍数据保存保险异常", e);	
			bool = false;
			message = e.getErrMsg();
		} catch (Exception e) {
			log.error("优惠专家－我要转介绍数据保存保险异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 保险列表
	 * @param favorableInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/favorable/list.htm")
	public String list(FavorableInfo favorableInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入保险列表");
		getList(favorableInfo, pageNum, pageSize, request, response);
		return "/favorable/favorable_list";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void getList(FavorableInfo favorableInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response){
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = favorableInfoService.getPageList(favorableInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<FavorableInfo> list = null;
		if(count > 0){
			list = (List<FavorableInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<FavorableInfo>();
		}
		request.setAttribute("favorableInfo", favorableInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
	}
	
	/**
	 * 删除保险信息
	 * @param favorable
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/favorable/favorabledel.htm")
	public void favorableDel(@RequestParam("favorable_id") BigDecimal favorable_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入保险信息删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(favorable_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				FavorableInfo favorableInfo = new FavorableInfo();
				favorableInfo.setFavor_id(favorable_id);
				bool = favorableInfoService.deleteByExample(favorableInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除保险异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改favorable保险页面
	 * @param favorable_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/favorable/favorableinfo.htm")
	public String favorableinfo(BigDecimal favorable_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(favorable_id == null){
				log.info("进入新增favorable保险页面");
				request.getSession().removeAttribute("favorableInfo");
			}else{
				log.info("进入favorable保险修改页面");
				FavorableInfo favorableInfo = new FavorableInfo();
				favorableInfo.setFavor_id(favorable_id);
				favorableInfo = favorableInfoService.selectByPrimaryKey(favorableInfo);
				if(favorableInfo!=null && favorableInfo.getFavor_detail()!=null){
					//转化为字符串
					favorableInfo.setFavor_detail_str(new String(favorableInfo.getFavor_detail(), "UTF-8"));
				}
				request.getSession().setAttribute("favorableInfo", favorableInfo);
				FileInfo fileInfo = new FileInfo();
				fileInfo.setParent_id(favorable_id);//父id
				fileInfo.setFile_type(Constant.FILE_TYPE_FAVORABLE);//类型
				List<FileInfo> files = fileInfoService.selectByExample(fileInfo);
				if(files!=null && files.size() > 0){
					favorableInfo.setFileInfo(files.iterator().next());
				}
			}
			List<CarType> carTypes = carTypeService.getCarTypeList();
			request.setAttribute("car_types", carTypes);//车型
		}
		return "/favorable/favorable_modify";
	}
	
	/**
	 * favorable保险保存
	 * @param favorableInfo
	 * @param image_file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/favorable/favorablesave.htm")
	public String favorableSave(FavorableInfo favorableInfo, MultipartFile image_file, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		String err_msg = null;
		favorableInfo.setImage_file(image_file);//将文件重新设置
		//将字符串转化为byte[]
		String favor_detail_str = favorableInfo.getFavor_detail_str();
		if(favor_detail_str!=null && !"".equals(favor_detail_str)){
			favorableInfo.setFavor_detail(favor_detail_str.getBytes());
		}
		if(favorableInfo!=null && favorableInfo.getFavor_id()!=null){//修改
			String msg = modify(favorableInfo, request, response);
			err_msg = msg==null?"修改成功":msg;
		}else{//否则新增favorable保险
			String msg = add(favorableInfo, request, response);
			err_msg = msg==null?"新增成功":msg;
		}
		request.setAttribute("err_msg", err_msg);
		//获取车型
		List<CarType> carTypes = carTypeService.getCarTypeList();
		request.setAttribute("car_types", carTypes);//车型
		return "/favorable/favorable_modify";
	}
	
	/**
	 * 修改favorable保险信息
	 * @param favorableInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private String modify(FavorableInfo favorableInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入favorable保险修改");
		String message = null;
		try {
			boolean bool = favorableInfoService.updateByPrimaryKeySelective(favorableInfo);
			if(!bool){
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改favorable保险信息异常", e);	
			message = e.getErrMsg();
		} 
		return message;
	}
	/**
	 * favorable保险新增
	 * @param favorableInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private String add(FavorableInfo favorableInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入favorable保险新增");
		String message = null;
		try {
			favorableInfo.setFavor_id(new BigDecimal(Constant.HEADER_ID_FAVORABLE+System.currentTimeMillis()));
			boolean bool = favorableInfoService.insertSelective(favorableInfo);
			if(!bool){
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增favorable保险信息异常", e);	
			message = e.getErrMsg();
		} 
		return message;
	}
}
