package com.car.file.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.car.base.BaseController;
import com.car.domain.FileInfo;
import com.car.service.IFileInfoService;
import com.car.utils.CarException;
import com.car.utils.Constant;

/**
 * 文件信息
 * @Title: ContactController.java
 * @author wangyh
 * @date 2014-2-23 下午4:13:08
 * @Description: 
 */
@Controller
public class FileController extends BaseController{

	
	private static Log log = LogFactory.getLog(FileController.class);
	
	@Autowired
	private IFileInfoService fileInfoService;
	
	/**
	 * 文件上传页面
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/file_index.htm")
	public String file_index(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入文件上传页面");
		//获取图片
		getImages(request);
		return "/file/file_index";
	}
	
	/**
	 * 获取图片
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	private void getImages(HttpServletRequest request){
		
		List<FileInfo> image_list = new ArrayList<FileInfo>();
		FileInfo fileInfo = new FileInfo();
		//产品广告图片
		fileInfo.setFile_type(Constant.FILE_TYPE_PRODUCT_AD);
		List<FileInfo> p_advs =  fileInfoService.selectByExample(fileInfo);
		if(p_advs!=null){image_list.addAll(p_advs);}
		//优惠广告图片
		fileInfo.setFile_type(Constant.FILE_TYPE_FAVORABLE_AD);
		List<FileInfo> f_advs =  fileInfoService.selectByExample(fileInfo);
		if(f_advs!=null){image_list.addAll(f_advs);}
		if(image_list!=null&&image_list.size()>0){
			Collections.sort(image_list, new SortComparator());
		}
		request.setAttribute("image_list", image_list);
	}
	
	@SuppressWarnings("rawtypes")
	private class SortComparator implements Comparator {
		public int compare(Object a, Object b) {
			FileInfo fileA = (FileInfo)a;
			FileInfo fileB = (FileInfo)b;
			return fileA.getFile_id().compareTo(fileB.getFile_id());
		}
	}
	/**
	 * 批量上传图片
	 * @param image_files
	 * @param file_type
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/uploadImages.htm")
	public String uploadImages(@RequestParam MultipartFile[] image_files, String[] file_type, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入批量上传图片");
		
		request.setAttribute("err_div0", uploadFile(image_files, file_type));
		//获取相关图片
		getImages(request);
		
		return "/file/file_index";
	}
	
	/**
	 * 文件上传
	 * @param image_files
	 * @param file_type
	 * @return
	 */
	private String uploadFile(MultipartFile[] image_files, String[] file_type){
		
		String err_msg = "图片保存成功";
		try{
			if(file_type == null || image_files == null || file_type.length == 0 || image_files.length==0){
				throw new CarException("100001", "参数不能为空");
			}
			
			if(!fileInfoService.saveFiles(image_files, file_type)){
				err_msg = "图片保存失败";
			}
		}catch(CarException e){
			log.info("图片保存异常：", e);
			err_msg = e.getErrMsg();
		}catch(Exception e){
			log.info("图片保存异常：", e);
			err_msg = "系统异常";
		}
		return err_msg;
	}
	/**
	 * 删除文件信息
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/filedel.htm")
	public void fileDel(@RequestParam("file_id") BigDecimal file_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入文件信息删除");
		boolean bool = true;
		String message = "删除成功";
		try {
			if(file_id == null){
				bool = false;
				message = "参数不能为空";
			}else{
				FileInfo fileInfo = new FileInfo();
				fileInfo.setFile_id(file_id);
				bool = fileInfoService.deleteByExample(fileInfo);
				if(!bool){
					message = "删除失败";
				}
			}
		} catch (Exception e) {
			log.error("删除文件异常", e);	
			bool = false;
			message = "系统异常";
		} finally {
			StringBuffer script = new StringBuffer("<script>parent.alert('"+message+"');");
			if(bool){
				script.append("parent.$('#fileDiv').remove();");
			}
			script.append("</script>");
			response.getOutputStream().write(script.toString().getBytes("utf-8"));
		}
	}
	
	/**
	 * 广告图片删除
	 * @param file_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/deletefile.htm")
	public void deleteFile(BigDecimal file_id, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入文件删除");
		String err_msg = "文件删除成功";
		try{
			if(file_id == null){
				throw new CarException("100001", "参数不能为空");
			}
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFile_id(file_id);
			boolean bool = fileInfoService.deleteByExample(fileInfo);
			if(!bool){
				err_msg = "文件删除失败";
			}else{
				err_msg = String.valueOf(file_id);//返回id
			}
		}catch(CarException e){
			log.info("文件删除异常：", e);
			err_msg = e.getErrMsg();
		}catch(Exception e){
			log.info("文件删除异常：", e);
			err_msg = "系统异常";
		}
		response.getWriter().write(err_msg);
	}
	
	/**
	 * 进入新增或者修改file文件页面
	 * @param file_id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/fileinfo.htm")
	public String fileinfo(BigDecimal file_id, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		if(islogined(request, response)){//已登录
			if(file_id == null){
				log.info("进入新增文件页面");
				request.getSession().removeAttribute("fileInfo");
			}else{
				log.info("进入文件修改页面");
				FileInfo fileInfo = new FileInfo();
				fileInfo.setFile_id(file_id);
				fileInfo = fileInfoService.selectByPrimaryKey(fileInfo);
				request.getSession().setAttribute("fileInfo", fileInfo);
			}
		}
		return "/file/file_modify";
	}
	
	/**
	 * file文件保存
	 * @param fileInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/filesave.htm")
	public void fileSave(FileInfo fileInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		if(fileInfo!=null && fileInfo.getFile_id()!=null){//修改
			modify(fileInfo, request, response);
		}else{//否则新增file文件
			add(fileInfo, request, response);
		}
	}
	
	/**
	 * 修改file文件信息
	 * @param fileInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void modify(FileInfo fileInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入文件修改");
		boolean bool = true;
		String message = "修改成功";
		try {
			bool = fileInfoService.updateByPrimaryKeySelective(fileInfo);
			if(!bool){
				bool = false;
				message = "修改失败";
			}
		} catch (CarException e) {
			log.error("修改文件信息异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	/**
	 * file文件新增
	 * @param fileInfo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(FileInfo fileInfo, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		log.info("进入文件新增");
		boolean bool = true;
		String message = "新增成功";
		try {
			fileInfo.setFile_id(new BigDecimal(Constant.HEADER_ID_FILE+System.currentTimeMillis()));
			bool = fileInfoService.insertSelective(fileInfo);
			if(!bool){
				bool = false;
				message = "新增失败";
			}
		} catch (CarException e) {
			log.error("新增文件信息异常", e);	
			bool = false;
			message = e.getErrMsg();
		} finally {
			returnResult(response, bool, message);
		}
	}
	
	/**
	 * 文件类型更新
	 * @param file_id
	 * @param file_type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/manager/file/updatefiletype.htm")
	public void updatefileseq(BigDecimal file_id, String file_type, 
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("进入更新文件类型");
		String err_msg = "类型修改成功";
		try{
			if(file_id == null){
				throw new CarException("100001", "参数不能为空");
			}
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFile_id(file_id);
			fileInfo.setFile_type(file_type);
			boolean bool = fileInfoService.updateByPrimaryKeySelective(fileInfo);
			if(!bool){
				err_msg = "类型修改失败";
			}
		}catch(CarException e){
			log.info("文件序号更新异常：", e);
			err_msg = e.getErrMsg();
		}catch(Exception e){
			log.info("文件序号更新异常：", e);
			err_msg = "系统异常";
		}
		response.getWriter().write(err_msg);
	}
}
