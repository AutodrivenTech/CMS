package com.huazhu.application.weixin.user.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import io.swagger.annotations.ApiOperation;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.user.FollowResult;
import weixin.popular.bean.user.GetblacklistResult;

@Service
public class UserInfoService {
	
	//logback日志
	private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);
	
	@Autowired
    private	WXAccessTokenUtil wxUtil;
	
	@ApiOperation(value = "获取openid集合" , notes = "通过next_openid获取openid集合")
	public List<String> getOpenIds(String next_openid){
		List<String> openids = null;
		FollowResult result = UserAPI.userGet(wxUtil.getAccess_token(), next_openid);
		if(result != null) {
		   if(result.getCount() >0) {
			   openids = Arrays.asList(result.getData().getOpenid());
		   }
		}
		return openids;
	}
	
	@ApiOperation(value = "黑名单管理黑名单openid集合" , notes = "通过黑名单openid集合")
	public List<String> getBlackOpenIds(String begin_openid) {
		GetblacklistResult result = UserAPI.tagsMembersGetblacklist(wxUtil.getAccess_token(), begin_openid);
		List<String> blackOpenIds = null;
		if(result != null && result.getCount() >0) {
			blackOpenIds = Arrays.asList(result.getData().getOpenid());
		}
		return blackOpenIds;
	}
	

}
