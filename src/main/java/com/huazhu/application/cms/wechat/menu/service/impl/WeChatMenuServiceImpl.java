/**
 * Project Name		:	CMS
 * File Name		:	WeChatMenuServiceImpl.java
 * Package Name		:	com.huazhu.application.cms.wechat.menu.service
 * Date				:	2018年7月30日下午7:47:56
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.menu.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.wechat.menu.bo.WechatMenuBO;
import com.huazhu.application.cms.wechat.menu.dao.WechatMenuMapper;
import com.huazhu.application.cms.wechat.menu.entity.WechatMenu;
import com.huazhu.application.cms.wechat.menu.entity.WechatMenuExample;
import com.huazhu.application.cms.wechat.menu.service.WeChatMenuService;

/**
 * ClassName		:	WeChatMenuServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月30日 下午7:47:56 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class WeChatMenuServiceImpl implements WeChatMenuService {
	
	@Autowired
	private WechatMenuMapper wechatMenuMapper;

	/**
	 * 查询说有数据并返回递归格式的数据列表 .<br />
	 * 1. 查询一级菜单列表.<br />
	 * 2. 循环一级菜单列表.<br />
	 * 3. 查询二级菜单列表.<br />
	 * 4. 循环并封装二级菜单列表并赋给父菜单对象中.<br />
	 * 5. 封装返回对象并返回.<br />
	 *
	 * @see com.huazhu.application.cms.wechat.menu.service.WeChatMenuService#selectAllDataListWithRecursion()
	 */
	@Override
	public List<WechatMenuBO> selectAllDataListWithRecursion() {
		List<WechatMenuBO> res = new LinkedList<>();
		// 1. 查询一级菜单列表.<br />
		WechatMenuExample wechatMenuExample = new WechatMenuExample();
		wechatMenuExample.setOrderByClause("order_num asc");
		wechatMenuExample.createCriteria().andParentMenuEqualTo(0L).andActiveFlagEqualTo((byte) 10);
		List<WechatMenu> list = wechatMenuMapper.selectByExample(wechatMenuExample);
		
		// 2. 循环一级菜单列表.<br />
		for (WechatMenu o1 : list) {
			// 3. 查询二级菜单列表.<br />
			WechatMenuBO p1 = new WechatMenuBO();
			wechatMenuExample.createCriteria().andParentMenuEqualTo(o1.getRowId()).andActiveFlagEqualTo((byte) 10);
			List<WechatMenu> listChild = wechatMenuMapper.selectByExample(wechatMenuExample);
			
			List<WechatMenuBO> resChildList = new LinkedList<>();
			// 4. 循环并封装二级菜单列表并赋给父菜单对象中.<br />
			for (WechatMenu o2 : listChild) {
				WechatMenuBO p2 = new WechatMenuBO();
				BeanUtils.copyProperties(o2, p2);
				resChildList.add(p2);
			}
			
			// 5. 封装返回对象并返回.<br />
			BeanUtils.copyProperties(o1, p1);
			
			p1.setChildren(resChildList);
			
			res.add(p1);
		}
		
		return res;
	}

	@Override
	public Boolean addWeChatMenu(WechatMenu wechatMenu) {
		wechatMenu.setCreateDate(new Date());
		wechatMenu.setCreateUser(0L);
		wechatMenu.setActiveFlag((byte) 10);
		wechatMenuMapper.insertSelective(wechatMenu);
		return true;
	}

	@Override
	public Boolean updateWeChatMenu(WechatMenu wechatMenu) {
		wechatMenu.setLastUpdateDate(new Date());
		wechatMenu.setLastUpdateUser(0L);
		wechatMenuMapper.updateByPrimaryKeySelective(wechatMenu);
		return true;
	}

	@Override
	public Boolean deleteWeChatMenu(Long rowId) {
		WechatMenu wechatMenu = new WechatMenu();
		wechatMenu.setRowId(rowId);
		wechatMenu.setLastUpdateDate(new Date());
		wechatMenu.setLastUpdateUser(0L);
		wechatMenu.setActiveFlag((byte) 30);
		wechatMenuMapper.updateByPrimaryKeySelective(wechatMenu);
		return true;
	}

}
