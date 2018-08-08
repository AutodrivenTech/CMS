/**
 * Project Name		:	CMS
 * File Name		:	CusInfoParamDTO.java
 * Package Name		:	com.huazhu.application.cms.customer.dto.customer.result
 * Date				:	2018年7月11日下午6:07:31
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.customer.dto.customer.param;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	CusInfoParamDTO <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:07:31 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class CusInfoParamDTO implements Serializable {

	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	private int draw;
	
	private int start;
	
	private int length;
}
