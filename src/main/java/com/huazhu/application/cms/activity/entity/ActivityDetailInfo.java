package com.huazhu.application.cms.activity.entity;

import com.huazhu.application.cms.common.entity.BaseEntity;
import lombok.Data;

@Data
public class ActivityDetailInfo  extends BaseEntity {

    /**
     * 主键。UUID自动生成。
     */
    private Integer rowId;
    /**
     * 活动主表id
     */
    private Integer actId;
    /**
     * 活动明细名称
     */
    private String actDetailName;
    /**
     * 活动明细类型 10 文章 20 文章列表
     */
    private Integer actDetailType;
    /**
     * 活动明细内容
     */
    private Long actDetailCon;
    /**
     * 活动明细url
     */
    private String actDetailUrl;
    /**
     * 活动明细扫描次数
     */
    private Long actDetailCount;
    /**
     * 位置排序
     */
    private Integer orderNum;





}
