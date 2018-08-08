package com.huazhu.application.cms.tags.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.huazhu.application.common.Constant;
import com.huazhu.application.common.ImageUpload;

@RestController
public class TestController {
	
	@Autowired
	private ImageUpload imageUpload;
	
	@RequestMapping("/testUplaodImage")
	public Map<String,Object> testUplaodImage(MultipartFile multipartFile){
		Map<String,Object> map = new HashMap<String,Object>();
		String picUrl = imageUpload.singlePictureUploaded(multipartFile, "test");
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		map.put(Constant.RETURN_DATA, picUrl);
		return map;
	}

}
