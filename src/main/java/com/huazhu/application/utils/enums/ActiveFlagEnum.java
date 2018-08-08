package com.huazhu.application.utils.enums;

public enum ActiveFlagEnum {

    VALID(10, "有效"),

    INVALID(20, "无效"),

    DELETE(30,"删除");

    private int value;

    private String alias;

    private ActiveFlagEnum(int value, String alias) {
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
