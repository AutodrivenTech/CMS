package com.huazhu.application.cms.customer.entity;

import com.huazhu.application.cms.common.entity.BaseEntity;
import com.huazhu.application.cms.customer.dto.customer.result.CusTagInfoDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class CusInfo  extends BaseEntity {
    private Long rowId;

    private String cusName;

    private Integer hotelId;

    private Integer cusSex;

    private String country;

    private String cusSign;

    private String cusPhoto;

    private String cusOpenId;

    private Date followDate;

    private String province;

    private String city;

    private String language;

    private String surveyAge;

    private String abroadDestination;

    private String domesticDestination;

    private String activity;

    private List<CusTagInfoDTO> tags;







}