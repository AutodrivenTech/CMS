package com.huazhu.application.cms.mess.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.mess.entity.Message;
import com.huazhu.application.cms.mess.service.MessageService;
import com.huazhu.application.utils.enums.PushStatus;
import com.huazhu.application.weixin.mess.service.SendMessageService;

import weixin.popular.bean.message.Article;
import weixin.popular.bean.message.MessageSendResult;

@Component
public class SendMessJobDetail implements Job {
	
	private static final Logger logger = LoggerFactory.getLogger(SendMessJobDetail.class); 
	
	@Autowired
	private SendMessageService sendMessageService;
	
	@Autowired
    private MessageService messageService;
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		Set<String> touser = (Set<String>) jobDataMap.get("touser");
		List<ArticleDTO> articles = (List<ArticleDTO>) jobDataMap.get("articles");
		Long messId = (Long) jobDataMap.get("messId");
		logger.info("touser:" + touser);
		logger.info("articles:" + articles);
		logger.info("messId:" + messId);
		List<Article> list = new ArrayList<Article>();
		for (ArticleDTO a : articles) {
			Article article = new Article();
			article.setTitle(a.getConTitle());
			article.setContent(a.getConDetail());
			article.setContent_source_url(a.getConUrl());
			article.setThumb_url(a.getThumbMediaId());
			if(a.getConMessage() != null && a.getConMessage() == 10) {
				article.setNeed_open_comment(1);
			}else {
				article.setNeed_open_comment(0);
			}
			if(a.getMessageType() != null && a.getMessageType() == 10) {
				article.setOnly_fans_can_comment(0);
			}else {
				article.setOnly_fans_can_comment(1);
			}
			article.setShow_cover_pic("0");
		}
		MessageSendResult result = sendMessageService.sendMessPicnews(list, touser);
		logger.info("SendMessJobDetail**result:" + result);
		Message message = new Message();
		message.setRowId(messId);
		message.setMsgId(result.getMsg_id());
		message.setMsgDataId(String.valueOf(result.getMsg_data_id()));
		message.setLastUpdateDate(new Date());
		if(result.getErrcode().equals("0")) {
			message.setPushStatus(PushStatus.ALREADY_PUS.getValue());
		}else {
			message.setPushStatus(PushStatus.PUSH_FAIL.getValue());
		}
		messageService.updateMessageByRowId(message);
	}

}
