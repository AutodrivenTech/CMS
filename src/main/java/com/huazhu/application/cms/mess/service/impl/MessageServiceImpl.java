package com.huazhu.application.cms.mess.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.dto.ArticleListDTO;
import com.huazhu.application.cms.article.service.ArticleListService;
import com.huazhu.application.cms.article.service.ArticleService;
import com.huazhu.application.cms.customer.service.CusInfoService;
import com.huazhu.application.cms.mess.dto.MessageDTO;
import com.huazhu.application.cms.mess.job.SendMessJobDetail;
import com.huazhu.application.quartz.QuartzUtil;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.EnumUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import com.huazhu.application.utils.enums.ArticleTypeEnum;
import com.huazhu.application.utils.enums.PushStatus;
import com.huazhu.application.utils.enums.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.mess.dao.MessageMapper;
import com.huazhu.application.cms.mess.entity.Message;
import com.huazhu.application.cms.mess.service.MessageService;


@Service
public class MessageServiceImpl implements MessageService {
    
	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private CusInfoService cusInfoService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleListService articleListService;

	@Autowired
	private SendMessJobDetail sendMessJobDetail;

	@Autowired
	private QuartzUtil quartzUtil;

	@Override
	public MessageDTO queryMessageByRowId(Long rowId) {
		return messageMapper.queryMessageByRowId(rowId);
	}

	@Override
	public List<MessageDTO> queryMessageByConditions(Message message,SysAccountInfo accountInfo) {
		message.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		/*if(accountInfo.getUserType()==UserTypeEnum.SUBSIDIARY.getValue()){
			message.setConOrg(accountInfo.getUserOrg());
			message.setOrgType(UserTypeEnum.SUBSIDIARY.getValue());
		}*/
		List<MessageDTO> messageDTOS=messageMapper.queryMessageByConditions(message);
		return messageDTOS;
	}

	@Override
	public Integer insertMessage(Message message) {
		message.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		message.setCreateDate(DateUtil.getCurrentTime());
		message.setPushStatus(PushStatus.AUFDIT.getValue());
		return messageMapper.insertMessage(message);
	}

	@Override
	public Integer updateMessageByRowId(Message message) {
		message.setLastUpdateDate(DateUtil.getCurrentTime());
		MessageDTO messageInfo=this.queryMessageByRowId(message.getRowId());
		if(messageInfo.getPushStatus()==PushStatus.REJECTED.getValue()){
			message.setPushStatus(PushStatus.AUFDIT.getValue());
		}
		return messageMapper.updateMessageByRowId(message);
	}

	@Override
	public Integer deleteMessageByRowId(Long rowId,Integer userId) {
		return messageMapper.updateMessageByRowId(new Message(){{
			setRowId(rowId);
			setLastUpdateUser(Long.valueOf(userId));
			setLastUpdateDate(DateUtil.getCurrentTime());
			setActiveFlag(ActiveFlagEnum.DELETE.getValue());
		}});
	}

	@Override
	public void pushMessage(Long rowId, SysAccountInfo accountInfo) {
		MessageDTO messageDTO=this.queryMessageByRowId(rowId);
		List<String> openIds=new ArrayList<>();
		//10 集团总公司账户
		if(accountInfo.getUserType()==UserTypeEnum.GROUP.getValue()){
			//查询所有酒店的
			openIds=cusInfoService.getCusInfo(messageDTO.getFansFilteId());
		}else{
			//子酒店
			openIds=cusInfoService.getCusOpenId(accountInfo.getUserOrg());
		}
		//查询文章
		List<ArticleDTO> articleDTOList=new ArrayList<>();
		if(messageDTO.getPushType()==ArticleTypeEnum.ARTICLE.getValue()){
			ArticleDTO articleDTO=articleService.queryArticleByRowId(messageDTO.getPushCon().intValue());
			articleDTOList.add(articleDTO);
		}else{
			ArticleListDTO articleListDTO=articleListService.getArticleListDetail(messageDTO.getPushCon().intValue());
			articleDTOList.addAll(articleListDTO.getArticleList());
		}
		//推送消息
		quartzUtil.addJob(sendMessJobDetail,messageDTO.getPushTime(),"pushMessage","push","推送消息",new HashSet(openIds),articleDTOList,messageDTO.getRowId());

	}

	@Override
	public Integer approved(Long rowId, Integer pushStatus, Long userId) {
		Message message=new Message();
		if(pushStatus==PushStatus.WAIT_PUSH.getValue()){
			message.setPushStatus(PushStatus.WAIT_PUSH.getValue());
		}else{
			message.setPushStatus(PushStatus.REJECTED.getValue());
		}
		message.setLastUpdateDate(DateUtil.getCurrentTime());
		message.setLastUpdateUser(userId);
		return messageMapper.updateMessageByRowId(message);
	}

	@Override
	public Integer getMessageCount(String date,SysAccountInfo sysAccountInfo) {
		String status=EnumUtil.combineCode(PushStatus.AUFDIT.getValue(),PushStatus.ALREADY_PUS.getValue(),PushStatus.WAIT_PUSH.getValue(),PushStatus.REJECTED.getValue());
		Integer messageCount=messageMapper.getMessageCountByDate(date,status,sysAccountInfo.getUserOrg());
		return messageCount;
	}

	@Override
	public void setMessageExpire() {
		List<MessageDTO> messageDTOS=messageMapper.getMessageByExpire();
		messageDTOS.forEach(messageDTO -> {
			messageMapper.updateMessageByRowId(new Message(){{
				setRowId(messageDTO.getRowId());
				setPushStatus(PushStatus.EXPIRE.getValue());
				setLastUpdateDate(DateUtil.getCurrentTime());
			}});
		});
	}

}
