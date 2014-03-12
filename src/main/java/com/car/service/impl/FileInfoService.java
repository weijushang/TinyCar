package com.car.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.car.dao.IFileInfoDAO;
import com.car.domain.FileInfo;
import com.car.service.IFileInfoService;
import com.car.utils.CarConfig;
import com.car.utils.CarException;
import com.car.utils.Constant;
import com.car.utils.FileUtil;
import com.car.utils.MD5;

/**
 * 文件信息service实现类
 * @Title: FileInfoService.java
 * @author wangyh
 * @date 2014-2-24 上午11:26:33
 * @Description: 
 */
public class FileInfoService implements IFileInfoService {

	private static Log log = LogFactory.getLog(FileInfoService.class);

	@Autowired
	private IFileInfoDAO fileInfoDAO;
	
	@Override
	public boolean insertSelective(FileInfo fileInfo) throws CarException {
		
		boolean bool = true;
		try{

			fileInfoDAO.insertSelective(fileInfo);
		}catch(Exception e){
			log.error("保存数据异常 "+e);
			bool = false;
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return bool;
	}

	@Override
	public FileInfo selectByPrimaryKey(FileInfo fileInfo) {
		
		return fileInfoDAO.selectByPrimaryKey(fileInfo);
	}

	@Override
	public int countByExample(FileInfo fileInfo) {
		
		return fileInfoDAO.countByExample(fileInfo);
	}

	@Override
	public List<FileInfo> selectByExample(FileInfo fileInfo) {
		
		return fileInfoDAO.selectByExample(fileInfo);
	}

	@Override
	public boolean updateByPrimaryKeySelective(FileInfo fileInfo) throws CarException {
		
		try{
			return fileInfoDAO.updateByPrimaryKeySelective(fileInfo)>0?true:false;
		}catch(Exception e){
			log.error("更新用户数据异常 "+e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}

	@Override
	public boolean deleteByExample(FileInfo fileInfo) throws CarException {
		
		try{
			fileInfo = fileInfoDAO.selectByPrimaryKey(fileInfo);
			if(fileInfo==null){
				throw new CarException("60001", "不存在该纪录");
			}
			StringBuffer filePath = new StringBuffer(CarConfig.getString(Constant.IMAGES_DIR)).append(fileInfo.getFile_path());
			FileUtil.deleteFile(filePath.toString()+fileInfo.getFile_name());//删除原文件
			return fileInfoDAO.deleteByExample(fileInfo)>0?true:false;
		}catch(Exception e){
			log.error("删除用户异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getPageList(FileInfo fileInfo, int pageNum, int pageSize) {
		
		Map map = new HashMap();
		int count = fileInfoDAO.countByExample(fileInfo);//数量
		map.put(Constant.MAP_VALUE_COUNT, count);
		if(count > 0){
			if(pageNum > 0){
				pageNum = (pageNum-1)*pageSize;
			}
			List<FileInfo> list = fileInfoDAO.getPageList(fileInfo, pageNum, pageSize);//详情
			map.put(Constant.MAP_VALUE_LIST, list);
		}
		return map;
	}
	
	/**
	 * 批量保存图片
	 * @param image_files
	 * @param file_type
	 * @return
	 */
	@Override
	public boolean saveFiles(MultipartFile[] image_files, String[] file_type) throws CarException {
		try{
			
			for(int i=0; i<image_files.length; i++){
				MultipartFile file = image_files[i];
				if(file!=null && file.getSize() > 0){//说明有数据
					
					String file_id = Constant.HEADER_ID_FILE+System.currentTimeMillis()+i;
					String ori_file_name = file.getOriginalFilename();
					String new_file_name = MD5.encrypt(file_id+System.currentTimeMillis()+ori_file_name);//
					String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
					StringBuffer path = new StringBuffer("");
					if(Constant.FILE_TYPE_FAVORABLE_AD.equals(file_type[i])){
						path.append(CarConfig.getString(Constant.FAVORABLE_IMAGE_PATH)).append("AD/");
					}else{
						path.append(CarConfig.getString(Constant.PRODUCT_IMAGE_PATH)).append("AD/");
					}
					String savePath = CarConfig.getString(Constant.IMAGES_DIR)+path.toString();
					if(!new File(savePath).isDirectory()){
						new File(savePath).mkdirs();
					}
					//文件生成
					FileUtil.saveFile(file.getInputStream(), savePath, new_file_name+"."+suffix);
					
					FileInfo fileInfo = new FileInfo();
					fileInfo.setFile_id(new BigDecimal(file_id));
					fileInfo.setFile_name(new_file_name+"."+suffix);
					fileInfo.setFile_ori_name(ori_file_name);
					fileInfo.setFile_path(path.toString());
					fileInfo.setFile_suffix(suffix);
					fileInfo.setFile_type(file_type[i]);
					fileInfoDAO.insertSelective(fileInfo);
				}
			}
		}catch(Exception e){
			log.error("批量保存图片异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return true;
	}

	@Override
	public boolean saveFiles(MultipartFile[] image_files, String[] file_alise, String[] outer_url,
			Integer[] file_seq) throws CarException {
		
		try{
			for(int i=0; i<image_files.length; i++){
				MultipartFile file = image_files[i];
				if(file!=null && file.getSize() > 0){//说明有数据
					
					String file_id = Constant.HEADER_ID_FILE+System.currentTimeMillis()+i;
					String ori_file_name = file.getOriginalFilename();
					String new_file_name = MD5.encrypt(file_id+System.currentTimeMillis()+ori_file_name);//
					String suffix = ori_file_name.substring(ori_file_name.lastIndexOf(".")+1);//后缀
					String path = CarConfig.getString(Constant.LIFE_IMAGE_PATH);
					String savePath = CarConfig.getString(Constant.IMAGES_DIR)+path;
					if(!new File(savePath).isDirectory()){
						new File(savePath).mkdirs();
					}
					//文件生成
					FileUtil.saveFile(file.getInputStream(), savePath, new_file_name+"."+suffix);
					
					FileInfo fileInfo = new FileInfo();
					fileInfo.setFile_id(new BigDecimal(file_id));
					fileInfo.setFile_name(new_file_name+"."+suffix);
					fileInfo.setFile_ori_name(ori_file_name);
					fileInfo.setFile_path(path);
					fileInfo.setFile_suffix(suffix);
					String alise = file_alise[i];
					if(alise!=null && !"".equals(alise))
						fileInfo.setFile_alise(alise);//别名
					String url = outer_url[i];
					if(url!=null && !"".equals(url))
						fileInfo.setOuter_url(url);//外部链接
					Integer seq = file_seq[i];
					if(seq!=null)
						fileInfo.setFile_seq(seq);//序号
					fileInfo.setFile_type(Constant.FILE_TYPE_LIFE);
					fileInfoDAO.insertSelective(fileInfo);
				}
			}
		}catch(Exception e){
			log.error("批量保存图片异常：", e);
			throw new CarException(Constant.SYS_EXCEPTION_CODE, Constant.SYS_EXCEPTION_MSG);
		}
		return true;
	}
}
