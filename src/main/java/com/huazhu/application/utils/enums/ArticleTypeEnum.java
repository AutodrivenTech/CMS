package com.huazhu.application.utils.enums;

public enum ArticleTypeEnum {

    ARTICLE(10, "文章"),

    ARTICLE_LIST(20, "文章列表");

    private int value;

    private String alias;

    private ArticleTypeEnum(int value, String alias) {
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
