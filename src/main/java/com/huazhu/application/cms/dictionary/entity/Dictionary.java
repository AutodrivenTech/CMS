package com.huazhu.application.cms.dictionary.entity;

import java.io.Serializable;

import com.huazhu.application.cms.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class Dictionary extends BaseEntity implements Serializable {
	
	private Long id;
	private String code;
	private String value;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
