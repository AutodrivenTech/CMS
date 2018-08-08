package com.huazhu.application.cms.account.dao;


import com.huazhu.application.cms.account.entity.SysAccountInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysAccountInfoMapper {

    Integer addAccountInfo(SysAccountInfo sysAccountInfo);

    SysAccountInfo  findByUserName(@Param("userName") String userName,@Param("activeFlag")Integer activeFlag);

    Integer updateAccountInfo(SysAccountInfo sysAccountInfo);

    SysAccountInfo findById(@Param("rowId")Integer rowId);

    List<SysAccountInfo> getAccountList(@Param("activeFlag")Integer activeFlag);

}
