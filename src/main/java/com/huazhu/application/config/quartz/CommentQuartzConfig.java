/**
 * Project Name		:	CMS
 * File Name		:	CommentQuartzConfig.java
 * Package Name		:	com.huazhu.application.config.quartz
 * Date				:	2018年8月3日上午9:42:42
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.config.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huazhu.application.cms.wechat.comment.service.CommentService;

/**
 * ClassName		:	CommentQuartzConfig <br/>
 * Function			:	评论定时器配置. <br/>
 * Date				:	2018年8月3日 上午9:42:42 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 *
 */
@Component
@Configurable
@EnableScheduling
public class CommentQuartzConfig {

	@Autowired
	private CommentService commentService;

	//  每分钟启动
	@Scheduled(cron = "*/1 * * * * ?")
	public void timerToNow(){
		commentService.quartzPullAllComment(null);
	}
}
