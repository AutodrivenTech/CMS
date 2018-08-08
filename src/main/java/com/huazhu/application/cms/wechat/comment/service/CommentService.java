/**
 * Project Name		:	CMS
 * File Name		:	CommentService.java
 * Package Name		:	com.huazhu.application.cms.wechat.comment.service
 * Date				:	2018年8月3日上午9:35:25
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.comment.service;
/**
 * ClassName		:	CommentService <br/>
 * Function			:	评论业务接口. <br/>
 * Reason			:	处理和文章评论有关的业务逻辑。. <br/>
 * Date				:	2018年8月3日 上午9:35:25 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.wechat.comment.bo.param.ResConCommentParamBO;
import com.huazhu.application.cms.wechat.comment.entity.ResConComment;

public interface CommentService {
	/**
	 * 
	 * quartzPullAllComment		:	(定时拉取文章评论接口). <br/>
	 * 对全部已经推送成功的文章惊醒评论查询.<br/>
	 * 查询文章评论的顺序为按照文章发布的时间倒叙).<br/>
	 * 对于每篇文章本地已有缓存的评论不予查询.<br/>
	 * 查询操作采用异步的形式处理，防止调用者过长时间的等待.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return					:	操作结果 true 成功 false 失败
	 * 	如果返回成功，并不代表真正意义上的数据拉取完成，仅仅表示本次任务提交成功。
	 * @since					:	JDK 1.8
	 */
	Boolean quartzPullAllComment(Long conOrg);
	
	/**
	 * 
	 * selectData		:	(查询数据). <br/>
	 * 支持多条件复合查询. <br/>
	 * 支持分页功能. <br/>
	 *
	 * @author					:	Alex Hu
	 * @param param				:	查询参数
	 * @return					:	对应文章的留言内容
	 * @since					:	JDK 1.8
	 */
	PageInfo<ResConComment> selectData(ResConCommentParamBO param);
	
	/**
	 * 
	 * openComment		:	(开启留言功能). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param conId				:	要开启留言的文章id
	 * @return					:	留言开启结果
	 * @since					:	JDK 1.8
	 */
	Boolean openComment(Long conId);
	
	/**
	 * 
	 * closeComment		:	(关闭留言). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param conId				:	要关闭留言的文章id
	 * @return					:	留言关闭结果
	 * @since					:	JDK 1.8
	 */
	Boolean closeComment(Long conId);
	
	/**
	 * 
	 * markelect		:	(将留言标记为精选留言). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param comId				:	留言id
	 * @return					:	结果
	 * @since					:	JDK 1.8
	 */
	Boolean markelect(Long comId);
	
	/**
	 * 
	 * markelect		:	(将留言取消标记为精选留言). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param comId				:	留言id
	 * @return					:	结果
	 * @since					:	JDK 1.8
	 */
	Boolean unmarkelect(Long comId);
}
