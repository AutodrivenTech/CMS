package com.huazhu.application.cms.article.entity;

import java.io.Serializable;

import com.huazhu.application.cms.common.entity.BaseEntity;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class ArticleList extends BaseEntity implements Serializable {
	
	private Long rowId;

	private String conTitle;
	
	private Integer conOrg;

	private Integer orgType;
	
	

}
