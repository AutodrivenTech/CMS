/**
 * Project Name		:	CMS
 * File Name		:	DataResult.java
 * Package Name		:	com.huazhu.application.common.data.format
 * Date				:	2018年7月11日下午7:09:41
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.common.data.format;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	DataResult <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午7:09:41 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class DataResult<T> implements Serializable {
	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	public static final String SUCCESS_CODE = "00000";

	public static final String ERROR_CODE = "10000";

	public static final String SUCCESS_INFO = "请求成功";

	public static final String ERROR_INFO = "请求失败";

	/**
	 * 返回编码
	 */
	private String code;

	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 返回的对象
	 */
	private T obj;

	/**
	 * 数据签名
	 */
	private String sign;

	public DataResult(String code, String msg, T obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}

	public DataResult() {
		super();
	}

	public static DataResult<Object> success(String msg,Object obj) {
		return new DataResult<Object>(SUCCESS_CODE, msg, obj);
	}

	public static DataResult<Object> error(String msg,Object obj) {
		return new DataResult<Object>(ERROR_CODE, msg, obj);
	}
}
