package com.huazhu.application.cms.organization.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.organization.dao.BrandMapper;
import com.huazhu.application.cms.organization.dao.GroupMapper;
import com.huazhu.application.cms.organization.entity.Brand;
import com.huazhu.application.cms.organization.entity.Group;
import com.huazhu.application.cms.organization.service.GroupService;
import com.huazhu.application.common.Constant;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupMapper groupMapper;
	
	@Autowired
	private BrandMapper brandMapper;

	@Override
	public List<Group> queryGroup(Group group) {
		// TODO Auto-generated method stub
		return groupMapper.queryGroup(group);
	}

	@Override
	public Group queryGroupByRowId(Long rowId) {
		// TODO Auto-generated method stub
		return groupMapper.queryGroupByRowId(rowId);
	}

	@Override
	public Integer insertGroup(Group group) {
		// TODO Auto-generated method stub
		group.setCreateDate(new Date());
		//group.setCreateUser(createUser);
		return groupMapper.insertGroup(group);
	}

	@Override
	public Integer updateGroupByRowId(Group group) {
		// TODO Auto-generated method stub
		group.setLastUpdateDate(new Date());
		//group.setLastUpdateUser(lastUpdateUser);
		return groupMapper.updateGroupByRowId(group);
	}

	@Override
	public Map<String,Object> deleteGroupByRowId(Long rowId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		List<Brand> brands = brandMapper.queryBrandByGroupId(rowId);
		if(brands != null && brands.size() > 0) {
			map.put(Constant.RETURN_CODE, Constant.EXIST_CHILDREN_CODE); 
			map.put(Constant.RETURN_MSG, Constant.EXIST_CHILDREN_MSG);
		}else {
			Integer result = groupMapper.deleteGroupByRowId(rowId);
			if(result > 0) {
				map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE); 
				map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE); 
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}
		return map;
	}

}
