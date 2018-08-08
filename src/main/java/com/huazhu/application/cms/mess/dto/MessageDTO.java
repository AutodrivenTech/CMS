package com.huazhu.application.cms.mess.dto;

import com.huazhu.application.cms.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO  extends BaseEntity {
    private Long rowId;
    private String pushTitle;
    private Integer pushType;
    private Date pushTime;
    private Long pushCon;
    private Integer pushStatus;
    private Integer pushTag;
    private String msgId;
    private Integer conOrg;
    private Integer orgType;
    private  String msgDataId;
    private  String pushTagName;
    private Integer fansFilteId;
    private String fansFilteName;
}
