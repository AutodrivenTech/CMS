package com.huazhu.application.cms.wechat.comment.entity;

import java.util.Date;

public class ConInfo {
    private Long rowId;

    private String conTitle;

    private String conDesc;

    private Byte conType;

    private Long conTag;

    private Byte conShare;

    private Byte conMessage;

    private Long conOrg;

    private Byte orgType;

    private Date createDate;

    private Long createUser;

    private Date lastUpdateDate;

    private Long lastUpdateUser;

    private Byte activeFlag;

    private String conUrl;

    private Integer mateId;

    private Integer status;

    private Date releaseTime;

    private Date expireTime;

    private Byte messageType;

    private String keyword;

    private String conDetail;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getConTitle() {
        return conTitle;
    }

    public void setConTitle(String conTitle) {
        this.conTitle = conTitle == null ? null : conTitle.trim();
    }

    public String getConDesc() {
        return conDesc;
    }

    public void setConDesc(String conDesc) {
        this.conDesc = conDesc == null ? null : conDesc.trim();
    }

    public Byte getConType() {
        return conType;
    }

    public void setConType(Byte conType) {
        this.conType = conType;
    }

    public Long getConTag() {
        return conTag;
    }

    public void setConTag(Long conTag) {
        this.conTag = conTag;
    }

    public Byte getConShare() {
        return conShare;
    }

    public void setConShare(Byte conShare) {
        this.conShare = conShare;
    }

    public Byte getConMessage() {
        return conMessage;
    }

    public void setConMessage(Byte conMessage) {
        this.conMessage = conMessage;
    }

    public Long getConOrg() {
        return conOrg;
    }

    public void setConOrg(Long conOrg) {
        this.conOrg = conOrg;
    }

    public Byte getOrgType() {
        return orgType;
    }

    public void setOrgType(Byte orgType) {
        this.orgType = orgType;
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

    public String getConUrl() {
        return conUrl;
    }

    public void setConUrl(String conUrl) {
        this.conUrl = conUrl == null ? null : conUrl.trim();
    }

    public Integer getMateId() {
        return mateId;
    }

    public void setMateId(Integer mateId) {
        this.mateId = mateId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getConDetail() {
        return conDetail;
    }

    public void setConDetail(String conDetail) {
        this.conDetail = conDetail == null ? null : conDetail.trim();
    }
}