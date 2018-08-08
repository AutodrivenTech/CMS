/**
 * Project Name		:	CMS
 * File Name		:	SysMenuService.java
 * Package Name		:	com.huazhu.application.cms.system.service
 * Date				:	2018年7月11日下午6:55:16
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.system.service;

import java.util.List;

import com.huazhu.application.base.service.BaseService;
import com.huazhu.application.cms.system.entity.SysMenuInfo;
import com.huazhu.application.common.data.format.TreeData;

/**
 * ClassName		:	SysMenuService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:55:16 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SysMenuService extends BaseService<SysMenuInfo> {
	/**
	 * 
	 * selectAllMenuWithTreeByPermission		:	(查询所有菜单信息). <br/>
	 * 递归查询.<br/>
	 * 通过权限过滤.<br/>
	 * 返回树形格式.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param languageType		: 	查询语言类型 1 中文 2 英文
	 * @return
	 * @since					:	JDK 1.8
	 *
	 */
	List<TreeData> selectAllMenuWithTreeByPermission(Byte languageType);
}
