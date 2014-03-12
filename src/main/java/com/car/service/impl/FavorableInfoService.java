package com.car.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.car.dao.IFavorableInfoDAO;
import com.car.dao.IFileInfoDAO;
import com.car.domain.FavorableInfo;
import com.car.domain.FileInfo;
import com.car.service.IFavorableInfoService;
import com.car.utils.CarConfig;
import com.car.utils.CarException;
import com.car.utils.Constant;
import com.car.utils.FileUtil;
import com.car.utils.MD5;

/**
 * 优惠service实现类
 * @Title: FavorableInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class FavorableInfoService implements IFavorableInfoService {

	private static Log log = LogFactory.getLog(FavorableInfoService.class);

	@Autowired
	private IFavorableInfoDAO favorableInfoDAO;
	@Autowired
	private IFileInfoDAO fileInfoDAO;
	
	@Override
	public boolean insertSelective(FavorableInfo favorableInfo) throws CarException {
		
		boolean bool = true;
		try{
			MultipartFile image_file = favorableInfo.getImage_file();
			if(image_file!=null && image_file.getSize() > 0){//有图片上传
				addImages(favorableInfo, new MultipartFile[]{image_file});//新增
			}
			favorableInfoDAO.insertSelective(favorableInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public FavorableInfo selectByPrimaryKey(FavorableInfo favorableInfo) {
		
		return favorableInfoDAO.selectByPrimaryKey(favorableInfo);
	}

	@Override
	public int countByExample(FavorableInfo favorableInfo) {
		
		return favorableInfoDAO.countByExample(favorableInfo);
	}

	@Override
	public List<FavorableInfo> selectByExample(FavorableInfo favorableInfo) {
		
		return favorableInfoDAO.selectByExample(favorableInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(FavorableInfo favorableInfo) throws CarException {
		
		try{
			MultipartFile image_file = favorableInfo.getImage_file();
			if(image_file!=null && image_file.getSize() > 0){//有图片上传
				FileInfo fileInfo = new FileInfo();
				fileInfo.setParent_id(favorableInfo.getFavor_id());//父id
				fileInfo.setFile_type(Constant.FILE_TYPE_FAVORABLE);//优惠类型
				List<FileInfo> files = fileInfoDAO.selectByExample(fileInfo);
				if(files == null || files.size() == 0){//不存在则新增纪录
					addImages(favorableInfo, new MultipartFile[]{image_file});//新增
				}else{//更新纪录
					updateImages(favorableInfo, files.iterator().next(), image_file);//新增
				}
			}
			return favorableInfoDAO.updateByPrimaryKeySelective(favorableInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	/**
	 * 新增图片信息
	 * @param favorableInfo
	 * @param image_files
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private void addImages(FavorableInfo favorableInfo, MultipartFile[] image_files) throws FileNotFoundException, IOException, Exception{
		
		for(int i=0; i<image_files.length; i++){
			
			MultipartFile file = image_files[i];
			
			FileInfo fileInfo = new FileInfo();
			String file_id = Constant.HEADER_ID_FILE+System.currentTimeMillis()+i;
			fileInfo.setFile_id(new BigDecimal(file_id));
			fileInfo.setParent_id(favorableInfo.getFavor_id());
			fileInfo.setFile_type(Constant.FILE_TYPE_FAVORABLE);
			String ori_file_name = file.getOriginalFilename();
			String new_file_name = MD5.encrypt(file_id+System.currentTimeMillis()+ori_file_name);//
			String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
			StringBuffer path = new StringBuffer(CarConfig.getString(Constant.FAVORABLE_IMAGE_PATH)).append(favorableInfo.getFavor_id()).append("/");
			String savePath = CarConfig.getString(Constant.IMAGES_DIR)+path.toString();
			if(!new File(savePath).isDirectory()){
				new File(savePath).mkdirs();
			}
			//文件生成
			FileUtil.saveFile(file.getInputStream(), savePath, new_file_name+"."+suffix);
			
			fileInfo.setFile_name(new_file_name+"."+suffix);
			fileInfo.setFile_ori_name(ori_file_name);
			fileInfo.setFile_suffix(suffix);
			fileInfo.setFile_path(path.toString());//路径
			fileInfoDAO.insertSelective(fileInfo);
			
			if(image_files.length == 1){
				favorableInfo.setFileInfo(fileInfo);//重新设置
				favorableInfo.setFile_path(fileInfo.getFile_path()+fileInfo.getFile_name());//设置图片保存路径
			}
		}
	}
	
	/**
	 * 更新图片信息
	 * @param favorableInfo
	 * @param fileInfo
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private void updateImages(FavorableInfo favorableInfo, FileInfo fileInfo, MultipartFile file) throws FileNotFoundException, IOException, Exception{
		String ori_file_name = file.getOriginalFilename();
		String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
		StringBuffer path = new StringBuffer(CarConfig.getString(Constant.FAVORABLE_IMAGE_PATH)).append(favorableInfo.getFavor_id()).append("/");
		String savePath = CarConfig.getString(Constant.IMAGES_DIR)+path.toString();
		if(!new File(savePath).isDirectory()){
			new File(savePath).mkdirs();
		}
		StringBuffer filePath = new StringBuffer(CarConfig.getString(Constant.IMAGES_DIR)).append(fileInfo.getFile_path());

		String new_file_name = fileInfo.getFile_name().substring(0, 33)+suffix;//
		FileUtil.deleteFile(filePath.toString()+fileInfo.getFile_name());//删除原文件
		//文件生成
		FileUtil.saveFile(file.getInputStream(), savePath, new_file_name);
		//更新原文件名
		fileInfo.setFile_ori_name(ori_file_name);
		//更新后缀名
		fileInfo.setFile_suffix(suffix);
		fileInfo.setFile_name(new_file_name);
		fileInfoDAO.updateByPrimaryKeySelective(fileInfo);
		
		favorableInfo.setFileInfo(fileInfo);//重新设置
		favorableInfo.setFile_path(fileInfo.getFile_path()+fileInfo.getFile_name());//设置图片保存路径
	}

	@Override
	public boolean deleteByExample(FavorableInfo favorableInfo) throws CarException {
		
		try{

			return favorableInfoDAO.deleteByExample(favorableInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(FavorableInfo favorableInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = favorableInfoDAO.countByExample(favorableInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<FavorableInfo> list = favorableInfoDAO.getPageList(favorableInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
}
