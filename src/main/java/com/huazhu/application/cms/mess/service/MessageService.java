package com.huazhu.application.cms.mess.service;

import java.util.List;

import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.mess.dto.MessageDTO;
import com.huazhu.application.cms.mess.entity.Message;

public interface MessageService {

	MessageDTO queryMessageByRowId(Long rowId);

	List<MessageDTO> queryMessageByConditions(Message message,SysAccountInfo accountInfo);

	Integer insertMessage(Message message);

	Integer updateMessageByRowId(Message message);

	Integer deleteMessageByRowId(Long rowId,Integer userId);

	void pushMessage(Long rowId,SysAccountInfo accountInfo);

	Integer approved(Long rowId,Integer pushStatus,Long userId);

	Integer getMessageCount(String month,SysAccountInfo sysAccountInfo);

	void setMessageExpire();


}
