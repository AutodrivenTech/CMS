package com.huazhu.application.cms.account.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;


@ApiModel("用户信息")
@Data
public class SysAccountInfo {

    /**
     * 主键ID
     */
    private  Integer  rowId;

    /**
     * 用户名
     */
    private  String userName;

    /**
     * 邮件
     */
    private  String email;

    /**
     * 密码
     */
    private String  userPasswd;

    /**
     * 用户类型.10 集团总公司账户 20 子品牌操作人员账户
     */
    private Integer  userType;

    /**
     * 隶属组织
     */
    private Integer userOrg;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private  Integer createUser;

    /**
     * 最后修改时间
     */
    private Date lastUpdateDate;

    /**
     * 最后修改人
     */
    private Integer lastUpdateUser;

    /**
     * 状态 10 有效；20 无效；30 删除。
     */
    private  Integer activeFlag;

    /**
     * 盐
     */
    private String salt;


}
