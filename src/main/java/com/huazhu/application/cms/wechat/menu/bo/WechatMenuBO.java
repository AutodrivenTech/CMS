/**
 * Project Name		:	CMS
 * File Name		:	WechatMenuBO.java
 * Package Name		:	com.huazhu.application.cms.wechat.menu.bo
 * Date				:	2018年7月30日下午7:45:24
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.menu.bo;

import java.io.Serializable;
import java.util.List;

import com.huazhu.application.cms.wechat.menu.entity.WechatMenu;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	WechatMenuBO <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月30日 下午7:45:24 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class WechatMenuBO extends WechatMenu implements Serializable {
	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	private List<WechatMenuBO> children;
}
