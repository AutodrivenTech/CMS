package com.huazhu.application.cms.organization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.organization.entity.Group;

@Mapper
public interface GroupMapper {
	
	List<Group> queryGroup (Group group);
	
	Group queryGroupByRowId(Long rowId);
	
	Integer insertGroup(Group group);
	
	Integer updateGroupByRowId(Group group);
	
	Integer deleteGroupByRowId(Long rowId);

}
