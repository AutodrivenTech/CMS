package com.huazhu.application.cms.article.entity;

import java.io.Serializable;
import java.util.Date;

import com.huazhu.application.cms.common.entity.BaseEntity;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Article extends BaseEntity implements Serializable{
	
	private String rowId;
	private String conTitle;
	private String conDesc;
	private String conType;
	private Integer conTag;
	private String conDetail;
	private Integer  conShare;
	private Integer conMessage;
	private String conOrg;
	private Integer orgType;
	private String conUrl;
	private String mateId;
	private String status;
	private Date releaseTime;
	private Date expireTime;
	private Integer messageType;
	private String keyword;

	private Integer expire; //是否过期 是否过期 10--已过期  20--未过期
	private Integer isAccount; //是否本账号  10--是 20--否

	private Integer hotelId;


	

}
