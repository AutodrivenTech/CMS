package com.huazhu.application.cms.organization.service;

import java.util.List;
import java.util.Map;

import com.huazhu.application.cms.organization.entity.Group;

public interface GroupService {
	
    List<Group> queryGroup (Group group);
	
	Group queryGroupByRowId(Long rowId);
	
	Integer insertGroup(Group group);
	
	Integer updateGroupByRowId(Group group);
	
	Map<String,Object> deleteGroupByRowId(Long rowId);

}
