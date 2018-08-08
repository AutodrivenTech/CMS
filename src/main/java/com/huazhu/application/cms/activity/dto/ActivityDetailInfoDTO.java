package com.huazhu.application.cms.activity.dto;

import lombok.Data;

@Data
public class ActivityDetailInfoDTO {

    private Integer rowId;

    private String activityTitle;

    private String actDetailName;

    private Integer actDetailType;

    private Integer actDetailCon;

    private String actDetailUrl;

    private Integer actDetailCount;

    /**
     * 文章or文章列表标题
     */
    private String actDetailTitle;




}
