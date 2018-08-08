package com.huazhu.application.cms.mess.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.common.BasicController;
import com.huazhu.application.cms.mess.dto.MessageDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.mess.entity.Message;
import com.huazhu.application.cms.mess.service.MessageService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "消息管理")
@RestController
@RequestMapping("/cms/mess/")
public class MessageController extends BasicController {
	
	@Autowired
	private MessageService messageService;
	
	@ApiOperation(value = "新增消息" , notes = "新增消息")
	@PostMapping("/addMessage")
	public Map<String,Object> addMessage(Message message){
		Map<String,Object> map = new HashMap<String,Object>();
		//message.setCreateUser(Long.valueOf(getUserId()));
		Integer result = messageService.insertMessage(message);
		if(message != null) {
			if(result != null && result >0) {
				map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
				map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "修改消息" , notes = "修改消息")
	@PostMapping("/editMessage")
	public Map<String,Object> editMessage(Message message){
		Map<String,Object> map = new HashMap<String,Object>();
	//	message.setLastUpdateUser(Long.valueOf(getUserId()));
		Integer result = messageService.updateMessageByRowId(message);
		if(message != null) {
			if(result != null && result >0) {
				map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
				map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "预览消息" , notes = "预览消息")
	@RequestMapping("/previewMaterial")
	public Map<String,Object> previewMaterial(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null) {
			MessageDTO data = messageService.queryMessageByRowId(rowId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "条件查询消息" , notes = "模糊条件查询消息列表")
	@RequestMapping("/getMaterialByConditions")
	public Map<String,Object> getMaterialByConditions(Message message,int pageNum,int limit){
		Map<String,Object> map = new HashMap<String,Object>();
		PageHelper.startPage(pageNum, limit);
		List<MessageDTO> pageMess = messageService.queryMessageByConditions(message,getUserInfo());
		PageInfo<MessageDTO> pageData = new PageInfo<MessageDTO>(pageMess);
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		map.put(Constant.RETURN_DATA, pageData);

		
		return map;
	}

	@ApiOperation(value = "删除消息")
	@PostMapping("/deleteMessage")
	public Map<String,Object> deleteMessage(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId!=null || rowId<=0){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		if(messageService.deleteMessageByRowId(rowId,getUserId())<=0){
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}else{
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}
		return map;
	}

	@ApiOperation(value = "推送消息")
	@PostMapping("/pushMessage")
	public Map<String,Object> pushMessage(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId!=null || rowId<=0){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		SysAccountInfo accountInfo=getUserInfo();
		messageService.pushMessage(rowId,accountInfo);
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);

		return map;
	}

	@ApiOperation(value = "审批")
	@PostMapping("/approve")
	public 	Map<String,Object> approve(Long rowId,Integer pushStatus){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId!=null || rowId<=0){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		messageService.approved(rowId, pushStatus,Long.valueOf(getUserId()));
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		return map;
	}


	@ApiOperation(value = "根据月份统计消息条数")
	@PostMapping("/getMessageCount")
	public 	Map<String,Object> getMessageCount(String date){
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtils.isBlank(date)){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		Integer messageCount =messageService.getMessageCount(date,getUserInfo());
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		map.put(Constant.RETURN_DATA,messageCount);
		return map;
	}




}
