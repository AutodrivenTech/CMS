/**
 * Project Name		:	CMS
 * File Name		:	DataTable.java
 * Package Name		:	com.huazhu.application.common.data.format
 * Date				:	2018年7月11日下午6:11:17
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.common.data.format;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	DataTable <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:11:17 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class DataTable<T> implements Serializable {/** 
 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
 * @since			:	JDK 1.8
 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
	private int draw;

	/**
	 * 每页的行数
	 */
	private int recordsFiltered;

	/**
	 * 数据总数
	 */
	private int recordsTotal;

	/**
	 * 数据列表
	 */
	private List<T> data;
}
