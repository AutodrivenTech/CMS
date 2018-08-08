package com.huazhu.application.cms.wechat.comment.entity;

import java.util.Date;

public class ConListDetail {
    private Long rowId;

    private Long conListId;

    private Long conId;

    private Byte orderNum;

    private Date createDate;

    private Long createUser;

    private Date lastUpdateDate;

    private Long lastUpdateUser;

    private Byte activeFlag;

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

    public Byte getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Byte orderNum) {
        this.orderNum = orderNum;
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
}