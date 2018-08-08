package com.huazhu.application.cms.mess.dao;

import java.util.List;

import com.huazhu.application.cms.mess.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.mess.entity.Message;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper {

	MessageDTO queryMessageByRowId(@Param("rowId") Long rowId);
	
	List<MessageDTO> queryMessageByConditions(Message message);
	
	Integer insertMessage(Message message);
	
	Integer updateMessageByRowId(Message message);

	Integer getMessageCountByDate(@Param("date") String date,@Param("status")String status,@Param("hotelId")Integer hotelId);

	List<MessageDTO> getMessageByExpire();


}
