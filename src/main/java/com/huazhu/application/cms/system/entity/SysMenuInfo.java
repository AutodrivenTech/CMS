package com.huazhu.application.cms.system.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class SysMenuInfo {
	private Long rowId;

	private String chineseName;

	private String englishName;

	private String icon;

	private Byte levelNum;

	private String menuUrl;

	private Long parentMenu;

	private Byte orderNum;

	private Date createDate;

	private Long createUser;

	private Date lastUpdateDate;

	private Long lastUpdateUser;

	private Byte activeFlag;
}