/**
 * Project Name		:	CMS
 * File Name		:	WeChatMenuService.java
 * Package Name		:	com.huazhu.application.cms.wechat.menu.service
 * Date				:	2018年7月30日下午7:44:28
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.menu.service;
/**
 * ClassName		:	WeChatMenuService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月30日 下午7:44:28 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */

import java.util.List;

import com.huazhu.application.cms.wechat.menu.bo.WechatMenuBO;
import com.huazhu.application.cms.wechat.menu.entity.WechatMenu;

public interface WeChatMenuService {
	List<WechatMenuBO> selectAllDataListWithRecursion();
	
	Boolean addWeChatMenu(WechatMenu wechatMenu);
	
	Boolean updateWeChatMenu(WechatMenu wechatMenu);
	
	Boolean deleteWeChatMenu(Long rowId);
}
