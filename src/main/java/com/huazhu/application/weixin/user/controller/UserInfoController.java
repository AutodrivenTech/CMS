package com.huazhu.application.weixin.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazhu.application.common.Constant;
import com.huazhu.application.weixin.common.WXAccessTokenUtil;
import com.huazhu.application.weixin.user.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.user.User;
import weixin.popular.bean.user.UserInfoList;

@Api(value = "用户信息")
public class UserInfoController {
	
	//logback日志
	private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private WXAccessTokenUtil wxUtil;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@ApiOperation(value = "获取用户信息" ,notes = "获取用户信息通过openid")
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public Map<String,Object> getUserInfo(String openid){
		Map<String,Object> map = new HashMap<String,Object>();
		User user = UserAPI.userInfo(wxUtil.getAccess_token(), openid);
		if(user != null) {
			map.put(Constant.RETURN_CODE, user.getErrcode());
			map.put(Constant.RETURN_MSG, user.getErrmsg());
			map.put(Constant.RETURN_DATA, user);
		}else{
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		logger.info("UserInfoController**getUserInfo(获取用户信息) : " + Constant.RETURN_DATA + map);
		return map;
		
	}
	
	@ApiOperation(value = "分页获取用户信息" ,notes = "分页获取用户信息")
	@RequestMapping("/getUserListInfo")
	@ResponseBody
	public Map<String,Object> getUserListInfo(String next_openid,@RequestParam(value = Constant.PAGE_SIZE_NAME ,defaultValue = Constant.PAGE_SIZE)int limit){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> openids = userInfoService.getOpenIds(next_openid);
		List<String> new_openids = null;
		if(openids != null && openids.size() >0) {
		    new_openids = openids.size() > limit ? openids.subList(0, limit-1) : openids;
			UserInfoList users = UserAPI.userInfoBatchget(wxUtil.getAccess_token(), "zh-CN", new_openids);
			if(users != null) {
				map.put(Constant.RETURN_CODE, users.getErrcode());
				map.put(Constant.RETURN_MSG, users.getErrmsg());
				map.put(Constant.RETURN_DATA, users);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}else {
			map.put(Constant.RETURN_CODE, Constant.NO_DATA_CODE);
			map.put(Constant.RETURN_MSG, Constant.NO_DATA_MSG);
		}
		logger.info("UserInfoController**getUserListInfo(批量获取用户信息) : " + Constant.RETURN_DATA + map);
		return map;
	}
	
	@ApiOperation(value = "获取黑名单用户信息集合" , notes = "分页获取黑名单用户信息集合")
	@RequestMapping("/getBlackTagsUsers")
	@ResponseBody
	public Map<String,Object> getBlackTagsUsers(String next_openid,@RequestParam(value = Constant.PAGE_SIZE_NAME,defaultValue = Constant.PAGE_SIZE)int limit){
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> blackOpenids = userInfoService.getBlackOpenIds(next_openid);
		List<String> new_blackOpenids = null;
		if(blackOpenids != null) {
			new_blackOpenids = blackOpenids.size() > limit ? blackOpenids.subList(0, limit-1) : blackOpenids;
			UserInfoList blackUserInfoList = UserAPI.userInfoBatchget(wxUtil.getAccess_token(), "zh-CN", new_blackOpenids);
			if(blackUserInfoList != null) {
				map.put(Constant.RETURN_CODE, blackUserInfoList.getErrcode());
				map.put(Constant.RETURN_MSG, blackUserInfoList.getErrmsg());
				map.put(Constant.RETURN_DATA, blackUserInfoList);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}else{
			map.put(Constant.RETURN_CODE, Constant.NO_DATA_CODE);
			map.put(Constant.RETURN_MSG, Constant.NO_DATA_MSG);
		}
		logger.info("UserInfoController**getBlackTagsUsers(分页获取黑名单用户信息) : " + Constant.RETURN_DATA + map);

		return map;
	}


}
