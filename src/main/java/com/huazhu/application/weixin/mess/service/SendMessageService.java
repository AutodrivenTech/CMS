package com.huazhu.application.weixin.mess.service;

import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;
import com.huazhu.application.weixin.material.service.WXMaterialService;

import weixin.popular.api.MediaAPI;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.media.Media;
import weixin.popular.bean.message.Article;
import weixin.popular.bean.message.MessageSendResult;
import weixin.popular.bean.message.massmessage.MassMPnewsMessage;
import weixin.popular.bean.message.massmessage.MassTextMessage;
import weixin.popular.bean.message.preview.MpnewsPreview;
import weixin.popular.bean.message.preview.Preview;
@Service
public class SendMessageService {
	
	@Autowired
	private WXAccessTokenUtil util;
	
	@Autowired
	private WXMaterialService wxMaterialService;
	
	/**
	 * 图文消息media_id
	 * @param articles
	 * @return
	 */
	public Media mediaUploadnews(List<Article> articles) {
		return MediaAPI.mediaUploadnews(util.getAccess_token(), articles);
	}
	
	/**
	 * 永久素材，推送文章
	 * @param articles
	 * @param touser
	 * @return
	 */
	public MessageSendResult sendMessPicnews(List<Article> articles,Set<String> touser) {
		MassMPnewsMessage massMessage = new MassMPnewsMessage(wxMaterialService.add_news(articles).getMedia_id());
		massMessage.setTouser(touser);
		return MessageAPI.messageMassSend(util.getAccess_token(), massMessage);
	}
	
	/**
	 * 临时素材，推送文章
	 * @param articles
	 * @param touser
	 * @return
	 */
	public MessageSendResult sendMessPicnewsTemp(List<Article> articles,Set<String> touser) {
		MassMPnewsMessage massMessage = new MassMPnewsMessage(mediaUploadnews(articles).getMedia_id());
		massMessage.setTouser(touser);
		return MessageAPI.messageMassSend(util.getAccess_token(), massMessage);
	}
	
	/**
	 * 文本推送
	 * @param content
	 * @param touser
	 * @return
	 */
	public MessageSendResult sendTest(String content,Set<String> touser){
		MassTextMessage massMessage = new MassTextMessage(content);
		massMessage.setTouser(touser);
		return MessageAPI.messageMassSend(util.getAccess_token(), massMessage);
	}
	
	/**
	 * 预览接口
	 * @param preview
	 * @return
	 */
	public MessageSendResult messageMassPreview(MpnewsPreview preview){
		return MessageAPI.messageMassPreview(util.getAccess_token(), preview);
	}

}
