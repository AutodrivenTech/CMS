package com.huazhu.application.cms.tags.entity;

import java.io.Serializable;
import java.util.Date;

import com.huazhu.application.cms.tags.dto.TagDTO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("tags")
@SuppressWarnings("serial")
public class Tags extends TagDTO implements Serializable{
	
	private Long rowId;
	private String tabChineseName;
	private String tagEnglistName;
	private int tagType;
	private Date createDate;
	private Long createUser;
	private Date lastUpdateDate;
	private Long lastUpdateUser;
	private int activeFlag;
	  
	

	  

}
