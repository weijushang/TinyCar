package com.car.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 文件处理工具类
 * @Title: FileUtil.java
 * @author wangyh
 * @date 2014-2-23 上午11:51:43
 * @Description: 
 */
public class FileUtil {
	
	private static Log log = LogFactory.getLog(FileUtil.class);
	
	/**
	 * 保存文件
	 * @param inputStream 输入流
	 * @param savePath 文件保存路径
	 * @param fileName 文件名称
	 * @throws IOException 
	 */
	public static void saveFile(InputStream inputStream, String savePath, String fileName) throws FileNotFoundException, IOException, Exception{
		OutputStream bos = null;
		try{
			File fileDir = new File(savePath);
			if(!fileDir.isDirectory()){
				fileDir.mkdirs();
			}
			bos = new FileOutputStream(savePath + fileName);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);// 将文件写入服务器
			}
		}catch(FileNotFoundException e){
			log.error("文件保存-找不到文件异常", e);
			throw e;
		}catch(IOException e){
			log.error("文件保存-io读取异常", e);
			throw e;
		}catch(Exception e){
			log.error("文件保存异常", e);
			throw e;
		}finally{
			if(bos != null){
				bos.close();
			}
			if(inputStream != null){
				inputStream.close();
			}
		}
	}
	
	/**
	 * 删除文件
	 * @param filePath 文件绝对路径
	 * @return
	 */
	public static boolean deleteFile(String filePath){
		
		File file = new File(filePath);
		return file.delete();
	}
}
