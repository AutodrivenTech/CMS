/**
 * Project Name		:	CMS
 * File Name		:	TreeData.java
 * Package Name		:	com.huazhu.application.common.data.format
 * Date				:	2018年7月11日下午6:56:05
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.common.data.format;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName		:	TreeData <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:56:05 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class TreeData implements Serializable {

	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * 列表树节点上的文本，通常是节点右边的文本。
	 */
	private String text;

	/**
	 * 列表树节点上的图标，通常是节点左边的小图标。
	 */
	private String icon;

	/**
	 * 当某个节点被选择后显示的图标，通常是节点左边的小图标。
	 */
	private String selectedIcon;

	/**
	 * 结合全局enableLinks选项为列表树节点指定URL。
	 */
	private String href;

	/**
	 * 指定列表树的节点是否可选择。设置为false将使节点展开，并且不能被选择。
	 */
	private Boolean selectable;

	/**
	 * 一个节点的初始状态。
	 */
	private TreeStateData state;

	/**
	 * 节点的前景色，覆盖全局的前景色选项。
	 */
	private String color;

	/**
	 * 节点的背景色，覆盖全局的背景色选项。
	 */
	private String backColor;

	/**
	 * 通过结合全局showTags选项来在列表树节点的右边添加额外的信息。
	 */
	private String[] tags;

	/**
	 * 孩子节点
	 */
	private List<TreeData> nodes;
}
