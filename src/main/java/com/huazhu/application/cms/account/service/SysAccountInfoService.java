package com.huazhu.application.cms.account.service;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.dto.AccountInfoDTO;
import com.huazhu.application.cms.account.entity.SysAccountInfo;

import java.util.Map;

public interface SysAccountInfoService {

    /**
     * 创建用户
     * @param accountInfo
     * @return
     */
    Integer addAccountInfo(SysAccountInfo accountInfo);

    /**
     * 修改密码
     * @param accountInfoDTO
     * @return
     */
    Integer updatePassword(AccountInfoDTO accountInfoDTO,Integer userId);

    /**
     * 查询用户详情
     * @param userId
     * @return
     */
    SysAccountInfo getAccountInfoById(Integer userId);

    /**
     * 查询是否存在
     * @param userName
     * @return
     */
     SysAccountInfo findByUserName(String userName);

     SysAccountInfo login(String userName, String userPassword);


    PageInfo<SysAccountInfo> getAccountList(Integer pageNo, Integer pageSize);


}
