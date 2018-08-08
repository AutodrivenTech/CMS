package com.huazhu.application.cms.tags.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.tags.entity.Tags;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagsMapper {
	

	
	Integer insertTags(Tags tags);

	
	Integer updateTags(Tags tags);
	
	Tags queryTagsByRowId(Long rowId);
	
	List<Tags> queryTagsConditions(Tags tags);

	List<Tags> queryTagsById(@Param("tagId")String tagId, @Param("activeflag")Integer activeflag);

	List<Tags> queryTagsInfo(@Param("activeflag")Integer activeflag);

	Tags queryTagsByRowName(@Param("tagName")String tagName,@Param("type")Integer type);

	

}
