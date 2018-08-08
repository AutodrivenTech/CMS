/**
 * Project Name		:	CMS
 * File Name		:	TreeStateData.java
 * Package Name		:	com.huazhu.application.common.data.format
 * Date				:	2018年7月11日下午6:57:29
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.common.data.format;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	TreeStateData <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:57:29 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class TreeStateData implements Serializable {

	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 指示一个节点是否处于checked状态，用一个checkbox图标表示。
	 */
	private Boolean checked;

	/**
	 * 指示一个节点是否处于disabled状态。（不是selectable，expandable或checkable）
	 */
	private Boolean disabled;

	/**
	 * 指示一个节点是否处于展开状态。
	 */
	private Boolean expanded;

	/**
	 * 指示一个节点是否可以被选择。
	 */
	private Boolean selected;
}
