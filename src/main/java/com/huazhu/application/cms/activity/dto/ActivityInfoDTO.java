package com.huazhu.application.cms.activity.dto;

import lombok.Data;

import java.util.List;

@Data
public class ActivityInfoDTO {

    private Integer rowId;

    private String activityTitle;

    /**
     * 扫描次数
     */
    private Integer actDetailCount;

    /**
     *  活动明细
     */
    private List<ActivityDetailInfoDTO> detailInfoDTOList;






}
