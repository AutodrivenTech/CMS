/**
 * Project Name		:	CMS
 * File Name		:	HotelInfoReportParamBO.java
 * Package Name		:	com.huazhu.application.cms.wechat.dashboard.bo.param
 * Date				:	2018年8月1日上午9:53:17
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.dashboard.bo.param;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	HotelInfoReportParamBO <br/>
 * Function			:	首页酒店信息统计报表业务参数. <br/>
 * Date				:	2018年8月1日 上午9:53:17 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class HotelInfoReportParamBO implements Serializable {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分页页码
	 */
	private Integer pageNumber;
	
	/**
	 * 分页大小
	 */
	private Integer pageSize;
	
	private Long brandId;
}
