package com.huazhu.application.cms.organization.entity;

import java.io.Serializable;

import com.huazhu.application.cms.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class Brand extends BaseEntity implements Serializable{
	
	private Long rowId;
	private String brandChineseName;
	private String brandEnglishName;
	private Long groupId;
	
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getBrandChineseName() {
		return brandChineseName;
	}
	public void setBrandChineseName(String brandChineseName) {
		this.brandChineseName = brandChineseName;
	}
	public String getBrandEnglishName() {
		return brandEnglishName;
	}
	public void setBrandEnglishName(String brandEnglishName) {
		this.brandEnglishName = brandEnglishName;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	

}
