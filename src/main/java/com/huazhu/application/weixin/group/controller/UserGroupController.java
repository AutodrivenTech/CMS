package com.huazhu.application.weixin.group.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.user.Group;
import weixin.popular.bean.user.Group.GroupData;
@Api(value = "用户分组")
@Controller
@RequestMapping("/weixin/group/controller")
public class UserGroupController {
	
	//logback日志
	private final static Logger logger = LoggerFactory.getLogger(UserGroupController.class);
	
	@Autowired
	public WXAccessTokenUtil util;
	
	/**
	 * 获取用户分组列表
	 * @return
	 */
	@ApiOperation(value = "获取用户分组列表" ,notes = "获取用户分组列表")
	@RequestMapping("/getGroupList")
	@ResponseBody
	public Map<String,Object> getGroupList(){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("getGroupList(access_token) : " + util.getAccess_token());
    	Group g = UserAPI.groupsGet(util.getAccess_token());
    	List<GroupData> data = null;
    	if(g != null && g.isSuccess()) {
    		data = g.getGroups();
    		map.put("code", 0);
    		map.put("msg", "成功");
    	}else {
    		map.put("code",1);
    		map.put("msg", "失败");
    	}
    	map.put("data", data);
    	logger.info("getGroupList (用户分组列表): " + data);
		return map;
	}
	
	@ApiOperation(value = "新增分组" , notes = "新增分组")
	@RequestMapping("/addGroup")
	@ResponseBody
	public Map<String,Object> addGroup(String groupName){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("addGroup(access_token) : " + util.getAccess_token());
		Group g = UserAPI.groupsCreate(util.getAccess_token(), groupName);
		if(g != null) {
			if(g.getGroup() != null && g.getErrcode() == null) {
				map.put("code", 0);
				map.put("msg", "成功");
			    map.put("data", g.getGroup());
			    logger.info("addGroup(新增分组) : " + "成功" + "data" + g);
			}else {
				map.put("code", g.getErrcode());
				map.put("msg", g.getErrmsg());
				logger.info("addGroup(新增分组) : " + "失败" + "data" + g);
			}
		}else {
			map.put("code", 1);
			map.put("msg", "失败");
		}
		return map;
	}
	
	@ApiOperation(value = "修改分组名称" , notes = "修改分组名称")
	@RequestMapping("/editGroup")
	@ResponseBody
	public Map<String,Object> editGroup(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("editGroup(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.groupsUpdate(util.getAccess_token(), id, name);
		if(result != null) {
			map.put("code", result.getErrcode());
			map.put("msg", result.getErrmsg());
			logger.info("editGroup(修改分组名称) : " + result);
		}
		return map;
	}
	
	@ApiOperation(value = "删除分组名称" , notes = "删除分组名称")
	@RequestMapping("/deleteGroup")
	@ResponseBody
	public Map<String,Object> deleteGroup(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("deleteGroup(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.groupsDelete(util.getAccess_token(), id);
		if(result != null) {
			map.put("code", result.getErrcode());
			map.put("msg", result.getErrmsg());
			logger.info("deleteGroup(删除分组名称) : " + result);
		}
		return map;
	} 

}
 