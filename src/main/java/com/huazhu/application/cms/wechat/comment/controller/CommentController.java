/**
 * Project Name		:	CMS
 * File Name		:	CommentController.java
 * Package Name		:	com.huazhu.application.cms.wechat.comment.controller
 * Date				:	2018年7月31日下午5:04:00
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.wechat.comment.bo.param.ResConCommentParamBO;
import com.huazhu.application.cms.wechat.comment.entity.ResConComment;
import com.huazhu.application.cms.wechat.comment.service.CommentService;
import com.huazhu.application.common.data.format.ExceptionEnum;
import com.huazhu.application.common.data.format.Result;
import com.huazhu.application.common.data.format.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import weixin.popular.bean.comment.CommentListResult;

/**
 * ClassName		:	CommentController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月31日 下午5:04:00 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Api(value = "留言管理")
@RestController
@RequestMapping("/api/cms/wechat/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	/**
	 * 
	 * selectCommentWithPage		:	(查询留言列表). <br/>
	 * 支持分页查询.<br/>
	 * 支持按照某篇文章查询.<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@ApiOperation(value = "查询" , notes = "查询")
	@GetMapping
	public Result<CommentListResult> selectCommentWithPage(ResConCommentParamBO param){
		PageInfo<ResConComment> pageInfo = commentService.selectData(param);
		if (pageInfo == null) {
			ResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return ResultUtil.success(pageInfo);
	}

	/**
	 * 
	 * openComment		:	(开启留言功能). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param conId
	 * @return
	 * @since					:	JDK 1.8
	 */
	@PutMapping("/open/{conId}")
	public Result<Boolean> openComment(@PathVariable Long conId){
		if (conId == null) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		Boolean flag = commentService.openComment(conId);
		if (!flag) {
			return ResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return ResultUtil.success(true);
	}
	
	/**
	 * 
	 * closeComment		:	(关闭留言功能). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param conId
	 * @return
	 * @since					:	JDK 1.8
	 */
	@PutMapping("/close/{conId}")
	public Result<Boolean> closeComment(@PathVariable("conId") Long conId){
		if (conId == null) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		Boolean flag = commentService.closeComment(conId);
		if (!flag) {
			return ResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return ResultUtil.success(true);
	}
	
	/**
	 * 
	 * markelect		:	(留言设为精选). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param comId
	 * @return
	 * @since					:	JDK 1.8
	 */
	@PutMapping("/markelect/{comId}")
	public Result<Boolean> markelect(@PathVariable Long comId){
		if (comId == null) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		Boolean flag = commentService.markelect(comId);
		if (!flag) {
			return ResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return ResultUtil.success(true);
	}
	
	/**
	 * 
	 * unmarkelect		:	(移除精选留言). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param comId
	 * @return
	 * @since					:	JDK 1.8
	 */
	@PutMapping("/unmarkelect/{comId}")
	public Result<Boolean> unmarkelect(@PathVariable Long comId){
		if (comId == null) {
			return ResultUtil.error(ExceptionEnum.PARAM_ERROR);
		}
		Boolean flag = commentService.unmarkelect(comId);
		if (!flag) {
			return ResultUtil.error(ExceptionEnum.BUSINESS_ERROR);
		}
		return ResultUtil.success(true);
	}
}
