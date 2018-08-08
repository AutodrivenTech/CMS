package com.huazhu.application.cms.organization.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.organization.entity.Group;
import com.huazhu.application.cms.organization.service.GroupService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "集团组织")
@RestController()
@RequestMapping("/cms/organization/controller")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@ApiOperation(value = "新增集团" , notes = "新增组织机构集团")
	@RequestMapping("/addGroup")
	public Map<String,Object> addGroup(Group group){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer result = groupService.insertGroup(group);
		if(result >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "修改集团" , notes = "修改组织机构集团")
	@RequestMapping("/editGroup")
	public Map<String,Object> editGroup(Group group){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer result = groupService.updateGroupByRowId(group);
		if(result >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "预览集团" , notes = "预览组织机构集团")
	@RequestMapping("/previewGroup")
	public Map<String,Object> previewGroup(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null) {
			Group data = groupService.queryGroupByRowId(rowId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	} 
	
	@ApiOperation(value = "查询集团" , notes = "查询组织机构集团")
	@RequestMapping("/getGroups")
	public Map<String,Object> getGroups(Group group){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Group> data = groupService.queryGroup(group);
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
	
	@ApiOperation(value = "删除集团" , notes = "删除组织机构集团")
	@RequestMapping("/deleteGroups")
	public Map<String,Object> deleteGroups(Long rowId){ 
		
		return groupService.deleteGroupByRowId(rowId);
	}

}
