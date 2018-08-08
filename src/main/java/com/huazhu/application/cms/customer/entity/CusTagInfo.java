package com.huazhu.application.cms.customer.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CusTagInfo {

    private Integer rowId;

    private Integer cusId;

    private Integer tagId;

    private Integer createUser;

    private Date createDate;

}
