package com.huazhu.application.weixin.tags.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import io.swagger.annotations.ApiOperation;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.user.GetblacklistResult;
import weixin.popular.bean.user.TagsGetidlistResult;
import weixin.popular.bean.user.UserTagGetResult;

@Service
public class UserTagsService {
	//logback日志
	private static final Logger logger = LoggerFactory.getLogger(UserTagsService.class);
	
	@Autowired
    private	WXAccessTokenUtil wxUtil;
	
	@ApiOperation(value = "标签下用户(粉丝)" , notes = "标签下用户(粉丝)")
	public UserTagGetResult getTagUsers(Integer tagid,String next_openid) {
		UserTagGetResult result = UserAPI.userTagGet(wxUtil.getAccess_token(), tagid, next_openid);
		return result;
	}
	
	@ApiOperation(value = "获取用户身上的标签列表" , notes = "获取用户身上的标签列表")
	public TagsGetidlistResult getUserTags(String openid) {
		TagsGetidlistResult result = UserAPI.tagsGetidlist(wxUtil.getAccess_token(), openid);
		return result;
	}
	
	@ApiOperation(value = "黑名单管理黑名单列表" , notes = "黑名单管理黑名单列表")
	public GetblacklistResult getUserTagsblacklist(String begin_openid) {
		logger.info("UserTagsService**getUserTagsblacklist(access_token) : " + wxUtil.getAccess_token());
		GetblacklistResult result = UserAPI.tagsMembersGetblacklist(wxUtil.getAccess_token(), begin_openid);
		return result;
	}
	
	
}
