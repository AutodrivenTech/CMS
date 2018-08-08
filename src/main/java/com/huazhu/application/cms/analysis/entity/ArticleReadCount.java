package com.huazhu.application.cms.analysis.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class ArticleReadCount implements Serializable {
	
	private String title;
	private Integer readCount;
	private String msgid;
	private Set<String> orgName;

}
