package com.huazhu.application.cms.wechat.event.entity;

import java.util.Date;

public class CustomerInfo {
    private Long rowId;

    private String cusName;

    private Long hotelId;

    private Byte cusSex;

    private String country;

    private String cusSign;

    private String cusPhoto;

    private String cusOpenId;

    private Date createDate;

    private Long createUser;

    private Date lastUpdateDate;

    private Long lastUpdateUser;

    private Byte activeFlag;

    private Date followDate;

    private String province;

    private String city;

    private String language;

    private String surveyAge;

    private String abroadDestination;

    private String domesticDestination;

    private String activity;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Byte getCusSex() {
        return cusSex;
    }

    public void setCusSex(Byte cusSex) {
        this.cusSex = cusSex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getCusSign() {
        return cusSign;
    }

    public void setCusSign(String cusSign) {
        this.cusSign = cusSign == null ? null : cusSign.trim();
    }

    public String getCusPhoto() {
        return cusPhoto;
    }

    public void setCusPhoto(String cusPhoto) {
        this.cusPhoto = cusPhoto == null ? null : cusPhoto.trim();
    }

    public String getCusOpenId() {
        return cusOpenId;
    }

    public void setCusOpenId(String cusOpenId) {
        this.cusOpenId = cusOpenId == null ? null : cusOpenId.trim();
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(Long lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Date getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getSurveyAge() {
        return surveyAge;
    }

    public void setSurveyAge(String surveyAge) {
        this.surveyAge = surveyAge == null ? null : surveyAge.trim();
    }

    public String getAbroadDestination() {
        return abroadDestination;
    }

    public void setAbroadDestination(String abroadDestination) {
        this.abroadDestination = abroadDestination == null ? null : abroadDestination.trim();
    }

    public String getDomesticDestination() {
        return domesticDestination;
    }

    public void setDomesticDestination(String domesticDestination) {
        this.domesticDestination = domesticDestination == null ? null : domesticDestination.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }
}