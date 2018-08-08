package com.huazhu.application.cms.wechat.dashboard.entity;

import java.util.Date;

public class PushApplyInfo {
    private Long rowId;

    private String pushTitle;

    private Byte pushType;

    private Date pushTime;

    private Long pushCon;

    private Byte pushStatus;

    private Long conOrg;

    private Byte orgType;

    private Long pushTag;

    private String msgId;

    private String msgDataId;

    private Date createDate;

    private Long createUser;

    private Date lastUpdateDate;

    private Long lastUpdateUser;

    private Byte activeFlag;

    private Integer filterId;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle == null ? null : pushTitle.trim();
    }

    public Byte getPushType() {
        return pushType;
    }

    public void setPushType(Byte pushType) {
        this.pushType = pushType;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Long getPushCon() {
        return pushCon;
    }

    public void setPushCon(Long pushCon) {
        this.pushCon = pushCon;
    }

    public Byte getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Byte pushStatus) {
        this.pushStatus = pushStatus;
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

    public Long getPushTag() {
        return pushTag;
    }

    public void setPushTag(Long pushTag) {
        this.pushTag = pushTag;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public String getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(String msgDataId) {
        this.msgDataId = msgDataId == null ? null : msgDataId.trim();
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

    public Integer getFilterId() {
        return filterId;
    }

    public void setFilterId(Integer filterId) {
        this.filterId = filterId;
    }
}