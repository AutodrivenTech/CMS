package com.huazhu.application.cms.material.entity;

import java.io.Serializable;
import java.util.Date;

import com.huazhu.application.cms.common.entity.BaseEntity;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Material extends BaseEntity implements Serializable{
	
	private String rowId;
	private String  mateName;
	private String mateDesc;
	private String imgUrl;
	private String mateType;
	private String thumbMediaId;
	private Integer isUpload;
	private String tagIds;
	private String tagName;
	private Integer tagId;





}
