/**
 * Project Name		:	CMS
 * File Name		:	SysMenuController.java
 * Package Name		:	com.huazhu.application.cms.system.controller
 * Date				:	2018年7月11日下午7:10:46
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.system.service.SysMenuService;
import com.huazhu.application.common.data.format.DataResult;
import com.huazhu.application.common.data.format.TreeData;

/**
 * ClassName		:	SysMenuController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午7:10:46 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@RestController
@RequestMapping(value = "/system/menu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;

	@GetMapping(value={"/all/{languageType}"})
	public DataResult<List<TreeData>> selectAllMenuWithTreeByPermission(@PathVariable("languageType") byte languageType) {
		DataResult<List<TreeData>> res = new DataResult<List<TreeData>>(DataResult.SUCCESS_CODE, DataResult.SUCCESS_INFO, sysMenuService.selectAllMenuWithTreeByPermission(languageType));
		return res;
	}
}
