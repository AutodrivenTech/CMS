package com.huazhu.application.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class ImageUpload {
	
	//服务器图片存储路径
	@Value(value = "${base.save.path}")
	private String baseSavePath;
	//服务器图片访问路径
	@Value(value = "${base.save.url}")
	private String baseSaveUrl;
	/**
	 * 单张图片上传
	 * @param multipartFile
	 * @param path
	 * @return
	 */
	public String singlePictureUploaded(MultipartFile multipartFile,String path) {
		if(multipartFile.isEmpty()) {
			return "文件为空";
		}
		String fileName = multipartFile.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + sdf.format(new Date()) + fileSuffix;
		String basePicUrl = path + File.separator + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String savePath = baseSavePath + File.separator + basePicUrl;
		File targetFile = new File(savePath,newFileName);
		if(!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}
		try {
			multipartFile.transferTo(targetFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		String picUrl = basePicUrl + File.separator + newFileName;
		return baseSaveUrl + File.separator +  picUrl;
	}

}
