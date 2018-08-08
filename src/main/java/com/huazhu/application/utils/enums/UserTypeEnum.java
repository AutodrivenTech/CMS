package com.huazhu.application.utils.enums;

public enum UserTypeEnum {

    GROUP(10, "集团账户"),

    SUBSIDIARY(20, "子公司账户");

    private int value;

    private String alias;

    private UserTypeEnum(int value, String alias) {
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
