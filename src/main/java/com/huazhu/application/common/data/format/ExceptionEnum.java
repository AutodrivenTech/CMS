/**
 * Project Name		:	global-common
 * File Name		:	ExceptionEnum.java
 * Package Name		:	com.longkeinfo.global.common.exception
 * Date				:	2018年7月16日上午9:46:13
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.common.data.format;

/**
 * ClassName		:	ExceptionEnum <br/>
 * Function			:	异常枚举. <br/>
 * Reason			:	便于维护. <br/>
 * Date				:	2018年7月16日 上午9:46:13 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public enum ExceptionEnum {
	UNKONW_ERROR(-1,"未知错误"),
	PARAM_ERROR(99,"参数错误"),
	BUSINESS_ERROR(100,"业务处理异常"),
	LOGIN_ERROR(101,"登陆处理异常"),
	SUCCESS(0,"成功"),
	;

	private Integer code;

	private String msg;

	ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
