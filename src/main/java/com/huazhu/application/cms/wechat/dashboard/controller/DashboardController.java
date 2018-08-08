/**
 * Project Name		:	CMS
 * File Name		:	DashboardController.java
 * Package Name		:	com.huazhu.application.cms.wechat.dashboard.controller
 * Date				:	2018年8月1日上午9:31:11
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.wechat.dashboard.bo.param.HotelInfoReportParamBO;
import com.huazhu.application.cms.wechat.dashboard.bo.result.HotelInfoReportResultBO;
import com.huazhu.application.cms.wechat.dashboard.service.DashboardService;
import com.huazhu.application.common.data.format.ExceptionEnum;
import com.huazhu.application.common.data.format.Result;
import com.huazhu.application.common.data.format.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName		:	DashboardController <br/>
 * Function			:	首页仪表盘页面接口. <br/>
 * Reason			:	提供首页仪表盘页面相关图表数据. <br/>
 * Date				:	2018年8月1日 上午9:31:11 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Api(value = "仪表盘管理")
@RestController
@RequestMapping("/api/cms/wechat/dashboard")
@SuppressWarnings("unchecked")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	/**
	 * 
	 * selectCommentWithPage		:	(首页酒店信息统计图). <br/>
	 * 以酒店为基础查询以下内容.<br/>
	 * 	酒店目前的关注着数量.<br/>
	 * 	不包含当前周的近四周的每周的关注数/取消关注数较上一周的增减量.<br/>
	 * 	包含当前月在内的近三个月的每月剩余消息推送量.<br/>
	 * 查询结果支持分页功能.<br/>
	 * 默认排序方式为以酒店为基础做数据库默认排序.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param param				:	参数信息
	 * @return					:	包含统计结果的分页列表集合
	 * @since					:	JDK 1.8
	 */
	@ApiOperation(value = "酒店信息统计" , notes = "酒店信息统计")
	@GetMapping("/hotel/report")
	public Result<PageInfo<HotelInfoReportResultBO>> selectHotelInfoReportWithPage(HotelInfoReportParamBO param){
		if (param.getBrandId() == null || param.getBrandId() == 0) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		if (param.getPageNumber() == null || param.getPageNumber() == 0) {
			param.setPageNumber(1);
		}
		if (param.getPageSize() == null || param.getPageSize() == 0) {
			param.setPageSize(10);
		}
		return ResultUtil.success(dashboardService.selectHotelInfoReportWithPage(param));
	}
}
