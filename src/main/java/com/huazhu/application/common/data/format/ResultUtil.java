/**
 * Project Name		:	global-common
 * File Name		:	ResultUtil.java
 * Package Name		:	com.longkeinfo.global.common.utils.http
 * Date				:	2018年7月16日上午10:43:38
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.common.data.format;


/**
 * ClassName		:	ResultUtil <br/>
 * Function			:	结果封装，统一输出结果以及异常. <br/>
 * Date				:	2018年7月16日 上午10:43:38 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ResultUtil {
	public static Result success(Object object){
		Result result = new Result();
		result.setCode(0);
		result.setMsg("success");
		result.setData(object);
		return result;
	}

	public static Result success(){
		return success(null);
	}

	public static Result error(Integer code,String msg){
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

	public static Result error(ExceptionEnum exceptionEnum){
		Result result = new Result();
		result.setCode(exceptionEnum.getCode());
		result.setMsg(exceptionEnum.getMsg());
		result.setData(null);
		return result;
	}
}
