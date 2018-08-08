package com.huazhu.application.cms.organization.entity;

import java.io.Serializable;

import com.huazhu.application.cms.common.entity.BaseEntity;

@SuppressWarnings("serial")
public class Hotel extends BaseEntity implements Serializable{
	
	private Long rowId;
	private String hotelChineseName;
	private String hotelEnglishName;
	private Long brandId;
	private String qrTictek;
	private String sceneStr;
	
	
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getHotelChineseName() {
		return hotelChineseName;
	}
	public void setHotelChineseName(String hotelChineseName) {
		this.hotelChineseName = hotelChineseName;
	}
	public String getHotelEnglishName() {
		return hotelEnglishName;
	}
	public void setHotelEnglishName(String hotelEnglishName) {
		this.hotelEnglishName = hotelEnglishName;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getQrTictek() {
		return qrTictek;
	}
	public void setQrTictek(String qrTictek) {
		this.qrTictek = qrTictek;
	}
	public String getSceneStr() {
		return sceneStr;
	}
	public void setSceneStr(String sceneStr) {
		this.sceneStr = sceneStr;
	}
	

}
