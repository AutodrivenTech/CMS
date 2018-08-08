package com.huazhu.application.cms.wechat.dashboard.dao;

import com.huazhu.application.cms.wechat.dashboard.entity.PushApplyInfo;
import com.huazhu.application.cms.wechat.dashboard.entity.PushApplyInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PushApplyInfoMapper {
    int countByExample(PushApplyInfoExample example);

    int deleteByExample(PushApplyInfoExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(PushApplyInfo record);

    int insertSelective(PushApplyInfo record);

    List<PushApplyInfo> selectByExample(PushApplyInfoExample example);

    PushApplyInfo selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") PushApplyInfo record, @Param("example") PushApplyInfoExample example);

    int updateByExample(@Param("record") PushApplyInfo record, @Param("example") PushApplyInfoExample example);

    int updateByPrimaryKeySelective(PushApplyInfo record);

    int updateByPrimaryKey(PushApplyInfo record);
}