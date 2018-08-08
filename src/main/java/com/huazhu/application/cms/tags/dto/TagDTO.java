package com.huazhu.application.cms.tags.dto;

import lombok.Data;

@Data
public class TagDTO {

    /**
     * 查看数
     */
    private Integer seeCount;

    /**
     * 点赞数
     */
    private Integer laudCount;

    /**
     * 分享数
     */
    private  Integer ShareCount;
}
