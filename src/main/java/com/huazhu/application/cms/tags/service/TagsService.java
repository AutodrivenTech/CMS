package com.huazhu.application.cms.tags.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.tags.entity.Tags;

public interface TagsService {



	Map<String,Object> insertTags(Tags tags);
	
	Integer deleteTagsByRowId(Long rowId,Integer userId);

	Map<String,Object> updateTags(Tags tags);
	
	Tags queryTagsByRowId(Long rowId);
	
	List<Tags> queryTagsConditions(Tags tags);

	boolean getTagByName(String tagName,Integer type);

	PageInfo<Tags> queryTagsList(Tags tags,Integer pageNo,Integer pageSize);

}
