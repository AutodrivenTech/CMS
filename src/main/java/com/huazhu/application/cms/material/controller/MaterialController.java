package com.huazhu.application.cms.material.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.huazhu.application.cms.common.BasicController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.material.entity.Material;
import com.huazhu.application.cms.material.service.MaterialService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "素材管理")
@RestController
@RequestMapping("/cms/material")
public class MaterialController extends BasicController {
	
	@Autowired
	private MaterialService materialService;
	
	@ApiOperation(value = "新增素材" , notes = "新增素材")
	@PostMapping("/addMaterial")
	public Map<String,Object> addMaterial(Material material,MultipartFile file){
		Map<String,Object> map = new HashMap<String,Object>();
		if(material != null) {
		//	material.setCreateUser(Long.valueOf(getUserId()));
			Integer result = materialService.insertMaterial(material,file);
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
	
	@ApiOperation(value = "修改素材" , notes = "修改素材")
	@PostMapping("/editMaterial")
	public Map<String,Object> editMaterial(Material material,MultipartFile file){
		Map<String,Object> map = new HashMap<String,Object>();
		if(material != null) {
			//material.setLastUpdateUser(Long.valueOf(getUserId()));
			Integer result = materialService.updateMaterialByRowId(material,file);
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
	
	@ApiOperation(value = "预览素材" , notes = "预览素材")
	@RequestMapping("/previewMaterial")
	public Map<String,Object> previewMaterial(Integer rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId == null || rowId <=0) {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}

		Material data = materialService.queryMaterialByRowId(rowId);
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		map.put(Constant.RETURN_DATA, data);
		return map;
	}
	
	@ApiOperation(value = "条件查询素材列表" , notes = "模糊条件查询素材列表")
	@RequestMapping("/getMaterialList")
	public Map<String,Object> getMaterialList(Material material,Integer pageNo,Integer pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		if(pageNo==null && pageSize==null){
			List<Material> materialList=materialService.getMaterialList(material);
			map.put(Constant.RETURN_DATA, materialList);
		}else{
			PageInfo<Material> data = materialService.queryMaterialByConditions(material,pageNo,pageSize);
			map.put(Constant.RETURN_DATA, data);
		}
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		return map;
	}


	@ApiOperation(value = "删除素材" )
	@PostMapping("/deleteMaterial")
	public Map<String,Object> deleteMaterial(@RequestParam("rowIds") String rowIds){
		Map<String,Object> map=new HashMap<>();
		if(StringUtils.isBlank(rowIds)){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		map=materialService.deleteMaterialByRowId( rowIds,null);
		return map;
	}

}
 