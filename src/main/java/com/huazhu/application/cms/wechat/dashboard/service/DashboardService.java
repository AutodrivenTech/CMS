/**
 * Project Name		:	CMS
 * File Name		:	DashboardService.java
 * Package Name		:	com.huazhu.application.cms.wechat.dashboard.service
 * Date				:	2018年8月1日上午9:57:39
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.dashboard.service;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.wechat.dashboard.bo.param.HotelInfoReportParamBO;
import com.huazhu.application.cms.wechat.dashboard.bo.result.HotelInfoReportResultBO;

/**
 * ClassName		:	DashboardService <br/>
 * Function			:	仪表盘页面业务处理接口. <br/>
 * Reason			:	定义和暴漏仪表盘界面的业务处理功能. <br/>
 * Date				:	2018年8月1日 上午9:57:39 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface DashboardService {
	/**
	 * 
	 * selectHotelInfoReportWithPage		:	(首页酒店信息统计图). <br/>
	 * 以酒店为基础查询以下内容.<br/>
	 * 	酒店目前的关注着数量.<br/>
	 * 	不包含当前周的近四周的每周的关注数/取消关注数较上一周的增减量.<br/>
	 * 	包含当前月在内的近三个月的每月剩余消息推送量.<br/>
	 * 查询结果支持分页功能.<br/>
	 * 默认排序方式为以酒店为基础做数据库默认排序.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param param				:	查询参数
	 * @return					:	包含分页信息的业务结果对象
	 * @since					:	JDK 1.8
	 */
	PageInfo<HotelInfoReportResultBO> selectHotelInfoReportWithPage(HotelInfoReportParamBO param);
}
