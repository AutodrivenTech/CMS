package com.huazhu.application.cms.wechat.menu.entity;

import java.util.Date;

public class WechatMenu {
    private Long rowId;

    private String menuName;

    private String menuType;

    private String menuUrl;

    private Long parentMenu;

    private Byte orderNum;

    private String vakue5;

    private String vakue4;

    private String vakue3;

    private String vakue2;

    private String vakue1;

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Long getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Long parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Byte getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Byte orderNum) {
        this.orderNum = orderNum;
    }

    public String getVakue5() {
        return vakue5;
    }

    public void setVakue5(String vakue5) {
        this.vakue5 = vakue5 == null ? null : vakue5.trim();
    }

    public String getVakue4() {
        return vakue4;
    }

    public void setVakue4(String vakue4) {
        this.vakue4 = vakue4 == null ? null : vakue4.trim();
    }

    public String getVakue3() {
        return vakue3;
    }

    public void setVakue3(String vakue3) {
        this.vakue3 = vakue3 == null ? null : vakue3.trim();
    }

    public String getVakue2() {
        return vakue2;
    }

    public void setVakue2(String vakue2) {
        this.vakue2 = vakue2 == null ? null : vakue2.trim();
    }

    public String getVakue1() {
        return vakue1;
    }

    public void setVakue1(String vakue1) {
        this.vakue1 = vakue1 == null ? null : vakue1.trim();
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