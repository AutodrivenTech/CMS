package com.huazhu.application.cms.wechat.comment.dao;

import com.huazhu.application.cms.wechat.comment.entity.ConInfo;
import com.huazhu.application.cms.wechat.comment.entity.ConInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConInfoMapper {
    int countByExample(ConInfoExample example);

    int deleteByExample(ConInfoExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(ConInfo record);

    int insertSelective(ConInfo record);

    List<ConInfo> selectByExampleWithBLOBs(ConInfoExample example);

    List<ConInfo> selectByExample(ConInfoExample example);

    ConInfo selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") ConInfo record, @Param("example") ConInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ConInfo record, @Param("example") ConInfoExample example);

    int updateByExample(@Param("record") ConInfo record, @Param("example") ConInfoExample example);

    int updateByPrimaryKeySelective(ConInfo record);

    int updateByPrimaryKeyWithBLOBs(ConInfo record);

    int updateByPrimaryKey(ConInfo record);
}