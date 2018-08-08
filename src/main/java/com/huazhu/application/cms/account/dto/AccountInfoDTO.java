package com.huazhu.application.cms.account.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户信息")
@Data
public class AccountInfoDTO {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("旧密码")
    private  String userPassword;

    @ApiModelProperty("新密码")
    private String newPassword;

    @ApiModelProperty("确认密码")
    private  String confirmPassword;

    @ApiModelProperty("用户Id")
    private Integer rowId;









}
