package com.huazhu.application.cms.organization.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.organization.entity.Brand;
import com.huazhu.application.cms.organization.service.BrandService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "品牌管理")
@RestController
@RequestMapping("/cms/organization/controller")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@ApiOperation(value = "新增品牌" , notes = "新增组织机构品牌")
	@RequestMapping("/addBrand")
	public Map<String,Object> addBrand(Brand brand){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer result = brandService.insertBrand(brand);
		if(result >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "编辑品牌" , notes = "编辑组织机构品牌")
	@RequestMapping("/editBrand")
	public Map<String,Object> editBrand(Brand brand){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer result = brandService.updateBrandByRowId(brand);
		if(result >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "预览品牌" , notes = "预览组织机构品牌")
	@RequestMapping("/previewBrand")
	public Map<String,Object> previewBrand(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null) {
			Brand data = brandService.queryBrandByRowId(rowId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "查询品牌" , notes = "查询组织机构品牌")
	@RequestMapping("/getBrands")
	public Map<String,Object> getBrands(Brand brand){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Brand> data = brandService.queryBrand(brand);
		if(data != null) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.NO_DATA_CODE);
			map.put(Constant.RETURN_MSG, Constant.NO_DATA_MSG);
		}
		return map;
	}
	
	@ApiOperation(value = "集团下品牌" , notes = "集团品牌查询")
	@RequestMapping("/queryBrandByGroup")
	public Map<String,Object> queryBrandByGroup(Long groupId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(groupId != null) {
			List<Brand> data = brandService.queryBrandByGroupId(groupId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "删除品牌" , notes = "删除组织机构品牌")
	@RequestMapping("/deleteBrand")
	public Map<String,Object> deleteBrand(Long rowId){
		return brandService.deleteBrandByRowId(rowId);
	}

}





