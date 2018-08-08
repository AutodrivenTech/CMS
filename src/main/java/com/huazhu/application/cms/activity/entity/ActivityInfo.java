package com.huazhu.application.cms.activity.entity;

import com.huazhu.application.cms.common.entity.BaseEntity;
import lombok.Data;

@Data
public class ActivityInfo  extends BaseEntity {

    private  Integer rowId;

    /**
     * 标题
     */
    private  String  actTitle;

    /**
     * 隶属组织
     */
    private  Integer actOrg;

    /**
     * 组织类型 10 集团 20  子公司
     */
    private Integer orgType;

}
