package com.huazhu.application.utils.enums;

public enum ArticleStatus {
    UN_RELEASED(10, "未发布"),

    RELEASED(20, "已发布"),

    APPLY(30,"已使用");

    private int value;

    private String alias;

    private ArticleStatus(int value, String alias) {
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
