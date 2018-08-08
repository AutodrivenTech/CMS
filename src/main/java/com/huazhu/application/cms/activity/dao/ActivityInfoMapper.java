package com.huazhu.application.cms.activity.dao;

import com.huazhu.application.cms.activity.dto.ActivityInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityInfoMapper {

    List<ActivityInfoDTO> queryAll(ActivityInfo activityInfo);

    Integer updateAct(ActivityInfo activityInfo);

    Integer  addAct(ActivityInfo activityInfo);


    ActivityInfoDTO queryActivityById(@Param("rowId") Integer rowId);

}
