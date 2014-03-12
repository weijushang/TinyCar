package com.car.settle.controller;

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

import com.car.base.BaseController;
import com.car.base.Page;
import com.car.domain.SettleInfo;
import com.car.service.ISettleInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 结清预约
 * @Title: SettleController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class SettleController extends BaseController{

	
	private static Log log = LogFactory.getLog(SettleController.class);
	
	@Autowired
	private ISettleInfoService settleInfoService;
	
	/**
	 * 结清预约首页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/settle.htm")
	public String settle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入结清预约首页");
		
		return "/settle/settle";
	}
	
	/**
	 * 结清预约
	 * @param settleInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/car/settle_save.htm")
	public void settle_save(SettleInfo settleInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入结清预约");
		boolean bool = true;
		String message = "预约成功";
		try {
			if(StringUtils.isBlank(settleInfo.getSettle_name())||StringUtils.isBlank(settleInfo.getSettle_phone())){
				throw new CarException("10001", "参数不能为空");
			}
			settleInfo.setSettle_state(Constant.STATE_SETTLE_00);//未处理状态
			settleInfo.setSettle_id(new BigDecimal(Constant.HEADER_ID_SETTLE+System.currentTimeMillis()));
			bool = settleInfoService.insertSelective(settleInfo);
			if(!bool){
				message = "预约失败";	
			}
		} catch (CarException e) {
			log.error("在线结清预约数据保存异常", e);	
			bool = false;
			message = e.getErrMsg();
		} catch (Exception e) {
			log.error("在线结清预约数据保存异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 结清预约列表
	 * @param settleInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/settle/list.htm")
	public String list(SettleInfo settleInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入结清预约列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = settleInfoService.getPageList(settleInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<SettleInfo> list = null;
		if(count > 0){
			list = (List<SettleInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<SettleInfo>();
		}
		request.setAttribute("settleInfo", settleInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		return "/settle/settle_list";
	}
	
	/**
	 * 删除结清预约
	 * @param settle_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/settle/settledel.htm")
	public void settleDel(@RequestParam("settle_id") BigDecimal settle_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入结清预约删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(settle_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				SettleInfo settleInfo = new SettleInfo();
				settleInfo.setSettle_id(settle_id);
				bool = settleInfoService.deleteByExample(settleInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除结清预约异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改结清预约页面
	 * @param settleExpert_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/settle/settleinfo.htm")
	public String settleinfo(BigDecimal settle_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(settle_id == null){
				log.info("进入新增结清预约页面");
				request.getSession().removeAttribute("settleInfo");
			}else{
				log.info("进入结清预约修改页面");
				SettleInfo settleInfo = new SettleInfo();
				settleInfo.setSettle_id(settle_id);
				settleInfo = settleInfoService.selectByPrimaryKey(settleInfo);
				request.getSession().setAttribute("settleInfo", settleInfo);
			}
		}
		return "/settle/settle_modify";
	}
	
	/**
	 * 结清预约保存
	 * @param settleInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/settle/settlesave.htm")
	public void settleSave(SettleInfo settleInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		if(settleInfo!=null && settleInfo.getSettle_id()!=null){//修改
			modify(settleInfo, request, response);
		}else{//否则新增结清预约
			add(settleInfo, request, response);
		}
	}
	
	/**
	 * 修改结清预约
	 * @param settleInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(SettleInfo settleInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入结清预约修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = settleInfoService.updateByPrimaryKeySelective(settleInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改结清预约异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * 结清预约新增
	 * @param settleInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(SettleInfo settleInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入结清预约新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			settleInfo.setSettle_id(new BigDecimal(Constant.HEADER_ID_SETTLE+System.currentTimeMillis()));
			settleInfo.setSettle_state(Constant.STATE_SETTLE_00);
			bool = settleInfoService.insertSelective(settleInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增结清预约异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
}
