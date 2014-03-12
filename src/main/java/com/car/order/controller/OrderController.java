package com.car.order.controller;

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
import com.car.domain.CarType;
import com.car.domain.FavorExpertInfo;
import com.car.domain.OrderInfo;
import com.car.service.ICarTypeService;
import com.car.service.IFavorExpertInfoService;
import com.car.service.IOrderInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 在线申请
 * @Title: OrderController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:27
 * @Description: 
 */
@Controller
public class OrderController extends BaseController{

	
	private static Log log = LogFactory.getLog(OrderController.class);

	@Autowired
	private IOrderInfoService orderInfoService;
	@Autowired
	private ICarTypeService carTypeService;
	@Autowired
	private IFavorExpertInfoService favorExpertInfoService;
	
	/**
	 * 在线申请首页
	 * @param favorable_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/order.htm")
	public String order(@RequestParam("favorable_id") BigDecimal favorable_id, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入在线申请首页");
		request.setAttribute("favor_id", favorable_id);
		return "/order/order";
	}
	
	/**
	 * 
	 * @param orderInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/car/order_save.htm")
	public void order_save(OrderInfo orderInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入在线申请");
		boolean bool = true;
		String message = "申请成功";
		try {
			if(StringUtils.isBlank(orderInfo.getCust_name())||StringUtils.isBlank(orderInfo.getCust_phone())||StringUtils.isBlank(orderInfo.getCust_card())||
					StringUtils.isBlank(orderInfo.getCust_sex())||StringUtils.isBlank(orderInfo.getCar_type_name())||StringUtils.isBlank(orderInfo.getCar_price())||
					StringUtils.isBlank(orderInfo.getProvince_id())||StringUtils.isBlank(orderInfo.getCity_id())){
				throw new CarException("10001", "参数不能为空");
			}
			orderInfo.setOrder_state(Constant.STATE_ORDER_00);//未处理状态
			orderInfo.setOrder_id(new BigDecimal(Constant.HEADER_ID_PRODUCT_EXPERT+System.currentTimeMillis()));
			bool = orderInfoService.insertSelective(orderInfo);
			if(!bool){
				message = "申请失败";	
			}
		} catch (CarException e) {
			log.error("在线申请数据保存异常", e);	
			bool = false;
			message = e.getErrMsg();
		} catch (Exception e) {
			log.error("在线申请数据保存异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 获取介绍人信息
	 * @param orderInfo
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/car/introducer.htm")
	public void introducer(OrderInfo orderInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入获取介绍人信息");
		boolean bool = true;
		String message = null;
		try {
			if(orderInfo.getFavor_id() == null){
				throw new CarException("10001", "无法获取介绍人信息");
			}
			FavorExpertInfo favorExpertInfo = new FavorExpertInfo();
			favorExpertInfo.setFavor_id(orderInfo.getFavor_id());
			favorExpertInfo = favorExpertInfoService.selectByPrimaryKey(favorExpertInfo);
			if(favorExpertInfo!=null){
				bool = true;
				message = getIntroducerMsg(favorExpertInfo);
			}else{
				bool = false;
				message = "对不起，您还没有介绍人！";
			}
		} catch (CarException e) {
			log.error("获取介绍人信息异常", e);	
			bool = false;
			message = e.getErrMsg();
		} catch (Exception e) {
			log.error("获取介绍人信息异常", e);	
			bool = false;
			message = "系统异常";
		}finally{ 
			returnResult(response, bool, message);
		}
	}
	
	public String getIntroducerMsg(FavorExpertInfo favorExpertInfo){
		StringBuffer strBuff = new StringBuffer("<input type='hidden' id='expert_id' name='expert_id' value='"+favorExpertInfo.getExpert_id()+"'>");
		//推荐人姓名
//		strBuff.append("<div class='row'><div class='col-sm-12' style='padding-top:10px;padding-left:0px;padding-right:0px;'><table width='100%'><tr height='30px'>");
//		strBuff.append("<td width='120px' align='right'>推荐人姓名：</td><td><input type='text' style='width:95%;' class='form-control' id='name' name='name' value='"+favorExpertInfo.getCust_name()+"'>");
//		strBuff.append("</td></tr></table></div></div>");

		strBuff.append("<div class='row'><div class='col-sm-12' style='padding-top:10px;'>");
		strBuff.append("<input type='text' style='width:100%;' class='form-control' id='name' name='name' value='"+favorExpertInfo.getCust_name()+"'>");
		strBuff.append("</div></div>");
		//推荐人号码
		strBuff.append("<div class='row'><div class='col-sm-12' style='padding-top:10px;");
		strBuff.append("<input type='text' style='width:100%;' class='form-control' id='phone' name='phone' value='"+favorExpertInfo.getCust_phone()+"'>");
		strBuff.append("</div></div>");
		//被推荐人姓名
		strBuff.append("<div class='row'><div class='col-sm-12' style='padding-top:10px;'>");
		strBuff.append("<input type='text' style='width:100%;' class='form-control' id='presentee_name' name='presentee_name' value='"+favorExpertInfo.getPresentee_name()+"'>");
		strBuff.append("</td></tr></table></div></div>");
		//被推荐人号码
		strBuff.append("<div class='row'><div class='col-sm-12' style='padding-top:10px;'>");
		strBuff.append("<input type='text' style='width:100%;' class='form-control' id='presentee_phone' name='presentee_phone' value='"+favorExpertInfo.getPresentee_phone()+"'>");
		strBuff.append("</div></div>");
		return strBuff.toString();
	}
	
	/**
	 * 在线申请列表
	 * @param orderInfo
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/manager/order/list.htm")
	public String list(OrderInfo orderInfo, Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入在线申请列表");
		if(pageNum==null){
			pageNum = Constant.DEFAULT_PAGENUM;
		}
		if(pageSize==null){
			pageSize = Constant.DEFAULT_PAGESIZE; 
		}
		Map map = orderInfoService.getPageList(orderInfo, pageNum, pageSize);
		int count = (Integer) map.get(Constant.MAP_VALUE_COUNT);
		List<OrderInfo> list = null;
		if(count > 0){
			list = (List<OrderInfo>) map.get(Constant.MAP_VALUE_LIST);
		}else{
			list = new ArrayList<OrderInfo>();
		}
		request.setAttribute("orderInfo", orderInfo);//查询条件
		request.setAttribute("count", count);//总数
		request.setAttribute("list", list);//列表
		request.setAttribute("page", new Page(list, count, pageNum, pageSize, request.getRequestURI()));//分页控件
		return "/order/order_list";
	}
	
	/**
	 * 删除在线申请
	 * @param order
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/order/orderdel.htm")
	public void orderDel(@RequestParam("order_id") BigDecimal order_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入在线申请删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(order_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setOrder_id(order_id);
				bool = orderInfoService.deleteByExample(orderInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (CarException e) {
			log.error("删除预约异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 进入新增或者修改order预约页面
	 * @param order_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/order/orderinfo.htm")
	public String orderinfo(BigDecimal order_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(order_id == null){
				log.info("进入新增预约页面");
				request.getSession().removeAttribute("orderInfo");
			}else{
				log.info("进入预约修改页面");
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setOrder_id(order_id);
				orderInfo = orderInfoService.selectByPrimaryKey(orderInfo);
				request.getSession().setAttribute("orderInfo", orderInfo);
			}
		}
		return "/order/order_modify";
	}
	
	/**
	 * order预约保存
	 * @param orderInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/order/ordersave.htm")
	public void orderSave(OrderInfo orderInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		if(orderInfo!=null && orderInfo.getOrder_id()!=null){//修改
			modify(orderInfo, request, response);
		}else{//否则新增order预约
			add(orderInfo, request, response);
		}
	}
	
	/**
	 * 修改在线申请
	 * @param orderInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(OrderInfo orderInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入预约修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = orderInfoService.updateByPrimaryKeySelective(orderInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改在线申请异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * 预约新增
	 * @param orderInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(OrderInfo orderInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入预约新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			orderInfo.setOrder_id(new BigDecimal(Constant.HEADER_ID_ORDER+System.currentTimeMillis()));
			bool = orderInfoService.insertSelective(orderInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增在线申请异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 通过父id获取车型数据
	 * @param parent_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/car/carType.htm")
	public void getCartTypeByPid(@RequestParam("parent_id") Integer parent_id, Integer id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("通过父id获取车型数据");
		boolean bool = true;
		String message = null;
		try {
			if(parent_id == null){
				throw new CarException("10001", "参数不能为空");
			}
			List<CarType> list = carTypeService.getCarTypeListByPid(parent_id);
			//获取<select></select>
			message = getData(list, id);
			
		} catch (CarException e) {
			log.error("通过父id获取车型数据异常", e);	
			bool = false;
			message = e.getErrMsg();
		} catch (Exception e) {
			log.error("通过父id获取车型数据异常", e);	
			bool = false;
			message = "系统异常";
		}finally{ 
			returnResult(response, bool, message);
		}
	}
	/**
	 * 组合
	 * @param list
	 * @param id
	 * @return
	 */
	private String getData(List<CarType> list, Integer id){
		StringBuffer strBuff = new StringBuffer("<table width='100%'><tr height='30px'><td width='80px' align='right'>车系：</td><td>");
		strBuff.append("<select style='width:95%;' class='form-control' id='car_type_son' name='car_type_son' onchange='setTypeName(this.options[this.selectedIndex].text);'>");
		String car_type_name = null;
		if(list!=null&&list.size()>0){
			car_type_name = ((CarType) list.iterator().next()).getValue();
			for(CarType type : list){//迭代出数据
				strBuff.append("<option value='").append(type.getId()).append("' ");
				if(id!=null && id.equals(type.getId())){//选中状态
					strBuff.append("selected");
					car_type_name = type.getValue();
				}
				strBuff.append(">");
				strBuff.append(type.getValue()).append("</option>");
			}
		}
		strBuff.append("</select></td></tr></table>");
		strBuff.append("<input id='car_type_name' name='car_type_name' type='hidden' ");
		if(list!=null&&list.size()>0){
			strBuff.append("value='").append(car_type_name).append("'");
		}
		strBuff.append("/>");
		return strBuff.toString();
	}
}
