package com.huazhu.application.cms.wechat.comment.dao;

import com.huazhu.application.cms.wechat.comment.entity.ResConComment;
import com.huazhu.application.cms.wechat.comment.entity.ResConCommentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResConCommentMapper {
    int countByExample(ResConCommentExample example);

    int deleteByExample(ResConCommentExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(ResConComment record);

    int insertSelective(ResConComment record);

    List<ResConComment> selectByExample(ResConCommentExample example);

    ResConComment selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") ResConComment record, @Param("example") ResConCommentExample example);

    int updateByExample(@Param("record") ResConComment record, @Param("example") ResConCommentExample example);

    int updateByPrimaryKeySelective(ResConComment record);

    int updateByPrimaryKey(ResConComment record);
}