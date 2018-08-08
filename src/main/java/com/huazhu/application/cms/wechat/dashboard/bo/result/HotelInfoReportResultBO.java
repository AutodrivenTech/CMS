/**
 * Project Name		:	CMS
 * File Name		:	HotelInfoReportResultBO.java
 * Package Name		:	com.huazhu.application.cms.wechat.dashboard.bo.result
 * Date				:	2018年8月1日上午9:50:48
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.dashboard.bo.result;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.huazhu.application.cms.organization.entity.Hotel;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName		:	HotelInfoReportResultBO <br/>
 * Function			:	首页酒店信息统计报表业务结果. <br/>
 * Date				:	2018年8月1日 上午9:50:48 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Data
@ToString
public class HotelInfoReportResultBO implements Serializable {

	/** 
	 * serialVersionUID			:	序列化.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 酒店信息
	 */
	private Hotel hotel;

	/**
	 * 酒店客户数量
	 */
	private Integer customerCount;
	
	/**
	 * 客户变化情况
	 * key：时间周期
	 * value：增量，减量
	 */
	private Map<String, String> customerChange;
	
	private Map<String, String> hotelMeg;
}
