package com.huazhu.application.weixin.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.MenuAPI;
import weixin.popular.bean.BaseResult;

@Service
public class MenuService {
	
	@Autowired
	private WXAccessTokenUtil util;
	
	/**
	 * 创建菜单
	 * @param menuJson
	 * @return
	 */
	public BaseResult menuCreate(String menuJson) {
		return MenuAPI.menuCreate(util.getAccess_token(), menuJson);
	}

}
