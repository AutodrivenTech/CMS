package com.huazhu.application.cms.wechat.comment.dao;

import com.huazhu.application.cms.wechat.comment.entity.ConListDetail;
import com.huazhu.application.cms.wechat.comment.entity.ConListDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConListDetailMapper {
    int countByExample(ConListDetailExample example);

    int deleteByExample(ConListDetailExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(ConListDetail record);

    int insertSelective(ConListDetail record);

    List<ConListDetail> selectByExample(ConListDetailExample example);

    ConListDetail selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") ConListDetail record, @Param("example") ConListDetailExample example);

    int updateByExample(@Param("record") ConListDetail record, @Param("example") ConListDetailExample example);

    int updateByPrimaryKeySelective(ConListDetail record);

    int updateByPrimaryKey(ConListDetail record);
}