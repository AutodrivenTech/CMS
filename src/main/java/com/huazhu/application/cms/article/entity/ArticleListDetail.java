package com.huazhu.application.cms.article.entity;

import java.io.Serializable;

import com.huazhu.application.cms.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class ArticleListDetail extends BaseEntity implements Serializable {
	
	private Long rowId;
	private Long conListId;
	private Long conId;
	private Integer orderNum;
	
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public Long getConListId() {
		return conListId;
	}
	public void setConListId(Long conListId) {
		this.conListId = conListId;
	}
	public Long getConId() {
		return conId;
	}
	public void setConId(Long conId) {
		this.conId = conId;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	

}
