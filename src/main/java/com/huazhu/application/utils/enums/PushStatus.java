package com.huazhu.application.utils.enums;

public enum PushStatus {

    //推送状态 10 待审批 20 待推送 30 已推送 40 推送失败  50 已过期 60 已拒绝
    AUFDIT(10, "待审批"),

    WAIT_PUSH(20, "待推送"),

    ALREADY_PUS(30,"已推送"),

    PUSH_FAIL(40,"推送失败"),

    EXPIRE(50,"已过期"),

    REJECTED(60,"已拒绝");


    private int value;

    private String alias;

    private PushStatus(int value, String alias) {
        this.value = value;
        this.alias = alias;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
