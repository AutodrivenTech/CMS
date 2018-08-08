package com.huazhu.application.cms.system.dao;

import com.huazhu.application.cms.system.entity.SysMenuInfo;
import com.huazhu.application.cms.system.entity.SysMenuInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysMenuInfoMapper {
    int countByExample(SysMenuInfoExample example);

    int deleteByExample(SysMenuInfoExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(SysMenuInfo record);

    int insertSelective(SysMenuInfo record);

    List<SysMenuInfo> selectByExample(SysMenuInfoExample example);

    SysMenuInfo selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") SysMenuInfo record, @Param("example") SysMenuInfoExample example);

    int updateByExample(@Param("record") SysMenuInfo record, @Param("example") SysMenuInfoExample example);

    int updateByPrimaryKeySelective(SysMenuInfo record);

    int updateByPrimaryKey(SysMenuInfo record);
}