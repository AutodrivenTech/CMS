/**
 * Project Name		:	CMS
 * File Name		:	SysMenuServiceImpl.java
 * Package Name		:	com.huazhu.application.cms.system.service.impl
 * Date				:	2018年7月11日下午6:58:55
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.system.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.huazhu.application.cms.system.dao.SysMenuInfoMapper;
import com.huazhu.application.cms.system.entity.SysMenuInfo;
import com.huazhu.application.cms.system.entity.SysMenuInfoExample;
import com.huazhu.application.cms.system.service.SysMenuService;
import com.huazhu.application.common.data.format.TreeData;
import com.huazhu.application.common.data.format.TreeStateData;

/**
 * ClassName		:	SysMenuServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:58:55 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuInfoMapper sysMenuInfoMapper;

	@Override
	public SysMenuInfo selectByPrimaryKey(Long entityId) {
		return sysMenuInfoMapper.selectByPrimaryKey(entityId);
	}

	@Override
	public List<SysMenuInfo> select(SysMenuInfo record) {
		return null;
	}

	@Override
	public List<SysMenuInfo> selectAll() {
		return null;
	}

	@Override
	public SysMenuInfo selectOne(SysMenuInfo record) {
		return null;
	}

	@Override
	public List<SysMenuInfo> selectByExample(Object example) {
		return sysMenuInfoMapper.selectByExample((SysMenuInfoExample) example);
	}

	@Override
	public List<SysMenuInfo> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		PageHelper.offsetPage(rowBounds.getOffset(), rowBounds.getLimit());
		return sysMenuInfoMapper.selectByExample((SysMenuInfoExample) example);
	}

	@Override
	public int selectCount(SysMenuInfo record) {
		return 0;
	}

	@Override
	public int selectCountByExample(Object example) {
		return sysMenuInfoMapper.countByExample((SysMenuInfoExample) example);
	}

	@Override
	public List<SysMenuInfo> selectByRowBounds(SysMenuInfo record, RowBounds rowBounds) {
		return null;
	}

	@Override
	public boolean existsWithPrimaryKey(Long entityId) {
		return false;
	}

	@Override
	public int insert(SysMenuInfo record) {
		return sysMenuInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(SysMenuInfo record) {
		return sysMenuInfoMapper.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Long entityId) {
		return sysMenuInfoMapper.deleteByPrimaryKey(entityId);
	}

	@Override
	public int delete(SysMenuInfo record) {
		return 0;
	}

	@Override
	public int deleteByExample(Object example) {
		return sysMenuInfoMapper.deleteByExample((SysMenuInfoExample) example);
	}

	@Override
	public int updateByExample(SysMenuInfo record, Object example) {
		return sysMenuInfoMapper.updateByExample(record, (SysMenuInfoExample) example);
	}

	@Override
	public int updateByExampleSelective(SysMenuInfo record, Object example) {
		return sysMenuInfoMapper.updateByExampleSelective(record, (SysMenuInfoExample) example);
	}

	@Override
	public int updateByPrimaryKey(SysMenuInfo record) {
		return sysMenuInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(SysMenuInfo record) {
		return sysMenuInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<TreeData> selectAllMenuWithTreeByPermission(Byte languageType) {
		TreeData res = new TreeData();
		SysMenuInfoExample childExample = new SysMenuInfoExample();
		childExample.setOrderByClause("order_num asc");
		childExample.createCriteria().andLevelNumEqualTo((byte) 1).andParentMenuIsNull();

		recursiveMenu(childExample, res, languageType);

		return res.getNodes();
	}


	/**
	 * 
	 * recursiveMenu		:	(递归查询菜单信息). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param example
	 * @param res
	 * @since					:	JDK 1.8
	 */
	private void recursiveMenu(SysMenuInfoExample example, TreeData parent,Byte languageType) {
		// 定义孩子集合 存放孩子信息
		List<TreeData> child = new LinkedList<TreeData>();
		// 根据条件查询数据
		List<SysMenuInfo> list = this.selectByExample(example);
		// 判断是否有孩子数据
		if (list != null && list.size() > 0) {
			// 循环孩子数据
			for (SysMenuInfo o : list) {
				TreeData p = new TreeData();
				switch (languageType) {
				case 1:
					p.setText(o.getChineseName());
					p.setIcon(o.getIcon());
					p.setHref(o.getMenuUrl());
					break;
				case 2:
					p.setText(o.getEnglishName());
					p.setIcon(o.getIcon());
					p.setHref(o.getMenuUrl());
					break;
				default:
					p.setText(o.getChineseName());
					p.setIcon(o.getIcon());
					p.setHref(o.getMenuUrl());
					break;
				}

				p.setId(o.getRowId().toString());
				p.setHref(o.getMenuUrl());
				p.setSelectable(true);

				TreeStateData stats = new TreeStateData();
				stats.setExpanded(false);
				stats.setSelected(false);
				stats.setChecked(false);
				stats.setDisabled(false);

				p.setState(stats);

				SysMenuInfoExample childExample = new SysMenuInfoExample();
				childExample.setOrderByClause("order_num asc");
				childExample.createCriteria().andParentMenuEqualTo(o.getRowId()).andActiveFlagEqualTo((byte) 10);

				this.recursiveMenu(childExample, p, languageType);
				child.add(p);
			}
			parent.setNodes(child);
		}
	}
}
