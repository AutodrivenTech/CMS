package com.huazhu.application.weixin.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import weixin.popular.api.SnsAPI;
import weixin.popular.bean.sns.SnsToken;

@Service
public class WebPageAuthService {
	
	@Value(value = "${weixin.appid}")
	private String wxappid;
	
	@Value(value = "${weixin.appsecret}")
	private String wxappsecret;
	
	/**
	 * 生成网页授权 URL  (第三方平台开发)
	 * @param redirect_uri 自动URLEncoder
	 * @param state 可以为空
	 * @param component_appid 第三方平台开发，可以为空。
	 * 			 服务方的appid，在申请创建公众号服务成功后，可在公众号服务详情页找到
	 * @return url
	 */
	public String connectOauth2Authorize(String redirect_uri,String state,String component_appid){
		return SnsAPI.connectOauth2Authorize(wxappid, redirect_uri, false, state, component_appid);
	}
	
	/**
	 * 
	 * @param code 
	 * @return
	 */
	public SnsToken oauth2AccessToken(String code){
		return SnsAPI.oauth2AccessToken(wxappid, wxappsecret, code);
	}

}
