/**
 * Project Name		:	CMS
 * File Name		:	WeChatMenuController.java
 * Package Name		:	com.huazhu.application.cms.wechat.menu.controller
 * Date				:	2018年7月30日下午7:31:53
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.wechat.menu.bo.WechatMenuBO;
import com.huazhu.application.cms.wechat.menu.entity.WechatMenu;
import com.huazhu.application.cms.wechat.menu.service.WeChatMenuService;
import com.huazhu.application.common.data.format.ExceptionEnum;
import com.huazhu.application.common.data.format.Result;
import com.huazhu.application.common.data.format.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName		:	WeChatMenuController <br/>
 * Function			:	微信菜单接口. <br/>
 * Date				:	2018年7月30日 下午7:31:53 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Api(value = "微信菜单")
@RestController
@RequestMapping("/api/cms/wechat/menu")
public class WeChatMenuController {

	@Autowired
	private WeChatMenuService weChatMenuService;

	/**
	 * 
	 * selectAllDataListWithRecursion		:	(查询说有数据并返回递归格式的数据列表). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@ApiOperation(value = "查询" , notes = "查询")
	@GetMapping
	public Result<List<WechatMenuBO>> selectAllDataListWithRecursion(){
		return ResultUtil.success(weChatMenuService.selectAllDataListWithRecursion());
	}

	@ApiOperation(value = "新增" , notes = "新增")
	@PostMapping
	public Result<Boolean> addWeChatMenu(WechatMenu wechatMenu){
		System.out.println(wechatMenu);
		if (!this.checkParamWithAddWeChatMenu(wechatMenu)) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		
		return ResultUtil.success(weChatMenuService.addWeChatMenu(wechatMenu));
	}

	@ApiOperation(value = "修改" , notes = "修改")
	@PutMapping
	public Result<Boolean> updateWeChatMenu(WechatMenu wechatMenu){
		if (!this.checkParamWithUpdateWeChatMenu(wechatMenu)) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		
		return ResultUtil.success(weChatMenuService.updateWeChatMenu(wechatMenu));
	}

	@ApiOperation(value = "删除" , notes = "删除")
	@DeleteMapping("/{rowId}")
	public Result<Boolean> deleteWeChatMenu(@PathVariable("rowId") Long rowId){
		if (rowId == null) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		return ResultUtil.success(weChatMenuService.deleteWeChatMenu(rowId));
	}
	
	private Boolean checkParamWithAddWeChatMenu(WechatMenu wechatMenu) {
		if (wechatMenu == null) {
			return false;
		}
		
		if (StringUtils.isEmpty(wechatMenu.getMenuName())) {
			return false;
		}
		
		if (StringUtils.isEmpty(wechatMenu.getMenuType())) {
			return false;
		}
		
		if (wechatMenu.getOrderNum() == null) {
			return false;
		}
		
		return true;
	}
	
	private Boolean checkParamWithUpdateWeChatMenu(WechatMenu wechatMenu) {
		if (wechatMenu == null) {
			return false;
		}
		
		if (StringUtils.isEmpty(wechatMenu.getRowId())) {
			return false;
		}
		
		return true;
	}
}
