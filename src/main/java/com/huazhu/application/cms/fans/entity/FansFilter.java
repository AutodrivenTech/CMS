package com.huazhu.application.cms.fans.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel("粉丝过滤")
@Data
public class FansFilter {

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
     * 酒店ID
     */
    private String hotelId;

    /**
     * 性别 10--男  20--女
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
     * 标签ID
     */
    private  String tagId;

    /**
     * 二维码
     */
    private String qrCode;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 最后一次修改日期
     */
    private  Date lastUpdateDate;

    /**
     * 最后一次修改人
     */
    private Integer lastUpdateUser;

    /**
     * 状态 10 有效；20 无效；30 删除。
     */
    private Integer activeFlag;

}
