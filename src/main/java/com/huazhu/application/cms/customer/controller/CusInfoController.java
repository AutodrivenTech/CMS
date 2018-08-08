/**
 * Project Name		:	CMS
 * File Name		:	CusInfoController.java
 * Package Name		:	com.huazhu.application.cms.customer.controller
 * Date				:	2018年7月11日下午7:08:45
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.customer.controller;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.common.BasicController;
import com.huazhu.application.cms.customer.entity.CusInfo;
import com.huazhu.application.common.Constant;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.customer.dto.customer.param.CusInfoParamDTO;
import com.huazhu.application.cms.customer.dto.customer.result.CusInfoResultDTO;
import com.huazhu.application.cms.customer.service.CusInfoService;
import com.huazhu.application.common.data.format.DataResult;
import com.huazhu.application.common.data.format.DataTable;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName		:	CusInfoController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午7:08:45 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@RestController
@RequestMapping(value = "/customer")
public class CusInfoController extends BasicController {
	@Autowired
	private CusInfoService cusInfoService;

	@GetMapping(value={"/datatable"})
	public DataResult<DataTable<CusInfoResultDTO>> selectDataTableByParam(CusInfoParamDTO param) {
		System.out.println(param);
		DataResult<DataTable<CusInfoResultDTO>> res = new DataResult<DataTable<CusInfoResultDTO>>(DataResult.SUCCESS_CODE, DataResult.SUCCESS_INFO, cusInfoService.selectDataTableByParam(param));
		return res;
	}

	@ApiOperation(value = "客户列表")
	@GetMapping("/getCusInfoList")
	public Map<String,Object> getCusInfoList(CusInfo cusInfo,Integer pageNo,Integer pageSize){
		Map<String,Object> map=new HashMap<>();
		PageInfo<CusInfo> pageInfo=cusInfoService.getCusInfoList(cusInfo,pageNo,pageSize);
		map.put(Constant.RETURN_CODE,Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG,Constant.SUCCESS_CONTENT);
		map.put(Constant.RETURN_CODE,pageInfo);
		return map;
	}


	@ApiOperation(value = "新增客户")
	@PostMapping("/addActivity")
	public Map<String,Object> addActivity(CusInfo cusInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		if(cusInfo != null) {
			cusInfo.setCreateUser(Long.valueOf(getUserId()));
			if(cusInfoService.insertSelective(cusInfo)>0) {
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


	@ApiOperation(value = "修改用户信息" , notes = "修改用户信息")
	@PostMapping("/eidtCusInfo")
	public Map<String,Object> eidtCusInfo(CusInfo cusInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		if(cusInfo != null) {
			cusInfo.setLastUpdateUser(Long.valueOf(getUserId()));
			if(cusInfoService.updateByPrimaryKeySelective(cusInfo) >0) {
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

	@ApiOperation(value = "预览客户" , notes = "预览客户")
	@RequestMapping("/previewCusInfo")
	public Map<String,Object> previewCusInfo(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null || rowId<=0) {
			CusInfo cusInfo=cusInfoService.selectByPrimaryKey(rowId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, cusInfo);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}


	@ApiOperation(value = "删除")
	@RequestMapping("/deleteCusInfo")
	public Map<String,Object> deleteCusInfo(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId!=null || rowId<=0){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		if(cusInfoService.deleteCusInfo(rowId,getUserId())<=0){
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}else{
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}
		return map;
	}


	@ApiOperation(value = "导出信息")
	@GetMapping("/exportCus")
	public Map<String,Object> exportCus(CusInfo cusInfo){
		Map<String,Object> map=new HashMap<>();
		cusInfoService.exprotCus(cusInfo);
		map.put(Constant.RETURN_CODE,Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG,Constant.SUCCESS_CONTENT);
		return map;
	}

}
