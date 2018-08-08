package com.huazhu.application.cms.activity.service;


import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.activity.dto.ActivityInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityInfo;

public interface ActivityInfoService {

    PageInfo<ActivityInfoDTO> getActivityList(ActivityInfo activityInfo, Integer pageNo, Integer pageSize);

    Integer updateAct(ActivityInfo activityInfo);

    Integer addAct(ActivityInfo activityInfo);

    Integer delete(Integer rowId,Integer userId);

    ActivityInfoDTO getActivityById(Integer rowId);


}
