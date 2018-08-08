package com.huazhu.application.weixin.tags.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazhu.application.common.Constant;
import com.huazhu.application.weixin.common.WXAccessTokenUtil;
import com.huazhu.application.weixin.group.controller.UserGroupController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.user.TagsCreatResult;
import weixin.popular.bean.user.TagsGetResult;
@Api(value = "用户标签管理")
@Controller
@RequestMapping("/weixin/tags/controller")
public class UserTagsController {
	
	//logback日志
	private final static Logger logger = LoggerFactory.getLogger(UserGroupController.class);
	
	@Autowired
	private WXAccessTokenUtil util; 
		
	@ApiOperation(value = "获取标签列表" ,notes = "获取标签列表")
	@RequestMapping("/getTagsList")
	@ResponseBody
	public Map<String,Object> getTagsList(){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("getTagsList(access_token) : " + util.getAccess_token());
    	TagsGetResult result = UserAPI.tagsGet(util.getAccess_token());
    	if(result != null) {
    		if(result.getErrcode().equals(Constant.SUCCESS_CODE)) {
    			map.put("code", Constant.SUCCESS_CODE);
	    		map.put("msg", Constant.SUCCESS_CONTENT);
        		map.put("data", result.getTags());
        		logger.info("getTagsList (标签列表): " + result.getTags());
        	}else {
        		map.put("code",result.getErrcode());
        		map.put("msg", result.getErrmsg());
        		logger.info("addTag (新增标签): " + result.getErrcode() + "=====" + result.getErrmsg());
        	}
    	}else {
    		map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("getTagsList (标签列表): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
    	}
		return map;
	}
	
	@ApiOperation(value = "新增标签",notes = "新增标签" )
	@RequestMapping("/addTag")
	@ResponseBody
	public Map<String,Object> addTag(String name){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("addTag(access_token) : " + util.getAccess_token());
		TagsCreatResult result = UserAPI.tagsCreate(util.getAccess_token(), name);
		if(result != null) {
			if(result.getErrcode().equals(Constant.SUCCESS_CODE)) {
				map.put("code", Constant.SUCCESS_CODE);
	    		map.put("msg", Constant.SUCCESS_CONTENT);
	    		map.put("data", result.getTag());
	    		logger.info("addTag (新增标签): data" + result.getTag());
			}else {
				map.put("code",result.getErrcode());
	    		map.put("msg", result.getErrmsg());
	    		logger.info("addTag (新增标签): " + result.getErrcode() + "=====" + result.getErrmsg());
			}
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("addTag (新增标签): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "编辑标签",notes = "编辑标签" )
	@RequestMapping("/editTag")
	@ResponseBody
	public Map<String,Object> editTag(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("editTag(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.tagsUpdate(util.getAccess_token(), Integer.getInteger(id.trim()), name);
		if(result != null) {
			map.put("code",result.getErrcode());
    		map.put("msg", result.getErrmsg());
    		logger.info("editTag (编辑标签): " + result.getErrcode() + "=====" + result.getErrmsg());
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("editTag (编辑标签): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "删除标签" , notes = "删除标签")
	@RequestMapping("/deleteTag")
	@ResponseBody
	public Map<String,Object> deleteTag(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("deleteTag(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.tagsDelete(util.getAccess_token(), Integer.getInteger(id.trim()));
		if(result != null) {
			map.put("code",result.getErrcode());
    		map.put("msg", result.getErrmsg());
    		logger.info("deleteTag (删除标签): " + result.getErrcode() + "=====" + result.getErrmsg());
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("deleteTag (删除标签): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	
	@ApiOperation(value = "批量为用户打标签" , notes = " 批量为用户打标签")
	@RequestMapping("/batchtaggingUsers")
	@ResponseBody
	public Map<String,Object> batchtaggingUsers(String tagid,String[] openids){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("batchtaggingUsers(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.tagsMembersBatchtagging(util.getAccess_token(), Integer.getInteger(tagid), openids);
		if(result != null) {
			map.put("code",result.getErrcode());
    		map.put("msg", result.getErrmsg());
    		logger.info("batchtaggingUsers (批量为用户打标签): " + result.getErrcode() + "=====" + result.getErrmsg());
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("batchtaggingUsers (批量为用户打标签): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}

	@ApiOperation(value = "批量为用户取消标签" , notes = "批量为用户取消标签")
	@RequestMapping("/batchuntaggingUsers")
	@ResponseBody
	public Map<String,Object> batchuntaggingUsers(String tagid,String[] openids){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("batchuntaggingUsers(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.tagsMembersBatchuntagging(util.getAccess_token(), Integer.getInteger(tagid), openids);
		if(result != null) {
			map.put("code",result.getErrcode());
    		map.put("msg", result.getErrmsg());
    		logger.info("batchuntaggingUsers (批量为用户取消标签): " + result.getErrcode() + "=====" + result.getErrmsg());
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("batchuntaggingUsers (批量为用户取消标签): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "黑名单管理批量拉黑用户" , notes = "黑名单管理批量拉黑用户")
	@RequestMapping("/tagsBatchblackUser")
	@ResponseBody
	public Map<String,Object> tagsBatchblackUser(String[] openid_list){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("tagsBatchblackUser(access_token) : " + util.getAccess_token());
		BaseResult result = UserAPI.tagsMembersBatchblacklist(util.getAccess_token(), openid_list);
		if(result != null) {
			map.put("code",result.getErrcode());
    		map.put("msg", result.getErrmsg());
    		logger.info("tagsBatchblackUser (黑名单管理	批量拉黑用户): " + result.getErrcode() + "=====" + result.getErrmsg());
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("tagsBatchblackUser (黑名单管理批量拉黑用户): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "黑名单管理批量取消拉黑用户" , notes = "黑名单管理批量取消拉黑用户")
	@RequestMapping("/tagsBatchunblackUser")
	@ResponseBody
	public Map<String,Object> tagsBatchunblackUser(String[] openid_list){
		Map<String,Object> map = new HashMap<String,Object>();
		BaseResult result = UserAPI.tagsMembersBatchunblacklist(util.getAccess_token(), openid_list);
		if(result != null) {
			map.put("code",result.getErrcode());
    		map.put("msg", result.getErrmsg());
    		logger.info("tagsBatchunblackUser (黑名单管理批量取消拉黑用户): " + result.getErrcode() + "=====" + result.getErrmsg());
		}else {
			map.put("code",Constant.FAILURE_CODE);
    		map.put("msg", Constant.FAILURE_CONTENT);
    		logger.info("tagsBatchunblackUser (黑名单管理批量取消黑名单用户): " + Constant.FAILURE_CODE + "=====" + Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	
}
