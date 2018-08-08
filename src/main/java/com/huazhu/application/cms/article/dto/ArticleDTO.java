package com.huazhu.application.cms.article.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO {
    private Integer rowId;

    private String conTitle;

    private String conDesc;

    private Integer conType;

    private String tagName;

    private Integer tagId;

    private String conDetail;

    private Integer  conShare;

    private Integer conMessage;

    private Integer conOrg;

    private Integer orgType;

    private String conUrl;

    private String photoUrl;

    private Integer status;

    private Date releaseTime;

    private String thumbMediaId;

    private Date expireTime;

    private String publishUser;

    private Integer  messageType;

    private Integer readCount;

    private String keyword;

    private String hotelName;

    private String brandName;
}
