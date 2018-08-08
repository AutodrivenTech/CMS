package com.huazhu.application.cms.fans.dto;

import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.tags.entity.Tags;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class FansFilterDTO {

    /**
     * ID
     */
    private Integer rowId;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否公开过滤器 1--是 0--否
     */
    private  Integer isOpen;

    /**
     * 是否酒店粉丝 1--是 0--否
     */
    private  Integer  isFans;

    /**
     * 酒店id
     */
    private String hotelId;

    /**
     * 酒店
     */
    private List<Hotel> hotels;

    /**
     * 性别 0--男  1--女
     */
    private Integer sex;

    /**
     * 关注开始日期
     */
    private Date startDate;

    /**
     * 关注结束日期
     */
    private Date endDate;

    /**
     * 国家
     */
    private String country;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private  String province;

    /**
     * 语言
     */
    private String language;

    /**
     * 调研年龄
     */
    private String surveyAge;

    /**
     * 境外目的地
     */
    private String abroadDestination;

    /**
     * 境内目的地
     */
    private String domesticDestination;

    /**
     * 活动
     */
    private String activity;

    /**
     * 标签
     */
    private String tagId;

    /**
     * 标签集合
     */
    private List<Tags> tags;


    /**
     * 二维码
     */
    private String  qrCode;



    private Integer activeFlag;
}
