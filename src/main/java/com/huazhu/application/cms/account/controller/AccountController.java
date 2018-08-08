package com.huazhu.application.cms.account.controller;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.dto.AccountInfoDTO;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.account.service.SysAccountInfoService;
import com.huazhu.application.cms.common.BasicController;
import com.huazhu.application.common.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Api(value = "用户管理")
@RequestMapping(value = "/cms/account")
@RestController
public class AccountController extends BasicController {

    @Autowired
    private SysAccountInfoService accountInfoService;

    @ApiOperation(value = "创建用户")
    @PostMapping("/addAccountInfo")
    public Map<String,Object> addAccountInfo(SysAccountInfo sysAccountInfo){
        Map<String,Object> map=new HashMap<String,Object>();
        if(sysAccountInfo==null){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return map;
        }
        //sysAccountInfo.setLastUpdateUser(getUserId());
        if(accountInfoService.addAccountInfo(sysAccountInfo)<=0){
            map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
            map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
        }else{
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }
        return  map;
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public  Map<String,Object> login(String userName, String userPassword){
        Map<String,Object> map=new HashMap<String,Object>();
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(userPassword)){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
        }
        SysAccountInfo sysAccountInfo=accountInfoService.login(userName,userPassword);
        if(sysAccountInfo==null){
            map.put(Constant.RETURN_CODE, Constant.PASSWORD_ERROR_CODE);
            map.put(Constant.RETURN_MSG, Constant.PASSWORD_ERROR_MSG);
            return map;
        }
        map.put(Constant.RETURN_DATA,sysAccountInfo);
        session.setAttribute(USER_INFO, sysAccountInfo.getRowId());
        session.setAttribute(HOTEL_INFO,sysAccountInfo);
        return  map;
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/updatePassword")
    public Map<String, Object> updatePassword(AccountInfoDTO accountInfoDTO){
        Map<String, Object> map=new HashMap<String, Object>();
        if(!Objects.equals(accountInfoDTO.getNewPassword(),accountInfoDTO.getConfirmPassword())){
            map.put(Constant.RETURN_CODE,Constant.PASSWORD_CODE);
            map.put(Constant.RETURN_MSG, Constant.PASSWORD_MSG);
            return map;
        }
        // 修改是否成功
        if (accountInfoService.updatePassword(accountInfoDTO,getUserId()) > 0) {
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }else{
            map.put(Constant.RETURN_CODE,Constant.PASSWORD_RESET_CODE);
            map.put(Constant.RETURN_MSG, Constant.PASSWORD_RESET_MSG);
        }
        return  map;
    }


    @ApiOperation(value = "查看用户详情")
    @PostMapping("/getAccountInfo")
    public Map<String, Object> getAccountInfo(){
        Map<String, Object> map=new HashMap<String, Object>();
        SysAccountInfo accountInfo=accountInfoService.getAccountInfoById(getUserId());
        map.put(Constant.RETURN_DATA,accountInfo);
        return  map;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/layOut")
    public  void   layOut(){
        session.removeAttribute(USER_INFO);
    }


    @ApiOperation(value = "用户列表")
    @PostMapping("/getAccountList")
    public  Map<String, Object>  getAccountList(Integer pageNo,Integer pageSize){
        Map<String, Object> map=new HashMap<String, Object>();
        PageInfo<SysAccountInfo> pageInfo=accountInfoService.getAccountList(pageNo,pageSize);
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        map.put(Constant.RETURN_DATA,pageInfo);
        return  map;
    }





}
