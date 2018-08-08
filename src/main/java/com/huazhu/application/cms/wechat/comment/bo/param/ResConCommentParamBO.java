/**
 * Project Name		:	CMS
 * File Name		:	ResConCommentParamBO.java
 * Package Name		:	com.huazhu.application.cms.wechat.comment.bo.param
 * Date				:	2018年8月6日上午10:13:42
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.comment.bo.param;

import java.io.Serializable;

import com.huazhu.application.cms.wechat.comment.entity.ResConComment;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	ResConCommentParamBO <br/>
 * Function			:	留言业务参数对象. <br/>
 * Date				:	2018年8月6日 上午10:13:42 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class ResConCommentParamBO extends ResConComment implements Serializable{

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 分页页码，默认第一页
	 */
	private Integer pageNumber = 1;
	
	/**
	 * 分页大小，默认每页显示10条数据
	 */
	private Integer pageSize = 10;
}
