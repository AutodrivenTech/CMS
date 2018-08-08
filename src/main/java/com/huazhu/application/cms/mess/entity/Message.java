package com.huazhu.application.cms.mess.entity;

import java.io.Serializable;
import java.util.Date;

import com.huazhu.application.cms.common.entity.BaseEntity;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Message extends BaseEntity implements Serializable {
	
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
	private Integer filterId;



	

	

}
