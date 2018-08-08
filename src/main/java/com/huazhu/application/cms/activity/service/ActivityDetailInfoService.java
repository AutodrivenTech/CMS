package com.huazhu.application.cms.activity.service;

import com.huazhu.application.cms.activity.dto.ActivityDetailInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityDetailInfo;

public interface ActivityDetailInfoService {

        Integer updateActDetail(ActivityDetailInfo activityDetailInfo);

        Integer delete(Integer rowId,Integer userId);

        Integer addActDetail(ActivityDetailInfo activityDetailInfo);

        ActivityDetailInfoDTO getActDetailById(Integer rowId);

        Integer updateActDetailCount(Integer rowId);
}
