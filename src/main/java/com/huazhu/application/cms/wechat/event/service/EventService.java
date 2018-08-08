/**
 * Project Name		:	CMS
 * File Name		:	EventService.java
 * Package Name		:	com.huazhu.application.cms.wechat.event.service
 * Date				:	2018年7月31日上午9:44:16
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.wechat.event.service;
/**
 * ClassName		:	EventService <br/>
 * Function			:	事件响应接口. <br/>
 * Reason			:	定义微信相关的事件响应的业务逻辑. <br/>
 * Date				:	2018年7月31日 上午9:44:16 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface EventService {
	
	/**
	 * 
	 * subscribe		:	(关注/订阅接口). <br/>
	 * 当用户通过搜索公众号并进行关注时触发此接口的业务逻辑.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param openId			:	关注着的微信openid
	 * @return					:	业务处理是否成功
	 * @since					:	JDK 1.8
	 */
	Boolean subscribe(String openId);
	
	/**
	 * 
	 * unsubscribe		:	(取消关注/取消订阅接口). <br/>
	 * 当用户通过搜索公众号主动取消关注时触发此接口的业务逻辑.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param openId			:	关注着的微信openid
	 * @return					:	业务处理是否成功
	 * @since					:	JDK 1.8
	 */
	Boolean unsubscribe(String openId);
	
	/**
	 * 
	 * subscribeByQR		:	(通过扫描带有场景值的二维码事件接口). <br/>
	 * 当用户通过通过扫描带有场景值的二维码时触发此接口的业务逻辑.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param openId			:	关注着的微信openid
	 * @param qrscene			:	二维码的场景值 格式：qrscene_为前缀，后面为二维码的参数值
	 * @return					:	业务处理是否成功
	 * @since					:	JDK 1.8
	 */
	Boolean subscribeByQR(String openId, String qrscene);
}
