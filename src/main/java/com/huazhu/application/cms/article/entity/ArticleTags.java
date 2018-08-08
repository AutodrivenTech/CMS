package com.huazhu.application.cms.article.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ArticleTags implements Serializable {
	
	private Long rowId;
	private Long conId;
	private Long tagId;
	private Date createDate;
	private Long createUser;
	
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public Long getConId() {
		return conId;
	}
	public void setConId(Long conId) {
		this.conId = conId;
	}
	public Long getTagId() {
		return tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	
	

}
