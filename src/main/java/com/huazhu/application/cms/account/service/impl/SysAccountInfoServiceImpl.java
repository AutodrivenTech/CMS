package com.huazhu.application.cms.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.dao.SysAccountInfoMapper;
import com.huazhu.application.cms.account.dto.AccountInfoDTO;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.account.service.SysAccountInfoService;
import com.huazhu.application.cms.common.mail.MailService;
import com.huazhu.application.cms.common.mail.RedisService;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.PasswordUtil;
import com.huazhu.application.utils.RandomUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class SysAccountInfoServiceImpl implements SysAccountInfoService {

    @Autowired
    private SysAccountInfoMapper sysAccountInfoMapper;

    @Autowired
    private MailService mailService;

    @Autowired
    private RedisService redisService;





    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer addAccountInfo(SysAccountInfo accountInfo) {
        Integer result=0;
        //查询是否存在
       SysAccountInfo sysAccountInfo=findByUserName(accountInfo.getUserName());
       if(sysAccountInfo!=null){
           return result;
       }
       accountInfo.setActiveFlag(ActiveFlagEnum.VALID.getValue());
       accountInfo.setCreateDate(DateUtil.getCurrentTime());
       String salt=PasswordUtil.generateSalt();
       String random=RandomUtil.generateNumber(6);
       accountInfo.setSalt(salt);
       accountInfo.setUserPasswd(PasswordUtil.generate(random, salt));
       result=sysAccountInfoMapper.addAccountInfo(accountInfo);
       if(result!=0){
           String  content="用户名:"+accountInfo.getUserName()+",密码:"+random;
           mailService.sendSimpleMail(accountInfo.getEmail(),"用户名密码",content);
       }
       return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer updatePassword(AccountInfoDTO accountInfoDTO,Integer userId) {
        SysAccountInfo accountInfo=sysAccountInfoMapper.findById(accountInfoDTO.getRowId());
        Boolean check = PasswordUtil.check(accountInfoDTO.getUserPassword(), accountInfo.getSalt(), accountInfo.getUserPasswd());
        if (!check) {
            return null;
        }
        String salt=PasswordUtil.generateSalt();
        return sysAccountInfoMapper.updateAccountInfo(new SysAccountInfo(){{
            setUserPasswd(PasswordUtil.generate(accountInfoDTO.getNewPassword(), salt));
            setLastUpdateDate(DateUtil.getCurrentTime());
            setSalt(salt);
            setLastUpdateUser(userId);
        }});
    }

    @Override
    public SysAccountInfo getAccountInfoById(Integer userId) {
        return sysAccountInfoMapper.findById(userId);
    }


    public SysAccountInfo findByUserName(String userName){
        return sysAccountInfoMapper.findByUserName(userName,ActiveFlagEnum.VALID.getValue());

    }

    @Override
    public SysAccountInfo login(String userName, String userPassword) {
        SysAccountInfo sysAccountInfo=findByUserName(userName);
        if(sysAccountInfo==null){
            return null;
        }
        Boolean check = PasswordUtil.check(userPassword, sysAccountInfo.getSalt(), sysAccountInfo.getUserPasswd());
        if (!check) {
            return null;
        }
       /* String token=UUID.randomUUID().toString().replace("-", "");
        redisService.set(token, String.valueOf(sysAccountInfo.getRowId()), expiresSecond);
        sysAccountInfo.setToken(token);*/
        return sysAccountInfo;
    }



    public PageInfo<SysAccountInfo> getAccountList(Integer pageNo, Integer pageSize){
        PageInfo<SysAccountInfo> pageInfo = PageHelper.startPage(pageNo, pageSize)
                .doSelectPageInfo(() -> sysAccountInfoMapper.getAccountList(ActiveFlagEnum.VALID.getValue()));
        return  pageInfo;
    }

    private  Integer getAccountId(String token){
        return  Integer.valueOf(redisService.get(token));
    }


}
