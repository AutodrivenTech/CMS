/**
 * Project Name		:	CMS
 * File Name		:	BaseController.java
 * Package Name		:	com.huazhu.application.base.controller
 * Date				:	2018年7月11日下午7:07:52
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName		:	BaseController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午7:07:52 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/")
public class BaseController {
	@RequestMapping("/") 
	public String toIndex() {
		return "base/holle";
	}

	@RequestMapping("/desktop") 
	public String toDesktop() {
		return "base/desktop";
	}

	@RequestMapping("/user/toUserList") 
	public String toUserList() {
		return "user/userList";
	}
}
