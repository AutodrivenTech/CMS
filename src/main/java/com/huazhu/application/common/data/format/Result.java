/**
 * Project Name		:	global-common
 * File Name		:	Result.java
 * Package Name		:	com.longkeinfo.global.common.data.format.http
 * Date				:	2018年7月16日上午9:53:10
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.common.data.format;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	Result <br/>
 * Function			:	结果实体类. <br/>
 * Reason			:	使用泛型. <br/>
 * Date				:	2018年7月16日 上午9:53:10 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class Result<T> implements Serializable {
	/** 
	 * serialVersionUID			:	序列号.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	private Integer code;

	private String msg;

	private T data;
}
