package com.huazhu.application.cms.tags.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.common.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.tags.entity.Tags;
import com.huazhu.application.cms.tags.service.TagsService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value ="标签管理")
@RestController
@RequestMapping("cms/tags")
public class TagsController extends BasicController {
	
	@Autowired
	private TagsService tagsService;
	
	@ApiOperation(value = "新增标签" , notes = "新增标签")
	@PostMapping("/addTags")
	public Map<String,Object> addTags(Tags tags){
		Map<String,Object> map = new HashMap<String,Object>();
		if(tags != null) {
			//tags.setLastUpdateUser(Long.valueOf(getUserId()));
			map=tagsService.insertTags(tags);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "编辑标签" , notes = "编辑标签")
	@PostMapping("/editTags")
	public Map<String,Object> editTags(Tags tags){
		Map<String,Object> map = new HashMap<String,Object>();
		if(tags != null) {
			//tags.setLastUpdateUser(Long.valueOf(getUserId()));
			map = tagsService.updateTags(tags);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "删除标签" , notes = "删除标签")
	@PostMapping("/deleteTags")
	public Map<String,Object> deleteTags(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null) {
			Integer result = tagsService.deleteTagsByRowId(rowId,null);
			if(result != null && result >0) {
				map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
				map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "查询标签" , notes = "查询标签列表")
	@RequestMapping("/getTagsList")
	public Map<String,Object> getTagsList(Tags tags,Integer pageNo,Integer pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		if(pageNo==null && pageSize==null){
			List<Tags> data = tagsService.queryTagsConditions(tags);
			map.put(Constant.RETURN_DATA, data);
		}else{
			PageInfo<Tags> pageInfo = tagsService.queryTagsList(tags,pageNo,pageSize);
			map.put(Constant.RETURN_DATA, pageInfo);
		}
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);

		return map;
		
	}

	@ApiOperation(value = "查询标签详情" , notes = "查询标签详情")
	@RequestMapping("/getTagsDetail")
	public Map<String,Object> getTagsDetail(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		Tags tags=tagsService.queryTagsByRowId(rowId);
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		map.put(Constant.RETURN_DATA,tags);
		return map;

	}



}
