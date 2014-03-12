package com.car.credit.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.base.BaseController;
import com.car.base.Page;
import com.car.domain.CreditExpertInfo;
import com.car.service.ICreditExpertInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 贷款专家
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class CreditExpertController extends BaseController{

	
	private static Log log = LogFactory.getLog(CreditExpertController.class);
	
	@Autowired
	private ICreditExpertInfoService creditExpertInfoService;
	
	/**
	 * 贷款专家列表
	 * @param creditExpertInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/credit/list.htm")
	public String list(CreditExpertInfo creditExpertInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入贷款专家列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = creditExpertInfoService.getPageList(creditExpertInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<CreditExpertInfo> list = null;
		if(count > 0){
			list = (List<CreditExpertInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<CreditExpertInfo>();
		}
		request.setAttribute("creditExpertInfo", creditExpertInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		return "/credit/credit_list";
	}
	
	/**
	 * 删除贷款专家
	 * @param expert_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/credit/creditdel.htm")
	public void creditExpertDel(@RequestParam("expert_id") BigDecimal expert_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入贷款专家删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(expert_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				CreditExpertInfo creditExpertInfo = new CreditExpertInfo();
				creditExpertInfo.setExpert_id(expert_id);
				bool = creditExpertInfoService.deleteByExample(creditExpertInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除贷款专家异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改贷款专家页面
	 * @param creditExpert_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/credit/creditinfo.htm")
	public String creditExpertinfo(BigDecimal expert_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(expert_id == null){
				log.info("进入新增贷款专家页面");
				request.getSession().removeAttribute("creditExpertInfo");
			}else{
				log.info("进入贷款专家修改页面");
				CreditExpertInfo creditExpertInfo = new CreditExpertInfo();
				creditExpertInfo.setExpert_id(expert_id);
				creditExpertInfo = creditExpertInfoService.selectByPrimaryKey(creditExpertInfo);
				request.getSession().setAttribute("creditExpertInfo", creditExpertInfo);
			}
		}
		return "/credit/credit_modify";
	}
	
	/**
	 * 贷款专家保存
	 * @param creditExpertInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/credit/creditsave.htm")
	public void creditExpertSave(CreditExpertInfo creditExpertInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		if(creditExpertInfo!=null && creditExpertInfo.getExpert_id()!=null){//修改
			modify(creditExpertInfo, request, response);
		}else{//否则新增贷款专家
			add(creditExpertInfo, request, response);
		}
	}
	
	/**
	 * 修改贷款专家
	 * @param creditExpertInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(CreditExpertInfo creditExpertInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入贷款专家修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = creditExpertInfoService.updateByPrimaryKeySelective(creditExpertInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改贷款专家异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * 贷款专家新增
	 * @param creditExpertInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(CreditExpertInfo creditExpertInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入贷款专家新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			creditExpertInfo.setExpert_id(new BigDecimal(Constant.HEADER_ID_PRODUCT_EXPERT+System.currentTimeMillis()));
			creditExpertInfo.setExpert_state(Constant.STATE_PRODUCT_EXPERT_00);
			bool = creditExpertInfoService.insertSelective(creditExpertInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增贷款专家异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
}
