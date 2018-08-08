package com.huazhu.application.cms.organization.entity;

import java.io.Serializable;

import com.huazhu.application.cms.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class Group extends BaseEntity implements Serializable{
	
	private Long rowId;
	private String groupChineseName;
	private String groupEnglishName;
	
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getGroupChineseName() {
		return groupChineseName;
	}
	public void setGroupChineseName(String groupChineseName) {
		this.groupChineseName = groupChineseName;
	}
	public String getGroupEnglishName() {
		return groupEnglishName;
	}
	public void setGroupEnglishName(String groupEnglishName) {
		this.groupEnglishName = groupEnglishName;
	}
	
	
}
